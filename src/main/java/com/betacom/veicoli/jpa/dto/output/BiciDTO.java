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
public class BiciDTO {
	
	private Integer id;
	private Integer idTipoSospensione;
	private Integer numeroMarce;
	private Boolean pieghevole;
	private Integer idVeicolo;
}
