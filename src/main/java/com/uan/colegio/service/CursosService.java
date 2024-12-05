package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.CursosDto;
import com.uan.colegio.entity.Cursos;

public interface CursosService extends GenericService<Cursos, UUID>{
    public List<CursosDto> findAll();
	public CursosDto findByid(UUID id);
	public CursosDto save(CursosDto barriosDto) ;
	void delete(CursosDto barriosDto);
	void deleteById(UUID id);
}
