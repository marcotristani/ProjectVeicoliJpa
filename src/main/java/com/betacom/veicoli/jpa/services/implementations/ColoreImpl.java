package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.ColoreReq;
import com.betacom.veicoli.jpa.dto.output.ColoreDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.ColoreMap;
import com.betacom.veicoli.jpa.models.Colore;
import com.betacom.veicoli.jpa.repositories.IColoreRepository;
import com.betacom.veicoli.jpa.services.interfaces.IColoreService;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@ToString
@Service
public class ColoreImpl implements IColoreService{

	private final IColoreRepository colR;
	@Transactional
	@Override
	public void create(ColoreReq req) throws Exception {
		log.debug("Creazione colore{}", req);
		
		String nomeColore = req.getNome().trim().toLowerCase();
		
		if(colR.existsByNome(nomeColore)) throw new AcademyException("colore-fnd");
		
		Colore col= new Colore();
		col.setNome(nomeColore);
		colR.save(col);
	}
	@Transactional
	@Override
	public void update(ColoreReq req) throws Exception {
		log.debug("Aggiornamento colore{}", req);
		
		Colore col= colR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("colore-ntfnd"));
		
		if(req.getNome() != null) {
			
			String nomeColore= req.getNome().trim().toLowerCase();
			
			if(!nomeColore.equals(col.getNome())) {
				
				if(colR.existsByNome(nomeColore))
				
				throw new AcademyException("colore-fnd");
				col.setNome(nomeColore);
			}
		}
		
		
		
		
		
	}
	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("Eliminazione colore{}", id);
		 
		Colore col= colR.findById(id)
				.orElseThrow(() -> new AcademyException("colore-ntfnd"));
		
		if (!col.getVeicoli().isEmpty()) throw new AcademyException("colore-con-veicoli");
		
		colR.delete(col);
		
		
		
	}

	@Override
	public List<ColoreDTO> list() throws Exception {
		log.debug("Lista dei colori");
		
		List <Colore> lC = colR.findAll(Sort.by("nome"));
				return ColoreMap.buildColoreDTOs(lC);
	}

}
