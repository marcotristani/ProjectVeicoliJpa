package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.TipoVeicoloDTO;
import com.betacom.veicoli.jpa.models.TipoVeicolo;

public class TipoVeicoloMapper {

	public static TipoVeicoloDTO buildTipoVeicoloDTO(TipoVeicolo tipoVeicolo) {
		return TipoVeicoloDTO.builder()
				.id(tipoVeicolo.getId())
				.nome(tipoVeicolo.getTipo())
				.build();
	}
	
	public static List<TipoVeicoloDTO> buildListTipoVeicoloDTO(List<TipoVeicolo> lTV){
		return lTV.stream()
				.map(tipoVeicolo -> buildTipoVeicoloDTO(tipoVeicolo))
				.toList();
	}
}
