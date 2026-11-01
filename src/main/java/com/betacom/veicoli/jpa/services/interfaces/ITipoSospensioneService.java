package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.TipoSospenzioneReq;
import com.betacom.veicoli.jpa.dto.output.TipoSospensioneDTO;

public interface ITipoSospensioneService {
	void create(TipoSospenzioneReq req) throws Exception;
	void update(TipoSospenzioneReq req) throws Exception;
	void delete(Integer id) throws Exception;

	List<TipoSospensioneDTO> list() throws Exception;

}
