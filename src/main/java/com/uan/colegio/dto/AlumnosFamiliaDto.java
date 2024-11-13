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
	private ColegiosDto colegiosDto;
	private AlumnosBasicosDto alumnosBasicosDto;
	private String afNombreMadre;
	private TiposIdentificacionDto tipoIdentMadDto;
	private String afIdentMad;
	private CiudadesDto ciudadExpedMadDto;
	private String afDirResMad;
	private String afTelResMad;
	private BarriosDto barrioResMadDto;
	private String afEmpresaMad;
	private String afDirTrabMad;
	private String afTelTrabMad;
	private String afTelMovilMad;
	private ProfesionesDto profesionMadreDto;
	private String afEmailMadre;
	private Boolean afViveMenMadre;
	private String afObsRespMadre;
	private String afNombrePadre;
    private TiposIdentificacionDto tipoIdentPadDto;
    private String afIdentPad;
    private CiudadesDto ciudadExpedPadDto;
    private String afDirResPad;
    private String afTelResPad;
    private BarriosDto barrioResPadDto;
    private String afEmpTrabPad;
    private String afDirTrabPad;
    private String afTelTrabPad;
    private String afTelMovilPad;
    private ProfesionesDto profPadDto;
    private String afEmailPad;
    private Boolean afViveMenorPad;
    private String afObsRespPad;
    private String afNomAcudiente;
    private TiposIdentificacionDto tipoIdentAcuDto;
    private String afIdentAcu;
    private CiudadesDto ciudadExpedAcuDto;
    private String afDirResAcu;
    private String afTelResAcu;
    private String afTelAcu;
    private String afTelMovilAcu;
    private ProfesionesDto profesionAcuDto;
    private String afParentescoAcu;
    
}
