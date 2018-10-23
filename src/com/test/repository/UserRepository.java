package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

