package com.betacom.veicoli.jpa.dto.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TargaReq {

	Integer id;
	String targa;
}
