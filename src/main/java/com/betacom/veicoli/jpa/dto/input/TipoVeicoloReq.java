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
public class TipoVeicoloReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "tipov-no-id")
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "status-ntfnd")
	private Boolean status;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipoveicolo-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "tipoveicolo-ntfnd")
	private String nome;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "pattern-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "pattern-ntfnd")
	private String pattern;
}
