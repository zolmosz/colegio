package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.AlumnosDocumentos;

@Configuration
public interface AlumnosDocumentosDao extends CrudRepository<AlumnosDocumentos, UUID>{
    AlumnosDocumentos findByAlumnosBasicos_AbLlave(UUID abLlave);
}
