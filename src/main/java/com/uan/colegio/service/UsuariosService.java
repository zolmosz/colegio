package com.uan.colegio.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.uan.colegio.commons.GenericService;
import com.uan.colegio.dto.UsuariosDto;
import com.uan.colegio.entity.Usuarios;

public interface UsuariosService extends GenericService<Usuarios, UUID>{
	public List<UsuariosDto> findAll();
	public UsuariosDto findByid(UUID id);
	public UsuariosDto save(UsuariosDto userDto) ;
	void delete(UsuariosDto userDto);
	void deleteById(UUID id);
	public Optional<Usuarios> findByUsCodigo(String user);
	public Optional<Usuarios> BuscarPorId(UUID id);
}
