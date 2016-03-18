package modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompetenceId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6826406994184188479L;

	@ManyToOne( cascade=CascadeType.ALL, targetEntity=User.class)
    @JoinColumn(name="userId", referencedColumnName="IdUser")
	private User userId;
	
	@ManyToOne( cascade=CascadeType.ALL, targetEntity=Competence.class)
    @JoinColumn(name="competenceId", referencedColumnName="Idcomp")
	private Competence competenceId;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Competence getCompetenceId() {
		return competenceId;
	}

	public void setCompetenceId(Competence competenceId) {
		this.competenceId = competenceId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((competenceId == null) ? 0 : competenceId.hashCode());
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
		CompetenceId other = (CompetenceId) obj;
		if (competenceId == null) {
			if (other.competenceId != null)
				return false;
		} else if (!competenceId.equals(other.competenceId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
}
