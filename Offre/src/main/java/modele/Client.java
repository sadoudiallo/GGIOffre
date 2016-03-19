package modele;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(name="Client.getId", query="SELECT u FROM Client u WHERE u.ID = :_id"),
    @NamedQuery(name="Client.getAllClient", query="SELECT u FROM Client u"),
    @NamedQuery(name="Client.getClientByEmailPwd", query="SELECT u FROM Client u WHERE u.email=:email AND u.password=:password"),
    @NamedQuery(name="Client.getClientByEmail", query="SELECT u FROM Client u where u.email=:_email"),
    @NamedQuery(name="Client.getClientBystatut", query="SELECT u FROM Client u where u.statut=:_statut"),
    
})


@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String email;
	private String password;
	private String nom;
	private String Prenom;
	private String dateNaissance;
	private String adresse;
	private String telephone;
	private String statut;
	private String urlPhoto;
	private boolean isAbonner;
	private boolean validate;
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public Client(String mail, String _nom, String _prenom, String dateN,String add,String tel, String pwd) {
		// TODO Auto-generated constructor stub
		this.email=mail;
		this.nom=_nom;
		this.Prenom=_prenom;
		this.adresse=add;
		this.dateNaissance=dateN;
		this.telephone=tel;
		this.password=pwd;
	}
	
	@OneToMany(mappedBy="client")
    private Set<Offre> offres;
	
	 @OneToMany(mappedBy="messageid.clientId", cascade=CascadeType.ALL)
	 private List<EnvoieMessage> messages=new ArrayList<EnvoieMessage>() ;

	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Set<Offre> getOffres() {
		return offres;
	}
	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<EnvoieMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<EnvoieMessage> messages) {
		this.messages = messages;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public boolean isAbonner() {
		return isAbonner;
	}
	public void setAbonner(boolean isAbonner) {
		this.isAbonner = isAbonner;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	
	
	

}
