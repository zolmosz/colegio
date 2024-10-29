package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.TiposIdentificacionDao;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.entity.TiposIdentificacion;
import com.uan.colegio.service.TiposIdentificacionService;
import com.uan.colegio.utils.MHelpers;

@Service
public class TiposIdentificacionServiceImpl extends GenericServiceImpl<TiposIdentificacion, UUID> implements TiposIdentificacionService {

	@Autowired
	private TiposIdentificacionDao TiposIdentificacionDao;

	@Override
	public List<TiposIdentificacionDto> findAll() {
		List<TiposIdentificacionDto> listatiposIdentificacionDto = new ArrayList<>();

		Iterable<TiposIdentificacion> tiposIdentificacionItr = this.TiposIdentificacionDao.findAll();

		for (TiposIdentificacion tiposIdentificacion : tiposIdentificacionItr) {

			TiposIdentificacionDto tiposIdentificacionDto = new TiposIdentificacionDto();
			tiposIdentificacionDto = MHelpers.modelMapper().map(tiposIdentificacion, TiposIdentificacionDto.class);
			listatiposIdentificacionDto.add(tiposIdentificacionDto);
		}

		return listatiposIdentificacionDto;
	}

	@Override
	public TiposIdentificacionDto findByid(UUID id) {
		Optional<TiposIdentificacion> tiposIdentificacion = this.TiposIdentificacionDao.findById(id);
		TiposIdentificacionDto tiposIdentificacionDto = MHelpers.modelMapper().map(tiposIdentificacion.get(), TiposIdentificacionDto.class);

		return tiposIdentificacionDto;
	}

	@Override
	public TiposIdentificacionDto save(TiposIdentificacionDto tiposIdentificacionDto) {
		TiposIdentificacion tiposIdentificacion = MHelpers.modelMapper().map(tiposIdentificacionDto, TiposIdentificacion.class);

		tiposIdentificacion = this.TiposIdentificacionDao.save(tiposIdentificacion);
		tiposIdentificacionDto = MHelpers.modelMapper().map(tiposIdentificacion, TiposIdentificacionDto.class);

		return tiposIdentificacionDto;
	}

	@Override
	public void delete(TiposIdentificacionDto tiposIdentificacionDto) {
		TiposIdentificacion tiposIdentificacion = MHelpers.modelMapper().map(tiposIdentificacionDto, TiposIdentificacion.class);
		this.TiposIdentificacionDao.delete(tiposIdentificacion);
	}

	@Override
	public CrudRepository<TiposIdentificacion, UUID> getDao() {
		return TiposIdentificacionDao;
	}

	@Override
	public void deleteById(UUID id) {
		TiposIdentificacionDao.deleteById(id);		
	}

}
