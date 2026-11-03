package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.Marca;
import java.util.List;


public interface IMarcaRepository extends JpaRepository<Marca, Integer>{
	
	boolean existsByNomeIgnoreCase(String nome);
	
	Marca findByNome(String nome);
	
}