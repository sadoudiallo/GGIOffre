package modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ParleLangueId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3240086384702345236L;

	@ManyToOne( cascade=CascadeType.ALL, targetEntity=User.class)
    @JoinColumn(name="userId", referencedColumnName="IdUser")
	private User userId;
	
	@ManyToOne( cascade=CascadeType.ALL, targetEntity=Langue.class)
    @JoinColumn(name="langueId", referencedColumnName="IdL")
	private Langue langueId;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Langue getLangueId() {
		return langueId;
	}

	public void setLangueId(Langue langueId) {
		this.langueId = langueId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((langueId == null) ? 0 : langueId.hashCode());
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
		ParleLangueId other = (ParleLangueId) obj;
		if (langueId == null) {
			if (other.langueId != null)
				return false;
		} else if (!langueId.equals(other.langueId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	

}
