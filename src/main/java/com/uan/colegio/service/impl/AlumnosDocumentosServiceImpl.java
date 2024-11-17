package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.AlumnosDocumentosDao;
import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.AlumnosDocumentosDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.entity.AlumnosDocumentos;
import com.uan.colegio.service.AlumnosDocumentosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class AlumnosDocumentosServiceImpl extends GenericServiceImpl<AlumnosDocumentos, UUID> implements AlumnosDocumentosService {

	@Autowired
	private AlumnosDocumentosDao AlumnosDocumentosDao;

	@Override
	public List<AlumnosDocumentosDto> findAll() {
		List<AlumnosDocumentosDto> listaalumnosDocumentosDto = new ArrayList<>();

		Iterable<AlumnosDocumentos> alumnosDocumentosItr = this.AlumnosDocumentosDao.findAll();

		for (AlumnosDocumentos alumnosDocumentos : alumnosDocumentosItr) {

			AlumnosDocumentosDto alumnosDocumentosDto = new AlumnosDocumentosDto();
			alumnosDocumentosDto = MHelpers.modelMapper().map(alumnosDocumentos, AlumnosDocumentosDto.class);
			alumnosDocumentosDto.setColegiosDto(MHelpers.modelMapper().map(alumnosDocumentos.getColegios(), ColegiosDto.class));
			alumnosDocumentosDto.setAlumnosBasicosDto(MHelpers.modelMapper().map(alumnosDocumentos.getAlumnosBasicos(), AlumnosBasicosDto.class));
			listaalumnosDocumentosDto.add(alumnosDocumentosDto);
		}

		return listaalumnosDocumentosDto;
	}

	@Override
	public AlumnosDocumentosDto findByid(UUID id) {
		Optional<AlumnosDocumentos> alumnosDocumentos = this.AlumnosDocumentosDao.findById(id);
		AlumnosDocumentosDto alumnosDocumentosDto = MHelpers.modelMapper().map(alumnosDocumentos.get(), AlumnosDocumentosDto.class);
		alumnosDocumentosDto.setColegiosDto(MHelpers.modelMapper().map(alumnosDocumentos.get().getColegios(), ColegiosDto.class));
		alumnosDocumentosDto.setAlumnosBasicosDto(MHelpers.modelMapper().map(alumnosDocumentos.get().getAlumnosBasicos(), AlumnosBasicosDto.class));

		return alumnosDocumentosDto;
	}

	@Override
	public AlumnosDocumentosDto save(AlumnosDocumentosDto alumnosDocumentosDto) {
		AlumnosDocumentos alumnosDocumentos = MHelpers.modelMapper().map(alumnosDocumentosDto, AlumnosDocumentos.class);

		alumnosDocumentos = this.AlumnosDocumentosDao.save(alumnosDocumentos);
		alumnosDocumentosDto = MHelpers.modelMapper().map(alumnosDocumentos, AlumnosDocumentosDto.class);

		return alumnosDocumentosDto;
	}

	@Override
	public void delete(AlumnosDocumentosDto alumnosDocumentosDto) {
		AlumnosDocumentos alumnosDocumentos = MHelpers.modelMapper().map(alumnosDocumentosDto, AlumnosDocumentos.class);
		this.AlumnosDocumentosDao.delete(alumnosDocumentos);
	}

	@Override
	public CrudRepository<AlumnosDocumentos, UUID> getDao() {
		return AlumnosDocumentosDao;
	}

	@Override
	public void deleteById(UUID id) {
		AlumnosDocumentosDao.deleteById(id);		
	}

}
