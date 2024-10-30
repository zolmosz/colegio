package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.dto.CargosDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.dto.DirectivoDto;
import com.uan.colegio.dto.DirectivosDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.service.BarriosService;
import com.uan.colegio.service.CargosService;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.DirectivosService;
import com.uan.colegio.service.ProfesionesService;
import com.uan.colegio.service.DirectivoService;
import com.uan.colegio.service.TiposIdentificacionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/directivo")
public class DirectivosController {
	
	@Autowired
	private DirectivosService directivosrv;
	@Autowired
	private ColegiosService colegiosrv;
	@Autowired
	private TiposIdentificacionService tipoidentsrv;
	@Autowired
	private CargosService cargosrv;
	
	
	@GetMapping("/")
	public String listarDirectivos(Model model, HttpSession sesion) {
		List<DirectivosDto> listaDtoDirectivo = directivosrv.findAll();
		
		model.addAttribute("titulo","Lista de Directivo");
		model.addAttribute("directivos",listaDtoDirectivo);
		
		return "views/directivo/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		DirectivosDto directivoDto = new DirectivosDto();
		List<ColegiosDto> listaColegiosDto = colegiosrv.findAll();
		List<TiposIdentificacionDto> listaTipoIdentDto = tipoidentsrv.findAll();
		List<CargosDto> listaCargosDtos = cargosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Directivo");
		model.addAttribute("directivo", directivoDto);
		model.addAttribute("colegios",listaColegiosDto);
		model.addAttribute("tipident", listaTipoIdentDto);
		model.addAttribute("cargos", listaCargosDtos);
		
		return "views/directivo/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarDirectivo(@ModelAttribute DirectivosDto directivoDto) {
		
		directivosrv.save(directivoDto);
		
		return "redirect:/views/directivo/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idUsuario,  Model model, HttpSession sesion) {
		
		DirectivosDto directivoDto = directivosrv.findByid(idUsuario);
		List<ColegiosDto> listaColegiosDto = colegiosrv.findAll();
		List<TiposIdentificacionDto> listaTipoIdentDto = tipoidentsrv.findAll();
		List<CargosDto> listaCargosDtos = cargosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Directivo");
		model.addAttribute("directivo", directivoDto);
		model.addAttribute("colegios",listaColegiosDto);
		model.addAttribute("tipident", listaTipoIdentDto);
		model.addAttribute("cargos", listaCargosDtos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/directivo/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idUsuario,  Model model, HttpSession sesion) {
		
		directivosrv.deleteById(idUsuario);
		
		return "redirect:/views/directivo/";
	}
}
