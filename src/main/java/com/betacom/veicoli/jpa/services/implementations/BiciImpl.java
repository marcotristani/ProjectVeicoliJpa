package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.betacom.veicoli.jpa.services.interfaces.IBiciService;
import com.betacom.veicoli.jpa.services.interfaces.IVeicoliService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BiciImpl implements IBiciService{
	
	private final IBiciRepository biciR;
	private final IFreniRepository freniR;
	private final ITipoSospensioneRepository sospensioniR;
	private final IVeicoliService veiS;
	
	@Override
	@Transactional
	public void create(BiciReq req) throws Exception {
		log.debug("Create {}", req);
		Freni freno = freniR.findById(req.getIdFreno())
		        .orElseThrow(() -> new AcademyException("freno-ntfnd"));
		TipoSospensione sospensione = sospensioniR.findById(req.getIdTipoSospensione())
				.orElseThrow(() -> new AcademyException("tipososp-ntfnd"));
		Veicoli veicolo = veiS.create(req.getVeicolo());
		Bici bici = new Bici();
		
		bici.setFreno(freno);
		bici.setCorone(req.getNumeroCorone());
		bici.setMarce(req.getNumeroMarce());
		bici.setPieghevole(req.getPieghevole());
		bici.setSospensione(sospensione);
		bici.setVeicolo(veicolo);

		biciR.save(bici);
		
	}

	@Override
	@Transactional
	public void update(BiciReq req) throws Exception {
		log.debug("Update {}", req);
		Bici bici = biciR.findById(req.getId())
		        .orElseThrow(() -> new AcademyException("bici-ntfnd"));
		Freni freno = freniR.findById(req.getIdFreno())
		        .orElseThrow(() -> new AcademyException("freno-ntfnd"));
		TipoSospensione sospensione = sospensioniR.findById(req.getIdTipoSospensione())
		        .orElseThrow(() -> new AcademyException("tipososp-ntfnd"));
		bici.setFreno(freno);
		bici.setCorone(req.getNumeroCorone());
		bici.setMarce(req.getNumeroMarce());
		bici.setPieghevole(req.getPieghevole());
		bici.setSospensione(sospensione);
	
		veiS.update(bici.getVeicolo().getId(), req.getVeicolo());
		
		biciR.save(bici);
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
