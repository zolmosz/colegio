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
@Table(name = "departamentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Departamentos {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID dpLlave;
	private String dpCodigo;
    private String dpNombre;
    private UUID dpPais;
}
