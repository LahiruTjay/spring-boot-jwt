package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Long> {

}
