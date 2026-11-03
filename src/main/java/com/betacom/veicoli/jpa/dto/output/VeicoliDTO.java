package com.betacom.veicoli.jpa.dto.output;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VeicoliDTO {
	private Integer  id;
	private Integer  idTipoVeicolo;
	private Integer  tipoCategoriaId;
	private Integer  idMarca;
	private String   modello;
	private Integer  TipoAlimentazioneId;
	private Integer  idColore;
	private Integer  annoProduzione;
	private LocalDateTime   data_inserimento;
	private Integer  numeroRuote;
	
	private Integer idFreno;
    private Integer idTipoSospensione;
    private Integer numeroCorone;
    private Integer numeroMarce;
    private Boolean pieghevole;
    
    private Integer ccMoto;
    private String targaMoto;
    
    private Integer nPorte;
    private Integer ccMacchina;
    private String targaMacchina;
    
	
}
