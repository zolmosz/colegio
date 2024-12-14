package com.uan.colegio.entity;

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
@Table(name = "periodos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Periodos {
    @Id
    @GeneratedValue(generator = "uuid2")
	private UUID perLlave;
    @ManyToOne
    @JoinColumn(name = "per_colegio")
	private Colegios colegios;
    private String perCodigo;
	private String perNombre;
	private Integer perNumero;
	private Integer perAnio;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date perFecini;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date perFecfin;
    private Boolean perEstado;
}
