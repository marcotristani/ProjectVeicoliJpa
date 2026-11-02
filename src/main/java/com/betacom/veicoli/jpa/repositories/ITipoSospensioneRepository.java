package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.TipoSospensione;

public interface ITipoSospensioneRepository extends JpaRepository<TipoSospensione, Integer> {
    boolean existsByNome(String nome);
}