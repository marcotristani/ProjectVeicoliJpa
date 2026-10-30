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
	@NotNull(groups = ValidationGroup.Update.class, message = "veicoli-no-id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipo-no-id")
	@NotBlank(groups = ValidationGroup.Create.class, message = "tipo-no-id")
	private Integer idTipoVeicolo;@NotNull(groups = ValidationGroup.Update.class, message = "veicoli-no-id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipo-no-id")
	@NotBlank(groups = ValidationGroup.Create.class, message = "tipo-no-id")
	private Integer idTipoVeicolo;
}
