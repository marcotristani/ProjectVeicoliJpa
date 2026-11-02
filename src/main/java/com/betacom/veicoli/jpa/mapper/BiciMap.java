package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.BiciDTO;
import com.betacom.veicoli.jpa.models.Bici;

public class BiciMap {
	public static BiciDTO buildBiciDTO (Bici b) {
		return BiciDTO.builder()
				.id(b.getId())
				.idTipoSospensione(b.getSospensione().getId())
				.idFreno(b.getFreno().getId())
				.numeroMarce(b.getMarce())
				.numeroCorone(b.getCorone())
				.pieghevole(b.getPieghevole())
				.build();
	}
	
	public static List<BiciDTO> buildBiciDTO (List<Bici> lB){
		return lB.stream()
				.map(b -> buildBiciDTO(b))
				.toList();
	}
}
