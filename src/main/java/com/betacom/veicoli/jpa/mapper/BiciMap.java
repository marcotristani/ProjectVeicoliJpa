package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.BiciDTO;
import com.betacom.veicoli.jpa.models.Bici;
import com.betacom.veicoli.jpa.models.Veicoli;

public class BiciMap {
	public static BiciDTO buildBiciDTO (Bici b) {
		Veicoli v = b.getVeicolo();
		return BiciDTO.builder()
				.id(b.getId())
				.idTipoSospensione(b.getSospensione().getId())
				.tipoSospensione(b.getSospensione().getNome())
				.idFreno(b.getFreno().getId())
				.tipoFreno(b.getFreno().getTipo())
				.numeroMarce(b.getMarce())
				.numeroCorone(b.getCorone())
				.pieghevole(b.getPieghevole())
				.idVeicolo(v.getId())
                .idTipoVeicolo(v.getTipoVeicolo().getId())
                .tipoVeicolo(v.getTipoVeicolo().getTipo())
                .tipoCategoriaId(v.getTipoCategoria().getId())
                .tipoCategoria(v.getTipoCategoria().getNome())
                .idMarca(v.getMarca().getId())
                .nomeMarca(v.getMarca().getNome())
                .modello(v.getModello())
                .TipoAlimentazioneId(v.getTipoAlimentazione().getId())
                .tipoAlimentazione(v.getTipoAlimentazione().getNome())
                .idColore(v.getColore().getId())
                .nomeColore(v.getColore().getNome())
                .annoProduzione(v.getAnnoProduzione())
                .numeroRuote(v.getNRuote())
				.build();
	}
	
	public static List<BiciDTO> buildBiciDTO (List<Bici> lB){
		return lB.stream()
				.map(b -> buildBiciDTO(b))
				.toList();
	}
}
