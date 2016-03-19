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
    @NamedQuery(name="Competence.getAllCompetence", query="SELECT u FROM Competence u"),
    @NamedQuery(name="Competence.getAllCompetenceByIdUser", query="SELECT c FROM Competence c, PossedeCompetence p, User u where p.competenceid.userId=u and p.competenceid.competenceId=c and u.IdUser=:_id "),
    
})
@Entity
public class Competence {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Idcomp;
	private String nom;
	private String description;
	public Competence() {
		// TODO Auto-generated constructor stub
	}
	public Competence(String _nom, String desc) {
		// TODO Auto-generated constructor stub
		this.nom=_nom;
		this.description=desc;
	}
	
	@OneToMany(mappedBy="competenceid.competenceId", cascade=CascadeType.ALL)
	 private List<PossedeCompetence> competence = new ArrayList<PossedeCompetence>();
	
	public int getIdcomp() {
		return Idcomp;
	}

	public void setIdcomp(int idcomp) {
		Idcomp = idcomp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PossedeCompetence> getCompetence() {
		return competence;
	}

	public void setCompetence(List<PossedeCompetence> competence) {
		this.competence = competence;
	}
	
}
