package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.Moto;
import com.betacom.veicoli.jpa.models.Veicoli;



public interface IMotoRepository extends JpaRepository<Moto, Integer>{

	//PER CONTROLLI SE LA TARGA O IL VEICOLO SONO GIà PRESENTI
	//boolean esisteTarga(String targa);
	//boolean esisteIdVeicolo(Integer idVeicolo);
	Moto findByVeicolo(Veicoli veicolo);
}
