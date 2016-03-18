package modele;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PossedeCompetence {
	@EmbeddedId
	private CompetenceId competenceid=new CompetenceId();

	public CompetenceId getCompetenceid() {
		return competenceid;
	}

	public void setCompetenceid(CompetenceId competenceid) {
		this.competenceid = competenceid;
	}
	
	

}
