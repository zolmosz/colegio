package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.CargosDto;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.CargosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/cargos")
public class CargosController {
	

	@Autowired
	private CargosService cargosrv;
	@Autowired
	private ColegiosService colegiosrv;
	
	
	@GetMapping("/")
	public String listarcargos(Model model, HttpSession sesion) {
		List<CargosDto> listaDtoCargos = cargosrv.findAll();
		
		
		model.addAttribute("titulo","Lista de cargos");
		model.addAttribute("cargos",listaDtoCargos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/cargos/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		CargosDto cargosDto = new CargosDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Cargo");
		model.addAttribute("cargo", cargosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/cargos/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarCargos(@ModelAttribute CargosDto cargosDto) {
		
		cargosrv.save(cargosDto);
		
		return "redirect:/views/cargos/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idCargo,  Model model, HttpSession sesion) {
		
		CargosDto cargosDto = cargosrv.findByid(idCargo);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Cargo");
		model.addAttribute("cargo", cargosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/cargos/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idCargo,  Model model, HttpSession sesion) {
		
		cargosrv.deleteById(idCargo);
		
		return "redirect:/views/cargos/";
	}
}
