package com.betacom.veicoli.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MacchinaReq extends VeicoliReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "macchina-no-id")
	private Integer idMacchina;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "targa-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "targa-ntfnd")
	private String targa;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "np-ntfnd")
	private Integer numeroPorte;
	
	
	@NotNull(groups = ValidationGroup.Create.class, message = "cc-ntfnd")
	private Integer cc;
	
	
}
