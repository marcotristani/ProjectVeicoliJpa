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
public class MacchinaReq extends VeicoliReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "macchina-no-id")
	private Integer idMacchina;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "targa-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "targa-ntfnd")
	private String targa;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "np-ntfnd")
	@Min(value = 2, groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "porte-invalid")
	@Max(value = 6, groups = {ValidationGroup.Create.class, ValidationGroup.Update.class}, message = "porte-invalid")
	private Integer numeroPorte;
	
	
	@NotNull(groups = ValidationGroup.Create.class, message = "cc-ntfnd")
	private Integer cc;
	
	
}
