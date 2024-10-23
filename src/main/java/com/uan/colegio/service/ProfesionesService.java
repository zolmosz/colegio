package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.entity.Profesiones;

public interface ProfesionesService extends GenericService<Profesiones, UUID>{
	public List<ProfesionesDto> findAll();
	public ProfesionesDto findByid(UUID id);
	public ProfesionesDto save(ProfesionesDto profesionesDto) ;
	void delete(ProfesionesDto profesionesDto);
	void deleteById(UUID id);
}
