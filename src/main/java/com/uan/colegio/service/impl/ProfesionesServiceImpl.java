package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.ProfesionesDao;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.entity.Profesiones;
import com.uan.colegio.service.ProfesionesService;
import com.uan.colegio.utils.MHelpers;

@Service
public class ProfesionesServiceImpl extends GenericServiceImpl<Profesiones, UUID> implements ProfesionesService {

	@Autowired
	private ProfesionesDao ProfesionesDao;

	@Override
	public List<ProfesionesDto> findAll() {
		List<ProfesionesDto> listaprofesionesDto = new ArrayList<>();

		Iterable<Profesiones> profesionesItr = this.ProfesionesDao.findAll();

		for (Profesiones profesiones : profesionesItr) {

			ProfesionesDto profesionesDto = new ProfesionesDto();
			profesionesDto = MHelpers.modelMapper().map(profesiones, ProfesionesDto.class);
			listaprofesionesDto.add(profesionesDto);
		}

		return listaprofesionesDto;
	}

	@Override
	public ProfesionesDto findByid(UUID id) {
		Optional<Profesiones> profesiones = this.ProfesionesDao.findById(id);
		ProfesionesDto profesionesDto = MHelpers.modelMapper().map(profesiones.get(), ProfesionesDto.class);

		return profesionesDto;
	}

	@Override
	public ProfesionesDto save(ProfesionesDto profesionesDto) {
		Profesiones profesiones = MHelpers.modelMapper().map(profesionesDto, Profesiones.class);

		profesiones = this.ProfesionesDao.save(profesiones);
		profesionesDto = MHelpers.modelMapper().map(profesiones, ProfesionesDto.class);

		return profesionesDto;
	}

	@Override
	public void delete(ProfesionesDto profesionesDto) {
		Profesiones profesiones = MHelpers.modelMapper().map(profesionesDto, Profesiones.class);
		this.ProfesionesDao.delete(profesiones);
	}

	@Override
	public CrudRepository<Profesiones, UUID> getDao() {
		return ProfesionesDao;
	}

	@Override
	public void deleteById(UUID id) {
		ProfesionesDao.deleteById(id);		
	}

}
