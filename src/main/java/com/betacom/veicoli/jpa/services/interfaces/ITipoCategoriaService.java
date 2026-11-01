package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.TipoCategoriaReq;
import com.betacom.veicoli.jpa.dto.output.TipoCategoriaDTO;

public interface ITipoCategoriaService {
	void create(TipoCategoriaReq req) throws Exception;
	void update(TipoCategoriaReq req) throws Exception;
	void delete(Integer id) throws Exception;

	List<TipoCategoriaDTO> list() throws Exception;

}
