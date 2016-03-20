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
    @NamedQuery(name="Loisir.getAllLoisir", query="SELECT u FROM Loisir u"),
    @NamedQuery(name="Loisir.getAllLoisirByIdUser", query="SELECT c FROM Loisir c, AimeLoisir p, User u where p.loisirId.userId=u and p.loisirId.loisirid=c and u.IdUser=:_id "),
})
@Entity
public class Loisir {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int Idloisir;
private String nom;
@OneToMany(mappedBy="loisirId.loisirid", cascade=CascadeType.ALL)
private List<AimeLoisir> loisirs = new ArrayList<AimeLoisir>();
public int getIdloisir() {
	return Idloisir;
}
public void setIdloisir(int idloisir) {
	Idloisir = idloisir;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public List<AimeLoisir> getLoisirs() {
	return loisirs;
}
public void setLoisirs(List<AimeLoisir> loisirs) {
	this.loisirs = loisirs;
}

}
