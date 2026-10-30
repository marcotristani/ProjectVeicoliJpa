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
@Table(name = "veicoli")
public class Veicoli {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVeicolo; 
	
	@Column(
			name = "n_ruote",
			nullable = false
			)
	private Integer nRuote;      
	private Integer  idAlimentazione; 
	private Integer  idCategoria;         
	private Integer  idColore;
	private Integer  idMarca;  
	
	@Column(
			name = "anno_produzione",
			nullable = false
			)
	private Integer annoProduzione;
	
	private Integer idModello;
}
