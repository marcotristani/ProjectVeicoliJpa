package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.Bici;

public interface IBiciRepository extends JpaRepository<Bici, Integer>{
	
	 //CONTROLLO SE LA BICI ESISTE
	 //boolean esisteIdVeicolo(Integer idVeicolo)
}
