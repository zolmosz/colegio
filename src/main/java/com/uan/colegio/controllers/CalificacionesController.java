package com.uan.colegio.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.CalificacionesDto;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.CalificacionesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/notas/calificaciones")
public class CalificacionesController {
	

	@Autowired
	private CalificacionesService calificacionesrv;
	@Autowired
	private ColegiosService colegiosrv;
	
	
	@GetMapping("/")
	public String listarcalificaciones(Model model, HttpSession sesion) {
		List<CalificacionesDto> listaDtoCalificaciones = calificacionesrv.findAll();
		
		
		model.addAttribute("titulo","Lista de calificaciones");
		model.addAttribute("calificaciones",listaDtoCalificaciones);
		
		return "views/notas/calificaciones/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		CalificacionesDto calificacionesDto = new CalificacionesDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Calificación");
		model.addAttribute("calificaciones", calificacionesDto);
		model.addAttribute("colegios", listaDtoColegios);
		
		return "views/notas/calificaciones/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarCalificaciones(@ModelAttribute CalificacionesDto calificacionesDto, @RequestParam(value="imagenCal", required = false) MultipartFile imagen ) throws IOException {
		CalificacionesDto califDto = new CalificacionesDto();

		if (calificacionesDto.getCaLlave() != null){
			califDto = calificacionesrv.findByid(calificacionesDto.getCaLlave());
		}

		calificacionesDto.setCaImagen((!imagen.isEmpty() && imagen != null) ? imagen.getBytes():califDto.getCaImagen());

		calificacionesrv.save(calificacionesDto);
		
		return "redirect:/views/notas/calificaciones/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idCalifica,  Model model, HttpSession sesion) {
		
		CalificacionesDto calificacionesDto = calificacionesrv.findByid(idCalifica);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		String b64Icalifica = (calificacionesDto.getCaImagen() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(calificacionesDto.getCaImagen()):"";

		model.addAttribute("b64Icalifica", b64Icalifica);
		model.addAttribute("titulo","Formulario nueva calificación");
		model.addAttribute("calificaciones", calificacionesDto);
		model.addAttribute("colegios", listaDtoColegios);
		
		return "views/notas/calificaciones/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idCargo,  Model model, HttpSession sesion) {
		
		calificacionesrv.deleteById(idCargo);
		
		return "redirect:/views/notas/calificaciones/";
	}
}
