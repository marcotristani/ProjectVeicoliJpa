package com.betacom.veicoli.jpa.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<VeicoliDTO>> list() throws Exception {
        return ResponseEntity.ok(listService.printList());
    }

}
