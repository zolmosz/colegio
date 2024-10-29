package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.PaisesDao;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.entity.Paises;
import com.uan.colegio.service.PaisesService;
import com.uan.colegio.utils.MHelpers;

@Service
public class PaisesServiceImpl extends GenericServiceImpl<Paises, UUID> implements PaisesService {

	@Autowired
	private PaisesDao paisesDao;

	@Override
	public List<PaisesDto> findAll() {
		List<PaisesDto> listapaisDto = new ArrayList<>();

		Iterable<Paises> paisesItr = this.paisesDao.findAll();

		for (Paises pais : paisesItr) {

			PaisesDto paisDto = new PaisesDto();
			paisDto = MHelpers.modelMapper().map(pais, PaisesDto.class);
			listapaisDto.add(paisDto);
		}

		return listapaisDto;
	}

	@Override
	public PaisesDto findByid(UUID id) {
		Optional<Paises> pais = this.paisesDao.findById(id);
		PaisesDto paisDto = MHelpers.modelMapper().map(pais.get(), PaisesDto.class);

		return paisDto;
	}

	@Override
	public PaisesDto save(PaisesDto paisDto) {
		Paises pais = MHelpers.modelMapper().map(paisDto, Paises.class);

		pais = this.paisesDao.save(pais);
		paisDto = MHelpers.modelMapper().map(pais, PaisesDto.class);

		return paisDto;
	}

	@Override
	public void delete(PaisesDto paisDto) {
		Paises pais = MHelpers.modelMapper().map(paisDto, Paises.class);
		this.paisesDao.delete(pais);
	}

	@Override
	public CrudRepository<Paises, UUID> getDao() {
		return paisesDao;
	}

	@Override
	public void deleteById(UUID id) {
		paisesDao.deleteById(id);		
	}

}
