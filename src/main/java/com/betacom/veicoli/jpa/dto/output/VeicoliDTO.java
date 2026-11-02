package com.betacom.veicoli.jpa.dto.output;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
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
