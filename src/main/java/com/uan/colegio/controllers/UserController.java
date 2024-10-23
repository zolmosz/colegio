package com.uan.colegio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.PerfilesDto;
import com.uan.colegio.dto.UsuariosDto;
import com.uan.colegio.service.PerfilesService;
import com.uan.colegio.service.UsuariosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/users")
public class UserController {
	

	@Autowired
	private UsuariosService usersrv;
	@Autowired
	private PerfilesService perfilSrv;
	
	
	@GetMapping("/")
	public String listarusers(Model model, HttpSession sesion) {
		List<UsuariosDto> listaDtoUsers = usersrv.findAll();
		
		
		model.addAttribute("titulo","Lista de users");
		model.addAttribute("users",listaDtoUsers);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/users/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		UsuariosDto usersDto = new UsuariosDto();
		List<PerfilesDto> listaPerfiles = perfilSrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Usuario");
		model.addAttribute("user", usersDto);
		model.addAttribute("perfiles", listaPerfiles);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/users/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarUsuario(@ModelAttribute UsuariosDto usuarioDto) {
		
		usersrv.save(usuarioDto);
		
		return "/views/users/listar";
	}
}
