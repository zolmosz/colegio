package com.uan.colegio.entity;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recurso_humano")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecursoHumano {
	@Id
    @GeneratedValue(generator = "uuid2")
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
