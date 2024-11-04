package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GradosDto {
	private UUID grLlave;
	private ColegiosDto colegiosDto;
	private String grCodigo;
	private String grDesc;
	private Boolean grEstado;
}
