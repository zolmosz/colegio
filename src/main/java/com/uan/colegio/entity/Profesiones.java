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
@Table(name = "profesiones")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profesiones {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID prLlave;
	private UUID prColegio;
	private String prCodigo;
    private String prNombre;
    private Boolean prEstado;
}
