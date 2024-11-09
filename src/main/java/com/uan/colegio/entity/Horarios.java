package com.uan.colegio.entity;


import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "horarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Horarios {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID hoLlave;
	@ManyToOne
    @JoinColumn(name = "ho_colegio")
	Colegios colegios;
	private String hoCodigo;
	private String hoDesc;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hoFechaIni;
	@Temporal(TemporalType.DATE)
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
