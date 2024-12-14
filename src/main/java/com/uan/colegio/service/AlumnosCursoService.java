package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.AlumnosCursoDto;
import com.uan.colegio.entity.AlumnosCurso;

public interface AlumnosCursoService extends GenericService<AlumnosCurso, UUID>{
	public List<AlumnosCursoDto> findAll();
	public AlumnosCursoDto findByid(UUID id);
	public AlumnosCursoDto save(AlumnosCursoDto alumnosCursoDto) ;
	void delete(AlumnosCursoDto alumnosCursoDto);
	void deleteById(UUID id);
}
