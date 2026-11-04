package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.TipoCategoriaReq;
import com.betacom.veicoli.jpa.dto.output.TipoCategoriaDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.CategorieMap;
import com.betacom.veicoli.jpa.models.TipoCategoria;
import com.betacom.veicoli.jpa.repositories.ITipoCategoriaRepository;
import com.betacom.veicoli.jpa.services.interfaces.ITipoCategoriaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoCategoriaImpl implements ITipoCategoriaService {

	private final ITipoCategoriaRepository tipoCatR;

	@Transactional
	@Override
	public void create(TipoCategoriaReq req) throws Exception {
		log.debug("create {}", req);
		if (tipoCatR.existsByNome(req.getNome())) {
			throw new AcademyException("tipocat-fnd");
		}
		TipoCategoria cat = new TipoCategoria();
		cat.setNome(req.getNome());
		tipoCatR.save(cat);
	}

	@Transactional
	@Override
	public void update(TipoCategoriaReq req) throws Exception {
		log.debug("update {}", req);
		TipoCategoria cat = tipoCatR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("tipocat-ntfnd"));

		if (req.getNome() != null) {
			if (tipoCatR.existsByNome(req.getNome())) {
				throw new AcademyException("tipocat-fnd");
			}
			cat.setNome(req.getNome());
		}
		tipoCatR.save(cat);
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete {}", id);
		TipoCategoria cat = tipoCatR.findById(id)
				.orElseThrow(() -> new AcademyException("tipocat-ntfnd"));

		tipoCatR.delete(cat);
	}

	@Override
	public List<TipoCategoriaDTO> list() throws Exception {
		log.debug("list");
		List<TipoCategoria> lCat = tipoCatR.findAll();
		return CategorieMap.buildTipoCategoriaDTO(lCat);
	}
}