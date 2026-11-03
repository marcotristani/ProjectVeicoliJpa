package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.VeicoliDTO;
import com.betacom.veicoli.jpa.models.Veicoli;

public class VeicoliMap {

    public static VeicoliDTO buildVeicoliDTO(Veicoli v) {
       
        return VeicoliDTO.builder()
                .id(v.getId())
                .idTipoVeicolo(v.getTipoVeicolo().getId())
                .tipoCategoriaId(v.getTipoCategoria().getId())
                .idMarca(v.getMarca().getId())
                .modello(v.getModello())
                .TipoAlimentazioneId(v.getTipoAlimentazione().getId())
                .idColore(v.getColore().getId())
                .annoProduzione(v.getAnnoProduzione())
                .data_inserimento(v.getDataInserimento())
                .numeroRuote(v.getNRuote())
                .build();
    }
    
    public static List<VeicoliDTO> buildVeicoliDTO (List<Veicoli> lV){
		return lV.stream()
				.map(v -> buildVeicoliDTO(v))
				.toList();
	}
}