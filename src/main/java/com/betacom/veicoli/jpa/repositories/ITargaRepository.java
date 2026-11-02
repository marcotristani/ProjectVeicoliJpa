package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.Targa;

public interface ITargaRepository extends JpaRepository<Targa, Integer>{

	// true se esiste gia' una targa uguale (vale per macchine E moto, perche' la tabella e' una sola)
	boolean existsByTarga(String targa);
}
