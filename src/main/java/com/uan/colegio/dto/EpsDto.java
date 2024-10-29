package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EpsDto {
	private UUID epsLlave;
	private UUID epsColegio;
	private String epsNit;
	private String epsDigitoVer;
    private String epsNombre;
    private Boolean epsEstado;
}
