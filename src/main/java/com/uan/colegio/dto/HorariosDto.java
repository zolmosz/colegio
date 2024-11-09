package com.uan.colegio.dto;

import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HorariosDto {
	private UUID hoLlave;
	private ColegiosDto colegiosDto;
	private String hoCodigo;
	private String hoDesc;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hoFechaIni;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hoFechaFin;
	private LocalTime hoHoraIni;
	private LocalTime hoHoraFin;
	private Boolean hoLunes;
	private Boolean hoMartes;
	private Boolean hoMiercoles;
	private Boolean hoJueves;
	private Boolean hoViernes;
	private Boolean hoSabado;
	private Boolean hoDomingo;
	private Boolean hoEstado;
}
