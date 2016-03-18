package modele;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AimeLoisir {
	@EmbeddedId
	private LoisirId loisirId=new LoisirId();

	public LoisirId getLoisirId() {
		return loisirId;
	}

	public void setLoisirId(LoisirId loisirId) {
		this.loisirId = loisirId;
	}
	

}
