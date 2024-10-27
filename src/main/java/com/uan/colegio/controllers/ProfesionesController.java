package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.ProfesionesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/profesiones")
public class ProfesionesController {
	

	@Autowired
	private ProfesionesService profesionesrv;
	@Autowired
	private ColegiosService colegiosrv;
	
	
	@GetMapping("/")
	public String listarprofesiones(Model model, HttpSession sesion) {
		List<ProfesionesDto> listaDtoProfesiones = profesionesrv.findAll();
		
		
		model.addAttribute("titulo","Lista de profesiones");
		model.addAttribute("profesiones",listaDtoProfesiones);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/profesiones/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		ProfesionesDto profesionesDto = new ProfesionesDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Cargo");
		model.addAttribute("profesion", profesionesDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/profesiones/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarProfesiones(@ModelAttribute ProfesionesDto profesionesDto) {
		
		profesionesrv.save(profesionesDto);
		
		return "redirect:/views/profesiones/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idProfesion,  Model model, HttpSession sesion) {
		
		ProfesionesDto profesionesDto = profesionesrv.findByid(idProfesion);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nueva Profesion");
		model.addAttribute("profesion", profesionesDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/profesiones/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idProfesion,  Model model, HttpSession sesion) {
		
		profesionesrv.deleteById(idProfesion);
		
		return "redirect:/views/profesiones/";
	}
}
