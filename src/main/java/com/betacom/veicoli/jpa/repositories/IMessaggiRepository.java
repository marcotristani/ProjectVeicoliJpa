package com.betacom.veicoli.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoli.jpa.models.Messaggi;
import com.betacom.veicoli.jpa.models.MessaggiID;


public interface IMessaggiRepository extends JpaRepository<Messaggi, MessaggiID>{

}
