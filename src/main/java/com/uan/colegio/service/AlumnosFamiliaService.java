package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.AlumnosFamiliaDto;
import com.uan.colegio.entity.AlumnosFamilia;

public interface AlumnosFamiliaService extends GenericService<AlumnosFamilia, UUID>{
	public List<AlumnosFamiliaDto> findAll();
	public AlumnosFamiliaDto findByid(UUID id);
	public AlumnosFamiliaDto save(AlumnosFamiliaDto alumnosFamiliaDto) ;
	void delete(AlumnosFamiliaDto alumnosFamiliaDto);
	void deleteById(UUID id);
}
