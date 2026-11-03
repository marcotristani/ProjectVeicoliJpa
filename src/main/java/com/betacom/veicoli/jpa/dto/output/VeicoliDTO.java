package com.betacom.veicoli.jpa.dto.output;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VeicoliDTO {
	private Integer  id;
	private Integer  idTipoVeicolo;
	private Integer  tipoCategoriaId;
	private Integer  idMarca;
	private String   modello;
	private Integer  TipoAlimentazioneId;
	private Integer  idColore;
	private Integer  annoProduzione;
	private LocalDateTime   data_inserimento;
	private Integer  numeroRuote;
}
