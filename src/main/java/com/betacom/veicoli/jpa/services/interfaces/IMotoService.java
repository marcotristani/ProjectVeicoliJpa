package com.betacom.veicoli.jpa.services.interfaces;


public interface IMotoService {
	void create(MotoReq req) throws Exception;
	void update(MotoReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
}
