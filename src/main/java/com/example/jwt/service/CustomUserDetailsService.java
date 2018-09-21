package com.example.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
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
        SystemUser systemUser = loadSystemUserByUsername(username);
        SystemUser systemUser2 =  systemUserDAO.findByUsername(username);
        List<RoleAuthority> roles = roleAuthorityDAO.getRoleAuthoriyByRole(systemUser2.get)
        
        System.out.println(systemUser2.toString());
        
        return new User(systemUser.getUsername(), systemUser.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER")); // todo - get the user from the DB
    }

    public SystemUser loadSystemUserByUsername(String username) {
        return new SystemUser("batman", "{noop}password"); // noop is for password encoder (look it up)
    }

}
