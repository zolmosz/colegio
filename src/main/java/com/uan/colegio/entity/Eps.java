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
@Table(name = "eps")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Eps {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID epsLlave;
	private UUID epsColegio;
	private String epsNit;
	private String epsDigitoVer;
    private String epsNombre;
    private Boolean epsEstado;
}
