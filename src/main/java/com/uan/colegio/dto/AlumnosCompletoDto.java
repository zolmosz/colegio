package com.uan.colegio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlumnosCompletoDto {
    private AlumnosBasicosDto alumnosBasicosDto;
    private AlumnosFamiliaDto alumnosFamiliaDto;
    private AlumnosDocumentosDto alumnosDocumentosDto;
}
