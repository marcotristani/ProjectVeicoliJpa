package com.betacom.veicoli.jpa.services.implementations;

import org.springframework.stereotype.Service;

import com.betacom.veicoli.jpa.dto.input.TargaReq;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.models.Targa;
import com.betacom.veicoli.jpa.repositories.ITargaRepository;
import com.betacom.veicoli.jpa.services.interfaces.ITargaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TargaImpl implements ITargaService{

	private final ITargaRepository targaRepository;
	@Override
	public Targa create(TargaReq req) throws Exception {
		if(targaRepository.existsByTarga(req.getTarga().trim().toLowerCase()))
				throw new AcademyException("targa-fnd");
		Targa targa = new Targa();
		targa.setTarga(req.getTarga().trim().toLowerCase());
		return targaRepository.save(targa);
	}

	@Override
	public void update(Integer id, TargaReq req) throws Exception {
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
