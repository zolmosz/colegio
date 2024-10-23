package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.entity.Colegios;

public interface ColegiosService extends GenericService<Colegios, UUID>{
	public List<ColegiosDto> findAll();
	public ColegiosDto findByid(UUID id);
	public ColegiosDto save(ColegiosDto colegioDto) ;
	void delete(ColegiosDto colegioDto);
	void deleteById(UUID id);
}
