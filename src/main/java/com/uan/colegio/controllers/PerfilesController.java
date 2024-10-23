package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.PerfilesDto;
import com.uan.colegio.service.PerfilesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/perfiles")
public class PerfilesController {
	

	@Autowired
	private PerfilesService perfilsrv;
	
	
	@GetMapping("/")
	public String listarperfiles(Model model, HttpSession sesion) {
		List<PerfilesDto> listaDtoPerfiles = perfilsrv.findAll();
		
		
		model.addAttribute("titulo","Lista de perfiles");
		model.addAttribute("perfiles",listaDtoPerfiles);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/perfiles/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		PerfilesDto perfilesDto = new PerfilesDto();
		
		model.addAttribute("titulo","Formulario nuevo Perfil");
		model.addAttribute("perfil", perfilesDto);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/perfiles/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarPerfiles(@ModelAttribute PerfilesDto perfilesDto) {
		
		perfilsrv.save(perfilesDto);
		
		return "redirect:/views/perfiles/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idPerfil,  Model model, HttpSession sesion) {
		
		PerfilesDto perfilesDto = perfilsrv.findByid(idPerfil);
		
		model.addAttribute("titulo","Formulario nuevo Perfil");
		model.addAttribute("perfil", perfilesDto);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/perfiles/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idPerfil,  Model model, HttpSession sesion) {
		
		perfilsrv.deleteById(idPerfil);
		
		return "redirect:/views/perfiles/";
	}
}
