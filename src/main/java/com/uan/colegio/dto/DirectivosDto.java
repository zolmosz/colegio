package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DirectivosDto {
	private UUID diLlave;
	private ColegiosDto colegiosDto;
	private String diCodigo;
	private TiposIdentificacionDto tiposIdentificacionDto;
	private String diIdentificacion;
	private CargosDto cargosDto;
	private Boolean diEstado;
	private String diNombres;
	private String diApellidos;
}
