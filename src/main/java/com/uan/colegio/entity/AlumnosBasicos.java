package com.uan.colegio.entity;


import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne
    @JoinColumn(name = "ab_colegio")
	private Colegios Colegios;
	private String abCodigo;
	private String abNombres;
	private String abApellidos;
	private Date abFechaNac;
	private BigInteger abEdad;
	private String abGrupoRh;
	@ManyToOne
    @JoinColumn(name = "ab_eps")
	private Eps eps;
	private String abAlergias;
	@ManyToOne
    @JoinColumn(name = "ab_tipo_ident")
	private TiposIdentificacion tiposIdentificacion;
	private String abIdentidad;
	private String abDireccionRes;
	private String abTelefonoRes;
	@ManyToOne
    @JoinColumn(name = "ab_horario_escolar")
	private Horarios horarios;
	private Date abFechaIngreso;
	private String abFoto;
	@ManyToOne
    @JoinColumn(name = "ab_nivel_ingreso")
	private Grados grados;
	private String abEstado;
	private byte[] abFotoImg;
}
