package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.PerfilesDto;
import com.uan.colegio.dto.UsuariosDto;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.PerfilesService;
import com.uan.colegio.service.UsuariosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/usuarios")
public class UsuariosController {
	

	@Autowired
	private UsuariosService usuariosrv;
	@Autowired
	private ColegiosService colegiosrv;
	@Autowired
	private PerfilesService perfilsrv;
	
	
	@GetMapping("/")
	public String listarusuarios(Model model, HttpSession sesion) {
		List<UsuariosDto> listaDtoUsuarios = usuariosrv.findAll();
		
		
		model.addAttribute("titulo","Lista de usuarios");
		model.addAttribute("usuarios",listaDtoUsuarios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/usuarios/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		UsuariosDto usuariosDto = new UsuariosDto();
		List<ColegiosDto> listaColegiosDto = colegiosrv.findAll();
		List<PerfilesDto> listaPerfilesDtos = perfilsrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Usuario");
		model.addAttribute("usuario", usuariosDto);
		model.addAttribute("colegios",listaColegiosDto);
		model.addAttribute("perfiles", listaPerfilesDtos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/usuarios/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarUsuarios(@ModelAttribute UsuariosDto usuariosDto) {
		
		usuariosrv.save(usuariosDto);
		
		return "redirect:/views/usuarios/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idUsuario,  Model model, HttpSession sesion) {
		
		UsuariosDto usuariosDto = usuariosrv.findByid(idUsuario);
		List<ColegiosDto> listaColegiosDto = colegiosrv.findAll();
		List<PerfilesDto> listaPerfilesDtos = perfilsrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Usuario");
		model.addAttribute("usuario", usuariosDto);
		model.addAttribute("colegios",listaColegiosDto);
		model.addAttribute("perfiles", listaPerfilesDtos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/usuarios/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idUsuario,  Model model, HttpSession sesion) {
		
		usuariosrv.deleteById(idUsuario);
		
		return "redirect:/views/usuarios/";
	}
}
