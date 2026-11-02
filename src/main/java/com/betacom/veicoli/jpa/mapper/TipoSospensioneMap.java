package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.TipoSospensioneDTO;
import com.betacom.veicoli.jpa.models.TipoSospensione;

public class TipoSospensioneMap {

    public static TipoSospensioneDTO buildTipoSospensioneDTO(TipoSospensione ts) {
        return TipoSospensioneDTO.builder()
                .id(ts.getId())
                .nome(ts.getNome())
                .build();
    }

    public static List<TipoSospensioneDTO> buildTipoSospensioneDTOs(List<TipoSospensione> lT) {
        return lT.stream()
                .map(ts -> buildTipoSospensioneDTO(ts))
                .toList();
    }
}