package com.uan.colegio.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.AlumnosCompletoDto;
import com.uan.colegio.dto.AlumnosDocumentosDto;
import com.uan.colegio.dto.AlumnosFamiliaDto;
import com.uan.colegio.dto.BarriosDto;
import com.uan.colegio.dto.CiudadesDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.dto.ProfesionesDto;
import com.uan.colegio.dto.TiposIdentificacionDto;
import com.uan.colegio.entity.AlumnosBasicos;
import com.uan.colegio.service.AlumnosBasicosService;
import com.uan.colegio.service.AlumnosDocumentosService;
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
@RequestMapping("/views/alumnosadmis")
public class AlumnosProcAdmiController {

	@Autowired
	private AlumnosFamiliaService alumnosFamiliasrv;
	@Autowired
	private AlumnosBasicosService alumnosBasicosrv;
	@Autowired
	private AlumnosDocumentosService alumnosDocumentosrv;
	
	@GetMapping("/")
	public String listarAlumnosFamilia(Model model, HttpSession sesion) {
		List<AlumnosBasicosDto> listaDtoAlumnosBasicos = alumnosBasicosrv.getAlumnosCompletos();

		listaDtoAlumnosBasicos.forEach(alumno -> {
            alumno.setEstadoClase(AlumnosBasicosDto.getClaseEstado(alumno.getAbEstado()));
            alumno.setEstadoTexto(AlumnosBasicosDto.getTextoEstado(alumno.getAbEstado()));
        });

		model.addAttribute("titulo","Lista Información de Alumnos");
		model.addAttribute("alumnosbas",listaDtoAlumnosBasicos);
		
		return "views/alumnosadmis/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editarProcesoAlumnos(@PathVariable("id") UUID idAlumno,  Model model){

		AlumnosFamiliaDto alumnosFamiliaDto = alumnosFamiliasrv.findByAlumnosBasicos_AbLlave(idAlumno);
		AlumnosBasicosDto alumnosBasicosDto = alumnosBasicosrv.findByid(idAlumno);
		AlumnosDocumentosDto alumnosDocumentosDto = alumnosDocumentosrv.findByAlumnosBasicos_AbLlave(idAlumno);
			
		String base64Image = (alumnosBasicosDto.getAbFotoImg() != null) ? "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(alumnosBasicosDto.getAbFotoImg()):"";

		String b64IformIns = (alumnosDocumentosDto.getAdFormInscripcionMatricula() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdFormInscripcionMatricula()):"";
		String b64IregCiv = (alumnosDocumentosDto.getAdRegistroCivilNac() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdRegistroCivilNac()):"";
		String b64IcarnVac = (alumnosDocumentosDto.getAdCarneVacunas() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdCarneVacunas()):"";
		String b64IcertEps = (alumnosDocumentosDto.getAdCertAfiliacionEpsPrepagada() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdCertAfiliacionEpsPrepagada()):"";
		String b64Ifotos = (alumnosDocumentosDto.getAdFotos() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdFotos()):"";
		String b64IcertCd = (alumnosDocumentosDto.getAdCertCrecimientoDesarrollo() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdCertCrecimientoDesarrollo()):"";
		String b64IcertVa = (alumnosDocumentosDto.getAdCertValoracionVisualAuditiva() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdCertValoracionVisualAuditiva()):"";
		String b64IcedMad = (alumnosDocumentosDto.getAdCedulaMadre() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdCedulaMadre()):"";
		String b64IcedPad = (alumnosDocumentosDto.getAdCedulaPadre() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdCedulaPadre()):"";
		String b64IcontServ = (alumnosDocumentosDto.getAdContratoPrestServicios() != null) ? "data:application/pdf;base64," + Base64.getEncoder().encodeToString(alumnosDocumentosDto.getAdContratoPrestServicios()):"";

		AlumnosCompletoDto alumnosCompletoDto = new AlumnosCompletoDto();
		alumnosCompletoDto.setAlumnosBasicosDto(alumnosBasicosDto);
		alumnosCompletoDto.setAlumnosFamiliaDto(alumnosFamiliaDto);
		alumnosCompletoDto.setAlumnosDocumentosDto(alumnosDocumentosDto);

		model.addAttribute("titulo","Lista Información de Alumnos");
		model.addAttribute("alumnoscom",alumnosCompletoDto);
		model.addAttribute("base64Image", base64Image);
		model.addAttribute("b64IformIns", b64IformIns);
		model.addAttribute("b64IregCiv", b64IregCiv);
		model.addAttribute("b64IcarnVac", b64IcarnVac);
		model.addAttribute("b64IcertEps", b64IcertEps);
		model.addAttribute("b64Ifotos", b64Ifotos);
		model.addAttribute("b64IcertCd", b64IcertCd);
		model.addAttribute("b64IcertVa", b64IcertVa);
		model.addAttribute("b64IcedMad", b64IcedMad);
		model.addAttribute("b64IcedPad", b64IcedPad);
		model.addAttribute("b64IcontServ", b64IcontServ);
		
		return "views/alumnosadmis/crear";
	}

	@PostMapping("/salvar")
	public String salvarAlumnos(@ModelAttribute AlumnosFamiliaDto alumnosFamiliaDto) throws IOException {
		
		alumnosFamiliasrv.save(alumnosFamiliaDto);
		
		return "redirect:/views/alumnosadmis/";
	}
	
}
