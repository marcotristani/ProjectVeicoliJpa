package com.betacom.veicoli.jpa.models;



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
	
	@OneToOne
	@JoinColumn(
			name = "veicolo_id",
			referencedColumnName = "id"
			)
	private Veicoli veicolo;
	
	@ManyToOne
	@JoinColumn(
			name = "freno_id",
			nullable = false
			)
	private Freni freno;
	
	@ManyToOne
	@JoinColumn(
			name = "sospensione_id",
			nullable = false
			)
	private TipoSospensione sospensione;
	

	
}
