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
@Table(name = "tipo_sospensioni")
public class TipoSospensione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(
			name = "nome_sospensione",
			nullable = false
			)
	private String nome;
	
	@Column(
			name = "status",
			nullable = false
			)
	private Boolean status;
	
	@Column(
			name = "pattern",
			nullable = false
			)
	private String pattern;
}
