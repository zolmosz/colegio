package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.LocalidadesDto;
import com.uan.colegio.entity.Localidades;

public interface LocalidadesService extends GenericService<Localidades, UUID>{
	public List<LocalidadesDto> findAll();
	public LocalidadesDto findByid(UUID id);
	public LocalidadesDto save(LocalidadesDto localidadesDto) ;
	void delete(LocalidadesDto localidadesDto);
	void deleteById(UUID id);
}
