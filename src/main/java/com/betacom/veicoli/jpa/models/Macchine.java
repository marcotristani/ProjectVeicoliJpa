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
@Table(name = "macchine")
public class Macchine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMacchina;
	private Integer idVeicolo;
	private Integer idTarga;  
	
	@Column(
			name = "cc",
			nullable = false
			)
	private Integer cc; 
	
	@Column(
			name = "n_porte",
			nullable = false
			)
	private Integer porte;

}
