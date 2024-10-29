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
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.service.CiudadesService;
import com.uan.colegio.service.ColegiosService;
import com.uan.colegio.service.DepartamentosService;
import com.uan.colegio.service.PaisesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/colegios")
public class ColegiosController {
	

	@Autowired
	private PaisesService paissrv;
	@Autowired
	private DepartamentosService departamentossrv;
	@Autowired
	private CiudadesService ciudadessrv;
	@Autowired
	private ColegiosService colegiosrv;
	
	
	@GetMapping("/")
	public String listarColegios(Model model, HttpSession sesion) {
		List<ColegiosDto> listaDtoColegios = colegiosrv.findAll();
		
		model.addAttribute("titulo","Lista de Colegios");
		model.addAttribute("colegios",listaDtoColegios);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/colegios/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		ColegiosDto ColegiosDto = new ColegiosDto();
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		List<DepartamentosDto> listaDtoDepartamentos = departamentossrv.findAll();
		List<CiudadesDto> listaDtoCiudades = ciudadessrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo departamento");
		model.addAttribute("colegio", ColegiosDto);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("departamentos", listaDtoDepartamentos);
		model.addAttribute("ciudades", listaDtoCiudades);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/colegios/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarColegios(@ModelAttribute ColegiosDto ColegiosDto) {
		
		colegiosrv.save(ColegiosDto);
		
		return "redirect:/views/colegios/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idcolegio,  Model model, HttpSession sesion) {
		
		ColegiosDto colegiosDto = colegiosrv.findByid(idcolegio);
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		List<DepartamentosDto> listaDtoDepartamentos = departamentossrv.findAll();
		List<CiudadesDto> listaDtoCiudades = ciudadessrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo departamento");
		model.addAttribute("colegio", colegiosDto);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("departamentos", listaDtoDepartamentos);
		model.addAttribute("ciudades", listaDtoCiudades);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/colegios/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idciudad,  Model model, HttpSession sesion) {
		
		colegiosrv.deleteById(idciudad);
		
		return "redirect:/views/colegios/";
	}
}
