package com.betacom.veicoli.jpa.dto.output;

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
public class MacchinaDTO {

	private Integer id;
	private String targa;
	private Integer numeroPorte;
	private Integer idVeicolo;
	private Integer cc;

}
