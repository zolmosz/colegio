package com.uan.colegio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.uan.colegio.commons.impl.GenericServiceImpl;
import com.uan.colegio.dao.UsuariosDao;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.PerfilesDto;
import com.uan.colegio.dto.UsuariosDto;
import com.uan.colegio.entity.Usuarios;
import com.uan.colegio.service.UsuariosService;
import com.uan.colegio.utils.MHelpers;

@Service
public class UsuariosServiceImpl extends GenericServiceImpl<Usuarios, UUID> implements UsuariosService {

	@Autowired
	private UsuariosDao usuariosDao;

	@Override
	public List<UsuariosDto> findAll() {
		List<UsuariosDto> listaUserDto = new ArrayList<>();

		Iterable<Usuarios> usuariosItr = this.usuariosDao.findAll();

		for (Usuarios usuario : usuariosItr) {

			UsuariosDto usuarioDto = new UsuariosDto();
			usuarioDto = MHelpers.modelMapper().map(usuario, UsuariosDto.class);
			usuarioDto.setPerfilesDto(MHelpers.modelMapper().map(usuario.getPerfiles(), PerfilesDto.class));
			usuarioDto.setColegiosDto(MHelpers.modelMapper().map(usuario.getColegios(), ColegiosDto.class));
			listaUserDto.add(usuarioDto);
		}

		return listaUserDto;
	}

	@Override
	public UsuariosDto findByid(UUID id) {
		Optional<Usuarios> usuario = this.usuariosDao.findById(id);
		UsuariosDto usuarioDto = MHelpers.modelMapper().map(usuario.get(), UsuariosDto.class);

		return usuarioDto;
	}

	@Override
	public UsuariosDto save(UsuariosDto usuarioDto) {
		Usuarios usuario = MHelpers.modelMapper().map(usuarioDto, Usuarios.class);

		usuario = this.usuariosDao.save(usuario);
		usuarioDto = MHelpers.modelMapper().map(usuario, UsuariosDto.class);

		return usuarioDto;
	}

	@Override
	public void delete(UsuariosDto usuarioDto) {
		Usuarios usuario = MHelpers.modelMapper().map(usuarioDto, Usuarios.class);
		this.usuariosDao.delete(usuario);
	}

	@Override
	public UsuariosDto findByUsCodigo(String usuarioname) {
		Optional<Usuarios> usuario = this.usuariosDao.findByUsCodigo(usuarioname);
		UsuariosDto usuarioDto = MHelpers.modelMapper().map(usuario.get(), UsuariosDto.class);

		return usuarioDto;
	}

	@Override
	public CrudRepository<Usuarios, UUID> getDao() {
		return usuariosDao;
	}

	@Override
	public void deleteById(UUID id) {
		usuariosDao.deleteById(id);
	}

}
