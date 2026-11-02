package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.MacchinaReq;
import com.betacom.veicoli.jpa.dto.output.MacchinaDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.models.Macchina;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IMacchinaRepository;
import com.betacom.veicoli.jpa.repositories.ITargaRepository;
import com.betacom.veicoli.jpa.repositories.IVeicoliRepository;
import com.betacom.veicoli.jpa.services.interfaces.IMacchinaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor

public class MacchinaImpl  implements IMacchinaService{
	
	private final IMacchinaRepository macR;
	private final IVeicoliRepository vecR;
	private final ITargaRepository targaR;
//	private final VeicoliImpl veicoliS; 
	
	
	
	@Transactional
	@Override
	public void create(MacchinaReq req) throws Exception {
		log.debug("Creazione macchina{}", req);
		
		if(targaR.existsByTarga(req.getTarga()))
			throw new AcademyException("targa gia presente in DB");
		
	
		
		
		
		
	}

	@Override
	public void update(MacchinaReq req) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MacchinaDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
