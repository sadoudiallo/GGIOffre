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
    @NamedQuery(name="Titre.getAllTitre", query="SELECT u FROM Titre u where u.estChoisi=true"),
    @NamedQuery(name="Titre.getAllTitreByUser", query="SELECT t FROM Titre t, Intitule I, User u where I.intituleId.userId=u and I.intituleId.titreId=t and u.email=:_email "),
    @NamedQuery(name="Titre.getTitreByNameAndUser", query="SELECT t FROM Titre t, Intitule I, User u where I.intituleId.userId=u and I.intituleId.titreId=t and u.email=:_email and t.nomTitre=:_nom"),
    @NamedQuery(name="Titre.getTitreByUser", query="SELECT t FROM Titre t, Intitule I, User u where I.intituleId.userId=u and I.intituleId.titreId=t and u.email=:_email and t.estChoisi=true"),

    @NamedQuery(name="Titre.getAllUserByTitrename", query="SELECT u FROM Titre t, Intitule I, User u where I.intituleId.userId=u and I.intituleId.titreId=t and t.nomTitre=:_nomtitre and t.estChoisi=true "),
    @NamedQuery(name="Titre.getAllUserByTitrenameEtLieu", query="SELECT u FROM Titre t, Intitule I, User u where I.intituleId.userId=u and I.intituleId.titreId=t and t.nomTitre=:_nomtitre and u.adresse=:_lieu "),
})
@Entity
public class Titre {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int IDT;
private String nomTitre;
private boolean estChoisi;
public Titre() {
	// TODO Auto-generated constructor stub
}


@OneToMany(mappedBy="intituleId.titreId", cascade=CascadeType.ALL)
private List<Intitule> titres = new ArrayList<Intitule>();




public int getIDT() {
	return IDT;
}


public void setIDT(int iDT) {
	IDT = iDT;
}


public String getNomTitre() {
	return nomTitre;
}


public void setNomTitre(String nomTitre) {
	this.nomTitre = nomTitre;
}


public boolean isEstChoisi() {
	return estChoisi;
}


public void setEstChoisi(boolean estChoisi) {
	this.estChoisi = estChoisi;
}


public List<Intitule> getTitres() {
	return titres;
}


public void setTitres(List<Intitule> titres) {
	this.titres = titres;
}



}
