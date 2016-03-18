package modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name="ExterneUserMessage.getId", query="SELECT u FROM ExterneUserMessage u WHERE u.id = :_id"),
    @NamedQuery(name="ExterneUserMessage.getAllExterneUserMessage", query="SELECT u FROM ExterneUserMessage u where u.supprimer=false"),
    @NamedQuery(name="ExterneUserMessage.getAllExterneUserMessagebydUser", query="SELECT c FROM ExterneUserMessage c where c.email=:_email and c.supprimer=false"),
    @NamedQuery(name="ExterneUserMessage.getAllExterneUserMessagebyDest", query="SELECT c FROM ExterneUserMessage c where c.emailDest=:_email and c.supprimer=false"),
    @NamedQuery(name="ExterneUserMessage.getCountMessagebyEmail", query="SELECT count(c.emailDest) FROM ExterneUserMessage c where c.emailDest=:_email and c.statutMessage=false"),
   
})
@Entity
public class ExterneUserMessage {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String email;
 private String nom;     
 private String prenom;
 private Date dateEnvoie;
 private String objet;
 private boolean statutMessage;
 private boolean supprimer;
 private String messageText;
 private String emailDest;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public Date getDateEnvoie() {
	return dateEnvoie;
}
public void setDateEnvoie(Date dateEnvoie) {
	this.dateEnvoie = dateEnvoie;
}
public String getObjet() {
	return objet;
}
public void setObjet(String objet) {
	this.objet = objet;
}
public boolean isStatutMessage() {
	return statutMessage;
}
public void setStatutMessage(boolean statutMessage) {
	this.statutMessage = statutMessage;
}
public String getMessageText() {
	return messageText;
}
public void setMessageText(String messageText) {
	this.messageText = messageText;
}
public String getEmailDest() {
	return emailDest;
}
public void setEmailDest(String emailDest) {
	this.emailDest = emailDest;
}
public boolean isSupprimer() {
	return supprimer;
}
public void setSupprimer(boolean supprimer) {
	this.supprimer = supprimer;
}
	

}
