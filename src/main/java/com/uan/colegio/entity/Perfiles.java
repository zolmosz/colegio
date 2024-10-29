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
@Table(name = "perfiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Perfiles {
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID peLlave;
	private String peCodigo;
	private String peDesc;
}
