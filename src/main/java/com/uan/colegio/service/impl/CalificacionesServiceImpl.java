package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.CalificacionesDao;
import com.uan.colegio.dto.CalificacionesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.entity.Calificaciones;
import com.uan.colegio.service.CalificacionesService;
import com.uan.colegio.utils.MHelpers;

@Service
public class CalificacionesServiceImpl extends GenericServiceImpl<Calificaciones, UUID> implements CalificacionesService{

    @Autowired
    private CalificacionesDao calificaiconesDao;

    @Override
    public List<CalificacionesDto> findAll() {
        List<CalificacionesDto> listacalificacionesDto = new ArrayList<>();

		Iterable<Calificaciones> calificacionesItr = this.calificaiconesDao.findAll();

		for (Calificaciones calificaciones : calificacionesItr) {

			CalificacionesDto calificacionesDto = new CalificacionesDto();
			calificacionesDto = MHelpers.modelMapper().map(calificaciones, CalificacionesDto.class);
            calificacionesDto.setColegiosDto(MHelpers.modelMapper().map(calificaciones.getColegios(), ColegiosDto.class));
			listacalificacionesDto.add(calificacionesDto);
		}

		return listacalificacionesDto;
    }

    @Override
    public CalificacionesDto findByid(UUID id) {
        Optional<Calificaciones> calificaciones = this.calificaiconesDao.findById(id);
		CalificacionesDto calificacionesDto = MHelpers.modelMapper().map(calificaciones.get(), CalificacionesDto.class);
        calificacionesDto.setColegiosDto(MHelpers.modelMapper().map(calificaciones.get().getColegios(), ColegiosDto.class));

		return calificacionesDto;
    }

    @Override
    public CalificacionesDto save(CalificacionesDto calificacionesDto) {
        Calificaciones calificaciones = MHelpers.modelMapper().map(calificacionesDto, Calificaciones.class);

		calificaciones = this.calificaiconesDao.save(calificaciones);
		calificacionesDto = MHelpers.modelMapper().map(calificaciones, CalificacionesDto.class);

		return calificacionesDto;
    }

    @Override
    public void delete(CalificacionesDto calificacionesDto) {
        Calificaciones calificaciones = MHelpers.modelMapper().map(calificacionesDto, Calificaciones.class);
		this.calificaiconesDao.delete(calificaciones);
    }

    @Override
    public void deleteById(UUID id) {
        calificaiconesDao.deleteById(id);
    }

    @Override
    public CrudRepository<Calificaciones, UUID> getDao() {
        return calificaiconesDao;
    }
    
}
