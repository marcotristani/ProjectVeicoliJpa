package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.TipoAlimentazione;

public interface ITipoAlimentazioneRepository extends JpaRepository<TipoAlimentazione, Integer>{
	Boolean existsByNomeAlimentazione(String nomeAlimentazione);
}
