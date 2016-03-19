package modele;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Temporal;

import org.h2.util.New;
import org.junit.Test;

import dao.MappingDao;

public class TestMapping {
	private MappingDao dao=MappingDao.getInstance();
	Date d=new Date();
	private User user=new User("kasadouzl@hotmail.fr","diallo","sadou","10/01/2016", "17 rue camille koechlin","/Offre/web-app/","06-68-05-16-36","123");
	private User user1=new User("kasadouzl@hotmail.fr","diallo","sadou","10/01/2016", "17 rue camille koechlin","/Offre/web-app/","06-68-05-16-36","123");
	@Test
public void test()
{
	Client client=new Client();
	ExterneUserMessage ext=new ExterneUserMessage();
	EnvoieMessage env=new EnvoieMessage();
	this.dao.createOrUpdateUser(user);
	this.dao.createOrUpdateUser(user1);
	//System.out.print(this.dao.getCountMessagebyEmail("kasadouzl@hotmail.fr"));
//	ArrayList<Offre> offres=this.dao.getOffreByTitreEtLieu("dev web", "Villeurbanne");
//	for(Offre of:offres)
//	{
//		System.out.println("le titre est :"+of.getDescription()+" et le lieu est:"+of.getAdresse());
//	}
	EnvoieMessage e=new EnvoieMessage();
	Client c=new Client();
	c=dao.getClientbyEmail("atos@gmail.com");
	long count=dao.getCountMessageRecuByEmailByClient("atos@gmail.com");
	//getCountMessagebyEmailClient(c);
   System.out.print("le nombre de message recu est :"+count);
//	System.out.println("voici le nombre d 'enregistrement"+dao.getAllEnvoieMessage().size());
//    
}
	
}
