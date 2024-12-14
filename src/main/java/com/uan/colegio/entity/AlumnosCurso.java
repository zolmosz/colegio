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
@Table(name = "alumnos_curso")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosCurso {
    @Id
    @GeneratedValue(generator = "uuid2")
	private UUID acLlave;
    @ManyToOne
    @JoinColumn(name = "ac_colegio")
	private Colegios colegios;
    @ManyToOne
    @JoinColumn(name = "ac_curso")
	private Cursos cursos;
    @ManyToOne
    @JoinColumn(name = "ac_alumno")
	private AlumnosBasicos alumnosBasicos;
}
