package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoli.jpa.dto.input.MotoReq;
import com.betacom.veicoli.jpa.dto.output.MotoDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.BiciMap;
import com.betacom.veicoli.jpa.mapper.MotoMap;
import com.betacom.veicoli.jpa.models.Bici;
import com.betacom.veicoli.jpa.models.Moto;
import com.betacom.veicoli.jpa.repositories.IMotoRepository;
import com.betacom.veicoli.jpa.services.interfaces.IMotoService;
import com.betacom.veicoli.jpa.services.interfaces.IVeicoliService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MotoImpl implements IMotoService{
	
	private final IMotoRepository motoRepository;
	private final IVeicoliService veicoliService;
		
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
		Moto moto = motoRepository.findById(req.getId())
				.orElseThrow(() -> new AcademyException("moto-ntfnd"));
		if(req.getCc()!= null) moto.setCc(req.getCc());
		motoRepository.save(moto);	
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("Delete bici con id {}", id);
		Moto moto = motoRepository.findById(id)
		        .orElseThrow(() -> new AcademyException("moto-ntfnd"));

		veicoliService.delete(moto.getVeicolo().getId());
		
	}

	@Override
	public List<MotoDTO> list() throws Exception {
		List<Moto> lM = motoRepository.findAll();
		return MotoMap.buildListMotoDTO(lM);
	}




}
