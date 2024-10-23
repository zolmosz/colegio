package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CargosDto {
	private UUID cgLlave;
	private UUID cgColegio;
	private String cgCodigo;
    private String cgNombre;
    private Boolean cgEstado;
}
