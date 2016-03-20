package modele;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EstTitulaireFormation {
	@EmbeddedId
	private EstTitulaireFormationId estTitulaireId=new EstTitulaireFormationId();

	public EstTitulaireFormationId getEstTitulaireId() {
		return estTitulaireId;
	}

	public void setEstTitulaireId(EstTitulaireFormationId estTitulaireId) {
		this.estTitulaireId = estTitulaireId;
	}
	

}
