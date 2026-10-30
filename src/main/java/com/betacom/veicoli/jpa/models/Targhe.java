package com.betacom.veicoli.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "targhe")
public class Targhe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTarga;
	
	@Column(
			name = "codice_targa",
			nullable = false,
			unique = true
			)
	private String targa;
}
