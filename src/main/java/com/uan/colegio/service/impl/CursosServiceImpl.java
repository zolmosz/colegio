package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.CursosDao;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.CursosDto;
import com.uan.colegio.dto.GradosDto;
import com.uan.colegio.dto.RecursoHumanoDto;
import com.uan.colegio.entity.Cursos;
import com.uan.colegio.service.CursosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class CursosServiceImpl extends GenericServiceImpl<Cursos, UUID> implements CursosService {

    @Autowired
	private CursosDao CursosDao;


    @Override
    public List<CursosDto> findAll() {
        List<CursosDto> listacursosDto = new ArrayList<>();

		Iterable<Cursos> cursosItr = this.CursosDao.findAll();

		for (Cursos cursos : cursosItr) {

			CursosDto cursosDto = new CursosDto();
			cursosDto = MHelpers.modelMapper().map(cursos, CursosDto.class);
            cursosDto.setColegiosDto(MHelpers.modelMapper().map(cursos.getColegios(), ColegiosDto.class));
            cursosDto.setProfesoresDto(MHelpers.modelMapper().map(cursos.getProfesores(), RecursoHumanoDto.class));
            cursosDto.setGradosDto(MHelpers.modelMapper().map(cursos.getGrados(), GradosDto.class));
			listacursosDto.add(cursosDto);
		}

		return listacursosDto;
    }

    @Override
    public CursosDto findByid(UUID id) {
        Optional<Cursos> cursos = this.CursosDao.findById(id);
		CursosDto cursosDto = MHelpers.modelMapper().map(cursos.get(), CursosDto.class);
        cursosDto.setColegiosDto(MHelpers.modelMapper().map(cursos.get().getColegios(), ColegiosDto.class));
        cursosDto.setProfesoresDto(MHelpers.modelMapper().map(cursos.get().getProfesores(), RecursoHumanoDto.class));
        cursosDto.setGradosDto(MHelpers.modelMapper().map(cursos.get().getGrados(), GradosDto.class));

		return cursosDto;
    }

    @Override
    public CursosDto save(CursosDto cursosDto) {
        Cursos cursos = MHelpers.modelMapper().map(cursosDto, Cursos.class);

		cursos = this.CursosDao.save(cursos);
		cursosDto = MHelpers.modelMapper().map(cursos, CursosDto.class);

		return cursosDto;
    }

    @Override
    public void delete(CursosDto cursosDto) {
        Cursos cursos = MHelpers.modelMapper().map(cursosDto, Cursos.class);
		this.CursosDao.delete(cursos);
    }

    @Override
    public void deleteById(UUID id) {
        CursosDao.deleteById(id);
    }

    @Override
    public CrudRepository<Cursos, UUID> getDao() {
        return CursosDao;
    }
    
}
