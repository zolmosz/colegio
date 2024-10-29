package com.uan.colegio.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartamentosDto {
	private UUID dpLlave;
	private String dpCodigo;
    private String dpNombre;
    private UUID dpPais;
    
}
