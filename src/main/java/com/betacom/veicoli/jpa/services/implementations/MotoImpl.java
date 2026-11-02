package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoli.jpa.dto.input.MotoReq;
import com.betacom.veicoli.jpa.dto.output.MotoDTO;
import com.betacom.veicoli.jpa.models.Moto;
import com.betacom.veicoli.jpa.repositories.IMotoRepository;
import com.betacom.veicoli.jpa.services.interfaces.IMotoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MotoImpl implements IMotoService{
	
	private final IMotoRepository motoRepository;
		
	@Override
	public void create(MotoReq req) throws Exception {
		log.debug("Create {}", req);
		Moto moto = new Moto();
		moto.setCc(req.getCc());
		motoRepository.save(moto);	
	}

	
	@Override
	public void update(MotoReq req) throws Exception {
        log.debug("update");

	
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MotoDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




}
