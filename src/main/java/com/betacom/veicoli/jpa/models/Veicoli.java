package com.betacom.veicoli.jpa.models;

import java.time.LocalDateTime;

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
	private Integer id; 
	
	@Column(
			name = "n_ruote",
			nullable = false
			)
	private Integer nRuote; 
	
	private Integer  idTipoVeicolo;
	private Integer  idTipoAlimentazione;
	private String   tipoAlimentazionePattern;
	private Integer  idTipoCategoria;    
	private String   tipoCategoriaPattern;
	private Integer  idColore;
	private Integer  idMarca;  
	
	@Column(
			name = "modello",
			nullable = false
			)
	private String  modello;
	
	@Column(
			name = "anno_produzione",
			nullable = false
			)
	private Integer annoProduzione;
	
	@Column(
			name = "data_inserimento",
			nullable = false
			)
	private LocalDateTime dataInserimento;
	
	
}
