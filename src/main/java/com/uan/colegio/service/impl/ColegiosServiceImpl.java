package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.ColegiosDao;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.DepartamentosDto;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.entity.Colegios;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class ColegiosServiceImpl extends GenericServiceImpl<Colegios, UUID> implements ColegiosService {

	@Autowired
	private ColegiosDao ColegiosDao;

	@Override
	public List<ColegiosDto> findAll() {
		List<ColegiosDto> listacolegioDto = new ArrayList<>();

		Iterable<Colegios> ColegiosItr = this.ColegiosDao.findAll();

		for (Colegios colegio : ColegiosItr) {

			ColegiosDto colegioDto = new ColegiosDto();
			colegioDto = MHelpers.modelMapper().map(colegio, ColegiosDto.class);
			colegioDto.setCiudadesDto(MHelpers.modelMapper().map(colegio.getCiudades(), CiudadesDto.class));
			colegioDto.setDepartamentosDto(MHelpers.modelMapper().map(colegio.getDepartamentos(), DepartamentosDto.class));
			colegioDto.setPaisesDto(MHelpers.modelMapper().map(colegio.getPaises(), PaisesDto.class));
			listacolegioDto.add(colegioDto);
		}

		return listacolegioDto;
	}

	@Override
	public ColegiosDto findByid(UUID id) {
		Optional<Colegios> colegio = this.ColegiosDao.findById(id);
		ColegiosDto colegioDto = MHelpers.modelMapper().map(colegio.get(), ColegiosDto.class);

		return colegioDto;
	}

	@Override
	public ColegiosDto save(ColegiosDto colegioDto) {
		Colegios colegio = MHelpers.modelMapper().map(colegioDto, Colegios.class);

		colegio = this.ColegiosDao.save(colegio);
		colegioDto = MHelpers.modelMapper().map(colegio, ColegiosDto.class);

		return colegioDto;
	}

	@Override
	public void delete(ColegiosDto colegioDto) {
		Colegios colegio = MHelpers.modelMapper().map(colegioDto, Colegios.class);
		this.ColegiosDao.delete(colegio);
	}

	@Override
	public CrudRepository<Colegios, UUID> getDao() {
		return ColegiosDao;
	}

	@Override
	public void deleteById(UUID id) {
		ColegiosDao.deleteById(id);		
	}

}
