package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.FreniDTO;
import com.betacom.veicoli.jpa.models.Freni;

public class FreniMap {

    public static FreniDTO buildFreniDTO(Freni f) {
        return FreniDTO.builder()
                .id(f.getId())
                .tipo(f.getTipo())
                .build();
    }

    public static List<FreniDTO> buildFreniDTOs(List<Freni> lF) {
        return lF.stream()
                .map(f -> buildFreniDTO(f))
                .toList();
    }
}