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

	List<VeicoliDTO> list() throws Exception;
}
