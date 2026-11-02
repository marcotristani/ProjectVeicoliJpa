package com.betacom.veicoli.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BiciReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "bici-no-id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipososp-no-id")
	private Integer idTipoSospensione;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "nm-ntfnd")
	private Integer numeroMarce;
	
	private Boolean pieghevole;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "veicoli-no-id")
	private Integer idVeicolo;
	
	
}
