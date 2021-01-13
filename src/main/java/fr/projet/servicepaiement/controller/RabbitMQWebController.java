package fr.projet.servicepaiement.controller;

import java.time.LocalDateTime;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.servicepaiement.model.Paiement;

// Point d'entrée pour le front : http://localhost:8080//servicepaiement-rabbitmq/paiement/

@RestController
@RequestMapping(value = "/servicepaiement-rabbitmq/")
public class RabbitMQWebController {
	
	// Interface AMQP pour les opérations RabbitMQ.
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	// Récupération d'un paiement via le front puis envoi d'une réponse le tout au format JSON.
	@PostMapping(value = "/paiement",
				 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
				 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Paiement> paiement(@RequestBody Paiement pay) {
		
		pay.setTimestamp(LocalDateTime.now());
		
		// Conversion et envoi au broker de messages via Interface AMQP (RabbitMQ)
		amqpTemplate.convertAndSend("servicepaiement.exchange","servicepaiement.routingkey",pay);
		
		// Retour de la réponse pour passé le paiement de "Pending" en "ACCEPTED" via le code 200 et récupération en front du timestamp grâce à la réponse HTTP.
		return ResponseEntity.accepted().body(pay);
	}

}