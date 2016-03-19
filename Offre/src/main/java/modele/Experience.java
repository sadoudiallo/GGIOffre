package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQueries({
    @NamedQuery(name="Experience.getAllExperience", query="SELECT u FROM Experience u"),
    @NamedQuery(name="Experience.getAllExperienceByIdUser", query="SELECT c FROM Experience c, PossedeExperience p, User u where p.contientid.userId=u and p.contientid.experienceId=c and u.IdUser=:_id "),
})
@Entity
public class Experience {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IdExp;
	private String nomExp;
	private String DescriptionExp;
	private String nomEntreprise;
	private String datedebut;
	private String datefin;
	
	public Experience(String nom, String desc, String nomE,String datedeb, String datef) {
		// TODO Auto-generated constructor stub
		this.nomExp=nom;
		this.DescriptionExp=desc;
		this.nomEntreprise=nomE;
		this.datedebut=datedeb;
		this.datefin=datef;
	}
	public Experience() {
		// TODO Auto-generated constructor stub
	}
	
	
	 @OneToMany(mappedBy="contientid.experienceId", cascade=CascadeType.ALL)
	 private List<PossedeExperience> experiences = new ArrayList<PossedeExperience>();

	public int getIdExp() {
		return IdExp;
	}

	public void setIdExp(int idExp) {
		IdExp = idExp;
	}

	public String getNomExp() {
		return nomExp;
	}

	public void setNomExp(String nomExp) {
		this.nomExp = nomExp;
	}

	public String getDescriptionExp() {
		return DescriptionExp;
	}

	public void setDescriptionExp(String descriptionExp) {
		DescriptionExp = descriptionExp;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}
	public String getDatefin() {
		return datefin;
	}
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	public List<PossedeExperience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<PossedeExperience> experiences) {
		this.experiences = experiences;
	}


}
