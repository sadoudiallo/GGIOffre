package modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EstTitulaireFormationId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3831667111136940203L;

	@ManyToOne( cascade=CascadeType.ALL, targetEntity=User.class)
    @JoinColumn(name="userId", referencedColumnName="IdUser")
	private User userId;
	
	@ManyToOne( cascade=CascadeType.ALL, targetEntity=Formation.class)
    @JoinColumn(name="formationId", referencedColumnName="idF")
	private Formation formationId;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Formation getFormationId() {
		return formationId;
	}

	public void setFormationId(Formation formationId) {
		this.formationId = formationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((formationId == null) ? 0 : formationId.hashCode());
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
		EstTitulaireFormationId other = (EstTitulaireFormationId) obj;
		if (formationId == null) {
			if (other.formationId != null)
				return false;
		} else if (!formationId.equals(other.formationId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	

}
