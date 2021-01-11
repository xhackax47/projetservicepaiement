package fr.projet.servicepaiement.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Paiement.class)
public class Paiement {
	
	private int id;
	private long montant;
	private LocalDateTime timestamp;
	private enum state {
		PENDING, ACCEPTED, VALIDATED
	}
	private state etat;

	// Constructeur
	
	public Paiement(int id, long montant, LocalDateTime timestamp, state etat) {
		super();
		this.id = id;
		this.montant = montant;
		this.timestamp = timestamp;
		this.etat = etat;
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
	public long getMontant() {
		return montant;
	}
	public void setMontant(long montant) {
		this.montant = montant;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public state getEtat() {
		return etat;
	}
	public void setEtat(state etat) {
		this.etat = etat;
	}
	
	// Méthodes

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", montant=" + montant + ", timestamp=" + timestamp + ", etat=" + etat + "]";
	};
	
}
