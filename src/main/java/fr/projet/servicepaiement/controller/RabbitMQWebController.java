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
	
	// Routage sur "/servicepaiement-rabbitmq/paiement?id=id&montant=montant"
	@GetMapping(value = "/paiement")
	public String paiement(@RequestParam("id") int id, @RequestParam("montant") long montant) {
		Paiement pay= new Paiement();
		pay.setId(id);
		pay.setMontant(montant);
		pay.setTimestamp(LocalDateTime.now());
		amqpTemplate.convertAndSend("javainuseExchange", "javainuse", pay);
		return "Le message a été envoyé avec succès à RabbitMQ";
	}
}