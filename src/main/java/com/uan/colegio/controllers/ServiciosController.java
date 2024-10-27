package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.ServiciosDto;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.ServiciosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/servicios")
public class ServiciosController {
	

	@Autowired
	private ServiciosService serviciosrv;
	@Autowired
	private ColegiosService colegiosrv;
	
	
	@GetMapping("/")
	public String listarservicios(Model model, HttpSession sesion) {
		List<ServiciosDto> listaDtoServicios = serviciosrv.findAll();
		
		
		model.addAttribute("titulo","Lista de servicios");
		model.addAttribute("servicios",listaDtoServicios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/servicios/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		ServiciosDto serviciosDto = new ServiciosDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Perfil");
		model.addAttribute("servicio", serviciosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/servicios/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarServicios(@ModelAttribute ServiciosDto serviciosDto) {
		
		serviciosrv.save(serviciosDto);
		
		return "redirect:/views/servicios/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idServicio,  Model model, HttpSession sesion) {
		
		ServiciosDto serviciosDto = serviciosrv.findByid(idServicio);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Perfil");
		model.addAttribute("servicio", serviciosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/servicios/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idServicio,  Model model, HttpSession sesion) {
		
		serviciosrv.deleteById(idServicio);
		
		return "redirect:/views/servicios/";
	}
}
