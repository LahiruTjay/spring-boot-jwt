package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.SystemUser;

public interface SystemUserDAO extends JpaRepository<SystemUser, Long> {

    SystemUser findByUsername(String username);

}
