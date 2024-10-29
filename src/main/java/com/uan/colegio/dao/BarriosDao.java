package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Barrios;


@Configuration
public interface BarriosDao extends CrudRepository<Barrios, UUID>{

}
