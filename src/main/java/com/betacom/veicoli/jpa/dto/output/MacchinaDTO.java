package com.betacom.veicoli.jpa.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MacchinaDTO extends VeicoliDTO{

	private Integer id;
	private String targa;
	private Integer numeroPorte;
	private Integer idVeicolo;
	private Integer cc;

}
