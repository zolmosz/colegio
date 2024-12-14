package com.uan.colegio.dao;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import com.uan.colegio.entity.Periodos;

@Configuration
public interface PeriodosDao extends CrudRepository<Periodos, UUID>{
    
}
