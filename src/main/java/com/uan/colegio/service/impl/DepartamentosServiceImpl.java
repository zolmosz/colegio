package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.DepartamentosDao;
import com.uan.colegio.dto.DepartamentosDto;
import com.uan.colegio.entity.Departamentos;
import com.uan.colegio.service.DepartamentosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class DepartamentosServiceImpl extends GenericServiceImpl<Departamentos, UUID> implements DepartamentosService {

	@Autowired
	private DepartamentosDao DepartamentosDao;

	@Override
	public List<DepartamentosDto> findAll() {
		List<DepartamentosDto> listadepartamentoDto = new ArrayList<>();

		Iterable<Departamentos> DepartamentosItr = this.DepartamentosDao.findAll();

		for (Departamentos departamento : DepartamentosItr) {

			DepartamentosDto departamentoDto = new DepartamentosDto();
			departamentoDto = MHelpers.modelMapper().map(departamento, DepartamentosDto.class);
			listadepartamentoDto.add(departamentoDto);
		}

		return listadepartamentoDto;
	}

	@Override
	public DepartamentosDto findByid(UUID id) {
		Optional<Departamentos> departamento = this.DepartamentosDao.findById(id);
		DepartamentosDto departamentoDto = MHelpers.modelMapper().map(departamento.get(), DepartamentosDto.class);

		return departamentoDto;
	}

	@Override
	public DepartamentosDto save(DepartamentosDto departamentoDto) {
		Departamentos departamento = MHelpers.modelMapper().map(departamentoDto, Departamentos.class);

		departamento = this.DepartamentosDao.save(departamento);
		departamentoDto = MHelpers.modelMapper().map(departamento, DepartamentosDto.class);

		return departamentoDto;
	}

	@Override
	public void delete(DepartamentosDto departamentoDto) {
		Departamentos departamento = MHelpers.modelMapper().map(departamentoDto, Departamentos.class);
		this.DepartamentosDao.delete(departamento);
	}

	@Override
	public CrudRepository<Departamentos, UUID> getDao() {
		return DepartamentosDao;
	}

	@Override
	public void deleteById(UUID id) {
		DepartamentosDao.deleteById(id);		
	}

}
