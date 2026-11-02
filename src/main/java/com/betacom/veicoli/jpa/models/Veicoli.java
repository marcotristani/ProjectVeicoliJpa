package com.betacom.veicoli.jpa.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	
	@ManyToOne
	@JoinColumn(
			name = "tipo_veicolo_id",
			nullable = false
			)
	private TipoVeicolo tipoVeicolo;
	
	@ManyToOne
	@JoinColumn(
			name = "alimentazione_id",
			nullable = false
			)
	private TipoAlimentazione  tipoAlimentazione; 
	

	
	@ManyToOne
	@JoinColumn(
			name = "categoria_id",
			nullable = false
			)
	private TipoCategoria tipoCategoria;    
	

	
	@ManyToOne
	@JoinColumn(
			name = "colore_id",
			nullable = false
			)
	private Colore colore;
	
	@ManyToOne
	@JoinColumn(
			name = "marca_id",
			nullable = false
			)
	private Marca marca;  
	
	//così facendo ho una relazione bidirezionale con macchina, ma non visulizzo la colonna macchina nella tabella veicoli perchè non ho fatto join column
	//inoltre dico che eliminando il veicolo di conseguenza elimino la macchina
	@OneToOne(  mappedBy = "veicolo",
				cascade = CascadeType.REMOVE,
				orphanRemoval = true
			)
	private Macchina macchina;
	
	@OneToOne(  mappedBy = "veicolo",
			cascade = CascadeType.REMOVE,
			orphanRemoval = true
		)
	private Moto moto;
	
	@OneToOne(  mappedBy = "veicolo",
			cascade = CascadeType.REMOVE,
			orphanRemoval = true
		)
	private Bici bici;
	
}
