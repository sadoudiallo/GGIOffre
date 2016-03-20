package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GeneratorType;


@NamedQueries({
    @NamedQuery(name="Annuaire.getAnnuaireById", query="SELECT u FROM Annuaire u WHERE u.id = :_id"),
    @NamedQuery(name="Annuaire.getAllAnnuaire", query="SELECT u FROM Annuaire u"),
    @NamedQuery(name="Annuaire.getAnnuaireByDomaineNomAdresse", query="SELECT u FROM Annuaire u WHERE u.domaine=:domaine or  u.adresse=:adresse"),

    
})
@Entity
public class Annuaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String datecreation;
	private String nomEntreprise;
	private String domaine;
	private String description;
	private String adresse;
	private String telephone;
	private long chiffreAffaire;
	private String logo;
	public Annuaire() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public long getChiffreAffaire() {
		return chiffreAffaire;
	}
	public void setChiffreAffaire(long chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(String datecreation) {
		this.datecreation = datecreation;
	}
	

}
