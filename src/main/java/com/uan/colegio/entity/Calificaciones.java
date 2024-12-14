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
@Table(name = "calificaciones")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Calificaciones {
    @Id
    @GeneratedValue(generator = "uuid2")
	private UUID caLlave;
    @ManyToOne
    @JoinColumn(name = "ca_colegio")
	private Colegios colegios;
    private Integer caCodigo;
    private String caDescripcion;
    private Integer caValor;
    private String caImagen;
    private Boolean caEstado;
}
