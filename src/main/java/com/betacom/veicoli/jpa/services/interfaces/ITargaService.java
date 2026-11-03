package com.betacom.veicoli.jpa.services.interfaces;

import com.betacom.veicoli.jpa.dto.input.TargaReq;
import com.betacom.veicoli.jpa.models.Targa;

public interface ITargaService {
	Targa create(TargaReq req) throws Exception;
	void update(Integer id, TargaReq req) throws Exception;
	void delete(Integer id) throws Exception;

	//List<TargaDTO> list() throws Exception;

}
