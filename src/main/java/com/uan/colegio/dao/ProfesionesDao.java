package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Profesiones;

@Configuration
public interface ProfesionesDao extends CrudRepository<Profesiones, UUID>{

}
