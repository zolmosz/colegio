package com.uan.colegio.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.uan.colegio.dto.AlumnosBasicosDto;
import com.uan.colegio.dto.AlumnosDocumentosDto;
import com.uan.colegio.dto.ColegiosDto;
import com.uan.colegio.service.AlumnosBasicosService;
import com.uan.colegio.service.AlumnosDocumentosService;
import com.uan.colegio.service.ColegiosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views/alumnosdoc")
public class AlumnosDocumentosController {

	@Autowired
	private ColegiosService colegiossrv;
	@Autowired
	private AlumnosBasicosService alumnosBasicossrv;
	@Autowired
	private AlumnosDocumentosService alumnosDocumentossrv;
	
	
	@GetMapping("/")
	public String listarAlumnosDocumentos(Model model, HttpSession sesion) {
		List<AlumnosDocumentosDto> listaDtoAlumnosDocumentos = alumnosDocumentossrv.findAll();
		
		model.addAttribute("titulo","Lista de Documentos Alumnos");
		model.addAttribute("alumnos",listaDtoAlumnosDocumentos);
		
		return "views/alumnosdoc/listar";
	}
	
	@GetMapping("/create")
	public String create(Model model, HttpSession sesion) {
		
		AlumnosDocumentosDto alumnosDocumentosDto = new AlumnosDocumentosDto();
		List<ColegiosDto> listaDtoColegios = colegiossrv.findAll();
		List<AlumnosBasicosDto> listaDtoAlumnosBasicos = alumnosBasicossrv.findAll();

		model.addAttribute("titulo","Formulario nuevo alumno");
		model.addAttribute("alumnodoc", alumnosDocumentosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("alumnos", listaDtoAlumnosBasicos);
		
		return "views/alumnosdoc/crear";
	}
	
	@PostMapping("/salvar")
	public String salvarAlumnos(@ModelAttribute AlumnosDocumentosDto alumnosDocumentosDto, 
		@RequestParam(value="formIns", required = false) MultipartFile formIns,
		@RequestParam(value="regCiv", required = false) MultipartFile regCiv,
		@RequestParam(value="carnVac", required = false) MultipartFile carnVac,
		@RequestParam(value="certEps", required = false) MultipartFile certEps,
		@RequestParam(value="fotos", required = false) MultipartFile fotos,
		@RequestParam(value="certCd", required = false) MultipartFile certCd,
		@RequestParam(value="certVa", required = false) MultipartFile certVa,
		@RequestParam(value="cedMad", required = false) MultipartFile cedMad,
		@RequestParam(value="cedPad", required = false) MultipartFile cedPad,
		@RequestParam(value="contServ", required = false) MultipartFile contServ
		) throws IOException {
		
			AlumnosDocumentosDto alumnosDocDto = new AlumnosDocumentosDto();

		if (alumnosDocumentosDto.getAdLlave() != null){
			alumnosDocDto = alumnosDocumentossrv.findByid(alumnosDocumentosDto.getAdLlave());
		}

		alumnosDocumentosDto.setAdFormInscripcionMatricula((!formIns.isEmpty() && formIns != null) ? formIns.getBytes():alumnosDocDto.getAdFormInscripcionMatricula());
		alumnosDocumentosDto.setAdRegistroCivilNac((!regCiv.isEmpty() && regCiv != null) ? regCiv.getBytes():alumnosDocDto.getAdRegistroCivilNac());
		alumnosDocumentosDto.setAdCarneVacunas((!carnVac.isEmpty() && carnVac != null) ? carnVac.getBytes():alumnosDocDto.getAdCarneVacunas());
		alumnosDocumentosDto.setAdCertAfiliacionEpsPrepagada((!certEps.isEmpty() && certEps != null) ? certEps.getBytes():alumnosDocDto.getAdCertAfiliacionEpsPrepagada());
		alumnosDocumentosDto.setAdFotos((!fotos.isEmpty() && fotos != null) ? fotos.getBytes():alumnosDocDto.getAdFotos());
		alumnosDocumentosDto.setAdCertCrecimientoDesarrollo((!certCd.isEmpty() && certCd != null) ? certCd.getBytes():alumnosDocDto.getAdCertCrecimientoDesarrollo());
		alumnosDocumentosDto.setAdCertValoracionVisualAuditiva((!certVa.isEmpty() && certVa != null) ? certVa.getBytes():alumnosDocDto.getAdCertValoracionVisualAuditiva());
		alumnosDocumentosDto.setAdCedulaMadre((!cedMad.isEmpty() && cedMad != null) ? cedMad.getBytes():alumnosDocDto.getAdCedulaMadre());
		alumnosDocumentosDto.setAdCedulaPadre((!cedPad.isEmpty() && cedPad != null) ? formIns.getBytes():alumnosDocDto.getAdCedulaPadre());
		alumnosDocumentosDto.setAdContratoPrestServicios((!contServ.isEmpty() && contServ != null) ? contServ.getBytes():alumnosDocDto.getAdContratoPrestServicios());
			
		alumnosDocumentossrv.save(alumnosDocumentosDto);
		
		return "redirect:/views/alumnosdoc/";
	}
	
	@GetMapping("/editar/{id}")
	public String create(@PathVariable("id") UUID idAlumno,  Model model, HttpSession sesion) {
		
		AlumnosDocumentosDto alumnosDocumentosDto = alumnosDocumentossrv.findByid(idAlumno);
		List<ColegiosDto> listaDtoColegios = colegiossrv.findAll();
		List<AlumnosBasicosDto> listaDtoAlumnosBasicos = alumnosBasicossrv.findAll();
		
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

		model.addAttribute("titulo","Formulario nuevo alumno");
		model.addAttribute("alumnodoc", alumnosDocumentosDto);
		model.addAttribute("colegios", listaDtoColegios);
		model.addAttribute("alumnos", listaDtoAlumnosBasicos);

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
		
		return "views/alumnosdoc/crear";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") UUID idAlumno,  Model model, HttpSession sesion) {
		
		alumnosDocumentossrv.deleteById(idAlumno);
		
		return "redirect:/views/alumnosdoc/";
	}

	@GetMapping("/verdoc")
	public String getDocument(Model model, HttpSession sesion) {
		
		// model.addAttribute("tipoDocumento", "tipoDocumento");
		// model.addAttribute("b64Idocumento", "b64Idocumento");
		
		return "redirect:/views/alumnosdoc/";
	}
	
}
