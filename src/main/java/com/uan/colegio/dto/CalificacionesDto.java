package com.uan.colegio.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalificacionesDto {
    private UUID caLlave;
    private ColegiosDto colegiosDto;
    private String caCodigo;
    private String caDescripcion;
    private Integer caValor;
    private byte[] caImagen;
    private Boolean caEstado;
}
