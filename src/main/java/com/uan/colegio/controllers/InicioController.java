package com.uan.colegio.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uan.colegio.entity.Usuarios;
import com.uan.colegio.service.UsuariosService;
import com.uan.colegio.utils.EncriptaSHA3;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class InicioController {
	
	@Autowired
	UsuariosService usersSrv;
	
	@Autowired
	EncriptaSHA3 encripta;
	
	@GetMapping("/inicio")
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping(value={"/","/login"})
	public String login() {		return "/login";
	}
	
	@GetMapping("/access")
	public String access(Model model, HttpSession session) {
		Optional<Usuarios> optUsuario =usersSrv.BuscarPorId((UUID) session.getAttribute("user_session_id"));

		if(optUsuario.isPresent() ){
			session.setAttribute("user_session_id", optUsuario.get().getUsLlave());
			session.setAttribute("user_name", optUsuario.get().getUsNombres()+" "+optUsuario.get().getUsApellidos());
			
			return "redirect:/inicio";
		}else{
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null){
			session.invalidate();
		}
		return "redirect:/login";
	}
	
}
