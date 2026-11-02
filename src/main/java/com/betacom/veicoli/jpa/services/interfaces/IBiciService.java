package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.BiciReq;
import com.betacom.veicoli.jpa.dto.output.BiciDTO;

public interface IBiciService {
	void create(BiciReq req) throws Exception;
	void update(BiciReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
	
	List<BiciDTO> list() throws Exception;
}
