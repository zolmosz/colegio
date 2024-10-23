package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.AlumnosFamiliaDao;
import com.uan.colegio.dto.AlumnosFamiliaDto;
import com.uan.colegio.entity.AlumnosFamilia;
import com.uan.colegio.service.AlumnosFamiliaService;
import com.uan.colegio.utils.MHelpers;

@Service
public class AlumnosFamiliaServiceImpl extends GenericServiceImpl<AlumnosFamilia, UUID> implements AlumnosFamiliaService {

	@Autowired
	private AlumnosFamiliaDao AlumnosFamiliaDao;

	@Override
	public List<AlumnosFamiliaDto> findAll() {
		List<AlumnosFamiliaDto> listaalumnosFamiliaDto = new ArrayList<>();

		Iterable<AlumnosFamilia> alumnosFamiliaItr = this.AlumnosFamiliaDao.findAll();

		for (AlumnosFamilia alumnosFamilia : alumnosFamiliaItr) {

			AlumnosFamiliaDto alumnosFamiliaDto = new AlumnosFamiliaDto();
			alumnosFamiliaDto = MHelpers.modelMapper().map(alumnosFamilia, AlumnosFamiliaDto.class);
			listaalumnosFamiliaDto.add(alumnosFamiliaDto);
		}

		return listaalumnosFamiliaDto;
	}

	@Override
	public AlumnosFamiliaDto findByid(UUID id) {
		Optional<AlumnosFamilia> alumnosFamilia = this.AlumnosFamiliaDao.findById(id);
		AlumnosFamiliaDto alumnosFamiliaDto = MHelpers.modelMapper().map(alumnosFamilia.get(), AlumnosFamiliaDto.class);

		return alumnosFamiliaDto;
	}

	@Override
	public AlumnosFamiliaDto save(AlumnosFamiliaDto alumnosFamiliaDto) {
		AlumnosFamilia alumnosFamilia = MHelpers.modelMapper().map(alumnosFamiliaDto, AlumnosFamilia.class);

		alumnosFamilia = this.AlumnosFamiliaDao.save(alumnosFamilia);
		alumnosFamiliaDto = MHelpers.modelMapper().map(alumnosFamilia, AlumnosFamiliaDto.class);

		return alumnosFamiliaDto;
	}

	@Override
	public void delete(AlumnosFamiliaDto alumnosFamiliaDto) {
		AlumnosFamilia alumnosFamilia = MHelpers.modelMapper().map(alumnosFamiliaDto, AlumnosFamilia.class);
		this.AlumnosFamiliaDao.delete(alumnosFamilia);
	}

	@Override
	public CrudRepository<AlumnosFamilia, UUID> getDao() {
		return AlumnosFamiliaDao;
	}

	@Override
	public void deleteById(UUID id) {
		AlumnosFamiliaDao.deleteById(id);		
	}

}
