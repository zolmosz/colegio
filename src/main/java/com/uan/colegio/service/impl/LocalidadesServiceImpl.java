package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.LocalidadesDao;
import com.uan.colegio.dto.LocalidadesDto;
import com.uan.colegio.entity.Localidades;
import com.uan.colegio.service.LocalidadesService;
import com.uan.colegio.utils.MHelpers;

@Service
public class LocalidadesServiceImpl extends GenericServiceImpl<Localidades, UUID> implements LocalidadesService {

	@Autowired
	private LocalidadesDao LocalidadesDao;

	@Override
	public List<LocalidadesDto> findAll() {
		List<LocalidadesDto> listalocalidadesDto = new ArrayList<>();

		Iterable<Localidades> localidadesItr = this.LocalidadesDao.findAll();

		for (Localidades localidades : localidadesItr) {

			LocalidadesDto localidadesDto = new LocalidadesDto();
			localidadesDto = MHelpers.modelMapper().map(localidades, LocalidadesDto.class);
			listalocalidadesDto.add(localidadesDto);
		}

		return listalocalidadesDto;
	}

	@Override
	public LocalidadesDto findByid(UUID id) {
		Optional<Localidades> localidades = this.LocalidadesDao.findById(id);
		LocalidadesDto localidadesDto = MHelpers.modelMapper().map(localidades.get(), LocalidadesDto.class);

		return localidadesDto;
	}

	@Override
	public LocalidadesDto save(LocalidadesDto localidadesDto) {
		Localidades localidades = MHelpers.modelMapper().map(localidadesDto, Localidades.class);

		localidades = this.LocalidadesDao.save(localidades);
		localidadesDto = MHelpers.modelMapper().map(localidades, LocalidadesDto.class);

		return localidadesDto;
	}

	@Override
	public void delete(LocalidadesDto localidadesDto) {
		Localidades localidades = MHelpers.modelMapper().map(localidadesDto, Localidades.class);
		this.LocalidadesDao.delete(localidades);
	}

	@Override
	public CrudRepository<Localidades, UUID> getDao() {
		return LocalidadesDao;
	}

	@Override
	public void deleteById(UUID id) {
		LocalidadesDao.deleteById(id);		
	}

}
