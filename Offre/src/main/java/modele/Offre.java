package modele;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQueries({
    @NamedQuery(name="Offre.getCode", query="SELECT u FROM Offre u WHERE u.code = :_id"),
    @NamedQuery(name="Offre.getAllOffre", query="SELECT u FROM Offre u"),
    @NamedQuery(name="Offre.getOffreByTitre", query="SELECT u FROM Offre u WHERE u.titre=:_titre"),
    
    @NamedQuery(name="Offre.getOffreByClient", query="SELECT u FROM Offre u, Client c WHERE u.client=c and c.email=:email"),
    
    @NamedQuery(name="Offre.getOffreByAdresse", query="SELECT u FROM Offre u where u.adresse=:_adresse"),
    @NamedQuery(name="Offre.getOffreByTitreEtLieu", query="SELECT u FROM Offre u WHERE u.titre =:title and u.adresse =:_lieu"),
})
@Entity
public class Offre {
	@Id
	private String code;
	private String titre;
	private String description;
	private String adresse;
	private String qualification;
	private String dureeHebdomadaire;
	private String datePublication;
 public Offre() {
	// TODO Auto-generated constructor stub
}
 public Offre(String _code,String _titre, String desc, String ad, String qualif, String dureH, String datepub) {
		// TODO Auto-generated constructor stub
	 this.code=_code;
	 this.titre=_titre;
	 this.description=desc;
	 this.adresse=ad;
	 this.qualification=qualif;
	 this.dureeHebdomadaire=dureH;
	 this.datePublication=datepub;
	}
 @OneToMany(mappedBy="postuleid.offreId", cascade=CascadeType.ALL)
 private List<Postule> postules = new ArrayList<Postule>();
 
 @ManyToOne
 @JoinColumn(name="ID")
 private Client client;
 
// @ManyToOne
// @JoinColumn(name="IdUser")
// private User user;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDureeHebdomadaire() {
		return dureeHebdomadaire;
	}
	public void setDureeHebdomadaire(String dureeHebdomadaire) {
		this.dureeHebdomadaire = dureeHebdomadaire;
	}
	
	public String getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(String datePublication) {
		this.datePublication = datePublication;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Postule> getPostules() {
		return postules;
	}
	public void setPostules(List<Postule> postules) {
		this.postules = postules;
	}
	  
	
}
