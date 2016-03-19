package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
public class Postule {
@EmbeddedId
private PostuleId postuleid=new PostuleId();
private Date datePostule;
public Postule() {
	// TODO Auto-generated constructor stub
}

public Date getDatePostule() {
	return datePostule;
}
public void setDatePostule(Date datePostule) {
	this.datePostule = datePostule;
}

public PostuleId getPostuleid() {
	return postuleid;
}
public void setPostuleid(PostuleId postuleid) {
	this.postuleid = postuleid;
}

}
