package fr.projet.servicepaiement.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Paiement.class)
public class Paiement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private long amount;
	private LocalDateTime timestamp;


	// Constructeur
	
	public Paiement(int id, long amount, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.amount = amount;
		this.timestamp = timestamp;
	}
	
	
	public Paiement() {
		super();
	}

	// Accesseurs
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	// Méthodes

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", amount=" + amount + ", timestamp=" + timestamp + "]";
	};
	
}
