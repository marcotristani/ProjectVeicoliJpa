package com.betacom.veicoli.jpa.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoVeicoloReq {
	private Integer id;
	private Boolean status;
	private String nome;
	private String pattern;
}
