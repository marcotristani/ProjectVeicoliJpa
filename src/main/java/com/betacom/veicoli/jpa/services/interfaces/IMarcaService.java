package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.MarcaReq;
import com.betacom.veicoli.jpa.dto.output.MarcaDTO;

public interface IMarcaService {
	void create(MarcaReq req) throws Exception;
	void update(MarcaReq req) throws Exception;
	void delete(Integer id) throws Exception;

	List<MarcaDTO> list() throws Exception;

}
