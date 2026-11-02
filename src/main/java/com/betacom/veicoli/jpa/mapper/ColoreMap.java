package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.ColoreDTO;
import com.betacom.veicoli.jpa.models.Colore;

public class ColoreMap {

    public static ColoreDTO buildColoreDTO(Colore c) {
        return ColoreDTO.builder()
                .id(c.getId())
                .nome(c.getNome())
                .build();
    }

    public static List<ColoreDTO> buildColoreDTOs(List<Colore> lC) {
        return lC.stream()
                .map(c -> buildColoreDTO(c))
                .toList();
    }
}