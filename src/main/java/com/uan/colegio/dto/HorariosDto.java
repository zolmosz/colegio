package com.uan.colegio.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

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
	private Date hoFechaIni;
	private Date hoFechaFin;
	private LocalDateTime hoHoraIni;
	private LocalDateTime hoHoraFin;
	private Boolean hoLunes;
	private Boolean hoMartes;
	private Boolean hoMiercoles;
	private Boolean hoJueves;
	private Boolean hoViernes;
	private Boolean hoSabado;
	private Boolean hoDomingo;
	private Boolean hoEstado;
}
