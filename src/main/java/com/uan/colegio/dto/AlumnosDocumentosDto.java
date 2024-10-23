package com.uan.colegio.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosDocumentosDto {
	private UUID adLlave;
    private UUID adColegio;
    private UUID adAlumno;
    
    private byte[] adFormInscripcionMatricula;
    private byte[] adRegistroCivilNac;
    private byte[] adCarneVacunas;
    private byte[] adCertAfiliacionEpsPrepagada;
    private byte[] adFotos;
    private byte[] adCertCrecimientoDesarrollo;
    private byte[] adCertValoracionVisualAuditiva;
    private byte[] adCedulaMadre;
    private byte[] adCedulaPadre;
    private byte[] adContratoPrestServicios;
}
