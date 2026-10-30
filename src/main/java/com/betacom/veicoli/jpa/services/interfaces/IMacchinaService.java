package com.betacom.veicoli.jpa.services.interfaces;


public interface IMacchinaService {
	void create(MacchinaReq req) throws Exception;
	void update(MacchinaReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
}
