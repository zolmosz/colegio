package com.uan.colegio.controllers;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.AlumnosFamiliaDto;
import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.entity.AlumnosBasicos;
import com.uan.colegio.service.AlumnosBasicosService;
import com.uan.colegio.service.AlumnosFamiliaService;
import com.uan.colegio.service.BarriosService;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.ProfesionesService;
import com.uan.colegio.service.TiposIdentificacionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/alumnosfam")
public class AlumnosFamiliaController {

	@Autowired
	private ColegiosService colegiossrv;
	@Autowired
	private TiposIdentificacionService tiposIdentificacionsrv;
	@Autowired
	private CiudadesService ciudadsrv;
	@Autowired
	private BarriosService barriosrv;
	@Autowired
	private AlumnosFamiliaService alumnosFamiliasrv;
	@Autowired
	private AlumnosBasicosService alumnosBasicosrv;
	@Autowired
	private ProfesionesService profesionessrv;
	
	
	@GetMapping("/")
	public String listarAlumnosFamilia(Model model, HttpSession sesion) {
		List<AlumnosFamiliaDto> listaDtoAlumnosFamilia = alumnosFamiliasrv.findAll();
		
		model.addAttribute("titulo","Lista de Alumnos");
		model.addAttribute("alumnos",listaDtoAlumnosFamilia);
		
		return "views/alumnosfam/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		AlumnosFamiliaDto alumnosFamiliaDto = new AlumnosFamiliaDto();
		List<AlumnosBasicosDto> listaAlumnosBasicosDtos = alumnosBasicosrv.findAll();
		List<ColegiosDto> listaDtoColegios = colegiossrv.findAll();
		List<TiposIdentificacionDto> listaDtoTiposIdentificacion = tiposIdentificacionsrv.findAll();
		List<CiudadesDto> listaCiudadesDtos = ciudadsrv.findAll();
		List<BarriosDto> listaBarriosDtos = barriosrv.findAll();
		List<ProfesionesDto> listaProfesionesDtos =  profesionessrv.findAll();

		model.addAttribute("titulo","Formulario nuevo alumno");
		model.addAttribute("alumnofam", alumnosFamiliaDto);
		model.addAttribute("alumnosbas", listaAlumnosBasicosDtos);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("tipident", listaDtoTiposIdentificacion);
		model.addAttribute("ciudades", listaCiudadesDtos);
		model.addAttribute("barrios", listaBarriosDtos);
		model.addAttribute("profesiones", listaProfesionesDtos);
		
		return "views/alumnosfam/crear";
	}
	

	@PostMapping("/salvar")
	public String salvarAlumnos(@ModelAttribute AlumnosFamiliaDto alumnosFamiliaDto) throws IOException {
		
		alumnosFamiliasrv.save(alumnosFamiliaDto);
		
		return "redirect:/views/alumnosfam/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idAlumno,  Model model, HttpSession sesion) {
		
		AlumnosFamiliaDto alumnosFamiliaDto = alumnosFamiliasrv.findByid(idAlumno);
		List<AlumnosBasicosDto> listaAlumnosBasicosDtos = alumnosBasicosrv.findAll();
		List<ColegiosDto> listaDtoColegios = colegiossrv.findAll();
		List<TiposIdentificacionDto> listaDtoTiposIdentificacion = tiposIdentificacionsrv.findAll();
		List<CiudadesDto> listaCiudadesDtos = ciudadsrv.findAll();
		List<BarriosDto> listaBarriosDtos = barriosrv.findAll();
		List<ProfesionesDto> listaProfesionesDtos =  profesionessrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo alumno");
		model.addAttribute("alumnofam", alumnosFamiliaDto);
		model.addAttribute("alumnosbas", listaAlumnosBasicosDtos);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("tipident", listaDtoTiposIdentificacion);
		model.addAttribute("ciudades", listaCiudadesDtos);
		model.addAttribute("barrios", listaBarriosDtos);
		model.addAttribute("profesiones", listaProfesionesDtos);
		
		return "views/alumnosfam/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idAlumno,  Model model, HttpSession sesion) {
		
		alumnosFamiliasrv.deleteById(idAlumno);
		
		return "redirect:/views/alumnosfam/";
	}
}
