package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.MotoDTO;
import com.betacom.veicoli.jpa.models.Moto;

public class MotoMap {

	public static MotoDTO buildMotoDTO (Moto moto) {
		return MotoDTO.builder()
				.id(moto.getId())
				.cc(moto.getCc())
				.idVeicolo(moto.getVeicolo().getId())
				.build();
	}
	
	public static List<MotoDTO> buildListMotoDTO (List<Moto> lM){
		return lM.stream()
				.map(moto -> buildMotoDTO(moto))
				.toList();
	}
}
