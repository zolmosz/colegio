package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.HorariosDao;
import com.uan.colegio.dto.HorariosDto;
import com.uan.colegio.entity.Horarios;
import com.uan.colegio.service.HorariosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class HorariosServiceImpl extends GenericServiceImpl<Horarios, UUID> implements HorariosService {

	@Autowired
	private HorariosDao HorariosDao;

	@Override
	public List<HorariosDto> findAll() {
		List<HorariosDto> listahorariosDto = new ArrayList<>();

		Iterable<Horarios> horariosItr = this.HorariosDao.findAll();

		for (Horarios horarios : horariosItr) {

			HorariosDto horariosDto = new HorariosDto();
			horariosDto = MHelpers.modelMapper().map(horarios, HorariosDto.class);
			listahorariosDto.add(horariosDto);
		}

		return listahorariosDto;
	}

	@Override
	public HorariosDto findByid(UUID id) {
		Optional<Horarios> horarios = this.HorariosDao.findById(id);
		HorariosDto horariosDto = MHelpers.modelMapper().map(horarios.get(), HorariosDto.class);

		return horariosDto;
	}

	@Override
	public HorariosDto save(HorariosDto horariosDto) {
		Horarios horarios = MHelpers.modelMapper().map(horariosDto, Horarios.class);

		horarios = this.HorariosDao.save(horarios);
		horariosDto = MHelpers.modelMapper().map(horarios, HorariosDto.class);

		return horariosDto;
	}

	@Override
	public void delete(HorariosDto horariosDto) {
		Horarios horarios = MHelpers.modelMapper().map(horariosDto, Horarios.class);
		this.HorariosDao.delete(horarios);
	}

	@Override
	public CrudRepository<Horarios, UUID> getDao() {
		return HorariosDao;
	}

	@Override
	public void deleteById(UUID id) {
		HorariosDao.deleteById(id);		
	}

}
