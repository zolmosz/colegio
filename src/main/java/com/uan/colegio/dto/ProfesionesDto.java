package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesionesDto {
	private UUID prLlave;
	private UUID prColegio;
	private String prCodigo;
    private String prNombre;
    private Boolean prEstado;
}
