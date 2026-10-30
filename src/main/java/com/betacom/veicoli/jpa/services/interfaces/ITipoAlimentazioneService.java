package com.betacom.veicoli.jpa.services.interfaces;

import java.util.List;

import com.betacom.veicoli.jpa.dto.input.TipoAlimentazioneReq;
import com.betacom.veicoli.jpa.dto.output.TipoAlimentazioneDTO;

public interface ITipoAlimentazioneService {
	void create(TipoAlimentazioneReq req) throws Exception;
	void update(TipoAlimentazioneReq req) throws Exception;
	void delete(Integer id) throws Exception;

	List<TipoAlimentazioneDTO> list() throws Exception;

}
