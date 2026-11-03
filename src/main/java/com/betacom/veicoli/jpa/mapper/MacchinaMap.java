package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.MacchinaDTO;
import com.betacom.veicoli.jpa.models.Macchina;

public class MacchinaMap {

	public static MacchinaDTO buildMacchinaDTO(Macchina mac) {
		return MacchinaDTO.builder()
				.id(mac.getId())
				.cc(mac.getCc())
				.numeroPorte(mac.getPorte())
				.targa(mac.getTarga().getTarga())  // oggetto Targa collegato → il suo testo ("el234gx")
				.idVeicolo(mac.getVeicolo().getId()) // padre Veicoli collegato → il suo id (1)
				.build();
	}
	
	public static List<MacchinaDTO> buildMacchinaDTOs (List<Macchina> lmac) {
		return lmac.stream()
				.map(m -> buildMacchinaDTO(m))
				.toList();
	}

}
