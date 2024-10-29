package com.uan.colegio.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uan.colegio.entity.Usuarios;
import com.uan.colegio.service.UsuariosService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuariosService usuariossrv;

	@Autowired
	private HttpSession session;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuarios> optUsuario = usuariossrv.findByUsCodigo(username);
		
		if (optUsuario.isPresent()) {
			session.setAttribute("user_session_id", optUsuario.get().getUsLlave());
			Usuarios usuario = optUsuario.get();

			return User.builder()
				.username(usuario.getUsCodigo())
				.password(usuario.getUsClave())
				.roles()
				.build();
		}else{
			throw new UsernameNotFoundException("Usuario no encontrado " + username);
		}

	}

}
