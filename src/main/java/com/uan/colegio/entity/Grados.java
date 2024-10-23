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
@Table(name = "grados")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grados {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID grLlave;
	private UUID grColegio;
	private String grCodigo;
	private String grDesc;
	private Boolean grEstado;
}
