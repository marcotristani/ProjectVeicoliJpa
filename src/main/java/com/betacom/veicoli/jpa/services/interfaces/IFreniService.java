package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.FreniReq;
import com.betacom.veicoli.jpa.dto.output.FreniDTO;

public interface IFreniService {
	void create(FreniReq req) throws Exception;
	void update(FreniReq req) throws Exception;
	void delete(Integer id) throws Exception;

	List<FreniDTO> list() throws Exception;

}
