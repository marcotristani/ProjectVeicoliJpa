package com.betacom.veicoli.jpa.dto.input;

import jakarta.validation.Valid;
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
	
	
	
	@NotNull(groups = ValidationGroup.Create.class, message = "nc-ntfnd")
	private Integer numeroCorone;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "nm-ntfnd")
	private Integer numeroMarce;
	
	private Boolean pieghevole;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipososp-no-id")
	private Integer idTipoSospensione;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "freno-no-id")
	private Integer idFreno;
	
	@Valid
	@NotNull(groups = ValidationGroup.Create.class, message = "veicoli-no-id")
	private VeicoliReq veicolo;
}
