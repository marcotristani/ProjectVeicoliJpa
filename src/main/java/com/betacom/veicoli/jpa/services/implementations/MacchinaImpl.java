package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoli.jpa.dto.input.MacchinaReq;
import com.betacom.veicoli.jpa.dto.input.TargaReq;
import com.betacom.veicoli.jpa.dto.output.MacchinaDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.MacchinaMap;
import com.betacom.veicoli.jpa.models.Macchina;
import com.betacom.veicoli.jpa.models.Targa;
import com.betacom.veicoli.jpa.models.TipoVeicolo;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IMacchinaRepository;
import com.betacom.veicoli.jpa.repositories.ITargaRepository;
import com.betacom.veicoli.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.veicoli.jpa.repositories.IVeicoliRepository;
import com.betacom.veicoli.jpa.services.interfaces.IMacchinaService;
import com.betacom.veicoli.jpa.services.interfaces.ITargaService;
import com.betacom.veicoli.jpa.services.interfaces.IVeicoliService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor

public class MacchinaImpl implements IMacchinaService {

	private final IMacchinaRepository macR;
	private final ITargaRepository targaR;
	private final IVeicoliService veicoliS;
	private final IVeicoliRepository veR;
	private final ITipoVeicoloRepository tipoveicoloR;
	private final ITargaService targaService;

	@Transactional
	@Override
	public void create(MacchinaReq req) throws Exception {
		log.debug("Creazione macchina {}", req);

		// 1. targa: pulita e libera? (controllo prima di qualsiasi INSERT)
		String targa = req.getTarga().trim().toLowerCase();
		if (targaR.existsByTarga(targa))
			throw new AcademyException("targa-exist");

		// 2. tipo veicolo "macchina"
		TipoVeicolo tipo = tipoveicoloR.findByTipo("macchina");
		if (tipo == null)
			throw new AcademyException("tipoVeicolo-ntfnd");

		// 3. padre: lo crea VeicoliImpl con i campi ereditati da VeicoliReq (req È
		// anche una VeicoliReq)
		Veicoli veicolo = veicoliS.create(req, tipo);

		// 4. targa: salvata prima della macchina (targa_id sta in macchine)
		Targa t = targaService.create(TargaReq.builder().targa(targa).build());

		// 5. macchina, collegata a padre e targa (lati owner)
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
		Macchina mac = macR.findById(req.getIdMacchina()).orElseThrow(() -> new AcademyException("macchina-ntfnd"));

		
		// 2. dati della macchina (solo se arrivati)
		Optional.ofNullable(req.getCc()).ifPresent(mac::setCc);
		Optional.ofNullable(req.getNumeroPorte()).ifPresent(mac::setPorte);

		
		// 3. targa: la aggiorna TargaImpl (id della targa collegata + testo nuovo)
		if (req.getTarga() != null)
			targaService.update(TargaReq.builder().id(mac.getTarga().getId()).targa(req.getTarga()).build());

		veicoliS.update(mac.getVeicolo(), req);
	}

	@Override
	@Transactional
	public void delete(Integer id) throws Exception {
		log.debug("Eliminazione macchina{}", id);

		Macchina mac = macR.findById(id).orElseThrow(() -> new AcademyException("macchina-ntfnd"));
		veR.delete(mac.getVeicolo());
		
		
	}

	@Override
	public List<MacchinaDTO> list() throws Exception {
		log.debug("Lista delle macchine");

		List<Macchina> lM = macR.findAll(Sort.by("veicolo.marca.nome"));

		return MacchinaMap.buildMacchinaDTOs(lM);
	}

}
