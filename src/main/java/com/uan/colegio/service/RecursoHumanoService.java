package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.RecursoHumanoDto;
import com.uan.colegio.entity.RecursoHumano;

public interface RecursoHumanoService extends GenericService<RecursoHumano, UUID>{
	public List<RecursoHumanoDto> findAll();
	public RecursoHumanoDto findByid(UUID id);
	public RecursoHumanoDto save(RecursoHumanoDto recursoHumanoDto) ;
	void delete(RecursoHumanoDto recursoHumanoDto);
	void deleteById(UUID id);
}
