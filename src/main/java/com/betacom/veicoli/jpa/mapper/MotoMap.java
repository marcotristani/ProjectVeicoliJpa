package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.MotoDTO;
import com.betacom.veicoli.jpa.models.Moto;

public class MotoMap {

	public static MotoDTO buildMotoDTO (Moto moto) {
		return MotoDTO.builder()
				.id(moto.getId())
				.cc(moto.getCc())
				.targa(moto.getTarga().getTarga())
				.idVeicolo(moto.getVeicolo().getId())
                .idTipoVeicolo(moto.getVeicolo().getTipoVeicolo().getId())
                .tipoCategoriaId(moto.getVeicolo().getTipoCategoria().getId())
                .idMarca(moto.getVeicolo().getMarca().getId())
                .modello(moto.getVeicolo().getModello())
                .TipoAlimentazioneId(moto.getVeicolo().getTipoAlimentazione().getId())
                .idColore(moto.getVeicolo().getColore().getId())
                .annoProduzione(moto.getVeicolo().getAnnoProduzione())
                .data_inserimento(moto.getVeicolo().getDataInserimento())
                .numeroRuote(moto.getVeicolo().getNRuote())
				.build();
	}
	
	public static List<MotoDTO> buildListMotoDTO (List<Moto> lM){
		return lM.stream()
				.map(moto -> buildMotoDTO(moto))
				.toList();
	}
}
