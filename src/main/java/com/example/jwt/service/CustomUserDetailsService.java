package com.example.jwt.service;

import java.util.List;
import java.util.stream.Collectors;

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
        return loadSystemUserByUsername(username);
    }

    private UserDetails loadSystemUserByUsername(String username) {
        SystemUser systemUser = systemUserDAO.findByUsername(username);
        List<GrantedAuthority> authorityList = roleAuthorityDAO.getRoleAuthoriyByRole(systemUser.getRole())
            .stream()
            .map(roleAuthority -> new SimpleGrantedAuthority(roleAuthority.getAuthority().getAuthority()))
            .collect(Collectors.toList());
        return new User(systemUser.getUsername(), "{noop}" + systemUser.getPassword(), authorityList);
    }
}
