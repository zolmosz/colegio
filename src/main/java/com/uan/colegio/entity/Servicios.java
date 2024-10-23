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
@Table(name = "servicios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Servicios {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID srLlave;
	private UUID srColegio;
	private String srCodigo;
    private String srNombre;
}
