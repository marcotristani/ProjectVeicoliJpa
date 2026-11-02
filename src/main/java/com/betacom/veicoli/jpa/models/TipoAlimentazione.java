package com.betacom.veicoli.jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alimentazioni")
public class TipoAlimentazione {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(
			name = "nome_alimentazione",
			nullable = false
			)
	private String nome;
	
	@Column(
			name = "pattern",
			nullable = false
			)
	private String pattern;
	
	@OneToMany(
			mappedBy = "tipoAlimentazione",
			fetch = FetchType.EAGER
			)
	private List<Veicoli> veicoli;
	
}
