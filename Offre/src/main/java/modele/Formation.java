package modele;

import java.util.ArrayList;
import java.util.Date;
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
    @NamedQuery(name="Formation.getAllFormation", query="SELECT u FROM Formation u"),
    @NamedQuery(name="Formation.getAllFormationByIdUser", query="SELECT c FROM Formation c, EstTitulaireFormation p, User u where p.estTitulaireId.userId=u and p.estTitulaireId.formationId=c and u.IdUser=:_id "),
})
@Entity
public class Formation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idF;
	private String titre;
	private String domaine;
	private String description;
	private String niveau;
	private String origine;
	private String dateFormation;
	private String diplomeObtenu;
	public Formation() {
		// TODO Auto-generated constructor stub
	}
	 @OneToMany(mappedBy="estTitulaireId.formationId", cascade=CascadeType.ALL)
	 private List<EstTitulaireFormation> formations = new ArrayList<EstTitulaireFormation>();
	
	
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
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
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getOrigine() {
		return origine;
	}
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	
	public String getDateFormation() {
		return dateFormation;
	}
	public void setDateFormation(String dateFormation) {
		this.dateFormation = dateFormation;
	}
	public String getDiplomeObtenu() {
		return diplomeObtenu;
	}
	public void setDiplomeObtenu(String diplomeObtenu) {
		this.diplomeObtenu = diplomeObtenu;
	}
	public List<EstTitulaireFormation> getFormations() {
		return formations;
	}
	public void setFormations(List<EstTitulaireFormation> formations) {
		this.formations = formations;
	}
	 

}
