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
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuarios {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID usLlave;
	@ManyToOne
    @JoinColumn(name = "us_colegio")
	Colegios colegios;
	private String usCodigo;
    private String usDescripcion;
    private String usNombres;
    private String usApellidos;
    private String usEmail;
    @ManyToOne
    @JoinColumn(name = "us_perfil")
    Perfiles perfiles;
    private String usClave;
    
}
