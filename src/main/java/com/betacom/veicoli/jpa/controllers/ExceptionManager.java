package com.betacom.veicoli.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.betacom.veicoli.jpa.dto.output.ResponseDTO;
import com.betacom.veicoli.jpa.services.interfaces.IMessaggiService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionManager {
	private final IMessaggiService msgS;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handlerException(Exception e){
		return ResponseEntity.badRequest().body(ResponseDTO.builder()
													.msg(msgS.get(e.getMessage()))
													.build());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handlerValidationException(MethodArgumentNotValidException e){
		String msg = e.getBindingResult()
				.getFieldErrors()
				.stream()
				.findFirst()
				.map(FieldError::getDefaultMessage)
				.orElse("Errore di validazione");
		return ResponseEntity.badRequest().body(ResponseDTO.builder()
													.msg(msgS.get(msg))
													.build());
				
	}
	
}