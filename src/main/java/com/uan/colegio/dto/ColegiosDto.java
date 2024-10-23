package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColegiosDto {
	private UUID coLlave;
	private String coCodigo;
    private String coNombre;
    private String coIdentificacion;
    private String coDigitoVer;
    private String coDireccion;
    private String coTelefono;
    private PaisesDto paisesDto;
    private DepartamentosDto departamentosDto;
    private CiudadesDto ciudadesDto;
    private String coEmail;
    private String coRegeducacion;
    private String coEstado;
}
