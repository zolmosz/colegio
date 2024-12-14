package com.uan.colegio.dto;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeriodosDto {
    private UUID perLlave;
    private ColegiosDto colegiosDto;
    private String perCodigo;
	private String perNombre;
	private Integer perNumero;
	private Integer perAnio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date perFecini;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date perFecfin;
    private Boolean perEstado;
}
