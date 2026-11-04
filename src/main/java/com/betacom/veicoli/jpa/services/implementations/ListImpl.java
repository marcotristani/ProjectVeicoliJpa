package com.betacom.veicoli.jpa.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.betacom.veicoli.jpa.dto.output.VeicoliDTO;
import com.betacom.veicoli.jpa.mapper.BiciMap;
import com.betacom.veicoli.jpa.mapper.MacchinaMap;
import com.betacom.veicoli.jpa.mapper.MotoMap;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IBiciRepository;
import com.betacom.veicoli.jpa.repositories.IMacchinaRepository;
import com.betacom.veicoli.jpa.repositories.IMotoRepository;
import com.betacom.veicoli.jpa.repositories.IVeicoliRepository;
import com.betacom.veicoli.jpa.services.interfaces.IListService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListImpl implements IListService{

	private final IMacchinaRepository macchinaRepository;
	private final IMotoRepository motoRepository;
	private final IBiciRepository biciRepository;
	private final IVeicoliRepository veicoliRepository;

	public List<VeicoliDTO> printList(String tipoVeicolo,
			String tipoCategoria, String modello,
			Integer annoProduzione, Integer nRuote,
			String tipoAlimentazione,String colore,
			String marca, Integer cc,
			Integer porte, String targa,
			Integer marce, Integer corone,
			Boolean pieghevole, String freno, String sospensione) {
	    List<Veicoli> veicoli = veicoliRepository.list(tipoVeicolo,
				tipoCategoria,modello,
				annoProduzione, nRuote,
				tipoAlimentazione, colore,
				marca, cc,
				porte, targa,
				marce, corone,
				pieghevole, freno, sospensione);
	    
	    List<VeicoliDTO> veicoliDTO= new ArrayList<VeicoliDTO>();
	    veicoli.forEach(veicolo -> {
	    	        String tipo = veicolo.getTipoVeicolo().getTipo().toUpperCase();
	    	        
	    	        if ("MOTO".equals(tipo)) veicoliDTO.add(MotoMap.buildMotoDTO(motoRepository.findByVeicolo(veicolo)));
	    	        if ("BICI".equals(tipo)) veicoliDTO.add(BiciMap.buildBiciDTO(biciRepository.findByVeicolo(veicolo)));
	    	        if ("MACCHINA".equals(tipo)) veicoliDTO.add(MacchinaMap.buildMacchinaDTO(macchinaRepository.findByVeicolo(veicolo)));

	    	        
	    	    });

	    
	    return veicoliDTO;
	}


}

