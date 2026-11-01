package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.TipoVeicoloReq;
import com.betacom.veicoli.jpa.dto.output.TipoVeicoloDTO;

public interface ITipoVeicoloService {
	void create(TipoVeicoloReq req) throws Exception;
	void update(TipoVeicoloReq req) throws Exception;
	void delete(Integer id) throws Exception;

	List<TipoVeicoloDTO> list() throws Exception;

}
