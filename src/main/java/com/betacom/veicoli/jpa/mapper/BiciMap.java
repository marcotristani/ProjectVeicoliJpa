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
				.idFreno(b.getFreno().getId())
				.numeroMarce(b.getMarce())
				.numeroCorone(b.getCorone())
				.pieghevole(b.getPieghevole())
				.idVeicolo(v.getId())
                .idTipoVeicolo(v.getTipoVeicolo().getId())
                .tipoCategoriaId(v.getTipoCategoria().getId())
                .idMarca(v.getMarca().getId())
                .modello(v.getModello())
                .TipoAlimentazioneId(v.getTipoAlimentazione().getId())
                .idColore(v.getColore().getId())
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
