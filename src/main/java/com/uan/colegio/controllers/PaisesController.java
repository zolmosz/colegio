package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.service.PaisesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/paises")
public class PaisesController {
	

	@Autowired
	private PaisesService paissrv;
	
	
	@GetMapping("/")
	public String listarpaises(Model model, HttpSession sesion) {
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		
		
		model.addAttribute("titulo","Lista de paises");
		model.addAttribute("paises",listaDtoPaises);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/paises/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		PaisesDto paisesDto = new PaisesDto();
		
		model.addAttribute("titulo","Formulario nuevo Pais");
		model.addAttribute("pais", paisesDto);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/paises/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarPaises(@ModelAttribute PaisesDto paisesDto) {
		
		paissrv.save(paisesDto);
		
		return "redirect:/views/paises/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idPais,  Model model, HttpSession sesion) {
		
		PaisesDto paisesDto = paissrv.findByid(idPais);
		
		model.addAttribute("titulo","Formulario nuevo Pais");
		model.addAttribute("pais", paisesDto);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/paises/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idPais,  Model model, HttpSession sesion) {
		
		paissrv.deleteById(idPais);
		
		return "redirect:/views/paises/";
	}
}
