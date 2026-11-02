package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.ColoreReq;
import com.betacom.veicoli.jpa.dto.output.ColoreDTO;

public interface IColoreService {
	void create(ColoreReq req) throws Exception;
	void update(ColoreReq req) throws Exception;
	void delete(Integer id) throws Exception;

	List<ColoreDTO> list() throws Exception;
    
}
