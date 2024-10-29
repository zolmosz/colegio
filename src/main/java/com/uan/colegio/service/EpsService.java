package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.EpsDto;
import com.uan.colegio.entity.Eps;

public interface EpsService extends GenericService<Eps, UUID>{
	public List<EpsDto> findAll();
	public EpsDto findByid(UUID id);
	public EpsDto save(EpsDto epsDto) ;
	void delete(EpsDto epsDto);
	void deleteById(UUID id);
}
