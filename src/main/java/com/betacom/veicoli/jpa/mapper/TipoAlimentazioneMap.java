package com.betacom.veicoli.jpa.mapper;



import java.util.List;

import com.betacom.veicoli.jpa.dto.output.TipoAlimentazioneDTO;
import com.betacom.veicoli.jpa.models.TipoAlimentazione;

public class TipoAlimentazioneMap {
	public static TipoAlimentazioneDTO buildTipoAlimentazioneDTO (TipoAlimentazione a) {
		return TipoAlimentazioneDTO.builder()
				.id(a.getId())
				.nome(a.getNome())
				.pattern(a.getPattern())
				.build();
	}
	
	public static List<TipoAlimentazioneDTO> buildTipoAlimentazioneDTO (List<TipoAlimentazione> lA){
		return lA.stream()
				.map(a -> buildTipoAlimentazioneDTO(a))
				.toList();
	}
}
