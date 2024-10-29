package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Localidades;

@Configuration
public interface LocalidadesDao extends CrudRepository<Localidades, UUID>{

}
