package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.service.TiposIdentificacionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/tipidentificacion")
public class TiposIdentificacionController {
	

	@Autowired
	private TiposIdentificacionService tipIdentificacionsrv;
	
	
	@GetMapping("/")
	public String listarTiposIdentificacion(Model model, HttpSession sesion) {
		List<TiposIdentificacionDto> listaDtoTiposIdentificacion = tipIdentificacionsrv.findAll();
		
		
		model.addAttribute("titulo","Lista de Tipos Identificacion");
		model.addAttribute("tidents",listaDtoTiposIdentificacion);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/tipidentificacion/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		TiposIdentificacionDto tidentDto = new TiposIdentificacionDto();
		
		model.addAttribute("titulo","Formulario nuevo Tipo Identificación");
		model.addAttribute("tident", tidentDto);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/tipidentificacion/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarTiposIdentificacion(@ModelAttribute TiposIdentificacionDto tidentDto) {
		
		tipIdentificacionsrv.save(tidentDto);
		
		return "redirect:/views/tipidentificacion/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idPais,  Model model, HttpSession sesion) {
		
		TiposIdentificacionDto tidentDto = tipIdentificacionsrv.findByid(idPais);
		
		model.addAttribute("titulo","Formulario nuevo Tipo Identificación");
		model.addAttribute("tident", tidentDto);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/tipidentificacion/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idPais,  Model model, HttpSession sesion) {
		
		tipIdentificacionsrv.deleteById(idPais);
		
		return "redirect:/views/tipidentificacion/";
	}
}
