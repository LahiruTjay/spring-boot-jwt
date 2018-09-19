package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.RoleAuthority;

public interface RoleAuthorityDAO extends JpaRepository<RoleAuthority, Long>{

}
