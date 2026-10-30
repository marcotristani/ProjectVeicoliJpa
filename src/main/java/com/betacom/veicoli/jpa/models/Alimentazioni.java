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
@Table(name = "alimentazioni")
public class Alimentazioni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlimentazione;
	
	@Column(
			name = "tipo_alimentazione",
			nullable = false
			)
	private String tipo;
}
