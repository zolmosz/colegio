package com.uan.colegio.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CiudadesDto {
	private UUID ciLlave;
	private String ciCodigo;
    private String ciNombre;
    private UUID ciPais;
    private UUID ciDepartamento;
    
}
