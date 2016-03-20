package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQueries({
    @NamedQuery(name="Langue.getAllLangue", query="SELECT u FROM Langue u"),
    @NamedQuery(name="Langue.getAllLangueByIdUser", query="SELECT c FROM Langue c, ParleLangue p, User u where p.parleid.userId=u and p.parleid.langueId=c and u.IdUser=:_id "),
})
@Entity
public class Langue {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IdL;
	private String nom;
	private String niveau;
	public Langue() {
		// TODO Auto-generated constructor stub
	}
	 @OneToMany(mappedBy="parleid.langueId", cascade=CascadeType.ALL)
	 private List<ParleLangue> langues = new ArrayList<ParleLangue>();
	public int getIdL() {
		return IdL;
	}
	public void setIdL(int idL) {
		IdL = idL;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public List<ParleLangue> getLangues() {
		return langues;
	}
	public void setLangues(List<ParleLangue> langues) {
		this.langues = langues;
	}
	 

}
