package com.uan.colegio.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uan.colegio.entity.User;

public interface UserService extends JpaRepository<User, UUID>{

	Optional<User> findByUsername(String username);
}
