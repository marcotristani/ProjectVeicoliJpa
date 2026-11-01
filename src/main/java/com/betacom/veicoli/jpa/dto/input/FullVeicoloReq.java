package com.betacom.veicoli.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FullVeicoloReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "fullv-no-id")
	private Integer id;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipo-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "tipo-ntfnd")
	private String tipo;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "nr-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "nr-ntfnd")
	private Integer numeroRuote;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "cat-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "cat-ntfnd")
	private String categ;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "alim-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "alim-ntfnd")
	private String alim;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "colore-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "colore-ntfnd")
	private String colore;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "marca-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "marca-ntfnd")
	private String marca;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "modello-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "modello-ntfnd")
	private String modello;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "annoprod-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "annoprod-ntfnd")
	private Integer annoProduzione;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "np-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "np-ntfnd")
	private Integer numeroPorte;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "nm-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "nm-ntfnd")
	private Integer numeroMarce;
	
	private Boolean pieghevole;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "tipososp-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "tipososp-ntfnd")
	private String tipoSospenzione;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "targa-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "targa-ntfnd")
	private String targa;
	
	@NotNull(groups = ValidationGroup.Create.class, message = "cc-ntfnd")
	@NotBlank(groups = ValidationGroup.Create.class, message = "cc-ntfnd")
	private Integer cc;
}
