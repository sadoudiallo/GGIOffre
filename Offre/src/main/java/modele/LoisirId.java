package modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LoisirId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8126289625290423974L;

	@ManyToOne( cascade=CascadeType.ALL, targetEntity=User.class)
    @JoinColumn(name="userId", referencedColumnName="IdUser")
	private User userId;
	
	@ManyToOne( cascade=CascadeType.ALL, targetEntity=Loisir.class)
    @JoinColumn(name="loisirid", referencedColumnName="Idloisir")
	private Loisir loisirid;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Loisir getLoisirid() {
		return loisirid;
	}

	public void setLoisirid(Loisir loisirid) {
		this.loisirid = loisirid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((loisirid == null) ? 0 : loisirid.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoisirId other = (LoisirId) obj;
		if (loisirid == null) {
			if (other.loisirid != null)
				return false;
		} else if (!loisirid.equals(other.loisirid))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
