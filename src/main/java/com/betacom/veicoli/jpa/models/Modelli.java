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
@Table(name = "modelli")
public class Modelli {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idModello;
	
	@Column(
			name = "nome_modello",
			nullable = false
			)
	private String nome;
}
