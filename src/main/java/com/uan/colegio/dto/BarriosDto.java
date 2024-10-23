package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BarriosDto {
	private UUID baLlave;
	private String baCodigo;
    private String baNombre;
    private UUID baPais;
    private UUID baDepartamento;
    private UUID baCiudad;
    private UUID baLocalidad;
}
