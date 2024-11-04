package com.uan.colegio.entity;


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
@Table(name = "grados")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grados {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID grLlave;
	@ManyToOne
    @JoinColumn(name = "gr_colegio")
	Colegios colegios;
	private String grCodigo;
	private String grDesc;
	private Boolean grEstado;
}
