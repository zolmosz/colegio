package com.uan.colegio.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PerfilesDto {
	private UUID peLlave;
	private String peCodigo;
	private String peDesc;
}
