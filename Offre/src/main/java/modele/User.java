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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(name="User.getId", query="SELECT u FROM User u WHERE u.IdUser = :_id"),
    @NamedQuery(name="User.getAllUser", query="SELECT u FROM User u"),
    @NamedQuery(name="User.getUserByEmailPwd", query="SELECT u FROM User u WHERE u.email=:email AND u.password=:password"),
    @NamedQuery(name="User.getUserByEmail", query="SELECT u FROM User u where u.email=:_email"),
    @NamedQuery(name="User.getUserByTitre", query="SELECT u FROM User u where u.titre=:_titre"),
//Requete pour les offres postulées
    @NamedQuery(name="Postule.getAllPostulant", query="SELECT u FROM User u , Postule p where p.postuleid.userId=u"),
    @NamedQuery(name="Postule.getAllPostulantByOffre", query="SELECT u FROM User u, Postule p, Offre o WHERE u=p.postuleid.userId and p.postuleid.offreId=o and o.code=:code"),
    @NamedQuery(name="Postule.getAllOffreByUser", query="SELECT o FROM User u, Postule p, Offre o WHERE u=p.postuleid.userId and p.postuleid.offreId=o and u.email=:email"),

    
})

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IdUser;
	private String email;
	private String nom;
	private String Prenom;
	private String dateNaissance;
	private String adresse;
	private String urlPhoto;
	private String telephone;
	private String password;
	private String titre;
	private String urlCV;
	private boolean abonner;
	private boolean validate;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String mail, String _nom, String _prenom, String date, String add, String url, String tel,String pwd) {
		// TODO Auto-generated constructor stub
		this.email=mail;
		this.nom=_nom;
		this.Prenom=_prenom;
		this.dateNaissance=date;
		this.adresse=add;
		this.urlPhoto=url;
		this.telephone=tel;
		this.password=pwd;

	}

	 @OneToMany(mappedBy="postuleid.userId", cascade=CascadeType.ALL)
	 private List<Postule> postules = new ArrayList<Postule>();
	
	 @OneToMany(mappedBy="contientid.userId", cascade=CascadeType.ALL)
	 private List<PossedeExperience> experiences = new ArrayList<PossedeExperience>();
	
	 @OneToMany(mappedBy="competenceid.userId", cascade=CascadeType.ALL)
	 private List<PossedeCompetence> competences = new ArrayList<PossedeCompetence>();
	
	 @OneToMany(mappedBy="messageid.userId", cascade=CascadeType.ALL)
	 private List<EnvoieMessage> messages = new ArrayList<EnvoieMessage>();
	 
	 @OneToMany(mappedBy="estTitulaireId.userId", cascade=CascadeType.ALL)
	 private List<EstTitulaireFormation> formations = new ArrayList<EstTitulaireFormation>();
	 
	 
	 @OneToMany(mappedBy="parleid.userId", cascade=CascadeType.ALL)
	 private List<ParleLangue> langues = new ArrayList<ParleLangue>();
	 
	 @OneToMany(mappedBy="loisirId.userId", cascade=CascadeType.ALL)
	 private List<AimeLoisir> loisirs = new ArrayList<AimeLoisir>();
	 
	public List<PossedeExperience> getExperiences() {
		return experiences;
	}
	
	@OneToMany(mappedBy="intituleId.userId", cascade=CascadeType.ALL)
	 private List<Intitule> titres = new ArrayList<Intitule>();
	
	
	public List<Intitule> getTitres() {
		return titres;
	}
	public void setTitres(List<Intitule> titres) {
		this.titres = titres;
	}
	
	public void setExperiences(List<PossedeExperience> experiences) {
		this.experiences = experiences;
	}
	public int getIdUser() {
		return IdUser;
	}
	public void setIdUser(int idUser) {
		IdUser = idUser;
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
	

	public List<PossedeCompetence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<PossedeCompetence> competences) {
		this.competences = competences;
	}
	
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<EnvoieMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<EnvoieMessage> messages) {
		this.messages = messages;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public boolean isAbonner() {
		return abonner;
	}
	public void setAbonner(boolean abonner) {
		this.abonner = abonner;
	}
	public List<EstTitulaireFormation> getFormations() {
		return formations;
	}
	public void setFormations(List<EstTitulaireFormation> formations) {
		this.formations = formations;
	}
	public List<ParleLangue> getLangues() {
		return langues;
	}
	public void setLangues(List<ParleLangue> langues) {
		this.langues = langues;
	}
	public List<AimeLoisir> getLoisirs() {
		return loisirs;
	}
	public void setLoisirs(List<AimeLoisir> loisirs) {
		this.loisirs = loisirs;
	}
	public String getUrlCV() {
		return urlCV;
	}
	public void setUrlCV(String urlCV) {
		this.urlCV = urlCV;
	}
	public List<Postule> getPostules() {
		return postules;
	}
	public void setPostules(List<Postule> postules) {
		this.postules = postules;
	}
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	
	
	
}
