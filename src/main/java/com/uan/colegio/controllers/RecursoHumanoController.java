package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.dto.CargosDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.PerfilesDto;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.dto.RecursoHumanoDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.service.BarriosService;
import com.uan.colegio.service.CargosService;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.PerfilesService;
import com.uan.colegio.service.ProfesionesService;
import com.uan.colegio.service.RecursoHumanoService;
import com.uan.colegio.service.TiposIdentificacionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/rechumano")
public class RecursoHumanoController {
	
	@Autowired
	private RecursoHumanoService rechumanosrv;
	@Autowired
	private ColegiosService colegiosrv;
	@Autowired
	private TiposIdentificacionService tipoidentsrv;
	@Autowired
	private ProfesionesService profesionsrv;
	@Autowired
	private CargosService cargosrv;
	@Autowired
	private CiudadesService ciudadsrv;
	@Autowired
	private BarriosService barriosrv;
	
	
	@GetMapping("/")
	public String listarRecHumano(Model model, HttpSession sesion) {
		List<RecursoHumanoDto> listaDtoRecursoHumano = rechumanosrv.findAll();
		
		model.addAttribute("titulo","Lista de Recursos Humanos");
		model.addAttribute("rechumanos",listaDtoRecursoHumano);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/rechumano/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		RecursoHumanoDto rechumanoDto = new RecursoHumanoDto();
		List<ColegiosDto> listaColegiosDto = colegiosrv.findAll();
		List<TiposIdentificacionDto> listaTipoIdentDto = tipoidentsrv.findAll();
		List<ProfesionesDto> listaProfesionesDtos = profesionsrv.findAll();
		List<CargosDto> listaCargosDtos = cargosrv.findAll();
		List<CiudadesDto> listaCiudadesDtos = ciudadsrv.findAll();
		List<BarriosDto> listaBarriosDtos = barriosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Recurso Humano");
		model.addAttribute("rechumano", rechumanoDto);
		model.addAttribute("colegios",listaColegiosDto);
		model.addAttribute("tipident", listaTipoIdentDto);
		model.addAttribute("profesiones", listaProfesionesDtos);
		model.addAttribute("cargos", listaCargosDtos);
		model.addAttribute("ciudades", listaCiudadesDtos);
		model.addAttribute("barrios", listaBarriosDtos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/rechumano/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarRecursoHumano(@ModelAttribute RecursoHumanoDto rechumanoDto) {
		
		rechumanosrv.save(rechumanoDto);
		
		return "redirect:/views/rechumano/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idUsuario,  Model model, HttpSession sesion) {
		
		RecursoHumanoDto rechumanoDto = rechumanosrv.findByid(idUsuario);
		List<ColegiosDto> listaColegiosDto = colegiosrv.findAll();
		List<TiposIdentificacionDto> listaTipoIdentDto = tipoidentsrv.findAll();
		List<ProfesionesDto> listaProfesionesDtos = profesionsrv.findAll();
		List<CargosDto> listaCargosDtos = cargosrv.findAll();
		List<CiudadesDto> listaCiudadesDtos = ciudadsrv.findAll();
		List<BarriosDto> listaBarriosDtos = barriosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Usuario");
		model.addAttribute("rechumano", rechumanoDto);
		model.addAttribute("colegios",listaColegiosDto);
		model.addAttribute("tipident", listaTipoIdentDto);
		model.addAttribute("profesiones", listaProfesionesDtos);
		model.addAttribute("cargos", listaCargosDtos);
		model.addAttribute("ciudades", listaCiudadesDtos);
		model.addAttribute("barrios", listaBarriosDtos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/rechumano/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idUsuario,  Model model, HttpSession sesion) {
		
		rechumanosrv.deleteById(idUsuario);
		
		return "redirect:/views/rechumano/";
	}
}
