package com.betacom.veicoli.jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_veicoli")
public class TipoVeicolo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(
			name = "tipo_veicolo",
			nullable = false
			)
	private String tipo;
	
	@OneToMany(
			mappedBy = "tipoVeicolo",
			fetch = FetchType.EAGER
			)
	private List<Veicoli> veicoli;
}
