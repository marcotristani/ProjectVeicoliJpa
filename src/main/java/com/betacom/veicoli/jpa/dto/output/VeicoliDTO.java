package com.betacom.veicoli.jpa.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeicoliDTO {
	private Integer id;
    private String tipo;
    private Integer numeroRuote;
    private String categ;
    private String alim;
    private String colore;
    private String marca;
    private String modello;
    private Integer annoProduzione;
}
