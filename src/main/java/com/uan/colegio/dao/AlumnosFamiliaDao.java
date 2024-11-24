package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.AlumnosFamilia;


@Configuration
public interface AlumnosFamiliaDao extends CrudRepository<AlumnosFamilia, UUID>{
    AlumnosFamilia findByAlumnosBasicos_AbLlave(UUID abLlave);
}
