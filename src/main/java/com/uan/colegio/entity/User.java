package com.uan.colegio.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	
	@Id
    @GeneratedValue(generator = "uuid2")
	private UUID id;
	private String username;
	private String password;
	
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name="user_authority",
			joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="authority_id", referencedColumnName = "id")
			)
	private List<Authority> autorities;
}
