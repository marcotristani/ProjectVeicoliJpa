package com.betacom.veicoli.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ColoreReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "colore-no-id" )
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "colore-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "colore-ntfnd")
	private String nome;
}
