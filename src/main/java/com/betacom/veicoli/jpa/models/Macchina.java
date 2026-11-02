
package com.betacom.veicoli.jpa.models;

import jakarta.persistence.CascadeType;
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
	
	// OWNER della targa: colonna targa_id in questa tabella.
	// nullable = false -> niente NULL | unique -> una targa appartiene a un solo veicolo
	// cascade REMOVE + orphanRemoval -> cancellando la macchina/moto si cancella anche la sua targa
	@OneToOne(
			cascade = CascadeType.REMOVE,
			orphanRemoval = true
			)
	@JoinColumn(
			name = "targa_id",
			referencedColumnName = "id",
			nullable = false,
			unique = true
			)
	private Targa targa;

}
