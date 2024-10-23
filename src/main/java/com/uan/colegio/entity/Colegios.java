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
@Table(name = "colegios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Colegios {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID coLlave;
	private String coCodigo;
    private String coNombre;
    private String coIdentificacion;
    private String coDigitoVer;
    private String coDireccion;
    private String coTelefono;
    
    @ManyToOne
    @JoinColumn(name = "co_pais")
    Paises paises;
    @ManyToOne
    @JoinColumn(name = "co_departamento")
    Departamentos departamentos;
    @ManyToOne
    @JoinColumn(name = "co_ciudad")
    Ciudades ciudades;
    
    private String coEmail;
    private String coRegeducacion;
    private String coEstado;
    
    
}
