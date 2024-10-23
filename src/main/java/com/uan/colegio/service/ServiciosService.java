package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.ServiciosDto;
import com.uan.colegio.entity.Servicios;

public interface ServiciosService extends GenericService<Servicios, UUID>{
	public List<ServiciosDto> findAll();
	public ServiciosDto findByid(UUID id);
	public ServiciosDto save(ServiciosDto serviciosDto) ;
	void delete(ServiciosDto serviciosDto);
	void deleteById(UUID id);
}
