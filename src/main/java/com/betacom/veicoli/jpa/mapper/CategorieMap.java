package com.betacom.veicoli.jpa.mapper;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.TipoCategoriaDTO;
import com.betacom.veicoli.jpa.models.TipoCategoria;

public class CategorieMap {

	public static TipoCategoriaDTO buildTipoCategoriaDTO(TipoCategoria tc) {
		return TipoCategoriaDTO.builder()
				.id(tc.getId())
				.nome(tc.getNome())
				.build();
	}

	public static List<TipoCategoriaDTO> buildTipoCategoriaDTO(List<TipoCategoria> lCat) {
		return lCat.stream()
				.map(tc -> buildTipoCategoriaDTO(tc))
				.toList();
	}
}