package com.uan.colegio.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursosDto {
    private UUID cuLlave;
    private ColegiosDto colegiosDto;
    private String cuCodigo;
	private String cuNombre;
    private RecursoHumanoDto profesoresDto;
    private GradosDto gradosDto;
    private Boolean cuEstado;
}
