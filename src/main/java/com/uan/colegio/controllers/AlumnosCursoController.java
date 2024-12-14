package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.AlumnosCursoDto;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.dto.RecursoHumanoDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.CursosDto;
import com.uan.colegio.dto.DepartamentosDto;
import com.uan.colegio.dto.GradosDto;
import com.uan.colegio.dto.LocalidadesDto;
import com.uan.colegio.service.AlumnosBasicosService;
import com.uan.colegio.service.AlumnosCursoService;
import com.uan.colegio.service.LocalidadesService;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.CursosService;
import com.uan.colegio.service.DepartamentosService;
import com.uan.colegio.service.GradosService;
import com.uan.colegio.service.PaisesService;
import com.uan.colegio.service.RecursoHumanoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/alumnoscurso")
public class AlumnosCursoController {
	

	@Autowired
	private ColegiosService colegiosrv;
	@Autowired
	private CursosService cursosrv;
	@Autowired
	private AlumnosBasicosService alumnosBasicosrv;
	@Autowired
	private AlumnosCursoService alumnosCursorv;
	
	
	
	@GetMapping("/")
	public String listarAlumnosCurso(Model model, HttpSession sesion) {
		List<AlumnosCursoDto> listaDtoAlumnosCurso = alumnosCursorv.findAll();
		
		model.addAttribute("titulo","Lista de Alumnos por Curso");
		model.addAttribute("alumnosCurso",listaDtoAlumnosCurso);
		
		return "views/alumnoscurso/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		AlumnosCursoDto alumnosCursoDto = new AlumnosCursoDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		List<CursosDto> listaDtoCursos = cursosrv.findAll();
		List<AlumnosBasicosDto> listaDtoAlumnosBasicos = alumnosBasicosrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Alumno al Curso");
		model.addAttribute("alumnosCurso", alumnosCursoDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("cursos", listaDtoCursos);
		model.addAttribute("alumnos", listaDtoAlumnosBasicos);
		
		return "views/alumnoscurso/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarAlumnosCurso(@ModelAttribute AlumnosCursoDto alumnosCursoDto) {
		
		alumnosCursorv.save(alumnosCursoDto);
		
		return "redirect:/views/alumnoscurso/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idcurso,  Model model, HttpSession sesion) {
		
		AlumnosCursoDto alumnosCursoDto = alumnosCursorv.findByid(idcurso);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		List<CursosDto> listaDtoCursos = cursosrv.findAll();
		List<AlumnosBasicosDto> listaDtoAlumnosBasicos = alumnosBasicosrv.findAll();

		model.addAttribute("titulo","Formulario nuevo Alumno por Curso");
		model.addAttribute("alumnosCurso", alumnosCursoDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("cursos", listaDtoCursos);
		model.addAttribute("alumnos", listaDtoAlumnosBasicos);
		
		return "views/alumnoscurso/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idcurso,  Model model, HttpSession sesion) {
		
		alumnosCursorv.deleteById(idcurso);
		
		return "redirect:/views/alumnoscurso/";
	}
}
