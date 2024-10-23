package com.uan.colegio.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Usuarios;


@Configuration
public interface UsuariosDao extends CrudRepository<Usuarios, UUID>{
	Optional<Usuarios> findByUsCodigo(String username);
}
