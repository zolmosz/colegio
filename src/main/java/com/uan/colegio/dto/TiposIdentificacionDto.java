package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TiposIdentificacionDto {
	private UUID tiLlave;
	private UUID tiColegio;
	private String tiCodigo;
    private String tiDesc;
}
