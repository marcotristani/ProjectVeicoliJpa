package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoli.jpa.dto.input.MotoReq;
import com.betacom.veicoli.jpa.dto.input.TargaReq;
import com.betacom.veicoli.jpa.dto.output.MotoDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.MotoMap;
import com.betacom.veicoli.jpa.models.Moto;
import com.betacom.veicoli.jpa.models.Targa;
import com.betacom.veicoli.jpa.models.TipoVeicolo;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IMotoRepository;
import com.betacom.veicoli.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.veicoli.jpa.services.interfaces.IMotoService;
import com.betacom.veicoli.jpa.services.interfaces.ITargaService;
import com.betacom.veicoli.jpa.services.interfaces.IVeicoliService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MotoImpl implements IMotoService{
	
	private final IMotoRepository motoRepository;
	private final ITipoVeicoloRepository tipoVeicoloRepository;
	private final ITargaService targaService;
	private final IVeicoliService veicoliService;
		
	@Transactional
	@Override
	public void create(MotoReq req) throws Exception {
		log.debug("Create {}", req);
		//req.setIdTipoVeicolo(tipoVeicoloRepository.findByTipo("moto").getId());
		TipoVeicolo tipoVeicolo;
		if(tipoVeicoloRepository.existsByTipo("moto"))
		     tipoVeicolo = tipoVeicoloRepository.findByTipo("moto");
		else
			throw new AcademyException("tipoVeicolo-noFnd");
			
		Veicoli veicolo = veicoliService.create(req, tipoVeicolo);
		
		Targa targa = targaService.create(TargaReq.builder().targa(req.getTarga()).build());
		
		Moto moto = new Moto();
		moto.setCc(req.getCc());
		moto.setVeicolo(veicolo);
		moto.setTarga(targa);
		motoRepository.save(moto);	
	}

	
	@Override
	public void update(MotoReq req) throws Exception {
		log.debug("Update {}", req);
		Moto moto = motoRepository.findById(req.getId())
				.orElseThrow(() -> new AcademyException("moto-ntfnd"));
		if(req.getCc()!= null) moto.setCc(req.getCc());
		
		if(req.getTarga() != null) {
			
			targaService.update(TargaReq.builder()
				.id(moto.getTarga().getId())
				.targa(req.getTarga())
				.build());
		}
		
		veicoliService.update(moto.getVeicolo(), req);
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
