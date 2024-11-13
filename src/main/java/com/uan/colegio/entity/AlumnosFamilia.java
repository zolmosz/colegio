package com.uan.colegio.entity;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumnos_familia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosFamilia {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID afLlave;
	@ManyToOne
    @JoinColumn(name = "af_colegio")
    private Colegios Colegios;
	@ManyToOne
    @JoinColumn(name = "af_alumno")
    private AlumnosBasicos alumnosBasicos;
	private String afNombreMadre;
    @ManyToOne
    @JoinColumn(name = "af_tipo_ident_mad")
	private TiposIdentificacion tiposIdentMad;
	private String afIdentMad;
    @ManyToOne
    @JoinColumn(name = "af_lugar_exped_mad")
	private Ciudades ciudadExpedMad;
	private String afDirResMad;
	private String afTelResMad;
	@ManyToOne
    @JoinColumn(name = "af_barrio_res_mad")
    private Barrios barrioResMad;
	private String afEmpresaMad;
	private String afDirTrabMad;
	private String afTelTrabMad;
	private String afTelMovilMad;
    @ManyToOne
    @JoinColumn(name = "af_profesion_madre")
	private Profesiones profesionMadre;
	private String afEmailMadre;
	private Boolean afViveMenMadre;
	private String afObsRespMadre;
	private String afNombrePadre;
    @ManyToOne
    @JoinColumn(name = "afTipoIdentPad")
    private TiposIdentificacion tipoIdentPad;
    private String afIdentPad;
    @ManyToOne
    @JoinColumn(name = "af_lugar_exped_pad")
    private Ciudades ciudadExpedPad;
    private String afDirResPad;
    private String afTelResPad;
    @ManyToOne
    @JoinColumn(name = "af_barrio_res_pad")
    private Barrios barrioResPad;
    private String afEmpTrabPad;
    private String afDirTrabPad;
    private String afTelTrabPad;
    private String afTelMovilPad;
    @ManyToOne
    @JoinColumn(name = "af_prof_pad")
    private Profesiones profesionesPad;
    private String afEmailPad;
    private Boolean afViveMenorPad;
    private String afObsRespPad;
    private String afNomAcudiente;
    @ManyToOne
    @JoinColumn(name = "af_tipo_ident_acu")
    private TiposIdentificacion tipoIdentAcu;
    private String afIdentAcu;
    @ManyToOne
    @JoinColumn(name = "af_lugar_exped_acu")
    private Ciudades ciudadExpedAcu;
    private String afDirResAcu;
    private String afTelResAcu;
    private String afTelAcu;
    private String afTelMovilAcu;
    @ManyToOne
    @JoinColumn(name = "af_profesion_acu")
    private Profesiones profesionAcu;
    private String afParentescoAcu;
    
}
