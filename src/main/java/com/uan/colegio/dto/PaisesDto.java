package com.uan.colegio.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaisesDto {
	private UUID paLlave;
	private String paCodigo;
    private String paNombrepais;
    
}
