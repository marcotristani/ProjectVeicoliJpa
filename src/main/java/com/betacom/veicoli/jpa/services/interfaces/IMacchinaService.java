package com.betacom.veicoli.jpa.services.interfaces;

import com.betacom.veicoli.jpa.dto.input.MacchinaReq;

public interface IMacchinaService {
	void create(MacchinaReq req) throws Exception;
	void update(MacchinaReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
}
