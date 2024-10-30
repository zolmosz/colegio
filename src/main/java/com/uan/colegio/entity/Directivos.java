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
@Table(name = "directivos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Directivos {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID diLlave;
	@ManyToOne
    @JoinColumn(name = "di_colegio")
	private Colegios Colegios;
	private String diCodigo;
	@ManyToOne
    @JoinColumn(name = "di_tipo_ident")
	private TiposIdentificacion TiposIdentificacion;
	private String diIdentificacion;
	@ManyToOne
    @JoinColumn(name = "di_cargo")
	private Cargos Cargos;
	private Boolean diEstado;
	private String diNombres;
	private String diApellidos;
}
