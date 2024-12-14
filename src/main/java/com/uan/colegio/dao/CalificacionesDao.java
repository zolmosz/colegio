package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Calificaciones;

@Configuration
public interface CalificacionesDao extends CrudRepository<Calificaciones, UUID>{
    
}
