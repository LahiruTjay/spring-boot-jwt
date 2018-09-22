package com.example.jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwt.entity.SystemUser;
import com.example.jwt.repository.RoleAuthorityDAO;
import com.example.jwt.repository.SystemUserDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    SystemUserDAO systemUserDAO;

    @Autowired
    RoleAuthorityDAO roleAuthorityDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //SystemUser systemUser = loadSystemUserByUsername(username);
        
        return loadSystemUserByUsername(username);
        //return new User(systemUser.getUsername(), systemUser.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER")); // todo - get the user from the DB
    }

    public UserDetails loadSystemUserByUsername(String username) {

        SystemUser systemUser = systemUserDAO.findByUsername(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        roleAuthorityDAO.getRoleAuthoriyByRole(systemUser.getRole())
            .forEach(role -> authorityList.add(new SimpleGrantedAuthority(role.getAuthority()
                .getAuthority())));

        return new User(systemUser.getUsername(), systemUser.getPassword(), authorityList);
        // return new SystemUser("batman", "{noop}password"); // noop is for password encoder (look it up)
    }

}
