
package com.betacom.veicoli.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "macchine")
public class Macchina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idVeicolo;
	private String Targa;  
	
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
	
	@OneToOne
	@JoinColumn(
			name = "veicolo_id",
			referencedColumnName = "id"
			)
	private Veicoli veicolo;

}
