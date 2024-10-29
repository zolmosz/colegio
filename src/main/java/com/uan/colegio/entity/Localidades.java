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
@Table(name = "localidades")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Localidades {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID loLlave;
	private String loCodigo;
    private String loNombre;
    private UUID loPais;
    private UUID loDepartamento;
    private UUID loCiudad;
}
