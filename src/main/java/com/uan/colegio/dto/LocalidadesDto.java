package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocalidadesDto {
	private UUID loLlave;
	private String loCodigo;
    private String loNombre;
    private UUID loPais;
    private UUID loDepartamento;
    private UUID loCiudad;
}
