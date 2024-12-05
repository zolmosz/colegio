package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.entity.AlumnosBasicos;


public interface AlumnosBasicosService extends GenericService<AlumnosBasicos, UUID>{
	public List<AlumnosBasicosDto> findAll();
	public AlumnosBasicosDto findByid(UUID id);
	public AlumnosBasicosDto save(AlumnosBasicosDto alumnosBasicosDto) ;
	void delete(AlumnosBasicosDto alumnosBasicosDto);
	void deleteById(UUID id);
	public byte[] getFotoActual(UUID id);
	public List<AlumnosBasicosDto> getAlumnosCompletos();
	public void updateEstado(UUID id, String Estado);
}
