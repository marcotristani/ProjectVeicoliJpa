package com.betacom.veicoli.jpa.dto.input;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class VeicoliReq {
	
	private Integer idVeicolo;
	
	private Integer idTipoVeicolo;

	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipocat-no-id")
	private Integer tipoCategoriaID;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "marca-no-id")
	private Integer idMarca;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "modello-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "modello-ntfnd")
	private String modello;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipoalim-ntfnd")
	private Integer tipoAlimentazioneId;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "colore-no-id")
	private Integer idColore;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "annoprod-ntfnd")
	private Integer  annoProduzione;

	@NotNull(groups = ValidationGroup.Create.class, message = "nr-ntfnd")
	@Min(value = 2, groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "ruote_invalid")
	@Max(value = 6, groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "ruote_invalid")
	private Integer  numeroRuote;
	
	
}