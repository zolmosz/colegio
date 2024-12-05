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
@Table(name = "cursos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cursos {
    @Id
    @GeneratedValue(generator = "uuid2")
	private UUID cuLlave;
    @ManyToOne
    @JoinColumn(name = "cu_colegio")
	private Colegios colegios;
    private String cuCodigo;
	private String cuNombre;
    @ManyToOne
    @JoinColumn(name = "cu_profesor")
	private RecursoHumano profesores;
    @ManyToOne
    @JoinColumn(name = "cu_grado")
	private Grados grados;
    private Boolean cuEstado;
}
