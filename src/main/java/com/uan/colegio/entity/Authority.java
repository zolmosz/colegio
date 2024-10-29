package com.uan.colegio.entity;

import java.util.UUID;

import com.uan.colegio.enums.AuthorityName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "autorities")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Authority {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	private UUID id;
	@Enumerated(EnumType.STRING)
	private AuthorityName name;
}
