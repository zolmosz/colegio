package com.uan.colegio.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum EstadosAlumnosEnum {
    REGISTRADO("REG","Registrado"),
    ADMITIDO("ADM","Admitido"),
    RECHAZADO("REC","Rechazado");
    
    private String estado;
    private String descripcion;

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDescByEstado(String estado){
        String respuesta=null;
        
        for (EstadosAlumnosEnum eleEnum: values() ){
            if(eleEnum.estado.equals(estado)){respuesta = eleEnum.getDescripcion();}
        }
        return respuesta;
    }
}
