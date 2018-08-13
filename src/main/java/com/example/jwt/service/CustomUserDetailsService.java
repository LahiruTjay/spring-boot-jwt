package com.example.jwt.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwt.entity.SystemUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SystemUser systemUser = loadSystemUserByUsername(username);
        return new User(systemUser.getUsername(), systemUser.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    public SystemUser loadSystemUserByUsername(String username) {
        return new SystemUser("batman", "{noop}password"); // noop is for password encoder (look it up)
    }

}
