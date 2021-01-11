package fr.projet.servicepaiement.controller;

import java.time.LocalDateTime;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.servicepaiement.model.Paiement;

@RestController
@RequestMapping(value = "/servicepaiement-rabbitmq/")
public class RabbitMQWebController {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	// Routing vers /servicepaiement-rabbitmq/paiement
	@GetMapping(value = "/paiement")
	public String producer(@RequestParam("id") int id, @RequestParam("montant") long montant, @RequestParam("timestamp") LocalDateTime timestamp) {
		Paiement pay= new Paiement();
		pay.setId(id);
		pay.setMontant(montant);
		pay.setTimestamp(LocalDateTime.now());
		amqpTemplate.convertAndSend(pay);
		return "Le message a été envoyé avec succès à RabbitMQ";
	}
}