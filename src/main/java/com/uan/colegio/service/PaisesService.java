package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.entity.Paises;

public interface PaisesService extends GenericService<Paises, UUID>{
	public List<PaisesDto> findAll();
	public PaisesDto findByid(UUID id);
	public PaisesDto save(PaisesDto paisDto) ;
	void delete(PaisesDto paisDto);
	void deleteById(UUID id);
}
