package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.TipoVeicoloReq;
import com.betacom.veicoli.jpa.dto.output.TipoVeicoloDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.TipoVeicoloMapper;
import com.betacom.veicoli.jpa.models.TipoVeicolo;
import com.betacom.veicoli.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.veicoli.jpa.services.interfaces.ITipoVeicoloService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoVeicoloImpl implements ITipoVeicoloService{

	private final ITipoVeicoloRepository tipoVeicoloRepository;
	
	@Transactional
	@Override
	public void create(TipoVeicoloReq req) throws Exception {
		log.debug("create {}", req);
		if (tipoVeicoloRepository.existsByTipo(req.getNome()))
			throw new AcademyException("tipoveicolo-fnd");

		TipoVeicolo tipoVeicolo = new TipoVeicolo();
		tipoVeicolo.setTipo(req.getNome());;
		tipoVeicoloRepository.save(tipoVeicolo);	
	}

	@Transactional
	@Override
	public void update(TipoVeicoloReq req) throws Exception {
		log.debug("update {}", req);	
		TipoVeicolo tipoVeicolo = tipoVeicoloRepository.findById(req.getId()).orElseThrow(()-> new AcademyException("tipoveicolo-ntfnd"));
		if (tipoVeicoloRepository.existsByTipo(req.getNome()))
			throw new AcademyException("tipoveicolo-fnd");
		if(req.getNome() != null) tipoVeicolo.setTipo(req.getNome());
		
		tipoVeicoloRepository.save(tipoVeicolo);	
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete tipo veicolo {} ", id);
		TipoVeicolo tipoVeicolo = tipoVeicoloRepository.findById(id).orElseThrow(()-> new AcademyException("tipoveicolo-ntfnd"));
		if (tipoVeicolo.getVeicoli() != null && !tipoVeicolo.getVeicoli().isEmpty()) {
            throw new AcademyException("TipoVeicolo-con-veicoli");
        }
		
		tipoVeicoloRepository.delete(tipoVeicolo);
		
	}

	@Override
	public List<TipoVeicoloDTO> list() throws Exception {
		List<TipoVeicolo> lTV = tipoVeicoloRepository.findAll();
		return TipoVeicoloMapper.buildListTipoVeicoloDTO(lTV);
	}

}
