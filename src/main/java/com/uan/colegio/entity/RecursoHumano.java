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
@Table(name = "recurso_humano")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecursoHumano {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID rhLlave;
	@ManyToOne
    @JoinColumn(name = "rh_colegio")
	private Colegios Colegios;
	@ManyToOne
    @JoinColumn(name = "rh_tipo_ident")
	private TiposIdentificacion TiposIdentificacion;
	private String rhIdentificacion;
	@ManyToOne
    @JoinColumn(name = "rh_profesion")
	private Profesiones Profesiones;
	@ManyToOne
    @JoinColumn(name = "rh_cargo")
	private Cargos Cargos;
	private String rhCodigo;
	private String rhNombres;
	private String rhApellidos;
	@ManyToOne
    @JoinColumn(name = "rh_lugar_exp")
	private Ciudades Ciudades;
	private String rhDireccionRes;
	private String rhTelefonoRes;
	@ManyToOne
    @JoinColumn(name = "rh_barrio_res")
	private Barrios Barrios;
	private String rhTelefonoMovil;
	private String rhEmail;
    private Boolean rhEstado;
}
