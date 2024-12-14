package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.AlumnosCursoDao;
import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.AlumnosCursoDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.CursosDto;
import com.uan.colegio.entity.AlumnosCurso;
import com.uan.colegio.service.AlumnosCursoService;
import com.uan.colegio.utils.MHelpers;

@Service
public class AlumnosCursoServiceImpl extends GenericServiceImpl<AlumnosCurso, UUID> implements AlumnosCursoService {

    @Autowired
	private AlumnosCursoDao AlumnosCursoDao;


    @Override
    public List<AlumnosCursoDto> findAll() {
        List<AlumnosCursoDto> listaAlumnosCursoDto = new ArrayList<>();

		Iterable<AlumnosCurso> alumnosCursoItr = this.AlumnosCursoDao.findAll();

		for (AlumnosCurso alumnosCurso : alumnosCursoItr) {

			AlumnosCursoDto alumnosCursoDto = new AlumnosCursoDto();
			alumnosCursoDto = MHelpers.modelMapper().map(alumnosCurso, AlumnosCursoDto.class);
            alumnosCursoDto.setColegiosDto(MHelpers.modelMapper().map(alumnosCurso.getColegios(), ColegiosDto.class));
            alumnosCursoDto.setCursosDto(MHelpers.modelMapper().map(alumnosCurso.getCursos(), CursosDto.class));
            alumnosCursoDto.setAlumnosBasicosDto(MHelpers.modelMapper().map(alumnosCurso.getAlumnosBasicos(), AlumnosBasicosDto.class));
			listaAlumnosCursoDto.add(alumnosCursoDto);
		}

		return listaAlumnosCursoDto;
    }

    @Override
    public AlumnosCursoDto findByid(UUID id) {
        Optional<AlumnosCurso> alumnosCurso = this.AlumnosCursoDao.findById(id);
		AlumnosCursoDto alumnosCursoDto = MHelpers.modelMapper().map(alumnosCurso.get(), AlumnosCursoDto.class);
        alumnosCursoDto.setColegiosDto(MHelpers.modelMapper().map(alumnosCurso.get().getColegios(), ColegiosDto.class));
        alumnosCursoDto.setCursosDto(MHelpers.modelMapper().map(alumnosCurso.get().getCursos(), CursosDto.class));
        alumnosCursoDto.setAlumnosBasicosDto(MHelpers.modelMapper().map(alumnosCurso.get().getAlumnosBasicos(), AlumnosBasicosDto.class));

		return alumnosCursoDto;
    }

    @Override
    public AlumnosCursoDto save(AlumnosCursoDto alumnosCursoDto) {
        AlumnosCurso alumnosCurso = MHelpers.modelMapper().map(alumnosCursoDto, AlumnosCurso.class);

		alumnosCurso = this.AlumnosCursoDao.save(alumnosCurso);
		alumnosCursoDto = MHelpers.modelMapper().map(alumnosCurso, AlumnosCursoDto.class);

		return alumnosCursoDto;
    }

    @Override
    public void delete(AlumnosCursoDto alumnosCursoDto) {
        AlumnosCurso alumnosCurso = MHelpers.modelMapper().map(alumnosCursoDto, AlumnosCurso.class);
		this.AlumnosCursoDao.delete(alumnosCurso);
    }

    @Override
    public void deleteById(UUID id) {
        AlumnosCursoDao.deleteById(id);
    }

    @Override
    public CrudRepository<AlumnosCurso, UUID> getDao() {
        return AlumnosCursoDao;
    }

}
