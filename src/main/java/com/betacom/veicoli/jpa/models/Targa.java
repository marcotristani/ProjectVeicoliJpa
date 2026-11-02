package com.betacom.veicoli.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/*
 * Tabella delle targhe, usata SOLO da macchine e moto (le bici non c'entrano).
 * Il collegamento lo hanno Macchina e Moto (owner, colonna targa_id): qui non serve nessun campo.
 * targa unique -> una macchina e una moto non possono avere la stessa targa.
 */
@Getter
@Setter
@Entity
@Table(name = "targhe")
public class Targa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(
			name = "targa",
			length = 10,
			nullable = false,
			unique = true
			)
	@Size(max = 10)
	private String targa;

}
