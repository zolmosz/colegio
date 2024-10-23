package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Servicios;

@Configuration
public interface ServiciosDao extends CrudRepository<Servicios, UUID>{

}
