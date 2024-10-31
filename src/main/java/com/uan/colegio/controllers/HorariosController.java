package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.HorariosDto;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.HorariosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/horarios")
public class HorariosController {
	

	@Autowired
	private HorariosService horariosrv;
	@Autowired
	private ColegiosService colegiosrv;
	
	
	@GetMapping("/")
	public String listarhorarios(Model model, HttpSession sesion) {
		List<HorariosDto> listaDtoHorarios = horariosrv.findAll();
		
		
		model.addAttribute("titulo","Lista de horarios");
		model.addAttribute("horarios",listaDtoHorarios);
		
		return "views/horarios/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		HorariosDto horariosDto = new HorariosDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo horario");
		model.addAttribute("horario", horariosDto);
		model.addAttribute("colegios", listaDtoColegios);
		
		return "views/horarios/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarHorarios(@ModelAttribute HorariosDto horariosDto) {
		
		horariosrv.save(horariosDto);
		
		return "redirect:/views/horarios/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idHorarios,  Model model, HttpSession sesion) {
		
		HorariosDto horariosDto = horariosrv.findByid(idHorarios);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo horario");
		model.addAttribute("horario", horariosDto);
		model.addAttribute("colegios", listaDtoColegios);
		
		return "views/horarios/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idHorarios,  Model model, HttpSession sesion) {
		
		horariosrv.deleteById(idHorarios);
		
		return "redirect:/views/horarios/";
	}
}
