package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.RecursoHumanoDao;
import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.dto.CargosDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.dto.RecursoHumanoDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.entity.RecursoHumano;
import com.uan.colegio.service.RecursoHumanoService;
import com.uan.colegio.utils.MHelpers;

@Service
public class RecursoHumanoServiceImpl extends GenericServiceImpl<RecursoHumano, UUID> implements RecursoHumanoService {

	@Autowired
	private RecursoHumanoDao RecursoHumanoDao;

	@Override
	public List<RecursoHumanoDto> findAll() {
		List<RecursoHumanoDto> listarecursoHumanoDto = new ArrayList<>();

		Iterable<RecursoHumano> recursoHumanoItr = this.RecursoHumanoDao.findAll();

		for (RecursoHumano recursoHumano : recursoHumanoItr) {

			RecursoHumanoDto recursoHumanoDto = new RecursoHumanoDto();
			recursoHumanoDto = MHelpers.modelMapper().map(recursoHumano, RecursoHumanoDto.class);
			recursoHumanoDto.setColegiosDto(MHelpers.modelMapper().map(recursoHumano.getColegios(), ColegiosDto.class));
			recursoHumanoDto.setTiposIdentificacionDto(MHelpers.modelMapper().map(recursoHumano.getTiposIdentificacion(),TiposIdentificacionDto.class));
			recursoHumanoDto.setProfesionesDto(MHelpers.modelMapper().map(recursoHumano.getProfesiones(), ProfesionesDto.class));
			recursoHumanoDto.setCargosDto(MHelpers.modelMapper().map(recursoHumano.getCargos(), CargosDto.class));
			recursoHumanoDto.setCiudadesDto(MHelpers.modelMapper().map(recursoHumano.getCiudades(), CiudadesDto.class));
			recursoHumanoDto.setBarriosDto(MHelpers.modelMapper().map(recursoHumano.getBarrios(), BarriosDto.class));
			listarecursoHumanoDto.add(recursoHumanoDto);
		}

		return listarecursoHumanoDto;
	}

	@Override
	public RecursoHumanoDto findByid(UUID id) {
		Optional<RecursoHumano> recursoHumano = this.RecursoHumanoDao.findById(id);
		RecursoHumanoDto recursoHumanoDto = MHelpers.modelMapper().map(recursoHumano.get(), RecursoHumanoDto.class);
		recursoHumanoDto.setColegiosDto(MHelpers.modelMapper().map(recursoHumano.get().getColegios(), ColegiosDto.class));
		recursoHumanoDto.setTiposIdentificacionDto(MHelpers.modelMapper().map(recursoHumano.get().getTiposIdentificacion(),TiposIdentificacionDto.class));
		recursoHumanoDto.setProfesionesDto(MHelpers.modelMapper().map(recursoHumano.get().getProfesiones(), ProfesionesDto.class));
		recursoHumanoDto.setCargosDto(MHelpers.modelMapper().map(recursoHumano.get().getCargos(), CargosDto.class));
		recursoHumanoDto.setCiudadesDto(MHelpers.modelMapper().map(recursoHumano.get().getCiudades(), CiudadesDto.class));
		recursoHumanoDto.setBarriosDto(MHelpers.modelMapper().map(recursoHumano.get().getBarrios(), BarriosDto.class));

		return recursoHumanoDto;
	}

	@Override
	public RecursoHumanoDto save(RecursoHumanoDto recursoHumanoDto) {
		RecursoHumano recursoHumano = MHelpers.modelMapper().map(recursoHumanoDto, RecursoHumano.class);

		recursoHumano = this.RecursoHumanoDao.save(recursoHumano);
		recursoHumanoDto = MHelpers.modelMapper().map(recursoHumano, RecursoHumanoDto.class);

		return recursoHumanoDto;
	}

	@Override
	public void delete(RecursoHumanoDto recursoHumanoDto) {
		RecursoHumano recursoHumano = MHelpers.modelMapper().map(recursoHumanoDto, RecursoHumano.class);
		this.RecursoHumanoDao.delete(recursoHumano);
	}

	@Override
	public CrudRepository<RecursoHumano, UUID> getDao() {
		return RecursoHumanoDao;
	}

	@Override
	public void deleteById(UUID id) {
		RecursoHumanoDao.deleteById(id);		
	}

}
