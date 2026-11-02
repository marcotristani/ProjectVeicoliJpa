package com.betacom.veicoli.jpa.controllers;

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

import com.betacom.veicoli.jpa.dto.input.TipoVeicoloReq;
import com.betacom.veicoli.jpa.dto.input.ValidationGroup;
import com.betacom.veicoli.jpa.dto.output.ResponseDTO;
import com.betacom.veicoli.jpa.services.interfaces.ITipoVeicoloService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/tipoVeicolo")
public class TipoVeicoloController {

	private final ITipoVeicoloService tipoVeicoloService;
	
	@GetMapping("/list")
	public ResponseEntity<Object> list() throws Exception{
		return ResponseEntity.ok(tipoVeicoloService.list());
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(
			@Validated(ValidationGroup.Create.class)
			@RequestBody TipoVeicoloReq req) throws Exception{
		tipoVeicoloService.create(req);
		
		return ResponseEntity.ok(ResponseDTO.builder().msg("Create successfull").build());
			
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(
			@Validated(ValidationGroup.Update.class)
			@RequestBody TipoVeicoloReq req) throws Exception{
			tipoVeicoloService.update(req);
		return ResponseEntity.ok(ResponseDTO.builder().msg("Update successfull").build());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception{
		tipoVeicoloService.delete(id);
		return ResponseEntity.ok(ResponseDTO.builder().msg("Delete successfull").build());
	}
}
