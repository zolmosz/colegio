package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.AlumnosDocumentosDto;
import com.uan.colegio.entity.AlumnosDocumentos;

public interface AlumnosDocumentosService extends GenericService<AlumnosDocumentos, UUID>{
	public List<AlumnosDocumentosDto> findAll();
	public AlumnosDocumentosDto findByid(UUID id);
	public AlumnosDocumentosDto save(AlumnosDocumentosDto alumnosDocumentosDto) ;
	void delete(AlumnosDocumentosDto alumnosDocumentosDto);
	void deleteById(UUID id);
}
