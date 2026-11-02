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
	private Integer idFreno;
	private Integer numeroMarce;
	private Integer numeroCorone;
	private Boolean pieghevole;
	private VeicoliDTO Veicolo;
}
