package com.example.jwt.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwt.entity.SystemUser;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("batman", "{noop}password", AuthorityUtils.createAuthorityList("ROLE_USER")); // noop is for password encoder (look it up)
    }

    public SystemUser loadSystemUserByUsername(String username) {
        return null;
    }

}
