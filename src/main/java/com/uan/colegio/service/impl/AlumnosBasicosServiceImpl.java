package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.AlumnosBasicosDao;
import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.AlumnosCompletoDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.EpsDto;
import com.uan.colegio.dto.GradosDto;
import com.uan.colegio.dto.HorariosDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.entity.AlumnosBasicos;
import com.uan.colegio.entity.AlumnosDocumentos;
import com.uan.colegio.entity.AlumnosFamilia;
import com.uan.colegio.service.AlumnosBasicosService;
import com.uan.colegio.utils.MHelpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Service
public class AlumnosBasicosServiceImpl extends GenericServiceImpl<AlumnosBasicos, UUID> implements AlumnosBasicosService {

	@Autowired
	private AlumnosBasicosDao AlumnosBasicosDao;
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<AlumnosBasicosDto> findAll() {
		List<AlumnosBasicosDto> listaalumnosBasicosDto = new ArrayList<>();

		Iterable<AlumnosBasicos> alumnosBasicosItr = this.AlumnosBasicosDao.findAll();

		for (AlumnosBasicos alumnosBasicos : alumnosBasicosItr) {

			AlumnosBasicosDto alumnosBasicosDto = new AlumnosBasicosDto();
			alumnosBasicosDto = MHelpers.modelMapper().map(alumnosBasicos, AlumnosBasicosDto.class);
			alumnosBasicosDto.setColegiosDto(MHelpers.modelMapper().map(alumnosBasicos.getColegios(), ColegiosDto.class));
			alumnosBasicosDto.setEpsDto(MHelpers.modelMapper().map(alumnosBasicos.getEps(), EpsDto.class));
			alumnosBasicosDto.setTiposIdentificacionDto(MHelpers.modelMapper().map(alumnosBasicos.getTiposIdentificacion(), TiposIdentificacionDto.class));
			alumnosBasicosDto.setHorariosDto(MHelpers.modelMapper().map(alumnosBasicos.getHorarios(), HorariosDto.class));
			alumnosBasicosDto.setGradosDto(MHelpers.modelMapper().map(alumnosBasicos.getGrados(), GradosDto.class));
			listaalumnosBasicosDto.add(alumnosBasicosDto);
		}

		return listaalumnosBasicosDto;
	}

	@Override
	public AlumnosBasicosDto findByid(UUID id) {
		Optional<AlumnosBasicos> alumnosBasicos = this.AlumnosBasicosDao.findById(id);
		AlumnosBasicosDto alumnosBasicosDto = MHelpers.modelMapper().map(alumnosBasicos.get(), AlumnosBasicosDto.class);
		alumnosBasicosDto.setColegiosDto(MHelpers.modelMapper().map(alumnosBasicos.get().getColegios(), ColegiosDto.class));
		alumnosBasicosDto.setEpsDto(MHelpers.modelMapper().map(alumnosBasicos.get().getEps(), EpsDto.class));
		alumnosBasicosDto.setTiposIdentificacionDto(MHelpers.modelMapper().map(alumnosBasicos.get().getTiposIdentificacion(), TiposIdentificacionDto.class));
		alumnosBasicosDto.setHorariosDto(MHelpers.modelMapper().map(alumnosBasicos.get().getHorarios(), HorariosDto.class));
		alumnosBasicosDto.setGradosDto(MHelpers.modelMapper().map(alumnosBasicos.get().getGrados(), GradosDto.class));

		return alumnosBasicosDto;
	}

	@Override
	public AlumnosBasicosDto save(AlumnosBasicosDto alumnosBasicosDto) {
		AlumnosBasicos alumnosBasicos = MHelpers.modelMapper().map(alumnosBasicosDto, AlumnosBasicos.class);

		alumnosBasicos = this.AlumnosBasicosDao.save(alumnosBasicos);
		alumnosBasicosDto = MHelpers.modelMapper().map(alumnosBasicos, AlumnosBasicosDto.class);

		return alumnosBasicosDto;
	}

	@Override
	public void delete(AlumnosBasicosDto alumnosBasicosDto) {
		AlumnosBasicos alumnosBasicos = MHelpers.modelMapper().map(alumnosBasicosDto, AlumnosBasicos.class);
		this.AlumnosBasicosDao.delete(alumnosBasicos);
	}

	@Override
	public CrudRepository<AlumnosBasicos, UUID> getDao() {
		return AlumnosBasicosDao;
	}

	@Override
	public void deleteById(UUID id) {
		AlumnosBasicosDao.deleteById(id);		
	}

	@Override
	public byte[] getFotoActual(UUID id) {
		Optional<AlumnosBasicos> alumnosBasicos = this.AlumnosBasicosDao.findById(id);
		AlumnosBasicosDto alumnosBasicosDto = MHelpers.modelMapper().map(alumnosBasicos.get(), AlumnosBasicosDto.class);
		return alumnosBasicosDto.getAbFotoImg();
	}

	@Override
	public List<AlumnosBasicosDto> getAlumnosCompletos() {
		List<AlumnosBasicos> listaAlumnosBasicos = new ArrayList<>();

		// CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// CriteriaQuery<AlumnosBasicos> query = cb.createQuery(AlumnosBasicos.class);

		// Root<AlumnosBasicos> alumnosBasicos = query.from(AlumnosBasicos.class);
		// alumnosBasicos.fetch("colegios", JoinType.LEFT); // Cambia LEFT o INNER según lo necesites
		// alumnosBasicos.fetch("eps", JoinType.LEFT);
		// alumnosBasicos.fetch("tiposIdentificacion", JoinType.LEFT);
		// alumnosBasicos.fetch("horarios", JoinType.LEFT);
		// alumnosBasicos.fetch("grados", JoinType.LEFT);

		// Join<AlumnosBasicos, AlumnosFamilia> familiaJoin = alumnosBasicos.join("familia", JoinType.INNER);
		// Join<AlumnosBasicos, AlumnosDocumentos> documentosJoin = alumnosBasicos.join("documentos", JoinType.INNER);

		// query.select(alumnosBasicos)
		// 	.where(cb.isNotNull(familiaJoin), cb.isNotNull(documentosJoin));

		// listaAlumnosBasicos = entityManager.createQuery(query).getResultList();

		String jpql = "SELECT a FROM AlumnosBasicos a " +
                  "JOIN FETCH a.colegios " +
                  "JOIN FETCH a.eps " +
                  "JOIN FETCH a.tiposIdentificacion " +
                  "JOIN FETCH a.horarios " +
                  "JOIN FETCH a.grados " +
                  "JOIN FETCH a.familia " +
                  "JOIN FETCH a.documentos";

		listaAlumnosBasicos = entityManager.createQuery(jpql, AlumnosBasicos.class).getResultList();

		// Mapear la lista de entidades a una lista de DTOs
		List<AlumnosBasicosDto> listaalumnosBasicosDto = new ArrayList<>();

		for (AlumnosBasicos alumnosBas : listaAlumnosBasicos) {

			AlumnosBasicosDto alumnosBasicosDto = new AlumnosBasicosDto();
			alumnosBasicosDto = MHelpers.modelMapper().map(alumnosBas, AlumnosBasicosDto.class);
			alumnosBasicosDto.setColegiosDto(MHelpers.modelMapper().map(alumnosBas.getColegios(), ColegiosDto.class));
			alumnosBasicosDto.setEpsDto(MHelpers.modelMapper().map(alumnosBas.getEps(), EpsDto.class));
			alumnosBasicosDto.setTiposIdentificacionDto(MHelpers.modelMapper().map(alumnosBas.getTiposIdentificacion(), TiposIdentificacionDto.class));
			alumnosBasicosDto.setHorariosDto(MHelpers.modelMapper().map(alumnosBas.getHorarios(), HorariosDto.class));
			alumnosBasicosDto.setGradosDto(MHelpers.modelMapper().map(alumnosBas.getGrados(), GradosDto.class));
			listaalumnosBasicosDto.add(alumnosBasicosDto);
		}


		return listaalumnosBasicosDto;
	}

}
