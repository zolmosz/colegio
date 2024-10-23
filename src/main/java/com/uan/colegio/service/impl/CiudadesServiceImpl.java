package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.CiudadesDao;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.entity.Ciudades;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.utils.MHelpers;

@Service
public class CiudadesServiceImpl extends GenericServiceImpl<Ciudades, UUID> implements CiudadesService {

	@Autowired
	private CiudadesDao CiudadesDao;

	@Override
	public List<CiudadesDto> findAll() {
		List<CiudadesDto> listaciudadDto = new ArrayList<>();

		Iterable<Ciudades> CiudadesItr = this.CiudadesDao.findAll();

		for (Ciudades ciudad : CiudadesItr) {

			CiudadesDto ciudadDto = new CiudadesDto();
			ciudadDto = MHelpers.modelMapper().map(ciudad, CiudadesDto.class);
			listaciudadDto.add(ciudadDto);
		}

		return listaciudadDto;
	}

	@Override
	public CiudadesDto findByid(UUID id) {
		Optional<Ciudades> ciudad = this.CiudadesDao.findById(id);
		CiudadesDto ciudadDto = MHelpers.modelMapper().map(ciudad.get(), CiudadesDto.class);

		return ciudadDto;
	}

	@Override
	public CiudadesDto save(CiudadesDto ciudadDto) {
		Ciudades ciudad = MHelpers.modelMapper().map(ciudadDto, Ciudades.class);

		ciudad = this.CiudadesDao.save(ciudad);
		ciudadDto = MHelpers.modelMapper().map(ciudad, CiudadesDto.class);

		return ciudadDto;
	}

	@Override
	public void delete(CiudadesDto ciudadDto) {
		Ciudades ciudad = MHelpers.modelMapper().map(ciudadDto, Ciudades.class);
		this.CiudadesDao.delete(ciudad);
	}

	@Override
	public CrudRepository<Ciudades, UUID> getDao() {
		return CiudadesDao;
	}

	@Override
	public void deleteById(UUID id) {
		CiudadesDao.deleteById(id);		
	}

}
