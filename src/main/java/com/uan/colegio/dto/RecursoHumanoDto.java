package com.uan.colegio.dto;


import java.util.UUID;

import com.uan.colegio.entity.Cargos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecursoHumanoDto {
	private UUID rhLlave;
	private ColegiosDto colegiosDto;
	private TiposIdentificacionDto tiposIdentificacionDto;
	private String rhIdentificacion;
	private ProfesionesDto profesionesDto;
	private CargosDto cargosDto;
	private String rhCodigo;
	private String rhNombres;
	private String rhApellidos;
	private CiudadesDto ciudadesDto;
	private String rhDireccionRes;
	private String rhTelefonoRes;
	private BarriosDto barriosDto;
	private String rhTelefonoMovil;
	private String rhEmail;
    private Boolean rhEstado;
}
