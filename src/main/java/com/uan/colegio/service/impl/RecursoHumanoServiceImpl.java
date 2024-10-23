package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.RecursoHumanoDao;
import com.uan.colegio.dto.RecursoHumanoDto;
import com.uan.colegio.entity.RecursoHumano;
import com.uan.colegio.service.RecursoHumanoService;
import com.uan.colegio.utils.MHelpers;

@Service
public class RecursoHumanoServiceImpl extends GenericServiceImpl<RecursoHumano, UUID> implements RecursoHumanoService {

	@Autowired
	private RecursoHumanoDao RecursoHumanoDao;

	@Override
	public List<RecursoHumanoDto> findAll() {
		List<RecursoHumanoDto> listarecursoHumanoDto = new ArrayList<>();

		Iterable<RecursoHumano> recursoHumanoItr = this.RecursoHumanoDao.findAll();

		for (RecursoHumano recursoHumano : recursoHumanoItr) {

			RecursoHumanoDto recursoHumanoDto = new RecursoHumanoDto();
			recursoHumanoDto = MHelpers.modelMapper().map(recursoHumano, RecursoHumanoDto.class);
			listarecursoHumanoDto.add(recursoHumanoDto);
		}

		return listarecursoHumanoDto;
	}

	@Override
	public RecursoHumanoDto findByid(UUID id) {
		Optional<RecursoHumano> recursoHumano = this.RecursoHumanoDao.findById(id);
		RecursoHumanoDto recursoHumanoDto = MHelpers.modelMapper().map(recursoHumano.get(), RecursoHumanoDto.class);

		return recursoHumanoDto;
	}

	@Override
	public RecursoHumanoDto save(RecursoHumanoDto recursoHumanoDto) {
		RecursoHumano recursoHumano = MHelpers.modelMapper().map(recursoHumanoDto, RecursoHumano.class);

		recursoHumano = this.RecursoHumanoDao.save(recursoHumano);
		recursoHumanoDto = MHelpers.modelMapper().map(recursoHumano, RecursoHumanoDto.class);

		return recursoHumanoDto;
	}

	@Override
	public void delete(RecursoHumanoDto recursoHumanoDto) {
		RecursoHumano recursoHumano = MHelpers.modelMapper().map(recursoHumanoDto, RecursoHumano.class);
		this.RecursoHumanoDao.delete(recursoHumano);
	}

	@Override
	public CrudRepository<RecursoHumano, UUID> getDao() {
		return RecursoHumanoDao;
	}

	@Override
	public void deleteById(UUID id) {
		RecursoHumanoDao.deleteById(id);		
	}

}
