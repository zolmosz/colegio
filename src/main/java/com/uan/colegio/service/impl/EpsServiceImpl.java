package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.EpsDao;
import com.uan.colegio.dto.EpsDto;
import com.uan.colegio.entity.Eps;
import com.uan.colegio.service.EpsService;
import com.uan.colegio.utils.MHelpers;

@Service
public class EpsServiceImpl extends GenericServiceImpl<Eps, UUID> implements EpsService {

	@Autowired
	private EpsDao EpsDao;

	@Override
	public List<EpsDto> findAll() {
		List<EpsDto> listaepsDto = new ArrayList<>();

		Iterable<Eps> epsItr = this.EpsDao.findAll();

		for (Eps eps : epsItr) {

			EpsDto epsDto = new EpsDto();
			epsDto = MHelpers.modelMapper().map(eps, EpsDto.class);
			listaepsDto.add(epsDto);
		}

		return listaepsDto;
	}

	@Override
	public EpsDto findByid(UUID id) {
		Optional<Eps> eps = this.EpsDao.findById(id);
		EpsDto epsDto = MHelpers.modelMapper().map(eps.get(), EpsDto.class);

		return epsDto;
	}

	@Override
	public EpsDto save(EpsDto epsDto) {
		Eps eps = MHelpers.modelMapper().map(epsDto, Eps.class);

		eps = this.EpsDao.save(eps);
		epsDto = MHelpers.modelMapper().map(eps, EpsDto.class);

		return epsDto;
	}

	@Override
	public void delete(EpsDto epsDto) {
		Eps eps = MHelpers.modelMapper().map(epsDto, Eps.class);
		this.EpsDao.delete(eps);
	}

	@Override
	public CrudRepository<Eps, UUID> getDao() {
		return EpsDao;
	}

	@Override
	public void deleteById(UUID id) {
		EpsDao.deleteById(id);		
	}

}
