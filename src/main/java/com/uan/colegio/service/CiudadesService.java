package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.entity.Ciudades;

public interface CiudadesService extends GenericService<Ciudades, UUID>{
	public List<CiudadesDto> findAll();
	public CiudadesDto findByid(UUID id);
	public CiudadesDto save(CiudadesDto ciudadDto) ;
	void delete(CiudadesDto ciudadDto);
	void deleteById(UUID id);
}
