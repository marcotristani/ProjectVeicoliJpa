package com.betacom.veicoli.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.veicoli.jpa.models.Veicoli;

public interface IVeicoliRepository extends JpaRepository<Veicoli, Integer>{

	@Query(name = "veicoli.list.filters")
	List<Veicoli> list(
			@Param("tipoVeicolo") String tipoVeicolo,
			@Param("tipoCategoria") String tipoCategoria
			);
	

}
