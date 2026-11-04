package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.FreniReq;
import com.betacom.veicoli.jpa.dto.output.FreniDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.FreniMap;
import com.betacom.veicoli.jpa.models.Freni;
import com.betacom.veicoli.jpa.repositories.IFreniRepository;
import com.betacom.veicoli.jpa.services.interfaces.IFreniService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class FreniImpl implements IFreniService {

    private final IFreniRepository freniR;

    @Transactional
    @Override
    public void create(FreniReq req) throws Exception {
        log.debug("create {}", req);
        if (freniR.existsByTipo(req.getTipo())) {
            throw new AcademyException("freno-fnd");
        }
        Freni f = new Freni();
        f.setTipo(req.getTipo());
        freniR.save(f);
    }

    @Transactional
    @Override
    public void update(FreniReq req) throws Exception {
        log.debug("update {}", req);
        Freni f = freniR.findById(req.getId())
                .orElseThrow(() -> new AcademyException("freno-ntfnd"));

        if (req.getTipo() != null) {
            if (freniR.existsByTipo(req.getTipo())) {
                throw new AcademyException("freno-fnd");
            }
            f.setTipo(req.getTipo());
        }
        freniR.save(f);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        log.debug("delete {}", id);
        Freni f = freniR.findById(id)
                .orElseThrow(() -> new AcademyException("freno-ntfnd"));
        freniR.delete(f);
    }

    @Override
    public List<FreniDTO> list() throws Exception {
        log.debug("list");
        List<Freni> lF = freniR.findAll();
        return FreniMap.buildFreniDTOs(lF);
    }
}