package com.betacom.veicoli.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MotoReq extends VeicoliReq{
	@NotNull(groups = ValidationGroup.Update.class, message = "moto-no-id")
	private Integer idMoto;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "targa-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "targa-ntfnd")
	@Pattern(
		    regexp = "^[A-Z]{2}[0-9]{5}$",
		    groups = {ValidationGroup.Create.class, ValidationGroup.Update.class},
		    message = "targa-invalid"
		)
	private String targa;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "cc-ntfnd")
	private Integer cc;
	
}
