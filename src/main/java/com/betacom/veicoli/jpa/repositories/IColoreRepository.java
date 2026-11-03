package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.Colore;
import com.betacom.veicoli.jpa.models.TipoVeicolo;

public interface IColoreRepository extends JpaRepository<Colore, Integer>{

	boolean existsByNome (String nomeColore);
	
	Colore findByNome(String nome); 
}
