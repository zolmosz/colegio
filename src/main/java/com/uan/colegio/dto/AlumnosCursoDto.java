package com.uan.colegio.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosCursoDto {
	private UUID acLlave;
	private ColegiosDto colegiosDto;
	private CursosDto cursosDto;
	private AlumnosBasicosDto alumnosBasicosDto;
}
