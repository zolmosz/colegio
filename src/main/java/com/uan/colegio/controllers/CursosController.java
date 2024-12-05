package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.CursosDto;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.dto.RecursoHumanoDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.DepartamentosDto;
import com.uan.colegio.dto.GradosDto;
import com.uan.colegio.dto.LocalidadesDto;
import com.uan.colegio.service.CursosService;
import com.uan.colegio.service.LocalidadesService;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.service.ColegiosService;
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
@RequestMapping("/views/cursos")
public class CursosController {
	

	@Autowired
	private ColegiosService colegiosrv;
	@Autowired
	private RecursoHumanoService recursoHumanosrv;
	@Autowired
	private GradosService gradossrv;
	@Autowired
	private CursosService cursosrv;
	
	
	
	@GetMapping("/")
	public String listarCursos(Model model, HttpSession sesion) {
		List<CursosDto> listaDtoCursos = cursosrv.findAll();
		
		model.addAttribute("titulo","Lista de Cursos");
		model.addAttribute("cursos",listaDtoCursos);
		
		return "views/cursos/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		CursosDto cursosDto = new CursosDto();
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		List<RecursoHumanoDto> listaDtoRecursoHumano = recursoHumanosrv.findAll();
		List<GradosDto> listaDtoGrados = gradossrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Barrio");
		model.addAttribute("cursos", cursosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("profesores", listaDtoRecursoHumano);
		model.addAttribute("grados", listaDtoGrados);
		
		return "views/cursos/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarCursos(@ModelAttribute CursosDto cursosDto) {
		
		cursosrv.save(cursosDto);
		
		return "redirect:/views/cursos/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idcurso,  Model model, HttpSession sesion) {
		
		CursosDto cursosDto = cursosrv.findByid(idcurso);
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		List<RecursoHumanoDto> listaDtoRecursoHumano = recursoHumanosrv.findAll();
		List<GradosDto> listaDtoGrados = gradossrv.findAll();

		model.addAttribute("titulo","Formulario nuevo Curso");
		model.addAttribute("cursos", cursosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("profesores", listaDtoRecursoHumano);
		model.addAttribute("grados", listaDtoGrados);
		
		return "views/cursos/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idcurso,  Model model, HttpSession sesion) {
		
		cursosrv.deleteById(idcurso);
		
		return "redirect:/views/cursos/";
	}
}
