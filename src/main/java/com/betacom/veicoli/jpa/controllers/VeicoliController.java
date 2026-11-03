package com.betacom.veicoli.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoli.jpa.services.interfaces.IVeicoliService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Veicoli")
public class VeicoliController {
	private final IVeicoliService veiS;
	
	@GetMapping("/list")
	public ResponseEntity<Object> list(
	        @RequestParam(required = false) Integer id,
	        @RequestParam(required = false) String tipoVeicolo,
	        @RequestParam(required = false) String tipoCategoria) throws Exception {

	    return ResponseEntity.ok(
	        veiS.list(id, tipoVeicolo, tipoCategoria)
	    );
	}
}
