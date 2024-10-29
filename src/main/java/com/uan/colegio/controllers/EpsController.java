package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.EpsDto;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.EpsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/eps")
public class EpsController {
	

	@Autowired
	private EpsService epsrv;
	@Autowired
	private ColegiosService colegiosrv;
	
	
	@GetMapping("/")
	public String listareps(Model model, HttpSession sesion) {
		List<EpsDto> listaDtoEps = epsrv.findAll();
		
		
		model.addAttribute("titulo","Lista de eps");
		model.addAttribute("eps",listaDtoEps);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/eps/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		EpsDto epsDto = new EpsDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Cargo");
		model.addAttribute("eps", epsDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/eps/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarEps(@ModelAttribute EpsDto epsDto) {
		
		epsrv.save(epsDto);
		
		return "redirect:/views/eps/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idEps,  Model model, HttpSession sesion) {
		
		EpsDto epsDto = epsrv.findByid(idEps);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Cargo");
		model.addAttribute("eps", epsDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/eps/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idEps,  Model model, HttpSession sesion) {
		
		epsrv.deleteById(idEps);
		
		return "redirect:/views/eps/";
	}
}
