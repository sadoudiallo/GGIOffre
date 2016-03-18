package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
   
    @NamedQuery(name="NbConnecte.getAllNbConnecte", query="SELECT u FROM NbConnecte u"),
    @NamedQuery(name="NbConnecte.deleteAll", query="delete  FROM NbConnecte "),
   @NamedQuery(name="NbConnecte.deleteNbConnecte", query="DELETE FROM NbConnecte u where u.mail=:_mail"),
    
    
})
@Entity
public class NbConnecte {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nombreConnecte;
	private String mail;
	public NbConnecte() {
		// TODO Auto-generated constructor stub
	}
	public int getNombreConnecte() {
		return nombreConnecte;
	}
	public void setNombreConnecte(int nombreConnecte) {
		this.nombreConnecte = nombreConnecte;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
