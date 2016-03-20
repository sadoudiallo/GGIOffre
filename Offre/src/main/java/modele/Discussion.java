package modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({    
    @NamedQuery(name="Discussion.getAllDiscussion", query="SELECT u FROM Discussion u"),
    @NamedQuery(name="Discussion.getDiscussionByMail", query="SELECT u FROM Discussion u where u.email=:_email"),    
})
@Entity
public class Discussion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private int IdDiscussion;
	 private String email;
	 private String message;
	 private Date dateEnvoie;
	 public Discussion() {
		// TODO Auto-generated constructor stub
	}
	public int getIdDiscussion() {
		return IdDiscussion;
	}
	public void setIdDiscussion(int idDiscussion) {
		IdDiscussion = idDiscussion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateEnvoie() {
		return dateEnvoie;
	}
	public void setDateEnvoie(Date dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}
	 
	 
	 
}
