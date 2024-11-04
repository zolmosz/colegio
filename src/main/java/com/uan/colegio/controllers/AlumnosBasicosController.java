package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.dto.EpsDto;
import com.uan.colegio.dto.GradosDto;
import com.uan.colegio.dto.HorariosDto;
import com.uan.colegio.service.AlumnosBasicosService;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.EpsService;
import com.uan.colegio.service.GradosService;
import com.uan.colegio.service.HorariosService;
import com.uan.colegio.service.TiposIdentificacionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/alumnosbas")
public class AlumnosBasicosController {
	

	@Autowired
	private ColegiosService colegiossrv;
	@Autowired
	private EpsService epssrv;
	@Autowired
	private TiposIdentificacionService tiposIdentificacionsrv;
	@Autowired
	private HorariosService horariossrv;
	@Autowired
	private GradosService gradossrv;
	@Autowired
	private AlumnosBasicosService alumnosBasicossrv;
	
	
	@GetMapping("/")
	public String listarAlumnosBasicos(Model model, HttpSession sesion) {
		List<AlumnosBasicosDto> listaDtoAlumnosBasicos = alumnosBasicossrv.findAll();
		
		model.addAttribute("titulo","Lista de Alumnos");
		model.addAttribute("alumnos",listaDtoAlumnosBasicos);
		
		return "views/alumnosbas/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		AlumnosBasicosDto alumnosBasicosDto = new AlumnosBasicosDto();
		List<ColegiosDto> listaDtoColegios = colegiossrv.findAll();
		List<EpsDto> listaDtoEps = epssrv.findAll();
		List<TiposIdentificacionDto> listaDtoTiposIdentificacion = tiposIdentificacionsrv.findAll();
		List<HorariosDto> listaHorariosDtos = horariossrv.findAll();
		List<GradosDto> listaGradosDtos = gradossrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Alumno");
		model.addAttribute("alumnobas", alumnosBasicosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("eps", listaDtoEps);
		model.addAttribute("tipident", listaDtoTiposIdentificacion);
		model.addAttribute("horarios", listaHorariosDtos);
		model.addAttribute("grados", listaGradosDtos);
		
		return "views/alumnosbas/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarCiudades(@ModelAttribute AlumnosBasicosDto alumnosBasicosDto) {
		
		alumnosBasicossrv.save(alumnosBasicosDto);
		
		return "redirect:/views/alumnosbas/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idAlumno,  Model model, HttpSession sesion) {
		
		AlumnosBasicosDto alumnosBasicosDto = alumnosBasicossrv.findByid(idAlumno);
		List<ColegiosDto> listaDtoColegios = colegiossrv.findAll();
		List<EpsDto> listaDtoEps = epssrv.findAll();
		List<TiposIdentificacionDto> listaDtoTiposIdentificacion = tiposIdentificacionsrv.findAll();
		List<HorariosDto> listaHorariosDtos = horariossrv.findAll();
		List<GradosDto> listaGradosDtos = gradossrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo departamento");
		model.addAttribute("alumnobas", alumnosBasicosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("eps", listaDtoEps);
		model.addAttribute("tipoident", listaDtoTiposIdentificacion);
		model.addAttribute("horarios", listaHorariosDtos);
		model.addAttribute("grados", listaGradosDtos);
		
		return "views/alumnosbas/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idAlumno,  Model model, HttpSession sesion) {
		
		alumnosBasicossrv.deleteById(idAlumno);
		
		return "redirect:/views/alumnosbas/";
	}
}
