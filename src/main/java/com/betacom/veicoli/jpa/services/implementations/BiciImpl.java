package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.BiciReq;
import com.betacom.veicoli.jpa.dto.output.BiciDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.BiciMap;
import com.betacom.veicoli.jpa.models.Bici;
import com.betacom.veicoli.jpa.models.Freni;
import com.betacom.veicoli.jpa.models.TipoSospensione;
import com.betacom.veicoli.jpa.models.TipoVeicolo;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IBiciRepository;
import com.betacom.veicoli.jpa.repositories.IFreniRepository;
import com.betacom.veicoli.jpa.repositories.ITipoSospensioneRepository;
import com.betacom.veicoli.jpa.repositories.ITipoVeicoloRepository;
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
	private final ITipoVeicoloRepository tipoVR;
	
	@Override
	@Transactional
	public void create(BiciReq req) throws Exception {
		log.debug("Create {}", req);
		Freni freno = freniR.findById(req.getIdFreno())
		        .orElseThrow(() -> new AcademyException("freni-ntfnd"));
		TipoSospensione sospensione = sospensioniR.findById(req.getIdTipoSospensione())
				.orElseThrow(() -> new AcademyException("tipososp-ntfnd"));
		
		TipoVeicolo tipoVeicolo;
		if(tipoVR.existsByTipo("bici"))
		     tipoVeicolo = tipoVR.findByTipo("bici");
		else
			throw new AcademyException("tipoveicolo-ntfnd");
		
		Veicoli veicolo = veiS.create(req, tipoVeicolo);
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
		        .orElseThrow(() -> new AcademyException("freni-ntfnd"));
		TipoSospensione sospensione = sospensioniR.findById(req.getIdTipoSospensione())
		        .orElseThrow(() -> new AcademyException("tipososp-ntfnd"));
		bici.setFreno(freno);
		bici.setCorone(req.getNumeroCorone());
		bici.setMarce(req.getNumeroMarce());
		bici.setPieghevole(req.getPieghevole());
		bici.setSospensione(sospensione);
	
		veiS.update(bici.getVeicolo(), req);
		
		biciR.save(bici);
	}

	
	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("Delete bici con id {}", id);
		Bici bici = biciR.findById(id)
		        .orElseThrow(() -> new AcademyException("bici-ntfnd"));

		veiS.delete(bici.getVeicolo().getId());
	}

	@Override
	public List<BiciDTO> list() throws Exception {
		List<Bici> lB = biciR.findAll();
		return BiciMap.buildBiciDTO(lB);
	}

}
