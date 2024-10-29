package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.AlumnosBasicos;

@Configuration
public interface AlumnosBasicosDao extends CrudRepository<AlumnosBasicos, UUID>{

}
