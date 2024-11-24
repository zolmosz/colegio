package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.AlumnosFamiliaDao;
import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.AlumnosFamiliaDto;
import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.entity.AlumnosFamilia;
import com.uan.colegio.service.AlumnosFamiliaService;
import com.uan.colegio.utils.MHelpers;

@Service
public class AlumnosFamiliaServiceImpl extends GenericServiceImpl<AlumnosFamilia, UUID> implements AlumnosFamiliaService {

	@Autowired
	private AlumnosFamiliaDao AlumnosFamiliaDao;

	@Override
	public List<AlumnosFamiliaDto> findAll() {
		List<AlumnosFamiliaDto> listaalumnosFamiliaDto = new ArrayList<>();

		Iterable<AlumnosFamilia> alumnosFamiliaItr = this.AlumnosFamiliaDao.findAll();

		for (AlumnosFamilia alumnosFamilia : alumnosFamiliaItr) {

			AlumnosFamiliaDto alumnosFamiliaDto = new AlumnosFamiliaDto();
			alumnosFamiliaDto = MHelpers.modelMapper().map(alumnosFamilia, AlumnosFamiliaDto.class);
			alumnosFamiliaDto.setColegiosDto(MHelpers.modelMapper().map(alumnosFamilia.getColegios(), ColegiosDto.class));
			alumnosFamiliaDto.setAlumnosBasicosDto(MHelpers.modelMapper().map(alumnosFamilia.getAlumnosBasicos(), AlumnosBasicosDto.class));
			alumnosFamiliaDto.setTipoIdentMadDto(MHelpers.modelMapper().map(alumnosFamilia.getTiposIdentMad(),TiposIdentificacionDto.class));
			alumnosFamiliaDto.setTipoIdentPadDto(MHelpers.modelMapper().map(alumnosFamilia.getTipoIdentPad(),TiposIdentificacionDto.class));
			alumnosFamiliaDto.setTipoIdentAcuDto(MHelpers.modelMapper().map(alumnosFamilia.getTipoIdentAcu(),TiposIdentificacionDto.class));
			alumnosFamiliaDto.setProfesionMadreDto(MHelpers.modelMapper().map(alumnosFamilia.getProfesionMadre(), ProfesionesDto.class));
			alumnosFamiliaDto.setProfPadDto(MHelpers.modelMapper().map(alumnosFamilia.getProfesionesPad(), ProfesionesDto.class));
			alumnosFamiliaDto.setProfesionAcuDto(MHelpers.modelMapper().map(alumnosFamilia.getProfesionAcu(), ProfesionesDto.class));
			alumnosFamiliaDto.setCiudadExpedMadDto(MHelpers.modelMapper().map(alumnosFamilia.getCiudadExpedMad(), CiudadesDto.class));
			alumnosFamiliaDto.setCiudadExpedPadDto(MHelpers.modelMapper().map(alumnosFamilia.getCiudadExpedPad(), CiudadesDto.class));
			alumnosFamiliaDto.setCiudadExpedAcuDto(MHelpers.modelMapper().map(alumnosFamilia.getCiudadExpedAcu(), CiudadesDto.class));
			alumnosFamiliaDto.setBarrioResMadDto(MHelpers.modelMapper().map(alumnosFamilia.getBarrioResMad(), BarriosDto.class));
			alumnosFamiliaDto.setBarrioResPadDto(MHelpers.modelMapper().map(alumnosFamilia.getBarrioResPad(), BarriosDto.class));
			listaalumnosFamiliaDto.add(alumnosFamiliaDto);
		}

		return listaalumnosFamiliaDto;
	}

	@Override
	public AlumnosFamiliaDto findByid(UUID id) {
		Optional<AlumnosFamilia> alumnosFamilia = this.AlumnosFamiliaDao.findById(id);
		AlumnosFamiliaDto alumnosFamiliaDto = MHelpers.modelMapper().map(alumnosFamilia, AlumnosFamiliaDto.class);
		alumnosFamiliaDto.setColegiosDto(MHelpers.modelMapper().map(alumnosFamilia.get().getColegios(), ColegiosDto.class));
		alumnosFamiliaDto.setAlumnosBasicosDto(MHelpers.modelMapper().map(alumnosFamilia.get().getAlumnosBasicos(), AlumnosBasicosDto.class));
		alumnosFamiliaDto.setTipoIdentMadDto(MHelpers.modelMapper().map(alumnosFamilia.get().getTipoIdentPad(), TiposIdentificacionDto.class));
		alumnosFamiliaDto.setTipoIdentPadDto(MHelpers.modelMapper().map(alumnosFamilia.get().getTipoIdentPad(), TiposIdentificacionDto.class));
		alumnosFamiliaDto.setTipoIdentAcuDto(MHelpers.modelMapper().map(alumnosFamilia.get().getTipoIdentAcu(), TiposIdentificacionDto.class));
		alumnosFamiliaDto.setProfesionMadreDto(MHelpers.modelMapper().map(alumnosFamilia.get().getProfesionMadre(), ProfesionesDto.class));
		alumnosFamiliaDto.setProfPadDto(MHelpers.modelMapper().map(alumnosFamilia.get().getProfesionMadre(), ProfesionesDto.class));
		alumnosFamiliaDto.setProfesionAcuDto(MHelpers.modelMapper().map(alumnosFamilia.get().getProfesionAcu(), ProfesionesDto.class));
		alumnosFamiliaDto.setCiudadExpedMadDto(MHelpers.modelMapper().map(alumnosFamilia.get().getCiudadExpedMad(), CiudadesDto.class));
		alumnosFamiliaDto.setCiudadExpedPadDto(MHelpers.modelMapper().map(alumnosFamilia.get().getCiudadExpedPad(), CiudadesDto.class));
		alumnosFamiliaDto.setCiudadExpedAcuDto(MHelpers.modelMapper().map(alumnosFamilia.get().getCiudadExpedAcu(), CiudadesDto.class));
		alumnosFamiliaDto.setBarrioResMadDto(MHelpers.modelMapper().map(alumnosFamilia.get().getBarrioResMad(), BarriosDto.class));
		alumnosFamiliaDto.setBarrioResPadDto(MHelpers.modelMapper().map(alumnosFamilia.get().getBarrioResPad(), BarriosDto.class));

		return alumnosFamiliaDto;
	}

	@Override
	public AlumnosFamiliaDto findByAlumnosBasicos_AbLlave(UUID id) {
		AlumnosFamilia alumnosFamilia = this.AlumnosFamiliaDao.findByAlumnosBasicos_AbLlave(id);

		AlumnosFamiliaDto alumnosFamiliaDto = MHelpers.modelMapper().map(alumnosFamilia, AlumnosFamiliaDto.class);
		alumnosFamiliaDto.setColegiosDto(MHelpers.modelMapper().map(alumnosFamilia.getColegios(), ColegiosDto.class));
		alumnosFamiliaDto.setAlumnosBasicosDto(MHelpers.modelMapper().map(alumnosFamilia.getAlumnosBasicos(), AlumnosBasicosDto.class));
		alumnosFamiliaDto.setTipoIdentMadDto(MHelpers.modelMapper().map(alumnosFamilia.getTipoIdentPad(), TiposIdentificacionDto.class));
		alumnosFamiliaDto.setTipoIdentPadDto(MHelpers.modelMapper().map(alumnosFamilia.getTipoIdentPad(), TiposIdentificacionDto.class));
		alumnosFamiliaDto.setTipoIdentAcuDto(MHelpers.modelMapper().map(alumnosFamilia.getTipoIdentAcu(), TiposIdentificacionDto.class));
		alumnosFamiliaDto.setProfesionMadreDto(MHelpers.modelMapper().map(alumnosFamilia.getProfesionMadre(), ProfesionesDto.class));
		alumnosFamiliaDto.setProfPadDto(MHelpers.modelMapper().map(alumnosFamilia.getProfesionMadre(), ProfesionesDto.class));
		alumnosFamiliaDto.setProfesionAcuDto(MHelpers.modelMapper().map(alumnosFamilia.getProfesionAcu(), ProfesionesDto.class));
		alumnosFamiliaDto.setCiudadExpedMadDto(MHelpers.modelMapper().map(alumnosFamilia.getCiudadExpedMad(), CiudadesDto.class));
		alumnosFamiliaDto.setCiudadExpedPadDto(MHelpers.modelMapper().map(alumnosFamilia.getCiudadExpedPad(), CiudadesDto.class));
		alumnosFamiliaDto.setCiudadExpedAcuDto(MHelpers.modelMapper().map(alumnosFamilia.getCiudadExpedAcu(), CiudadesDto.class));
		alumnosFamiliaDto.setBarrioResMadDto(MHelpers.modelMapper().map(alumnosFamilia.getBarrioResMad(), BarriosDto.class));
		alumnosFamiliaDto.setBarrioResPadDto(MHelpers.modelMapper().map(alumnosFamilia.getBarrioResPad(), BarriosDto.class));

		return alumnosFamiliaDto;
	}

	@Override
	public AlumnosFamiliaDto save(AlumnosFamiliaDto alumnosFamiliaDto) {
		AlumnosFamilia alumnosFamilia = MHelpers.modelMapper().map(alumnosFamiliaDto, AlumnosFamilia.class);

		alumnosFamilia = this.AlumnosFamiliaDao.save(alumnosFamilia);
		alumnosFamiliaDto = MHelpers.modelMapper().map(alumnosFamilia, AlumnosFamiliaDto.class);

		return alumnosFamiliaDto;
	}

	@Override
	public void delete(AlumnosFamiliaDto alumnosFamiliaDto) {
		AlumnosFamilia alumnosFamilia = MHelpers.modelMapper().map(alumnosFamiliaDto, AlumnosFamilia.class);
		this.AlumnosFamiliaDao.delete(alumnosFamilia);
	}

	@Override
	public CrudRepository<AlumnosFamilia, UUID> getDao() {
		return AlumnosFamiliaDao;
	}

	@Override
	public void deleteById(UUID id) {
		AlumnosFamiliaDao.deleteById(id);		
	}

}
