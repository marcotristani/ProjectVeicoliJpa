package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.MotoReq;
import com.betacom.veicoli.jpa.dto.output.MotoDTO;

public interface IMotoService {
	void create(MotoReq req) throws Exception;
	void update(MotoReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
	List<MotoDTO> list() throws Exception;

}
