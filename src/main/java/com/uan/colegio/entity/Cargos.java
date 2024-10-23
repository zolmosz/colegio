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
@Table(name = "cargos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cargos {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID cgLlave;
	private UUID cgColegio;
	private String cgCodigo;
    private String cgNombre;
    private Boolean cgEstado;
}
