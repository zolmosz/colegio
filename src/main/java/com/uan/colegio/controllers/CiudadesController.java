package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.dto.DepartamentosDto;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.service.DepartamentosService;
import com.uan.colegio.service.PaisesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/ciudades")
public class CiudadesController {
	

	@Autowired
	private PaisesService paissrv;
	@Autowired
	private DepartamentosService departamentossrv;
	@Autowired
	private CiudadesService ciudadesrv;
	
	
	@GetMapping("/")
	public String listarCiudades(Model model, HttpSession sesion) {
		List<CiudadesDto> listaDtoCiudades = ciudadesrv.findAll();
		
		model.addAttribute("titulo","Lista de Ciudades");
		model.addAttribute("ciudades",listaDtoCiudades);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/ciudades/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		CiudadesDto CiudadesDto = new CiudadesDto();
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		List<DepartamentosDto> listaDtoDepartamentos = departamentossrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo departamento");
		model.addAttribute("ciudad", CiudadesDto);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("departamentos", listaDtoDepartamentos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/ciudades/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarCiudades(@ModelAttribute CiudadesDto CiudadesDto) {
		
		ciudadesrv.save(CiudadesDto);
		
		return "redirect:/views/ciudades/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idciudad,  Model model, HttpSession sesion) {
		
		CiudadesDto ciudadesDto = ciudadesrv.findByid(idciudad);
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		List<DepartamentosDto> listaDtoDepartamentos = departamentossrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo departamento");
		model.addAttribute("ciudad", ciudadesDto);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("departamentos", listaDtoDepartamentos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/ciudades/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idciudad,  Model model, HttpSession sesion) {
		
		ciudadesrv.deleteById(idciudad);
		
		return "redirect:/views/ciudades/";
	}
}
