package com.example.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
public boolean existsByFullName(String fullName);
public UserDtls findByFullName(String fullName);
}