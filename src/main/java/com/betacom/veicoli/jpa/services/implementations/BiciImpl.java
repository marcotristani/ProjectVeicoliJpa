package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoli.jpa.dto.input.BiciReq;
import com.betacom.veicoli.jpa.dto.output.BiciDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.models.Bici;
import com.betacom.veicoli.jpa.models.Freni;
import com.betacom.veicoli.jpa.models.TipoSospensione;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IBiciRepository;
import com.betacom.veicoli.jpa.repositories.IFreniRepository;
import com.betacom.veicoli.jpa.repositories.ITipoSospensioneRepository;
import com.betacom.veicoli.jpa.repositories.IVeicoliRepository;
import com.betacom.veicoli.jpa.services.interfaces.IBiciService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BiciImpl implements IBiciService{
	
	private final IBiciRepository biciR;
	private final IFreniRepository freniR;
	private final ITipoSospensioneRepository sospensioniR;
	private final IVeicoliRepository veicR;
	
	@Override
	public void create(BiciReq req) throws Exception {
		log.debug("Create {}", req);
		Freni freno = freniR.findById(req.getIdFreno())
		        .orElseThrow(() -> new AcademyException("freno-ntfnd"));
		TipoSospensione sospensione = sospensioniR.findById(req.getIdTipoSospensione())
				.orElseThrow(() -> new AcademyException("tipososp-ntfnd"));

		Bici bici = new Bici();
		
		bici.setFreno(freno);
		bici.setCorone(req.getNumeroCorone());
		bici.setMarce(req.getNumeroCorone());
		bici.setPieghevole(req.getPieghevole());
		bici.setSospensione(sospensione);

		biciR.save(bici);
		
	}

	@Override
	public void update(BiciReq req) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BiciDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
