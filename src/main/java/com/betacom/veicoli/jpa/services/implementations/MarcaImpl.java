package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;
import java.util.Locale;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.MarcaReq;
import com.betacom.veicoli.jpa.dto.output.MarcaDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.MarcaMap;
import com.betacom.veicoli.jpa.models.Marca;
import com.betacom.veicoli.jpa.repositories.IMarcaRepository;
import com.betacom.veicoli.jpa.services.interfaces.IMarcaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MarcaImpl implements IMarcaService {

    private final IMarcaRepository marcaR;

    @Transactional
    @Override
    public void create(MarcaReq req) throws Exception {
        log.debug("create {}", req);
        String nome = normalizzaNome(req.getNome());

        if (marcaR.existsByNomeIgnoreCase(nome)) {
            throw new AcademyException("marca-exist");
        }

        Marca marca = new Marca();
        marca.setNome(nome);
        marcaR.save(marca);
    }

    @Transactional
    @Override
    public void update(MarcaReq req) throws Exception {
        log.debug("update {}", req);
        Marca marca = marcaR.findById(req.getId())
                .orElseThrow(() -> new AcademyException("marca-ntfnd"));

        if (req.getNome() != null) {
            String nome = normalizzaNome(req.getNome());
            if (!nome.equalsIgnoreCase(marca.getNome())
                    && marcaR.existsByNomeIgnoreCase(nome)) {
                throw new AcademyException("marca-exist");
            }
            marca.setNome(nome);
        }

        marcaR.save(marca);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        log.debug("delete {}", id);
        Marca marca = marcaR.findById(id)
                .orElseThrow(() -> new AcademyException("marca-ntfnd"));
        
        if (marca.getVeicoli() != null && !marca.getVeicoli().isEmpty()) {
            throw new AcademyException("marca-con-veicoli");
        }

        marcaR.delete(marca);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MarcaDTO> list() throws Exception {
        List<Marca> marche = marcaR.findAll(Sort.by("nome"));
        return MarcaMap.buildMarcaDTOList(marche);
    }

    private String normalizzaNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new AcademyException("marca-no-nome");
        }
        return nome.trim().toUpperCase(Locale.ROOT);
    }
}
