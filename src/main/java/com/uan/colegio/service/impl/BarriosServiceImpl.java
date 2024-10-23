package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.BarriosDao;
import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.entity.Barrios;
import com.uan.colegio.service.BarriosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class BarriosServiceImpl extends GenericServiceImpl<Barrios, UUID> implements BarriosService {

	@Autowired
	private BarriosDao BarriosDao;

	@Override
	public List<BarriosDto> findAll() {
		List<BarriosDto> listabarriosDto = new ArrayList<>();

		Iterable<Barrios> barriosItr = this.BarriosDao.findAll();

		for (Barrios barrios : barriosItr) {

			BarriosDto barriosDto = new BarriosDto();
			barriosDto = MHelpers.modelMapper().map(barrios, BarriosDto.class);
			listabarriosDto.add(barriosDto);
		}

		return listabarriosDto;
	}

	@Override
	public BarriosDto findByid(UUID id) {
		Optional<Barrios> barrios = this.BarriosDao.findById(id);
		BarriosDto barriosDto = MHelpers.modelMapper().map(barrios.get(), BarriosDto.class);

		return barriosDto;
	}

	@Override
	public BarriosDto save(BarriosDto barriosDto) {
		Barrios barrios = MHelpers.modelMapper().map(barriosDto, Barrios.class);

		barrios = this.BarriosDao.save(barrios);
		barriosDto = MHelpers.modelMapper().map(barrios, BarriosDto.class);

		return barriosDto;
	}

	@Override
	public void delete(BarriosDto barriosDto) {
		Barrios barrios = MHelpers.modelMapper().map(barriosDto, Barrios.class);
		this.BarriosDao.delete(barrios);
	}

	@Override
	public CrudRepository<Barrios, UUID> getDao() {
		return BarriosDao;
	}

	@Override
	public void deleteById(UUID id) {
		BarriosDao.deleteById(id);		
	}

}
