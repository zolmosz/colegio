package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.PerfilesDto;
import com.uan.colegio.entity.Perfiles;

public interface PerfilesService extends GenericService<Perfiles, UUID>{
	public List<PerfilesDto> findAll();
	public PerfilesDto findByid(UUID id);
	public PerfilesDto save(PerfilesDto PerfilesDto) ;
	void delete(PerfilesDto PerfilesDto);
	void deleteById(UUID id);
}
