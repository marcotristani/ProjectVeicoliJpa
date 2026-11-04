package com.betacom.veicoli.jpa.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoli.jpa.dto.output.VeicoliDTO;
import com.betacom.veicoli.jpa.services.interfaces.IListService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/list")
public class ListController {
	
	private final IListService listService;
	
    @GetMapping("/list")
    public ResponseEntity<List<VeicoliDTO>> list(
    		@RequestParam(required = false) String tipoVeicolo,
    		@RequestParam(required = false) String tipoCategoria,
    		@RequestParam(required = false) String modello,
    		@RequestParam(required = false) Integer annoProduzione,
    		@RequestParam(required = false) Integer nRuote,
    		@RequestParam(required = false) String tipoAlimentazione,
    		@RequestParam(required = false) String colore,
    		@RequestParam(required = false) String marca,
    		@RequestParam(required = false) Integer cc,
    		@RequestParam(required = false) Integer porte,
    		@RequestParam(required = false) String targa,
    		@RequestParam(required = false) Integer marce,
    		@RequestParam(required = false) Integer corone,
    		@RequestParam(required = false) Boolean pieghevole,
    		@RequestParam(required = false) String freno,
    		@RequestParam(required = false) String sospensione
    		) throws Exception {
        return ResponseEntity.ok(listService.printList(tipoVeicolo,
				tipoCategoria,modello,
				annoProduzione, nRuote,
				tipoAlimentazione, colore,
				marca, cc,
				porte, targa,
				marce, corone,
				pieghevole, freno, sospensione));
    }

}
