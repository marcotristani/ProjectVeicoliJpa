package com.betacom.veicoli.jpa.dto.input;



import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class VeicoliReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "veicoli-no-id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipo-no-id")
	private Integer idTipoVeicolo;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "alimpattern-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "alimpattern-ntfnd")
	private String tipoCategoriaPattern;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "cat-no-id")
	private Integer tipoCategoriaID;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "marca-no-id")
	private Integer idMarca;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "modello-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "modello-ntfnd")
	private String modello;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "alimpattern-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "alimpattern-ntfnd")
	private String TipoAlimentazionePattern;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "alim-ntfnd")
	private Integer TipoAlimentazioneId;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "col-no-id")
	private Integer idColore;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "annoprod-ntfnd")
	private Integer  annoProduzione;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "datains-ntfnd")
	private LocalDateTime   data_inserimento;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "nr-ntfnd")
	private Integer  numeroRuote;
	
	
}