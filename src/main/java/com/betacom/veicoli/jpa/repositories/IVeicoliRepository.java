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
			@Param("tipoCategoria") String tipoCategoria,
			@Param("modello") String modello,
			@Param("annoProduzione") Integer annoProduzione,
			@Param("nRuote") Integer nRuote,
			@Param("tipoAlimentazione") String tipoAlimentazione,
			@Param("colore") String colore,
			@Param("marca") String marca,
			@Param("cc") Integer cc,
			@Param("porte") Integer porte,
			@Param("targa") String targa,
			@Param("marce") Integer marce,
			@Param("corone") Integer corone,
			@Param("pieghevole") Boolean pieghevole,
			@Param("freno") String freno,
			@Param("sospensione") String sospensione
			);
	

}
