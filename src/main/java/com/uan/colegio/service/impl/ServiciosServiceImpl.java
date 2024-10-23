package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.ServiciosDao;
import com.uan.colegio.dto.ServiciosDto;
import com.uan.colegio.entity.Servicios;
import com.uan.colegio.service.ServiciosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class ServiciosServiceImpl extends GenericServiceImpl<Servicios, UUID> implements ServiciosService {

	@Autowired
	private ServiciosDao ServiciosDao;

	@Override
	public List<ServiciosDto> findAll() {
		List<ServiciosDto> listaserviciosDto = new ArrayList<>();

		Iterable<Servicios> serviciosItr = this.ServiciosDao.findAll();

		for (Servicios servicios : serviciosItr) {

			ServiciosDto serviciosDto = new ServiciosDto();
			serviciosDto = MHelpers.modelMapper().map(servicios, ServiciosDto.class);
			listaserviciosDto.add(serviciosDto);
		}

		return listaserviciosDto;
	}

	@Override
	public ServiciosDto findByid(UUID id) {
		Optional<Servicios> servicios = this.ServiciosDao.findById(id);
		ServiciosDto serviciosDto = MHelpers.modelMapper().map(servicios.get(), ServiciosDto.class);

		return serviciosDto;
	}

	@Override
	public ServiciosDto save(ServiciosDto serviciosDto) {
		Servicios servicios = MHelpers.modelMapper().map(serviciosDto, Servicios.class);

		servicios = this.ServiciosDao.save(servicios);
		serviciosDto = MHelpers.modelMapper().map(servicios, ServiciosDto.class);

		return serviciosDto;
	}

	@Override
	public void delete(ServiciosDto serviciosDto) {
		Servicios servicios = MHelpers.modelMapper().map(serviciosDto, Servicios.class);
		this.ServiciosDao.delete(servicios);
	}

	@Override
	public CrudRepository<Servicios, UUID> getDao() {
		return ServiciosDao;
	}

	@Override
	public void deleteById(UUID id) {
		ServiciosDao.deleteById(id);		
	}

}
