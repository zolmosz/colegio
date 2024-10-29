package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.LocalidadesDto;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.DepartamentosDto;
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
@RequestMapping("/views/localidades")
public class LocalidadesController {
	

	@Autowired
	private PaisesService paissrv;
	@Autowired
	private DepartamentosService departamentossrv;
	@Autowired
	private CiudadesService ciudadessrv;
	@Autowired
	private LocalidadesService localidadesrv;
	
	
	
	@GetMapping("/")
	public String listarLocalidades(Model model, HttpSession sesion) {
		List<LocalidadesDto> listaDtoLocalidades = localidadesrv.findAll();
		
		model.addAttribute("titulo","Lista de Localidades");
		model.addAttribute("localidades",listaDtoLocalidades);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/localidades/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		LocalidadesDto localidadesDto = new LocalidadesDto();
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		List<DepartamentosDto> listaDtoDepartamentos = departamentossrv.findAll();
		List<CiudadesDto> listaDtoCiudades = ciudadessrv.findAll();
		
		model.addAttribute("titulo","Formulario nueva Localidad");
		model.addAttribute("localidad", localidadesDto);
		model.addAttribute("ciudades", listaDtoCiudades);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("departamentos", listaDtoDepartamentos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/localidades/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarLocalidades(@ModelAttribute LocalidadesDto localidadesDto) {
		
		localidadesrv.save(localidadesDto);
		
		return "redirect:/views/localidades/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idciudad,  Model model, HttpSession sesion) {
		
		LocalidadesDto localidadesDto = localidadesrv.findByid(idciudad);
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		List<DepartamentosDto> listaDtoDepartamentos = departamentossrv.findAll();
		List<CiudadesDto> listaDtoCiudades = ciudadessrv.findAll();
		
		model.addAttribute("titulo","Formulario nueva Localidad");
		model.addAttribute("localidad", localidadesDto);
		model.addAttribute("ciudades", listaDtoCiudades);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("departamentos", listaDtoDepartamentos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/localidades/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idlocalidad,  Model model, HttpSession sesion) {
		
		localidadesrv.deleteById(idlocalidad);
		
		return "redirect:/views/localidades/";
	}
}
