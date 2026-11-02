package com.betacom.veicoli.jpa.models;

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
@Table(name = "full_veicolo")
public class FullVeicolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String tipo;
	private Integer numeroRuote;
	private String categ;
	private String alim;
	private String colore;
	private String marca;
	private String modello;
	private Integer annoProduzione;
	private Integer numeroPorte;
	private Integer numeroMarce;
	private Boolean pieghevole;
	private String tipoSospenzione;
	private String targa;
	private Integer cc;
}
