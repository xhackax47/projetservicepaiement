package fr.projet.servicepaiement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Paiement.class)
public class Paiement {
	
	private int id;
	private long amount;


	// Constructeur
	
	public Paiement(int id, long amount) {
		super();
		this.id = id;
		this.amount = amount;
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

	
	// Méthodes

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", amount=" + amount + "]";
	};
	
}
