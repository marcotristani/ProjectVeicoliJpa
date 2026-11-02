package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.TipoSospenzioneReq;
import com.betacom.veicoli.jpa.dto.output.TipoSospensioneDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.TipoSospensioneMap;
import com.betacom.veicoli.jpa.models.TipoSospensione;
import com.betacom.veicoli.jpa.repositories.ITipoSospensioneRepository;
import com.betacom.veicoli.jpa.services.interfaces.ITipoSospensioneService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoSospensioneImpl implements ITipoSospensioneService {

    private final ITipoSospensioneRepository tipoSospR;

    @Transactional
    @Override
    public void create(TipoSospenzioneReq req) throws Exception {
        log.debug("create {}", req);
        if (tipoSospR.existsByNome(req.getNome())) {
            throw new AcademyException("tipososp-exist");
        }
        TipoSospensione ts = new TipoSospensione();
        ts.setNome(req.getNome());
        ts.setStatus(true);
        ts.setPattern("TIPO_SOSPENSIONE");
        tipoSospR.save(ts);
    }

    @Transactional
    @Override
    public void update(TipoSospenzioneReq req) throws Exception {
        log.debug("update {}", req);
        TipoSospensione ts = tipoSospR.findById(req.getId())
                .orElseThrow(() -> new AcademyException("tipososp-ntfnd"));

        if (req.getNome() != null) {
            if (!ts.getNome().equals(req.getNome()) && tipoSospR.existsByNome(req.getNome())) {
                throw new AcademyException("tipososp-exist");
            }
            ts.setNome(req.getNome());
        }
        tipoSospR.save(ts);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        log.debug("delete {}", id);
        TipoSospensione ts = tipoSospR.findById(id)
                .orElseThrow(() -> new AcademyException("tipososp-ntfnd"));
        tipoSospR.delete(ts);
    }

    @Override
    public List<TipoSospensioneDTO> list() throws Exception {
        log.debug("list");
        List<TipoSospensione> lT = tipoSospR.findAll();
        return TipoSospensioneMap.buildTipoSospensioneDTOs(lT);
    }
}