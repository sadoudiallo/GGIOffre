package modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Embeddable
public class PossedeExpId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3663889533378999819L;

	@ManyToOne( cascade=CascadeType.ALL, targetEntity=User.class)
    @JoinColumn(name="userId", referencedColumnName="IdUser")
	private User userId;
	
	@ManyToOne( cascade=CascadeType.ALL, targetEntity=Experience.class)
    @JoinColumn(name="experienceId", referencedColumnName="IdExp")
	private Experience experienceId;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Experience getExperienceId() {
		return experienceId;
	}


	public void setExperienceId(Experience experienceId) {
		this.experienceId = experienceId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((experienceId == null) ? 0 : experienceId.hashCode());
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
		PossedeExpId other = (PossedeExpId) obj;
		if (experienceId == null) {
			if (other.experienceId != null)
				return false;
		} else if (!experienceId.equals(other.experienceId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	

}
