package com.uan.colegio.entity;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	private UUID diColegio;
	private String diCodigo;
	private UUID diTipoIdent;
	private String diIdentificacion;
	private UUID diCargo;
	private Boolean diEstado;
	private String diNombres;
	private String diApellidos;
}
