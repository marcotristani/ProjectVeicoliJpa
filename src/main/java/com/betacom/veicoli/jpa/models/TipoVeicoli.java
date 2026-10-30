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
@Table(name = "tipo_veicoli")
public class TipoVeicoli{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoVeicolo;
	@Column(
			name = "tipo_veicolo",
			nullable = false
			)
	private String tipo;
}
