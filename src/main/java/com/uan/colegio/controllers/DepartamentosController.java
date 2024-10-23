package com.uan.colegio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.DepartamentosDto;
import com.uan.colegio.dto.PaisesDto;
import com.uan.colegio.service.DepartamentosService;
import com.uan.colegio.service.PaisesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/departamentos")
public class DepartamentosController {
	

	@Autowired
	private PaisesService paissrv;
	@Autowired
	private DepartamentosService departamentosrv;
	
	
	@GetMapping("/")
	public String listarDepartamentos(Model model, HttpSession sesion) {
		List<DepartamentosDto> listaDtoDepartamentos = departamentosrv.findAll();
		
		model.addAttribute("titulo","Lista de Departamentos");
		model.addAttribute("departamentos",listaDtoDepartamentos);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/departamentos/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		DepartamentosDto DepartamentosDto = new DepartamentosDto();
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo departamento");
		model.addAttribute("departamento", DepartamentosDto);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/departamentos/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarDepartamentos(@ModelAttribute DepartamentosDto DepartamentosDto) {
		
		departamentosrv.save(DepartamentosDto);
		
		return "redirect:/views/departamentos/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID iddepartamento,  Model model, HttpSession sesion) {
		
		DepartamentosDto departamentosDto = departamentosrv.findByid(iddepartamento);
		List<PaisesDto> listaDtoPaises = paissrv.findAll();
		
		model.addAttribute("titulo","Formulario nuevo departamento");
		model.addAttribute("departamento", departamentosDto);
		model.addAttribute("paises", listaDtoPaises);
		model.addAttribute("usuario_ses", sesion.getAttribute("fname") +" " + sesion.getAttribute("lname"));
		
		return "views/departamentos/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID iddepartamento,  Model model, HttpSession sesion) {
		
		departamentosrv.deleteById(iddepartamento);
		
		return "redirect:/views/departamentos/";
	}
}
