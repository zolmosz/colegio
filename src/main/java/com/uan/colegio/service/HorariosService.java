package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.HorariosDto;
import com.uan.colegio.entity.Horarios;

public interface HorariosService extends GenericService<Horarios, UUID>{
	public List<HorariosDto> findAll();
	public HorariosDto findByid(UUID id);
	public HorariosDto save(HorariosDto horariosDto) ;
	void delete(HorariosDto horariosDto);
	void deleteById(UUID id);
}
