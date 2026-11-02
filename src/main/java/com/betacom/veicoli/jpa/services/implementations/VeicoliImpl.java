package com.betacom.veicoli.jpa.services.implementations;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoli.jpa.dto.input.VeicoliReq;
import com.betacom.veicoli.jpa.dto.output.VeicoliDTO;
import com.betacom.veicoli.jpa.exceptions.AcademyException;
import com.betacom.veicoli.jpa.models.Veicoli;
import com.betacom.veicoli.jpa.repositories.IBiciRepository;
import com.betacom.veicoli.jpa.repositories.IColoreRepository;
import com.betacom.veicoli.jpa.repositories.IFreniRepository;
import com.betacom.veicoli.jpa.repositories.IMarcaRepository;
import com.betacom.veicoli.jpa.repositories.ITipoAlimentazioneRepository;
import com.betacom.veicoli.jpa.repositories.ITipoCategoriaRepository;
import com.betacom.veicoli.jpa.repositories.ITipoSospensioneRepository;
import com.betacom.veicoli.jpa.repositories.IVeicoliRepository;
import com.betacom.veicoli.jpa.services.interfaces.IVeicoliService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class VeicoliImpl implements IVeicoliService{
	
	private final IColoreRepository colR;
	private final IVeicoliRepository veiR;
	private final IMarcaRepository marR;
	private final ITipoAlimentazioneRepository alimR;
	private final ITipoCategoriaRepository catR;
	
	@Transactional
	@Override
	public Veicoli create(VeicoliReq req) throws Exception {
		Veicoli v = new Veicoli();
		v.setColore(colR.findById(req.getIdColore())
				.orElseThrow(() -> new AcademyException("colore-ntfnd")));
		v.setMarca(marR.findById(req.getIdMarca())
			.orElseThrow(() -> new AcademyException("marca-ntfnd")));
		v.setTipoAlimentazione(alimR.findById(req.getTipoAlimentazioneId())
				.orElseThrow(() -> new AcademyException("alim-ntfnd")));
		v.setTipoCategoria(catR.findById(req.getTipoCategoriaID())
				.orElseThrow(() -> new AcademyException("cat-ntfnd")));
		v.setModello(req.getModello());
		v.setAnnoProduzione(req.getAnnoProduzione());
		v.setNRuote(req.getNumeroRuote());
		v.setDataInserimento(LocalDateTime.now());
		return veiR.save(v);
	}

	@Override
	public void update(VeicoliReq req) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<VeicoliDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


   
	
}
