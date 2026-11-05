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
import com.betacom.veicoli.jpa.repositories.ITargaRepository;
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
	private final ITargaRepository targaRepository;
	private final IVeicoliService veicoliService;
		
	@Transactional
	@Override
	public void create(MotoReq req) throws Exception {
		log.debug("Create {}", req);

		String targaPulita = req.getTarga().trim().toUpperCase();
		if (targaRepository.existsByTarga(targaPulita))
			throw new AcademyException("targa-fnd");

		TipoVeicolo tipoVeicolo = tipoVeicoloRepository.findByTipo("moto");
		if (tipoVeicolo == null)
			throw new AcademyException("tipoveicolo-ntfnd");

		Veicoli veicolo = veicoliService.create(req, tipoVeicolo);

		Targa targa = targaService.create(TargaReq.builder().targa(targaPulita).build());

		Moto moto = new Moto();
		moto.setCc(req.getCc());
		moto.setVeicolo(veicolo);
		moto.setTarga(targa);
		motoRepository.save(moto);	
	}

	@Transactional
	@Override
	public void update(MotoReq req) throws Exception {
		log.debug("Update {}", req);
		Moto moto = motoRepository.findById(req.getIdMoto())
				.orElseThrow(() -> new AcademyException("moto-ntfnd"));
		if(req.getCc()!= null) moto.setCc(req.getCc());
		
		if (req.getTarga() != null)
			targaService.update(TargaReq.builder().id(moto.getTarga().getId()).targa(req.getTarga().trim().toUpperCase()).build());

		//req.setIdVeicolo(moto.getVeicolo().getId());
		Integer idVeicolo= moto.getVeicolo().getId();
		Veicoli veicoloModificato = veicoliService.update(req, idVeicolo);

		moto.setVeicolo(veicoloModificato);
		motoRepository.save(moto);	
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("Delete moto con id {}", id);
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
