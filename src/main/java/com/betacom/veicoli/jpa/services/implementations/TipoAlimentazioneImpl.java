package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;


import com.betacom.veicoli.jpa.dto.input.TipoAlimentazioneReq;
import com.betacom.veicoli.jpa.dto.output.TipoAlimentazioneDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.TipoAlimentazioneMap;
import com.betacom.veicoli.jpa.models.TipoAlimentazione;
import com.betacom.veicoli.jpa.repositories.ITipoAlimentazioneRepository;
import com.betacom.veicoli.jpa.services.interfaces.ITipoAlimentazioneService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoAlimentazioneImpl implements ITipoAlimentazioneService{
	
	private final ITipoAlimentazioneRepository tipoAlimR;
	
	
	@Transactional
	@Override
	public void create(TipoAlimentazioneReq req) throws Exception {
		log.debug("create {}", req);
		if (tipoAlimR.existsByNome(req.getNome()))
			throw new AcademyException("tipoAlim-fnd");
		TipoAlimentazione alim = new TipoAlimentazione();
		alim.setNome(req.getNome());
		alim.setPattern(req.getPattern());
		tipoAlimR.save(alim);
		
	}

	@Transactional
	@Override
	public void update(TipoAlimentazioneReq req) throws Exception {
		log.debug("Update {}", req);
		TipoAlimentazione alim = tipoAlimR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("tipoAlim-ntfnd"));
		if (req.getNome() != null && !req.getNome().equalsIgnoreCase(alim.getNome())) {
			if (tipoAlimR.existsByNome(req.getNome()))
				throw new AcademyException("cfisc-fnd");
			alim.setNome(req.getNome());
		}
		if (req.getPattern() != null) alim.setPattern(req.getPattern());
		tipoAlimR.save(alim);
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("Delete {}", id);	
		TipoAlimentazione alim = tipoAlimR.findById(id)
				.orElseThrow(() -> new AcademyException("tipoAlim-ntfnd"));
		tipoAlimR.delete(alim);
	}

	@Override
	public List<TipoAlimentazioneDTO> list() throws Exception {
		List<TipoAlimentazione> lTA = tipoAlimR.findAll();
		return TipoAlimentazioneMap.buildTipoAlimentazioneDTO(lTA);
	}

}
