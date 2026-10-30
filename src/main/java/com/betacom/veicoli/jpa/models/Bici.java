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
@Table(name = "bici")
public class Bici {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(
			name = "n_marce",
			nullable = false
			)
	private Integer marce;
	
	@Column(
			name = "n_corone",
			nullable = false
			)
	private Integer corone;
	
	@Column(
			name = "pieghevole"
			)
	private Boolean pieghevole;
	
	private Integer idVeicolo;
	private Integer idFreno;
	private Integer idSospensione;
	
}
