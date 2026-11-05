package com.betacom.veicoli.jpa.dto.output;

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
public class BiciDTO extends VeicoliDTO{
	
	private Integer id;
	private Integer idTipoSospensione;
	private String tipoSospensione;
	private Integer idFreno;
	private String tipoFreno;
	private Integer numeroMarce;
	private Integer numeroCorone;
	private Boolean pieghevole;
	private Integer idVeicolo;
}
