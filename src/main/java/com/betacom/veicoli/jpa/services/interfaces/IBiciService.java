package com.betacom.veicoli.jpa.services.interfaces;


public interface IBiciService {
	void create(BiciReq req) throws Exception;
	void update(BiciReq req) throws Exception;
	void delete(Integer id) throws Exception;
	
}
