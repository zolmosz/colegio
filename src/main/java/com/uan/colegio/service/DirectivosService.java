package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.DirectivosDto;
import com.uan.colegio.entity.Directivos;

public interface DirectivosService extends GenericService<Directivos, UUID>{
	public List<DirectivosDto> findAll();
	public DirectivosDto findByid(UUID id);
	public DirectivosDto save(DirectivosDto directivosDto) ;
	void delete(DirectivosDto directivosDto);
	void deleteById(UUID id);
}
