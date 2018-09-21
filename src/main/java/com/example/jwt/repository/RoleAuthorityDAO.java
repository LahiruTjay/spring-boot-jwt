package com.example.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.Role;
import com.example.jwt.entity.RoleAuthority;

public interface RoleAuthorityDAO extends JpaRepository<RoleAuthority, Long> {

    List<RoleAuthority> getRoleAuthoriyByRole(Role role);
    
}
