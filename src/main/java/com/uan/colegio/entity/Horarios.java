package com.uan.colegio.entity;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
