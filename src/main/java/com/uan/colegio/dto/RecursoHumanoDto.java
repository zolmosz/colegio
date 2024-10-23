package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecursoHumanoDto {
	private UUID rhLlave;
	private UUID rhColegio;
	private UUID rhTipoIdent;
	private String rhIdentificacion;
	private UUID rhProfesion;
	private UUID rhCargo;
	private String rhCodigo;
	private String rhNombres;
	private String rhApellidos;
	private UUID rhLugarExp;
	private String rhDireccionRes;
	private String rhTelefonoRes;
	private UUID rhBarrioRes;
	private String rhTelefonoMovil;
	private String rhEmail;
    private Boolean rhEstado;
}
