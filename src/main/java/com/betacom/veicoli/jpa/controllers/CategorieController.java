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

import com.betacom.veicoli.jpa.dto.input.TipoCategoriaReq;
import com.betacom.veicoli.jpa.dto.input.ValidationGroup;
import com.betacom.veicoli.jpa.dto.output.ResponseDTO;
import com.betacom.veicoli.jpa.services.interfaces.ITipoCategoriaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/categorie")
public class CategorieController {

	private final ITipoCategoriaService tipoCatS;

	@GetMapping("/list")
	public ResponseEntity<Object> list() throws Exception {
		return ResponseEntity.ok(tipoCatS.list());
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> create(
			@Validated(ValidationGroup.Create.class) @RequestBody TipoCategoriaReq req) throws Exception {
		tipoCatS.create(req);
		return ResponseEntity.ok(ResponseDTO.builder().msg("create successful").build());
	}

	@PatchMapping("/update")
	public ResponseEntity<ResponseDTO> update(
			@Validated(ValidationGroup.Update.class) @RequestBody TipoCategoriaReq req) throws Exception {
		tipoCatS.update(req);
		return ResponseEntity.ok(ResponseDTO.builder().msg("update successful").build());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) throws Exception {
		tipoCatS.delete(id);
		return ResponseEntity.ok(ResponseDTO.builder().msg("delete successful").build());
	}
}