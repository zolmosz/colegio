package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.entity.Barrios;

public interface BarriosService extends GenericService<Barrios, UUID>{
	public List<BarriosDto> findAll();
	public BarriosDto findByid(UUID id);
	public BarriosDto save(BarriosDto barriosDto) ;
	void delete(BarriosDto barriosDto);
	void deleteById(UUID id);
}
