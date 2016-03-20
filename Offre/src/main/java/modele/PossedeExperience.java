package modele;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PossedeExperience {
	@EmbeddedId
	private PossedeExpId contientid=new PossedeExpId();

	public PossedeExpId getContientid() {
		return contientid;
	}

	public void setContientid(PossedeExpId contientid) {
		this.contientid = contientid;
	}
	
	
}
