package com.betacom.veicoli.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoli.jpa.dto.input.MotoReq;
import com.betacom.veicoli.jpa.dto.input.TargaReq;
import com.betacom.veicoli.jpa.dto.output.MotoDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.mapper.MotoMap;
import com.betacom.veicoli.jpa.models.Moto;
import com.betacom.veicoli.jpa.models.Targa;
import com.betacom.veicoli.jpa.models.TipoVeicolo;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IMotoRepository;
import com.betacom.veicoli.jpa.repositories.ITargaRepository;
import com.betacom.veicoli.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.veicoli.jpa.services.interfaces.IMotoService;
import com.betacom.veicoli.jpa.services.interfaces.ITargaService;
import com.betacom.veicoli.jpa.services.interfaces.IVeicoliService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MotoImpl implements IMotoService{
	
	private final IMotoRepository motoRepository;
	private final ITipoVeicoloRepository tipoVeicoloRepository;
	private final ITargaService targaService;
	private final ITargaRepository targaRepository;
	private final IVeicoliService veicoliService;
		
	@Transactional
	@Override
	public void create(MotoReq req) throws Exception {
		log.debug("Create {}", req);

		// 1. targa: pulita e libera? (controllo prima di qualsiasi INSERT)
		String targaPulita = req.getTarga().trim().toLowerCase();
		if (targaRepository.existsByTarga(targaPulita))
			throw new AcademyException("targa-fnd");

		// 2. tipo veicolo "moto"
		TipoVeicolo tipoVeicolo = tipoVeicoloRepository.findByTipo("moto");
		if (tipoVeicolo == null)
			throw new AcademyException("tipoveicolo-ntfnd");

		// 3. padre: lo crea VeicoliImpl con i campi ereditati da VeicoliReq
		Veicoli veicolo = veicoliService.create(req, tipoVeicolo);

		// 4. targa: salvata prima della moto (targa_id sta in moto)
		Targa targa = targaService.create(TargaReq.builder().targa(targaPulita).build());

		// 5. moto, collegata a padre e targa (lati owner)
		Moto moto = new Moto();
		moto.setCc(req.getCc());
		moto.setVeicolo(veicolo);
		moto.setTarga(targa);
		motoRepository.save(moto);	
	}

	@Transactional
	@Override
	public void update(MotoReq req) throws Exception {
		log.debug("Update {}", req);
		Moto moto = motoRepository.findById(req.getIdMoto())
				.orElseThrow(() -> new AcademyException("moto-ntfnd"));
		if(req.getCc()!= null) moto.setCc(req.getCc());
		
		// targa: la aggiorna TargaImpl (id della targa collegata + testo nuovo)
		if (req.getTarga() != null)
			targaService.update(TargaReq.builder().id(moto.getTarga().getId()).targa(req.getTarga()).build());

		// padre: idVeicolo lo recupero dalla moto
		req.setIdVeicolo(moto.getVeicolo().getId());
		Veicoli veicoloModificato = veicoliService.update(req);

		moto.setVeicolo(veicoloModificato);
		motoRepository.save(moto);	
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		log.debug("Delete moto con id {}", id);
		Moto moto = motoRepository.findById(id)
		        .orElseThrow(() -> new AcademyException("moto-ntfnd"));

		veicoliService.delete(moto.getVeicolo().getId());
		
	}

	
	@Override
	public List<MotoDTO> list() throws Exception {
		List<Moto> lM = motoRepository.findAll();
		return MotoMap.buildListMotoDTO(lM);
	}




}
