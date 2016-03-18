package modele;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Intitule {
@EmbeddedId	
private TitreId intituleId=new TitreId();

public TitreId getIntituleId() {
	return intituleId;
}

public void setIntituleId(TitreId intituleId) {
	this.intituleId = intituleId;
}


}
