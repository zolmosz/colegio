package com.uan.colegio.entity;


import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alumnos_basicos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosBasicos {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID abLlave;
	private UUID abColegio;
	private String abCodigo;
	private String abNombres;
	private String abApellidos;
	private Date abFechaNac;
	private BigInteger abEdad;
	private String abGrupoRh;
	private UUID abEps;
	private String abAlergias;
	private UUID ab_tipo_ident;
	private String abIdentidad;
	private String abDireccionRes;
	private String abTelefonoRes;
	private UUID abHorarioEscolar;
	private Date abFechaIngreso;
	private String abFoto;
	private UUID abNivelIngreso;
	private String abEstado;
	private byte[] abFotoImg;
}
