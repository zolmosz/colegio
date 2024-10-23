package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosFamiliaDto {
	private UUID afLlave;
	private UUID afColegio;
	private UUID afAlumno;
	private String afNombreMadre;
	private UUID afTipoIdentMad;
	private String afIdentMad;
	private UUID afLugarExpedMad;
	private String afDirResMad;
	private String afTelResMad;
	private UUID afBarrioResMad;
	private String afEmpresaMad;
	private String afDirTrabMad;
	private String afTelTrabMad;
	private String afTelMovilMad;
	private UUID afProfesionMadre;
	private String afEmailMadre;
	private Boolean afViveMenMadre;
	private String afObsRespMadre;
	private String afNombrePadre;
    private UUID afTipoIdentPad;
    private String afIdentPad;
    private UUID afLugarExpedPad;
    private String afDirResPad;
    private String afTelResPad;
    private UUID afBarrioResPad;
    private String afEmpTrabPad;
    private String afDirTrabPad;
    private String afTelTrabPad;
    private String afTelMovilPad;
    private UUID afProfPad;
    private String afEmailPad;
    private Boolean afViveMenorPad;
    private String afObsRespPad;
    private String afNomAcudiente;
    private UUID afTipoIdentAcu;
    private String afIdentAcu;
    private UUID afLugarExpedAcu;
    private String afDirResAcu;
    private String afTelResAcu;
    private String afTelAcu;
    private String afTelMovilAcu;
    private UUID afProfesionAcu;
    private String afParentescoAcu;
    
}
