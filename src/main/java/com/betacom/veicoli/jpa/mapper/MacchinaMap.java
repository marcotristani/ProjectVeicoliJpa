package com.betacom.veicoli.jpa.mapper;

import java.util.List;
import com.betacom.veicoli.jpa.dto.output.MacchinaDTO;
import com.betacom.veicoli.jpa.models.Macchina;
import com.betacom.veicoli.jpa.models.Veicoli;

public class MacchinaMap {

    public static MacchinaDTO buildMacchinaDTO(Macchina mac) {
        Veicoli v = mac.getVeicolo();
        
        return MacchinaDTO.builder()
                .id(mac.getId())
                .cc(mac.getCc())
                .numeroPorte(mac.getPorte())
                .idTipoVeicolo(v.getTipoVeicolo().getId())
                .annoProduzione(v.getAnnoProduzione())
                .tipoCategoriaId(v.getTipoCategoria().getId())
                .idColore(v.getColore().getId())
                .idMarca(v.getMarca().getId())
                .numeroRuote(v.getNRuote())
                .data_inserimento(v.getDataInserimento())
                .modello(v.getModello())
                .TipoAlimentazioneId(v.getTipoAlimentazione().getId())
                .targa(mac.getTarga().getTarga()) // oggetto Targa collegato → il suo testo ("el234gx")
                .idVeicolo(v.getId())             // padre Veicoli collegato → il suo id (1)
                .build();
    }

    public static List<MacchinaDTO> buildMacchinaDTOs(List<Macchina> lmac) {
        return lmac.stream()
                .map(m -> buildMacchinaDTO(m))
                .toList();
    }
}