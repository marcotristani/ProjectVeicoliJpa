package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.VeicoliReq;
import com.betacom.veicoli.jpa.dto.output.VeicoliDTO;
import com.betacom.veicoli.jpa.models.TipoVeicolo;
import com.betacom.veicoli.jpa.models.Veicoli;

public interface IVeicoliService {
	Veicoli create(VeicoliReq req, TipoVeicolo tipoVeicolo) throws Exception;
	Veicoli update(VeicoliReq req) throws Exception;
	void delete(Integer id) throws Exception;

	List<VeicoliDTO> list(String tipoVeicolo,
			String tipoCategoria, String modello,
			Integer annoProduzione, Integer nRuote,
			String tipoAlimentazione,String colore,
			String marca, Integer cc,
			Integer porte, String targa,
			String marce, String corone,
			Boolean pieghevole, String freno, String sospensione) throws Exception;
}
