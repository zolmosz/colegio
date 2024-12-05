package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uan.colegio.entity.AlumnosBasicos;

@Configuration
public interface AlumnosBasicosDao extends CrudRepository<AlumnosBasicos, UUID>{
    
    @Modifying
    @Query("UPDATE AlumnosBasicos a SET a.abEstado = :abEstado WHERE a.id = :id")
    int updateEstado(@Param("id") UUID id, @Param("abEstado") String abEstado);
}
