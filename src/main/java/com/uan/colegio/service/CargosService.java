package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.CargosDto;
import com.uan.colegio.entity.Cargos;

public interface CargosService extends GenericService<Cargos, UUID>{
	public List<CargosDto> findAll();
	public CargosDto findByid(UUID id);
	public CargosDto save(CargosDto cargosDto) ;
	void delete(CargosDto cargosDto);
	void deleteById(UUID id);
}
