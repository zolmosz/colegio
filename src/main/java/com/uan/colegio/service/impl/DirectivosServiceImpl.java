package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.DirectivosDao;
import com.uan.colegio.dto.DirectivosDto;
import com.uan.colegio.entity.Directivos;
import com.uan.colegio.service.DirectivosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class DirectivosServiceImpl extends GenericServiceImpl<Directivos, UUID> implements DirectivosService {

	@Autowired
	private DirectivosDao DirectivosDao;

	@Override
	public List<DirectivosDto> findAll() {
		List<DirectivosDto> listadirectivosDto = new ArrayList<>();

		Iterable<Directivos> directivosItr = this.DirectivosDao.findAll();

		for (Directivos directivos : directivosItr) {

			DirectivosDto directivosDto = new DirectivosDto();
			directivosDto = MHelpers.modelMapper().map(directivos, DirectivosDto.class);
			listadirectivosDto.add(directivosDto);
		}

		return listadirectivosDto;
	}

	@Override
	public DirectivosDto findByid(UUID id) {
		Optional<Directivos> directivos = this.DirectivosDao.findById(id);
		DirectivosDto directivosDto = MHelpers.modelMapper().map(directivos.get(), DirectivosDto.class);

		return directivosDto;
	}

	@Override
	public DirectivosDto save(DirectivosDto directivosDto) {
		Directivos directivos = MHelpers.modelMapper().map(directivosDto, Directivos.class);

		directivos = this.DirectivosDao.save(directivos);
		directivosDto = MHelpers.modelMapper().map(directivos, DirectivosDto.class);

		return directivosDto;
	}

	@Override
	public void delete(DirectivosDto directivosDto) {
		Directivos directivos = MHelpers.modelMapper().map(directivosDto, Directivos.class);
		this.DirectivosDao.delete(directivos);
	}

	@Override
	public CrudRepository<Directivos, UUID> getDao() {
		return DirectivosDao;
	}

	@Override
	public void deleteById(UUID id) {
		DirectivosDao.deleteById(id);		
	}

}
