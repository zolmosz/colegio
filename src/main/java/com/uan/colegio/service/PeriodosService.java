package com.uan.colegio.service;

import java.util.List;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.PeriodosDto;
import com.uan.colegio.entity.Periodos;

public interface PeriodosService extends GenericService<Periodos, UUID>{
    public List<PeriodosDto> findAll();
	public PeriodosDto findByid(UUID id);
	public PeriodosDto save(PeriodosDto periodosDto) ;
	void delete(PeriodosDto periodosDto);
	void deleteById(UUID id);
}
