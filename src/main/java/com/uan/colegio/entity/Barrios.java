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
@Table(name = "barrios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Barrios {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID baLlave;
	private String baCodigo;
    private String baNombre;
    private UUID baPais;
    private UUID baDepartamento;
    private UUID baCiudad;
    private UUID baLocalidad;
}
