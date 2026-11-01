package com.betacom.veicoli.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TipoAlimentazioneReq {
	@NotNull(groups = ValidationGroup.Create.class, message = "pattern-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "pattern-ntfnd")
	private String pattern;
	
	@NotNull(groups = ValidationGroup.Update.class, message = "tipoalim-no-id")
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipoalim-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "tipoalim-ntfnd")
	private String nome;
}
