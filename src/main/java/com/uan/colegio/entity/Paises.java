package com.uan.colegio.entity;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paises")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paises {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID paLlave;
	private String paCodigo;
    private String paNombrepais;
    
}
