package com.uan.colegio.dto;


import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosBasicosDto {
	private UUID abLlave;
	private ColegiosDto colegiosDto;
	private String abCodigo;
	private String abNombres;
	private String abApellidos;
	private Date abFechaNac;
	private BigInteger abEdad;
	private String abGrupoRh;
	private EpsDto epsDto;
	private String abAlergias;
	private TiposIdentificacionDto tiposIdentificacionDto;
	private String abIdentidad;
	private String abDireccionRes;
	private String abTelefonoRes;
	private HorariosDto horariosDto;
	private Date abFechaIngreso;
	private String abFoto;
	private GradosDto gradosDto;
	private String abEstado;
	private byte[] abFotoImg;
}
