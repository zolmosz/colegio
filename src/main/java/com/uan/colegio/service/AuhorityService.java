package com.uan.colegio.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uan.colegio.entity.Authority;
import com.uan.colegio.enums.AuthorityName;

public interface AuhorityService extends JpaRepository<Authority, UUID> {

	Optional<Authority> findByName(AuthorityName name);
}
