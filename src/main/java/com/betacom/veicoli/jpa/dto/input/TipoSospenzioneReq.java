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
public class TipoSospenzioneReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "tipososp-no-id")
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipososp-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "tipososp-ntfnd")
	private String nome;
}
