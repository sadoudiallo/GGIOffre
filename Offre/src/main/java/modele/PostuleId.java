package modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class PostuleId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4147883702346124044L;

	@ManyToOne( cascade=CascadeType.ALL, targetEntity=User.class)
    @JoinColumn(name="userId", referencedColumnName="IdUser")
	private User userId;
	
	@ManyToOne( cascade=CascadeType.ALL, targetEntity=Offre.class)
    @JoinColumn(name="offreId", referencedColumnName="code")
	private Offre offreId;
	
 public PostuleId() {
	// TODO Auto-generated constructor stub
}
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Offre getOffreId() {
		return offreId;
	}
	public void setOffreId(Offre offreId) {
		this.offreId = offreId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offreId == null) ? 0 : offreId.hashCode());
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
		PostuleId other = (PostuleId) obj;
		if (offreId == null) {
			if (other.offreId != null)
				return false;
		} else if (!offreId.equals(other.offreId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
