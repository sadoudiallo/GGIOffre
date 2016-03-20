package modele;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name="EnvoieMessage.deleteEnvoieMessage", query="delete FROM EnvoieMessage m where m.messageid.msgId=:e"),
	@NamedQuery(name="EnvoieMessage.getDateEnvoieMessage", query="SELECT m.dateEnvoi FROM EnvoieMessage m, MessageEnvoye e where m.messageid.msgId=:e"),
	@NamedQuery(name="EnvoieMessage.getEnvoieByMessage", query="SELECT m FROM EnvoieMessage m, MessageEnvoye e where m.messageid.msgId=:e"),
})
@Entity
public class EnvoieMessage {
		
	@EmbeddedId 
	private MessageId messageid=new MessageId();

	private Date dateEnvoi;

	public EnvoieMessage() {
		// TODO Auto-generated constructor stub
	}


	public MessageId getMessageid() {
		return messageid;
	}


	public void setMessageid(MessageId messageid) {
		this.messageid = messageid;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}


	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

}
