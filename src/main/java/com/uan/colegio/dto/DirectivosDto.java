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
	private UUID diColegio;
	private String diCodigo;
	private UUID diTipoIdent;
	private String diIdentificacion;
	private UUID diCargo;
	private Boolean diEstado;
	private String diNombres;
	private String diApellidos;
}
