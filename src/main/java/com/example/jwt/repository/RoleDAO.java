package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {

}
