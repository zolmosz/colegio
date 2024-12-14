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
    private Integer caCodigo;
    private String caDescripción;
    private Integer caValor;
    private String caImagen;
    private Boolean caEstado;
}
