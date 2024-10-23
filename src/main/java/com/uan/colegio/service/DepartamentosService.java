package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.DepartamentosDto;
import com.uan.colegio.entity.Departamentos;

public interface DepartamentosService extends GenericService<Departamentos, UUID>{
	public List<DepartamentosDto> findAll();
	public DepartamentosDto findByid(UUID id);
	public DepartamentosDto save(DepartamentosDto departamentoDto) ;
	void delete(DepartamentosDto departamentoDto);
	void deleteById(UUID id);
}
