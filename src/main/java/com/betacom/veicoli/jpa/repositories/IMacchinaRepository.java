package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.Macchina;

public interface IMacchinaRepository extends JpaRepository<Macchina, Integer>{
	
	//PER CONTROLLI SE LA TARGA O IL VEICOLO SONO GIà PRESENTI
	//boolean esisteTarga(String targa);
    //boolean esisteIdVeicolo(Integer idVeicolo);

}
