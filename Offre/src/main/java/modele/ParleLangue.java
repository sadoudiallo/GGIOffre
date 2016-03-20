package modele;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ParleLangue {

	@EmbeddedId
	private ParleLangueId parleid=new ParleLangueId();

	public ParleLangueId getParleid() {
		return parleid;
	}

	public void setParleid(ParleLangueId parleid) {
		this.parleid = parleid;
	}
	
}
