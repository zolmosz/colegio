package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.GradosDto;
import com.uan.colegio.entity.Grados;

public interface GradosService extends GenericService<Grados, UUID>{
	public List<GradosDto> findAll();
	public GradosDto findByid(UUID id);
	public GradosDto save(GradosDto gradosDto) ;
	void delete(GradosDto gradosDto);
	void deleteById(UUID id);
}
