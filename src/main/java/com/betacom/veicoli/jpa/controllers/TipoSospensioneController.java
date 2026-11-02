package com.betacom.veicoli.jpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoli.jpa.dto.input.TipoSospenzioneReq;
import com.betacom.veicoli.jpa.dto.input.ValidationGroup;
import com.betacom.veicoli.jpa.dto.output.ResponseDTO;
import com.betacom.veicoli.jpa.dto.output.TipoSospensioneDTO;
import com.betacom.veicoli.jpa.services.interfaces.ITipoSospensioneService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/tiposospensioni")
public class TipoSospensioneController {

    private final ITipoSospensioneService tipoSospS;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(
            @Validated(ValidationGroup.Create.class) @RequestBody TipoSospenzioneReq req)
            throws Exception {
        tipoSospS.create(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDTO.builder().msg("Creazione riuscita").build());
    }

    @PatchMapping("/update")
    public ResponseEntity<ResponseDTO> update(
            @Validated(ValidationGroup.Update.class) @RequestBody TipoSospenzioneReq req)
            throws Exception {
        tipoSospS.update(req);
        return ResponseEntity.ok(ResponseDTO.builder().msg("Aggiornamento riuscito").build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception {
        tipoSospS.delete(id);
        return ResponseEntity.ok(ResponseDTO.builder().msg("Cancellazione riuscita").build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<TipoSospensioneDTO>> list() throws Exception {
        return ResponseEntity.ok(tipoSospS.list());
    }
}