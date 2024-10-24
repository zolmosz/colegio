package com.uan.colegio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uan.colegio.dto.LoginRequest;
import com.uan.colegio.dto.UsuariosDto;
import com.uan.colegio.service.UsuariosService;
import com.uan.colegio.utils.EncriptaSHA3;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class InicioController {
	
	@Autowired
	UsuariosService usersSrv;
	
	@Autowired
	EncriptaSHA3 encripta;
	
	@GetMapping("/")
	public String inicio() {
//		return "inicio";
		return "login";
	}
	
	@PostMapping(value={"/logout"})
	public String logout() {
		return "/login";
	}
	
	@GetMapping(value={"/login"})
	public String login() {
		return "/inicio";
	}
	
	@PostMapping("/logginprocess")
	public String inicio(@ModelAttribute LoginRequest loginRequest, HttpSession sesion, Model model) {
		
//		UsuariosDto usuarioDto = usersSrv.findByUsCodigo(loginRequest.getUsername());
		
		
//		sesion.setAttribute("username", usuarioDto.getUsCodigo());
//		sesion.setAttribute("fname", usuarioDto.getUsNombres());
//		sesion.setAttribute("lname", usuarioDto.getUsApellidos());
		
//		model.addAttribute("titulo", "Bienvenido, Pagina de Inicio");
//		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
//		String usuario = encripta.getEncriptaSHA3_512(loginRequest.getPassword());
		
//		if (usuarioDto.getUsClave().equals(encripta.getEncriptaSHA3_512(loginRequest.getPassword()))) {
//			return "inicio";
//		}else {
//			return "login";
//		}
		
		return "inicio";
		
	}
}
