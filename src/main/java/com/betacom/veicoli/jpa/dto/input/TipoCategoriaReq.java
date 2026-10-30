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
public class TipoCategoriaReq {
	private String pattern;
	private Integer id;
	private String nome;
}
