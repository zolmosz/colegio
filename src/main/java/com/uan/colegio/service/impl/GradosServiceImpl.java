package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.GradosDao;
import com.uan.colegio.dto.GradosDto;
import com.uan.colegio.entity.Grados;
import com.uan.colegio.service.GradosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class GradosServiceImpl extends GenericServiceImpl<Grados, UUID> implements GradosService {

	@Autowired
	private GradosDao GradosDao;

	@Override
	public List<GradosDto> findAll() {
		List<GradosDto> listagradosDto = new ArrayList<>();

		Iterable<Grados> gradosItr = this.GradosDao.findAll();

		for (Grados grados : gradosItr) {

			GradosDto gradosDto = new GradosDto();
			gradosDto = MHelpers.modelMapper().map(grados, GradosDto.class);
			listagradosDto.add(gradosDto);
		}

		return listagradosDto;
	}

	@Override
	public GradosDto findByid(UUID id) {
		Optional<Grados> grados = this.GradosDao.findById(id);
		GradosDto gradosDto = MHelpers.modelMapper().map(grados.get(), GradosDto.class);

		return gradosDto;
	}

	@Override
	public GradosDto save(GradosDto gradosDto) {
		Grados grados = MHelpers.modelMapper().map(gradosDto, Grados.class);

		grados = this.GradosDao.save(grados);
		gradosDto = MHelpers.modelMapper().map(grados, GradosDto.class);

		return gradosDto;
	}

	@Override
	public void delete(GradosDto gradosDto) {
		Grados grados = MHelpers.modelMapper().map(gradosDto, Grados.class);
		this.GradosDao.delete(grados);
	}

	@Override
	public CrudRepository<Grados, UUID> getDao() {
		return GradosDao;
	}

	@Override
	public void deleteById(UUID id) {
		GradosDao.deleteById(id);		
	}

}
