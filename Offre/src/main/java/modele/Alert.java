package modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
    
    @NamedQuery(name="Alert.getAllAlert", query="SELECT u FROM Alert u"),
    @NamedQuery(name="Alert.getAlertByMail", query="SELECT u FROM Alert u where u.emailAlert=:_email"),    
})
@Entity
public class Alert {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAlert;
	private String emailAlert;

	public Alert() {
		// TODO Auto-generated constructor stub
	}

	public int getIdAlert() {
		return idAlert;
	}

	public void setIdAlert(int idAlert) {
		this.idAlert = idAlert;
	}

	public String getEmailAlert() {
		return emailAlert;
	}

	public void setEmailAlert(String emailAlert) {
		this.emailAlert = emailAlert;
	}
	
}
