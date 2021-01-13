package fr.projet.servicepaiement.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

// NON-UTILISE CAR UTILISATION DIRECTE DU TEMPLATE AMQP DANS LE CONTROLLER POUR LA RECEPTION RESTFUL

@Service
public class RabbitMQSender {
@Autowired
 private AmqpTemplate rabbitTemplate;
 
 @Value("${servicepaiement.rabbitmq.exchange}")
 private String exchange;
 
 @Value("${servicepaiement.rabbitmq.routingkey}")
 private String routingkey;
 
 @Scheduled
 public void send(String message) {
  String CustomMessage = "This is a message from sender : "+ message;
  
  rabbitTemplate.convertAndSend(exchange, routingkey, CustomMessage);
  System.out.println("Send msg to consumer= " + CustomMessage+" ");
 }
}
