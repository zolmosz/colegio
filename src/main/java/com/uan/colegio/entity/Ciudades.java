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
@Table(name = "ciudades")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ciudades {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID ciLlave;
	private String ciCodigo;
    private String ciNombre;
    private UUID ciPais;
    private UUID ciDepartamento;
}
