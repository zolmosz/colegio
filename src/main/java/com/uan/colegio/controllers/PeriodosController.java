package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.PeriodosDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.service.PeriodosService;
import com.uan.colegio.service.ColegiosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/notas/periodos")
public class PeriodosController {
	

	@Autowired
	private ColegiosService colegiosrv;
	@Autowired
	private PeriodosService periodosrv;
	
	
	
	@GetMapping("/")
	public String listarPeriodos(Model model, HttpSession sesion) {
		List<PeriodosDto> listaDtoPeriodos = periodosrv.findAll();
		
		model.addAttribute("titulo","Lista de Periodos");
		model.addAttribute("Periodos",listaDtoPeriodos);
		
		return "views/notas/periodos/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		PeriodosDto periodosDto = new PeriodosDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Periodo");
		model.addAttribute("Periodos", periodosDto);
		model.addAttribute("colegios", listaDtoColegios);
		
		return "views/notas/periodos/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarPeriodos(@ModelAttribute PeriodosDto periodosDto) {
		
		periodosrv.save(periodosDto);
		
		return "redirect:/views/notas/periodos/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idperiodo,  Model model, HttpSession sesion) {
		
		PeriodosDto periodosDto = periodosrv.findByid(idperiodo);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();

		model.addAttribute("titulo","Formulario nuevo Curso");
		model.addAttribute("Periodos", periodosDto);
		model.addAttribute("colegios", listaDtoColegios);
		
		return "views/notas/periodos/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idperiodo,  Model model, HttpSession sesion) {
		
		periodosrv.deleteById(idperiodo);
		
		return "redirect:/views/notas/periodos/";
	}
}
