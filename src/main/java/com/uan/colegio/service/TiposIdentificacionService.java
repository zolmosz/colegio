package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.entity.TiposIdentificacion;

public interface TiposIdentificacionService extends GenericService<TiposIdentificacion, UUID>{
	public List<TiposIdentificacionDto> findAll();
	public TiposIdentificacionDto findByid(UUID id);
	public TiposIdentificacionDto save(TiposIdentificacionDto tiposIdentificacionDto) ;
	void delete(TiposIdentificacionDto tiposIdentificacionDto);
	void deleteById(UUID id);
}
