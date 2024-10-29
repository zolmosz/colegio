package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.PerfilesDao;
import com.uan.colegio.dto.PerfilesDto;
import com.uan.colegio.entity.Perfiles;
import com.uan.colegio.service.PerfilesService;
import com.uan.colegio.utils.MHelpers;

@Service
public class PerfilesServiceImpl extends GenericServiceImpl<Perfiles, UUID> implements PerfilesService {

	@Autowired
	private PerfilesDao perfilesDao;

	@Override
	public List<PerfilesDto> findAll() {
		List<PerfilesDto> listaPerfilDto = new ArrayList<>();

		Iterable<Perfiles> perfilItr = this.perfilesDao.findAll();

		for (Perfiles perfil : perfilItr) {

			PerfilesDto perfilDto = new PerfilesDto();
			perfilDto = MHelpers.modelMapper().map(perfil, PerfilesDto.class);
			listaPerfilDto.add(perfilDto);
		}

		return listaPerfilDto;
	}

	@Override
	public PerfilesDto findByid(UUID id) {
		Optional<Perfiles> perfiles = this.perfilesDao.findById(id);
		PerfilesDto perfilesDto = MHelpers.modelMapper().map(perfiles.get(), PerfilesDto.class);

		return perfilesDto;
	}

	@Override
	public PerfilesDto save(PerfilesDto perfilesDto) {
		Perfiles perfiles = MHelpers.modelMapper().map(perfilesDto, Perfiles.class);

		perfiles = this.perfilesDao.save(perfiles);
		perfilesDto = MHelpers.modelMapper().map(perfiles, PerfilesDto.class);

		return perfilesDto;
	}

	@Override
	public void delete(PerfilesDto perfilesDto) {
		Perfiles perfiles = MHelpers.modelMapper().map(perfilesDto, Perfiles.class);
		this.perfilesDao.delete(perfiles);
	}
	
	@Override
	public void deleteById(UUID id) {
		perfilesDao.deleteById(id);
	}

	@Override
	public CrudRepository<Perfiles, UUID> getDao() {
		return perfilesDao;
	}

}
