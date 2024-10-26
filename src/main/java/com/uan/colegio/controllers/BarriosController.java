package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.DepartamentosDto;
import com.uan.colegio.dto.LocalidadesDto;
import com.uan.colegio.service.BarriosService;
import com.uan.colegio.service.LocalidadesService;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.service.DepartamentosService;
import com.uan.colegio.service.PaisesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/barrios")
public class BarriosController {
	

	@Autowired
	private PaisesService paissrv;
	@Autowired
	private DepartamentosService departamentossrv;
	@Autowired
	private CiudadesService ciudadessrv;
	@Autowired
	private LocalidadesService localidadessrv;
	@Autowired
	private BarriosService barriosrv;
	
	
	
	@GetMapping("/")
	public String listarBarrios(Model model, HttpSession sesion) {
		List<BarriosDto> listaDtoBarrios = barriosrv.findAll();
		
		model.addAttribute("titulo","Lista de Barrios");
		model.addAttribute("barrios",listaDtoBarrios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/barrios/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		BarriosDto barriosDto = new BarriosDto();
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		List<DepartamentosDto> listaDtoDepartamentos = departamentossrv.findAll();
		List<CiudadesDto> listaDtoCiudades = ciudadessrv.findAll();
		List<LocalidadesDto> listaDtoLocalidades = localidadessrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo Barrio");
		model.addAttribute("barrio", barriosDto);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("departamentos", listaDtoDepartamentos);
		model.addAttribute("ciudades", listaDtoCiudades);
		model.addAttribute("localidades", listaDtoLocalidades);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/barrios/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarBarrios(@ModelAttribute BarriosDto barriosDto) {
		
		barriosrv.save(barriosDto);
		
		return "redirect:/views/barrios/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idbarrio,  Model model, HttpSession sesion) {
		
		BarriosDto barriosDto = barriosrv.findByid(idbarrio);
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		List<DepartamentosDto> listaDtoDepartamentos = departamentossrv.findAll();
		List<CiudadesDto> listaDtoCiudades = ciudadessrv.findAll();
		List<LocalidadesDto> listaDtoLocalidades = localidadessrv.findAll();
		
		model.addAttribute("titulo","Formulario nueva Localidad");
		model.addAttribute("barrio", barriosDto);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("departamentos", listaDtoDepartamentos);
		model.addAttribute("ciudades", listaDtoCiudades);
		model.addAttribute("localidades", listaDtoLocalidades);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/barrios/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idbarrio,  Model model, HttpSession sesion) {
		
		barriosrv.deleteById(idbarrio);
		
		return "redirect:/views/barrios/";
	}
}
