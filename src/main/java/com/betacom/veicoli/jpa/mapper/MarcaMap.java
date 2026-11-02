package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.MarcaDTO;
import com.betacom.veicoli.jpa.models.Marca;

public class MarcaMap {

    public static List<MarcaDTO> buildMarcaDTOList(List<Marca> marche) {
        return marche.stream()
                .map(MarcaMap::buildMarcaDTO)
                .toList();
    }

    public static MarcaDTO buildMarcaDTO(Marca marca) {
        return MarcaDTO.builder()
                .id(marca.getId())
                .nome(marca.getNome())
                .build();
    }
}
