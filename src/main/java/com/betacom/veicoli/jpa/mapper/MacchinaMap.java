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
                .tipoVeicolo(v.getTipoVeicolo().getTipo())
                .annoProduzione(v.getAnnoProduzione())
                .tipoCategoriaId(v.getTipoCategoria().getId())
                .tipoCategoria(v.getTipoCategoria().getNome())
                .idColore(v.getColore().getId())
                .nomeColore(v.getColore().getNome())
                .idMarca(v.getMarca().getId())
                .nomeMarca(v.getMarca().getNome())
                .numeroRuote(v.getNRuote())
                .data_inserimento(v.getDataInserimento())
                .modello(v.getModello())
                .TipoAlimentazioneId(v.getTipoAlimentazione().getId())
                .tipoAlimentazione(v.getTipoAlimentazione().getNome())
                .targa(mac.getTarga().getTarga()) 
                .idVeicolo(v.getId())             
                .build();
    }

    public static List<MacchinaDTO> buildMacchinaDTOs(List<Macchina> lmac) {
        return lmac.stream()
                .map(m -> buildMacchinaDTO(m))
                .toList();
    }
}