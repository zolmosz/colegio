package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.CargosDao;
import com.uan.colegio.dto.CargosDto;
import com.uan.colegio.entity.Cargos;
import com.uan.colegio.service.CargosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class CargosServiceImpl extends GenericServiceImpl<Cargos, UUID> implements CargosService {

	@Autowired
	private CargosDao CargosDao;

	@Override
	public List<CargosDto> findAll() {
		List<CargosDto> listacargosDto = new ArrayList<>();

		Iterable<Cargos> cargosItr = this.CargosDao.findAll();

		for (Cargos cargos : cargosItr) {

			CargosDto cargosDto = new CargosDto();
			cargosDto = MHelpers.modelMapper().map(cargos, CargosDto.class);
			listacargosDto.add(cargosDto);
		}

		return listacargosDto;
	}

	@Override
	public CargosDto findByid(UUID id) {
		Optional<Cargos> cargos = this.CargosDao.findById(id);
		CargosDto cargosDto = MHelpers.modelMapper().map(cargos.get(), CargosDto.class);

		return cargosDto;
	}

	@Override
	public CargosDto save(CargosDto cargosDto) {
		Cargos cargos = MHelpers.modelMapper().map(cargosDto, Cargos.class);

		cargos = this.CargosDao.save(cargos);
		cargosDto = MHelpers.modelMapper().map(cargos, CargosDto.class);

		return cargosDto;
	}

	@Override
	public void delete(CargosDto cargosDto) {
		Cargos cargos = MHelpers.modelMapper().map(cargosDto, Cargos.class);
		this.CargosDao.delete(cargos);
	}

	@Override
	public CrudRepository<Cargos, UUID> getDao() {
		return CargosDao;
	}

	@Override
	public void deleteById(UUID id) {
		CargosDao.deleteById(id);		
	}

}
