package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.MacchinaReq;
import com.betacom.veicoli.jpa.dto.output.MacchinaDTO;

public interface IMacchinaService {
	void create(MacchinaReq req) throws Exception;
	void update(MacchinaReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
	List<MacchinaDTO> list() throws Exception;

}
