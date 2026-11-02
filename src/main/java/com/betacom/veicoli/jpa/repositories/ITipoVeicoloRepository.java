package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.TipoVeicolo;

public interface ITipoVeicoloRepository extends JpaRepository<TipoVeicolo, Integer>{

	Boolean existsByTipo(String tipo);
}
