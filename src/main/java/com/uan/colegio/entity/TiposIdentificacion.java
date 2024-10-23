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
@Table(name = "tipos_identificacion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TiposIdentificacion {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID tiLlave;
	private UUID tiColegio;
	private String tiCodigo;
    private String tiDesc;
}
