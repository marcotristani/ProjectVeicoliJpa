package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.output.VeicoliDTO;

public interface IListService {

	List<VeicoliDTO> printList(String tipoVeicolo,
			String tipoCategoria,String modello,
			Integer annoProduzione, Integer nRuote,
			String tipoAlimentazione,String colore,
			String marca, Integer cc,
			Integer porte, String targa,
			Integer marce, Integer corone,
			Boolean pieghevole, String freno, String sospensione);
}
