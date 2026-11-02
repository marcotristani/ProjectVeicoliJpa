package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.MacchinaReq;
import com.betacom.veicoli.jpa.dto.output.MacchinaDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.MacchinaMap;
import com.betacom.veicoli.jpa.models.Macchina;
import com.betacom.veicoli.jpa.models.Targa;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IMacchinaRepository;
import com.betacom.veicoli.jpa.repositories.ITargaRepository;
import com.betacom.veicoli.jpa.repositories.IVeicoliRepository;
import com.betacom.veicoli.jpa.services.interfaces.IMacchinaService;
import com.betacom.veicoli.jpa.services.interfaces.IVeicoliService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor

public class MacchinaImpl  implements IMacchinaService{
	
	private final IMacchinaRepository macR;
	private final ITargaRepository targaR;
	private final IVeicoliService veicoliS;
	private final IVeicoliRepository veR;
	
	
	
	@Transactional
	@Override
	public void create(MacchinaReq req) throws Exception {
		log.debug("Creazione macchina{}", req);
		
		String targa = req.getTarga().trim().toLowerCase();
		if(targaR.existsByTarga(targa))
			throw new AcademyException("targa-exist");
		
		Veicoli veicolo = veicoliS.create(req.getVeicolo());
		
		Targa t = new Targa();
		t.setTarga(targa);
		targaR.save(t);
		
		Macchina m = new Macchina();
		m.setCc(req.getCc());
		m.setPorte(req.getNumeroPorte());
		m.setVeicolo(veicolo);
		m.setTarga(t);
		macR.save(m);
		
		
		
	}

	@Override
	@Transactional
	public void update(MacchinaReq req) throws Exception {
		Macchina mac = macR.findById(req.getId())
				.orElseThrow(() -> new AcademyException("macchina-ntfnd"));

		Optional.ofNullable(req.getCc()).ifPresent(mac::setCc);
		Optional.ofNullable(req.getNumeroPorte()).ifPresent(mac::setPorte);

		// Targa: si modifica solo se è arrivata, è diversa da quella attuale e non la usa nessun altro
		Optional.ofNullable(req.getTarga())                         // scatola piena se nel JSON c'è "targa", vuota se è null → in quel caso salta tutto
				.map(t -> t.trim().toLowerCase())                   // pulizia: " AB111CD " → "ab111cd" (stessa regola della create)
				.filter(t -> !t.equals(mac.getTarga().getTarga()))  // tiene la targa solo se è DIVERSA da quella attuale della macchina;
								// se è uguale svuota la scatola → niente da modificare, nessun errore
				.ifPresent(t -> mac.getTarga().setTarga(            // se la scatola è ancora piena: cambio il testo DENTRO l'oggetto Targa già collegato
						Optional.of(t)                              // nuova scatola con la targa pulita (qui non è mai null, quindi of e non ofNullable)
								.filter(x -> !targaR.existsByTarga(x))  // tiene la targa solo se NON esiste già nel DB (né su macchine né su moto)
								.orElseThrow(() -> new AcademyException("targa-exist"))));  // se il filter l'ha scartata (già usata) → errore e rollback;
								// altrimenti restituisce la targa, che finisce in setTarga
	}

	@Override
	@Transactional
	public void delete(Integer id) throws Exception {
		log.debug("Eliminazione macchina{}", id);	
		
		Macchina mac = macR.findById(id)
				.orElseThrow(() -> new AcademyException("macchina-ntfnd"));
		veR.delete(mac.getVeicolo());
		
		
	}

	@Override
	public List<MacchinaDTO> list() throws Exception {
		log.debug("Lista delle macchine");
		
		List <Macchina> lM = macR.findAll(Sort.by("veicolo.marca.nome"));
		
		return MacchinaMap.buildMacchinaDTOs(lM);
	}

	
}
