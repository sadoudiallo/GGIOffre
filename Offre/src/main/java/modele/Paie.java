package modele;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Paie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numPaie;
	private Date datepaie;
	private double montantPaie;
	public Paie() {
		// TODO Auto-generated constructor stub
	}
	
	public Paie(Date dateP, Double montantP) {
		// TODO Auto-generated constructor stub
		this.datepaie=dateP;
		this.montantPaie=montantP;
	}
	
	@OneToOne
	private Client client;
	
	@OneToOne
	private User user;
	
	@OneToOne 
	private Offre offre;
	
	public int getNumPaie() {
		return numPaie;
	}
	public void setNumPaie(int numPaie) {
		this.numPaie = numPaie;
	}
	public Date getDatepaie() {
		return datepaie;
	}
	public void setDatepaie(Date datepaie) {
		this.datepaie = datepaie;
	}
	public double getMontantPaie() {
		return montantPaie;
	}
	public void setMontantPaie(double montantPaie) {
		this.montantPaie = montantPaie;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Offre getOffre() {
		return offre;
	}
	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	
}
