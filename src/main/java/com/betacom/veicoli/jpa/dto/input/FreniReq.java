package com.betacom.veicoli.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FreniReq {
	
	@NotNull(groups = ValidationGroup.Update.class, message = "freno-no-id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "freni-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "freni-ntfnd")
    private String tipo;
}
