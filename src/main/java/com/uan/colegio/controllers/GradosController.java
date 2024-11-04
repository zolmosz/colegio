package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.CargosDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.GradosDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.service.CargosService;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.GradosService;
import com.uan.colegio.service.GradosService;
import com.uan.colegio.service.TiposIdentificacionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/grados")
public class GradosController {
	
	@Autowired
	private GradosService gradosrv;
	@Autowired
	private ColegiosService colegiosrv;
	
	@GetMapping("/")
	public String listarGrados(Model model, HttpSession sesion) {
		List<GradosDto> listaDtoGrados = gradosrv.findAll();
		
		model.addAttribute("titulo","Lista de Grados");
		model.addAttribute("grados",listaDtoGrados);
		
		return "views/grados/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		GradosDto gradoDto = new GradosDto();
		List<ColegiosDto> listaColegiosDto = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Grado");
		model.addAttribute("grado", gradoDto);
		model.addAttribute("colegios",listaColegiosDto);
		
		return "views/grados/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarDirectivo(@ModelAttribute GradosDto gradoDto) {
		
		gradosrv.save(gradoDto);
		
		return "redirect:/views/grados/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idGrado,  Model model, HttpSession sesion) {
		
		GradosDto gradoDto = gradosrv.findByid(idGrado);
		List<ColegiosDto> listaColegiosDto = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Grado");
		model.addAttribute("grado", gradoDto);
		model.addAttribute("colegios",listaColegiosDto);
		
		return "views/grados/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idGrado,  Model model, HttpSession sesion) {
		
		gradosrv.deleteById(idGrado);
		
		return "redirect:/views/grados/";
	}
}
