package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	@NamedQuery(name="MessageEnvoye.deleteMessageById", query="delete FROM MessageEnvoye u where u.idM=:_iddelete"),
    @NamedQuery(name="MessageEnvoye.getMessageById", query="SELECT u FROM MessageEnvoye u WHERE u.idM = :_id"),
    @NamedQuery(name="MessageEnvoye.getAllMessage", query="SELECT u FROM MessageEnvoye u where u.supprimer=false"),
    @NamedQuery(name="MessageEnvoye.getAllMessageSupByClient", query="SELECT m FROM MessageEnvoye m, Client c, EnvoieMessage e WHERE m.destinataire=:dest and e.messageid.msgId=m and e.messageid.clientId=c and m.supprimer=true"),
    @NamedQuery(name="MessageEnvoye.getAllMessageRecuByClient", query="SELECT m FROM MessageEnvoye m, Client c, EnvoieMessage e WHERE m.destinataire=:dest and e.messageid.msgId=m and e.messageid.clientId=c and m.supprimer=false"),
    @NamedQuery(name="MessageEnvoye.getAllMessageEnvoyerByClient", query="SELECT m FROM MessageEnvoye m, Client u, EnvoieMessage e WHERE m.expeditaire=:exp and e.messageid.msgId=m and e.messageid.clientId=u"),
    @NamedQuery(name="MessageEnvoye.getCountMessageRecuByClient", query="SELECT count(m.destinataire) FROM MessageEnvoye m, Client c, EnvoieMessage e WHERE m.destinataire=:dest and e.messageid.msgId=m and e.messageid.clientId=c and m.statutMessage=false"),
    @NamedQuery(name="MessageEnvoye.getCountMessageEnvoyeByClient", query="SELECT count(m.destinataire) FROM MessageEnvoye m,Client u, EnvoieMessage e WHERE m.expeditaire=:exp and e.messageid.msgId=m and e.messageid.clientId=u"),
//    ___________________________________________by user____________________________________________

    @NamedQuery(name="MessageEnvoye.getAllMessageRecuByUser", query="SELECT m FROM MessageEnvoye m, User c, EnvoieMessage e WHERE m.destinataire=:dest and e.messageid.msgId=m and e.messageid.userId=c and m.supprimer=false"),
    @NamedQuery(name="MessageEnvoye.getAllMessageSupByUser", query="SELECT m FROM MessageEnvoye m, User c, EnvoieMessage e WHERE m.destinataire=:dest and e.messageid.msgId=m and e.messageid.userId=c and m.supprimer=TRUE"),
    @NamedQuery(name="MessageEnvoye.getAllMessageEnvoyerByUser", query="SELECT m FROM MessageEnvoye m, User u, EnvoieMessage e WHERE m.expeditaire=:exp and e.messageid.msgId=m and e.messageid.userId=u"),
    @NamedQuery(name="MessageEnvoye.getCountMessageRecuByUser", query="SELECT count(m.destinataire) FROM MessageEnvoye m, User c, EnvoieMessage e WHERE m.destinataire=:dest and e.messageid.msgId=m and e.messageid.userId=c and m.statutMessage=false"),
    @NamedQuery(name="MessageEnvoye.getCountMessageEnvoyeByUser", query="SELECT count(m.destinataire) FROM MessageEnvoye m,User u, EnvoieMessage e WHERE m.expeditaire=:exp and e.messageid.msgId=m and e.messageid.userId=u"),
    
})
@Entity
public class MessageEnvoye {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idM;
	private String messagText;
	private String objetMessage;
	private boolean statutMessage;
	private boolean supprimer;
	private String destinataire;
	private String expeditaire;
	private String urlcvjoint;
	
	public MessageEnvoye() {
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy="messageid.msgId", cascade=CascadeType.ALL)
	 private List<EnvoieMessage> messages=new ArrayList<EnvoieMessage>() ;


	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public String getMessagText() {
		return messagText;
	}
	public void setMessagText(String messagText) {
		this.messagText = messagText;
	}
	public String getObjetMessage() {
		return objetMessage;
	}
	public void setObjetMessage(String objetMessage) {
		this.objetMessage = objetMessage;
	}
	
	public boolean isStatutMessage() {
		return statutMessage;
	}
	public void setStatutMessage(boolean statutMessage) {
		this.statutMessage = statutMessage;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public String getExpeditaire() {
		return expeditaire;
	}
	public void setExpeditaire(String expeditaire) {
		this.expeditaire = expeditaire;
	}
	public List<EnvoieMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<EnvoieMessage> messages) {
		this.messages = messages;
	}
	public boolean isSupprimer() {
		return supprimer;
	}
	public void setSupprimer(boolean supprimer) {
		this.supprimer = supprimer;
	}
	public String getUrlcvjoint() {
		return urlcvjoint;
	}
	public void setUrlcvjoint(String urlcvjoint) {
		this.urlcvjoint = urlcvjoint;
	}


}
