package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.CalificacionesDto;
import com.uan.colegio.entity.Calificaciones;

public interface CalificacionesService extends GenericService<Calificaciones, UUID>{
    public List<CalificacionesDto> findAll();
	public CalificacionesDto findByid(UUID id);
	public CalificacionesDto save(CalificacionesDto calificacionesDto) ;
	void delete(CalificacionesDto calificacionesDto);
	void deleteById(UUID id);
}
