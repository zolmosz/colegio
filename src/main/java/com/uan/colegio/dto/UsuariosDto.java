package com.uan.colegio.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuariosDto {
	private UUID usLlave;
	private ColegiosDto colegiosDto;
	private String usCodigo;
    private String usDescripcion;
    private String usNombres;
    private String usApellidos;
    private String usEmail;
    private PerfilesDto perfilesDto;
    private String usClave;
    
}
