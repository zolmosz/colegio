package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiciosDto {
	private UUID srLlave;
	private UUID srColegio;
	private String srCodigo;
    private String srNombre;
}
