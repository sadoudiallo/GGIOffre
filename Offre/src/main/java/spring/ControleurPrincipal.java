package spring;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.print.attribute.standard.Copies;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.Part;

import modele.AimeLoisir;
import modele.Annuaire;
import modele.Client;
import modele.Competence;
import modele.CopyFiles;
import modele.EnvoieMessage;
import modele.EstTitulaireFormation;
import modele.Experience;
import modele.ExterneUserMessage;
import modele.Formation;
import modele.Intitule;
import modele.Langue;
import modele.Loisir;
import modele.MessageEnvoye;
import modele.MessageId;
import modele.NbConnecte;
import modele.Offre;
import modele.ParleLangue;
import modele.PossedeCompetence;
import modele.PossedeExperience;
import modele.Postule;
import modele.Titre;
import modele.User;
import modele.Alert;
import modele.Discussion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import dao.MappingDao;
//
//@CrossOrigin(allowCredentials = "http://localhost:8080")
@Controller
public class ControleurPrincipal {
	@RequestMapping(value = {"/", "/Home"}, method = RequestMethod.GET)
    public ModelAndView index() {
		
        return new ModelAndView("index");
    }

    @RequestMapping(value = {"/Home"}, method = RequestMethod.POST)
    public ModelAndView indexPOST() {
        return new ModelAndView("index");
    }
    @RequestMapping(value = {"/SignIn"}, method = RequestMethod.GET)
    public ModelAndView InscriptionGET() {

        return new ModelAndView("signin");
    }
    @RequestMapping(value = {"/Deconnect"}, method = RequestMethod.GET)
    public RedirectView deconnect(HttpServletRequest request, HttpServletResponse response) {
    	MappingDao dao=MappingDao.getInstance();
    	String email= request.getParameter("mail");
    	dao.deleteNbConnecte(email);
        request.getSession().invalidate();
        return new RedirectView("Home");
    }
    @RequestMapping(value = {"/Cv"}, method = RequestMethod.GET)
    public ModelAndView CvGET() {

        return new ModelAndView("cv");
    }
    
    @RequestMapping(value = {"/menuA"}, method = RequestMethod.GET)
    public ModelAndView menuA() {

        return new ModelAndView("menuA");
    }
    
    @RequestMapping(value = {"/annuaire"}, method = RequestMethod.GET)
    public ModelAndView annuaire() {

        return new ModelAndView("annuaire");
    }
    
    @RequestMapping(value = {"/ListeUser"}, method = RequestMethod.GET)
    public ModelAndView ListeUser() {

        return new ModelAndView("ListeUser");
    }
    
    @RequestMapping(value = {"/FicheEntreprise"}, method = RequestMethod.GET)
    public ModelAndView FicheEntreprise() {

        return new ModelAndView("FicheEntreprise");
    }
    
    @RequestMapping(value = {"/import"}, method = RequestMethod.GET)
    public ModelAndView ImportGET() {

        return new ModelAndView("import");
    }
    @RequestMapping(value = {"/AddOffre"}, method = RequestMethod.GET)
    public ModelAndView AddOffreGET() {

        return new ModelAndView("offre");
    }
    
    @RequestMapping(value = {"/ListeMessage"}, method = RequestMethod.GET)
    public ModelAndView ListeMessage() {

        return new ModelAndView("listemessage");
    }
    
    
    @RequestMapping(value = {"/MessageSup"}, method = RequestMethod.GET)
    public ModelAndView MessageSup() {

        return new ModelAndView("messageSup");
    }
    
    @RequestMapping(value = {"/MessageEnvoye"}, method = RequestMethod.GET)
    public ModelAndView MessageEnvoye() {

        return new ModelAndView("messageEnv");
    }
    @RequestMapping(value = {"/FicheMessage"}, method = RequestMethod.GET)
    public ModelAndView FicheMessage() {
        return new ModelAndView("ficheMessage");
    }
    @RequestMapping(value = {"/FicheOffre"}, method = RequestMethod.GET)
    public ModelAndView FicheOffre() {

        return new ModelAndView("FicheOffre");
    }
    
    @RequestMapping(value = {"/FicheCV"}, method = RequestMethod.GET)
    public ModelAndView FicheCV() {

        return new ModelAndView("FicheCV");
    }
    
   
    @RequestMapping(value = {"/resultaRech"}, method = RequestMethod.GET)
    public ModelAndView resultaRech() {

        return new ModelAndView("resultaRech");
    }
    
    
    @RequestMapping(value = {"/SignIn"}, method = RequestMethod.POST)
    public void InscriptionPOST(HttpServletRequest request, HttpServletResponse response) throws IOException {
      MappingDao dao = MappingDao.getInstance();
      Client clienttest=new Client();
      User usertest=new User();
      String mail=request.getParameter("email");
      clienttest=dao.getClientbyEmail(mail);
      usertest=dao.getUsertbyEmail(mail);
      System.out.println("enregistre maintenant");
       String type=request.getParameter("type");
       System.out.println("voici le type"+" :"+type);
       if(type.equals("employeur") && usertest==null && clienttest==null)
       {
    	   System.out.println("ok====");
    	   
    	   String dateN=request.getParameter("datenais");
    	   Client client=new Client();
    	   client.setNom(request.getParameter("nom"));
    	   client.setAdresse(request.getParameter("adresse"));
    	   client.setDateNaissance(dateN);
    	  
    	   client.setEmail(request.getParameter("email"));
    	   client.setPrenom(request.getParameter("prenom"));
    	   client.setTelephone(request.getParameter("telephone"));
    	   client.setPassword(request.getParameter("password"));
    	   client.setStatut("simple");
    	   System.out.println("voici la date de naissance"+dateN);
    	     dao.createOrUpdateClient(client);
    	     String lien ="http://localhost:8080/Offre"+"/aValider?email=" + mail ;
    	     try {
    	    	 MappingDao.EnvoiMail(mail," <html><meta http-equiv="+"Content-Type"+" content="+"text/html; charset=UTF-8 />" +
    	     
    	    	 "<title>Template Email-HTML</title>"+
    	    	 "<body style="+"margin: 0px 0px 0px 0px; padding: 0px 0px 0px 0px; font-family: Trebuchet MS, Arial, Verdana, sans-serif;>"

    	    	
    	    	 +"</body></html>  + "
    	    	 		+ "<a href=" + lien + ">" + "Veuillez cliquez sur ce lien pour confirmer votre inscription"+"</a>");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    // request.getSession().setAttribute("client", client);
    	     response.sendRedirect("Home");
    	     
       }if(type.equals("candidat") && usertest==null && clienttest==null)
       {
    	   System.out.println("ok====");
    	   User user =new User();
    	   String dateN=request.getParameter("datenais");
    	   user.setNom(request.getParameter("nom"));
    	   user.setAdresse(request.getParameter("adresse"));
    	   user.setDateNaissance(dateN);
    	   user.setEmail(request.getParameter("email"));
    	   user.setPrenom(request.getParameter("prenom"));
    	   user.setPassword(request.getParameter("password"));
    	   user.setTelephone(request.getParameter("telephone"));
    	   String pwd=request.getParameter("password");
    	   String vpwd=request.getParameter("vpassword");
    	   dao.createOrUpdateUser(user);
    	   System.out.println("enregistre");
    	   //request.getSession().setAttribute("user", user);
    	   
    	   String lien ="http://localhost:8080/Offre"+"/aValider?email=" + mail ;
  	     try {
				MappingDao.EnvoiMail(mail, "<a href=" + lien + ">" + "Veuillez cliquez sur ce lien pour confirmer votre inscription"+"</a>");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	   response.sendRedirect("Home");
    	
       }
       
       if(usertest!=null || clienttest!=null){
    	   System.out.println("redirection ok");
    	   response.sendRedirect("SignIn?err=sinscrire");
       }
 
        
    }
    
    
    
    
    @RequestMapping(value = {"/rechercheEntreprise"}, method = RequestMethod.POST)
    public void rechercheEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException {
      MappingDao dao = MappingDao.getInstance();
      String nom=request.getParameter("nom");
      String lieu=request.getParameter("lieu");
      System.out.println("nom=>"+nom+"et lieu"+lieu);
      response.sendRedirect("resultaRech?nom="+nom+"&lieu="+lieu);
        
    }
    
    /**
     * Enregistrer un alert 
     * @param request
     * @param response
     * @return 
     * @throws IOException
     */
    @RequestMapping(value = {"/Alert"}, method = RequestMethod.POST)
    public RedirectView Alert(HttpServletRequest request, HttpServletResponse response) throws IOException {
      MappingDao dao = MappingDao.getInstance();
  
      String emailalert=request.getParameter("emailalert");
      System.out.println("Alert Info"+emailalert);
      Alert alert=dao.getAlertByMail(emailalert);
      System.out.println("Alert Info table"+" "+alert);
      if(alert==null)
      {
	    Alert alertIn=new Alert();;
	    alertIn.setEmailAlert(emailalert);
        dao.createOrUpdateAlert(alertIn);
      }
      return new RedirectView("Home");
        
    }
    
    
    
    @RequestMapping(value = {"/Discussion"}, method = RequestMethod.POST)
    public RedirectView Discussion(HttpServletRequest request, HttpServletResponse response) throws IOException {
      MappingDao dao = MappingDao.getInstance();
    
      String email=request.getParameter("email");
      String message =request.getParameter("message");
      Date date=new Date();
      Discussion discussion=new Discussion();
      discussion.setEmail(email);
      discussion.setMessage(message);
      discussion.setDateEnvoie(date);
      dao.createOrUpdateDiscussion(discussion);
      return new RedirectView("Home");
        
    }

    @RequestMapping(value = {"/aValider"}, method = RequestMethod.GET)
    public ModelAndView aValider(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("aValider");
    }
    
    @RequestMapping(value = {"/saisi"}, method = RequestMethod.GET)
    public ModelAndView saisiMessage(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("saisi");
    }
    /**
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = {"/Repondre"}, method = RequestMethod.POST)
    public void Repondre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     	MappingDao dao = MappingDao.getInstance();
     	System.out.print("voici les paramettres"+request.getParameterMap());
 		String repondre=request.getParameter("repondre");
 		String nouveau=request.getParameter("nouveau");
 		String supprimer=request.getParameter("supprimer");
 		String idExterne=request.getParameter("idmgsExterne");
 		String idInterne=request.getParameter("idmsgInterne");
 		System.out.print("voici supprimer"+supprimer);
 		if(nouveau==null && supprimer==null && repondre.isEmpty() )
    	{
 			System.out.println("idExterne"+idExterne);
 			System.out.println("idinterne"+idInterne);
 			
 			if(idInterne==null)
    		{
 				response.sendRedirect("saisi?idMsgExterne="+idExterne);
 				
    		}else
    		{
    			response.sendRedirect("saisi?idMsgInterne="+idInterne);
    			
    			
    			
    		}
 			

    	}else if(repondre==null && supprimer==null && nouveau.isEmpty() )
    	{
    		response.sendRedirect("saisi?new=true");
   		
    	}
    	
    	else if(supprimer.isEmpty() && idInterne!=null )
    	{
    		int iddele=Integer.parseInt(idInterne);
    		MessageEnvoye mesgEnv=new MessageEnvoye();
    		mesgEnv=dao.getMessageById(iddele);
    		
            mesgEnv.setSupprimer(true);
            dao.createOrUpdateMessageEnvoye(mesgEnv);
    		System.out.print("Suppression du message dans MessageEnvoie  ok");
    		response.sendRedirect("ListeMessage");
   		
    	}
    	else if(supprimer.isEmpty() && idExterne!=null )
    	{
    		int iddele=Integer.parseInt(idExterne);
    		ExterneUserMessage externmsg=new ExterneUserMessage();
    		externmsg=dao.getExterneUserMessageById(iddele);
    		
            externmsg.setSupprimer(true);
            dao.createOrUpdateExternUsermessage(externmsg);
    		System.out.print("Suppression du message dans externeuser  ok");
    		response.sendRedirect("ListeMessage");
   		
    	}
 		
              
     }

    @RequestMapping(value = {"/validateCompte"})
    public ModelAndView ValidateCompte(HttpServletRequest request, HttpServletResponse response) {

        MappingDao dao = MappingDao.getInstance();
        String mail = request.getParameter("email");
        
        HttpSession session = request.getSession(true);
    	session.setAttribute("ident", mail);
    	
        System.out.println("l'email de l'utilsateur chercher est :" + " " + mail);

  
    	User user = new User();
    	 user = dao.getUsertbyEmail(mail);
    	 
    	 Client client = new Client();
       	 client = dao.getClientbyEmail(mail);
           	 
       if (user != null) {
            user.setValidate(true);
            dao.createOrUpdateUser(user);
            request.getSession().setAttribute("user", user);
        } else if(client != null) {
        	client.setValidate(true);
           dao.createOrUpdateClient(client);
           request.getSession().setAttribute("client", client);
       }
          
        return new ModelAndView("index");
        
    }
    
    
    @RequestMapping(value = {"/Connect"}, method = RequestMethod.GET)
    public ModelAndView ConnexionGET() {

        return new ModelAndView("connect");
    }
    
    @RequestMapping(value = {"/LogIn"}, method = RequestMethod.POST)
   public RedirectView login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MappingDao dao = MappingDao.getInstance();
    	 String ident = request.getParameter("email");
	    String pwd = request.getParameter("password");
    	//String statut=request.getParameter("statut"); 
    	HttpSession session = request.getSession(true);
    	NbConnecte nbconnect=new NbConnecte();
    	
    	session.setAttribute("ident", ident);
      
//    	 if (statut!=null)   
//    		 {
//    			 if(statut.equals("employeur"))
//    			 {
    				User user=dao.getUserByEmailPwd(ident, pwd);
    				Client client=dao.getClientByEmailPwd(ident, pwd);
    				if(client!=null )
    				{
//    					if(client.isValidate())
//    					{
    					System.out.println("Je suis client!!!!!");
    					nbconnect.setMail(ident);
    					dao.createOrUpdateNbConnecte(nbconnect);
    					request.getSession().setAttribute("client", client);
    					System.out.println("le client "+client.getNom()+"est bien connecté");
    					 return new RedirectView("Home");
//    					}else
//    					{
//    						return new RedirectView("Home?err=validate");
//    					}
    				}    				 
//    			 }if(statut.equals("candidat"))
//    			 {
//    				
     				if(user!=null)
     				{
//     					if(user.isValidate())
//     					{
	     					System.out.println("Je suis Candidat!!!!!");
	     					nbconnect.setMail(ident);
	    					dao.createOrUpdateNbConnecte(nbconnect);
	     					request.getSession().setAttribute("user", user);
	     					System.out.println("le client "+user.getNom()+"est bien connecté");
	     					 return new RedirectView("Home");
//     					}else{
//     						 return new RedirectView("Home?err=validate");
//     					}
     				}if(user==null && client==null)
     				{
     					System.out.println("erreur");
     					return new RedirectView("Home?err=connect");
     				}
 
//    			 }
// 
//    		 }   
    	
    	//request.getRequestDispatcher("/offre.jsp").forward(request, response);
    	 return new RedirectView("Home");
	              
    }

   @RequestMapping(value = {"/SaveOffre"}, method = RequestMethod.POST)
   public RedirectView SaveOffre(HttpServletRequest request, HttpServletResponse response) {
    	MappingDao dao = MappingDao.getInstance();
    	 String code = request.getParameter("code");
	    String titre = request.getParameter("titre");
    	String description=request.getParameter("description"); 
    	String qualification = request.getParameter("qualification");
 	    String adresse = request.getParameter("adresse");
     	String duree=request.getParameter("duree"); 
     	String date=request.getParameter("datepub"); 
     	String email=request.getParameter("email"); 
     	System.out.println("code est :"+code);
     	System.out.println("titre est :"+titre);
     	System.out.println("description est :"+description);
     	
     	
     	//rechercher l'offre dans la base de données
     	
     	Offre of=dao.getOffrebyCode(code);
     	System.out.println("email test1 est :"+email);
     	Client client=new Client();
     	System.out.println("email test 2est :"+email);
     	client=dao.getClientbyEmail(email);
     	System.out.println("email test3 est :"+email);
     	//Recuperez la liste des emails dans la table Alert
     	
     	ArrayList<Alert> AlertList=dao.getAlertAllAlert();
     	System.out.println("email test4 est :"+email);
     	ArrayList<String> lien=new ArrayList<String>();
     	System.out.println("email test5 est :"+email);
     	if(of==null)
     	{
     		System.out.println("En phase d'enregistrement");
     		
     		Offre offre=new Offre();
     		System.out.println("En phase d'enregistrement");
     		offre.setCode(code);
     		offre.setAdresse(adresse);
     		offre.setDatePublication(date);
     		offre.setDureeHebdomadaire(duree);
     		offre.setDescription(description);
     		offre.setQualification(qualification);
     		offre.setTitre(titre);
     		offre.setClient(client);
     		dao.createOrUpdateOffre(offre);
     		
     		for(Alert alert:AlertList)
     		{
     			
     			 String lienOffre ="http://localhost:8080/Offre"+"/FicheOffre?code=" + code ;
     	  	     try {
     					MappingDao.EnvoiMail(alert.getEmailAlert(), titre+" "+"<br><a href=" + lienOffre + ">" + "Consulter L'offre"+"</a>");
     				} catch (AddressException e) {
     					// TODO Auto-generated catch block
     					e.printStackTrace();
     				} catch (MessagingException e) {
     					// TODO Auto-generated catch block
     					e.printStackTrace();
     				}
     			
     		}
     		
     		
     		
     		System.out.println("enregistrement succes");
     		
     	}else{
     		dao.createOrUpdateOffre(of);
     		
     	}
    	   
    	 return new RedirectView("Home");
	              
    }

   @RequestMapping(value = {"/PageOffre"},method=RequestMethod.POST)
   public ModelAndView PageOffre(HttpServletRequest request, HttpServletResponse response) {
	   String lieu=request.getParameter("lieu");
	   String titre=request.getParameter("titre");
	   
	   System.out.println("lieu cherhce"+lieu);
	   System.out.println("titre cherhce"+titre);
   		request.setAttribute("titre", titre);
   		request.setAttribute("lieu", lieu);
       return new ModelAndView("listeoffre");
   }

@SuppressWarnings("deprecation")
@RequestMapping(value = {"/SaveCV"}, method = RequestMethod.POST)
public RedirectView SaveCV(HttpServletRequest request, HttpServletResponse response) {
 	MappingDao dao = MappingDao.getInstance();
 	String email=request.getParameter("email"); 
 	//Recuperation des parametres pour l'experience
 	String employeur = request.getParameter("employeur");
	String titre = request.getParameter("titre");
 	String description=request.getParameter("description"); 
 	String datedebut = request.getParameter("datedebut");
	String datefin = request.getParameter("datefin");
	//recuperation des parametres pour la competence
	String nomCompetence=request.getParameter("competence");
	String descCompetence=request.getParameter("descriptioncomp");
	
	//recuperation des parametres de la formation
	String titreFormation=request.getParameter("titref");
	String descFormation=request.getParameter("descriptionf");
	String origineFormation=request.getParameter("originef");
	String dateFormation=request.getParameter("datef");
	String domaineFormation=request.getParameter("domainef");
	String niveauFormation=request.getParameter("niveauf");
	String diplomef=request.getParameter("diplomef");
	
   
	//recuperation des parametres de la langue
	String nomlangue=request.getParameter("langue");
	String niveaulangue=request.getParameter("niveaulangue");
	//recuperation des parametres du loisir
	
	String nomloisir=request.getParameter("loisir");
  	System.out.println("==voici le nom du loisir== :"+nomloisir);
  	
  	//Recuperation des parametres du titre
  	
  	String nomTitre=request.getParameter("nomtitre");
  	String nomNewTitre=request.getParameter("nomNewtitre");
  	  	
  	System.out.println("==voici le nom du titre== :"+nomTitre);
  	System.out.println("==voici le nom de new titre== :"+nomNewTitre);
  	
  	Experience experience=new Experience();
  	Competence competence=new Competence();
  	User user=new User();
  	user=dao.getUsertbyEmail(email);
  	PossedeExperience possedeExperience=new PossedeExperience();
  	PossedeCompetence possedecompetence=new PossedeCompetence();
  	
  	Loisir loisir=new Loisir();
  	AimeLoisir aimeloisir=new AimeLoisir();
  	
  	Formation formation=new Formation();
  	EstTitulaireFormation esttutilairefromation=new EstTitulaireFormation();
  	
  	Langue langue=new Langue();
  	ParleLangue parlelangue=new ParleLangue();
  	
	Titre titreCv=new Titre();
	Intitule intituler=new Intitule();
  	
  	if(nomCompetence!=null)
  	{
  		competence.setDescription(descCompetence);
  	  	competence.setNom(nomCompetence);
  	  	//creation de la competence
  	  	dao.createOrUpdateCompetence(competence);
  	  	//Mise a jour de la table PossedeCompetence
  	  	possedecompetence.getCompetenceid().setCompetenceId(competence);
  	  	possedecompetence.getCompetenceid().setUserId(user);
  	  	dao.createOrUpdatePossedeCompetence(possedecompetence);
  	  	
  	}else if(employeur!=null)
  	{
  		
  		experience.setDatedebut(datedebut);
  	  	experience.setDatefin(datefin);
  	  	experience.setDescriptionExp(description);
  	  	experience.setNomEntreprise(employeur);
  	  	experience.setNomExp(titre);
  	  	
  	  	//Creation de l'experience en base
  	  	dao.createOrUpdateExperience(experience);
  	  	//Mise a jour de la table PossedeExperience
  	  	possedeExperience.getContientid().setExperienceId(experience);
  	  	possedeExperience.getContientid().setUserId(user);
  	  	dao.createOrUpdatePossedeExperience(possedeExperience);
  	}else if(titreFormation!=null){
  		formation.setDescription(descFormation);
  		formation.setTitre(titreFormation);
  		formation.setNiveau(niveauFormation);
  		formation.setDomaine(domaineFormation);
  		formation.setOrigine(origineFormation);
  		formation.setDateFormation(dateFormation);
  		formation.setDiplomeObtenu(diplomef);
  		
  		dao.createOrUpdateFormation(formation);
  		
	 esttutilairefromation.getEstTitulaireId().setFormationId(formation);
	 esttutilairefromation.getEstTitulaireId().setUserId(user);
	 dao.createOrUpdateEstTitulaireFormation(esttutilairefromation);
  		
  		
  	}else if(nomlangue!=null && nomloisir==null){
  		langue.setNom(nomlangue);
  		langue.setNiveau(niveaulangue);
  	     dao.createOrUpdateLangue(langue);
  	     parlelangue.getParleid().setLangueId(langue);
  	     parlelangue.getParleid().setUserId(user);
  	     dao.createOrUpdateParleLangue(parlelangue);
  		
  	}else if(nomloisir!=null){
  		System.out.println("debut d'enregistement dans la table loisir");
  		loisir.setNom(nomloisir);
  		dao.createOrUpdateLoisir(loisir);
  		System.out.println("Fin d'enregistement dans la table loisir");
  		aimeloisir.getLoisirId().setLoisirid(loisir);
  		aimeloisir.getLoisirId().setUserId(user);
  		dao.createOrUpdateAimeLoisir(aimeloisir);
  		
  	}if(nomTitre!=null && !nomTitre.equals(" ") )	{
  		ArrayList<Titre> titres=dao.getAllTitreByUser(email);
  		for(Titre titr:titres){
  			titr.setEstChoisi(false);
  			dao.createOrUpdateTitre(titr);
  		}
  		
  		System.out.println("Ok pour le titre");
  		
  		titreCv=dao.getTitreByNameAndUser(email,nomTitre);
  		
  		if(titreCv!=null)
  		{
  			System.out.println(" existe titre");
  			titreCv.setEstChoisi(true);
  			dao.createOrUpdateTitre(titreCv);
//  			intituler.getIntituleId().setIdTitre(titreCv);  			
//  			intituler.getIntituleId().setUserId(user);
//  			dao.createOrUpdateIntitule(intituler);
  		}else if(titreCv==null	)
  		{
  			System.out.println("existe pas titre");
  			Titre title=new Titre();
  			title.setNomTitre(nomTitre);
  			title.setEstChoisi(true);
  			dao.createOrUpdateTitre(title);
  			intituler.getIntituleId().setTitreId(title);  			
  			intituler.getIntituleId().setUserId(user);
  			dao.createOrUpdateIntitule(intituler);
  		}
  		
  		
  	}else if(nomNewTitre!=null && nomNewTitre!=" ")
  	{
  		ArrayList<Titre> titres=dao.getAllTitreByUser(email);
  		for(Titre titr:titres){
  			titr.setEstChoisi(false);
  			dao.createOrUpdateTitre(titr);
  		}
  		
  		System.out.println("Ok pour new titre");
  		titreCv=dao.getTitreByNameAndUser(email,nomNewTitre);
  		System.out.println("Ok pour new titre au titreCV");
  		if(titreCv!=null)
  		{
  			System.out.println("Ok titre trouver");
  			titreCv.setEstChoisi(true);
  			dao.createOrUpdateTitre(titreCv);  			
//  			intituler.getIntituleId().setIdTitre(titreCv);  			
//  			intituler.getIntituleId().setUserId(user);
//  			dao.createOrUpdateIntitule(intituler);
  		}else if(titreCv==null)
  		{
  			System.out.println("Ok titre non trouver");
  			Titre titrenew=new Titre();
  			titrenew.setNomTitre(nomNewTitre);
  			titrenew.setEstChoisi(true);
  			dao.createOrUpdateTitre(titrenew);
  			intituler.getIntituleId().setTitreId(titrenew);  			
  			intituler.getIntituleId().setUserId(user);
  			dao.createOrUpdateIntitule(intituler);
  		}
  		
  		
  	}
  
  
 	 return new RedirectView("Cv");
	              
 }

@RequestMapping(value = {"/AnuaireEntreprise"}, method = RequestMethod.POST)
public RedirectView AnuaireEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 	MappingDao dao = MappingDao.getInstance();
 	System.out.println("OKK=============> je suis dans l'annuaire");
 	 String nom = request.getParameter("nom");
	String chiffre = request.getParameter("chiffre");
 	String description=request.getParameter("description"); 
 	String domaine = request.getParameter("domaine");
	String adresse = request.getParameter("adresse");
  	String datecreate=request.getParameter("datecreate"); 
  	String tel=request.getParameter("tel"); 
  	Annuaire annuaire=new Annuaire();
  	annuaire.setAdresse(adresse);
  	//System.out.print("file"+request.getParameter("file"));
  	int chifAffaire=Integer.parseInt(chiffre);
  	annuaire.setChiffreAffaire(chifAffaire);
 	 annuaire.setDatecreation(datecreate);
 	 annuaire.setDomaine(domaine);
 	 annuaire.setNomEntreprise(nom);
 	 annuaire.setTelephone(tel);
 	 annuaire.setDescription(description);
 	 //telechargement de logo
// 	String path=new File("").getAbsolutePath(); 
// 	
// 	File fileSaveDir = new File(path);
//	if (!fileSaveDir.exists()) {
//	fileSaveDir.mkdir();
//	}		
//	for (Part part : request.getParts()) {
//	String fileName = extractFileName(part);
//	part.write(path +File.separator+fileName);		
//	//copie		
//	File srcFolder = new File(path +File.separator+fileName);
//    String destFolder = new String("/home/diallo/Offre/src/main/webapp/ressources/logoAnnuaire/");
//    CopyFiles cf = new CopyFiles();
//    cf.copyDirectory(srcFolder, destFolder);
//    annuaire.setLogo("/Offre/ressources/photo/"+fileName);
    dao.createOrUpdateAnnuaire(annuaire);
             
 
	 return new RedirectView("annuaire");
}

@SuppressWarnings("unused")
@RequestMapping(value = {"/Message"}, method = RequestMethod.POST)
public RedirectView Messag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //System.out.print("voici les paramettres"+request.getParameterMap());
	MappingDao dao = MappingDao.getInstance();
 	String expeditaire = request.getParameter("email");
 	String codeoffre = request.getParameter("code");
	String nom = request.getParameter("nom");
 	String prenom=request.getParameter("prenom"); 
 	String objet=request.getParameter("objet"); 
	String messageText=request.getParameter("message");
	String cvjoint=request.getParameter("cvjoint");
	String destinataire=request.getParameter("dest");
	String expNewMsg=request.getParameter("expNewMsg");	
	String expNewMsgCli=request.getParameter("clientDest");
	//_________________User est distinataire___________
	
	//String userDest=request.getParameter("userDest");
	String clientDest=request.getParameter("clientDest");
	String idmgsExterne=request.getParameter("emailDestExterne");
	
	Date dateEnvoie=new Date();
	Offre offre=new Offre();
	System.out.println("CV joint"+cvjoint);
	System.out.println("expNewMsgCli"+expNewMsgCli);
	Date datePostule=new Date();
	Postule postuler=new Postule();
	/**
	 * on regarde si le destinataire a été envoyé dans les parametres 
	 */
	if(destinataire!=null)
	{
		System.out.println("destinataire different de null");
		System.out.println("Je suis bien dans le bon endroit");
		System.out.println("l'email du destinataire est::"+destinataire);
		EnvoieMessage envoiMsg=new EnvoieMessage();
		MessageEnvoye messageEnv=new MessageEnvoye();
		User u=new User();
		Client cli=new Client();
		cli=dao.getClientbyEmail(destinataire);
		u=dao.getUsertbyEmail(expeditaire);
		messageEnv.setDestinataire(destinataire);
		messageEnv.setExpeditaire(expeditaire);
		messageEnv.setObjetMessage(objet);
		
		messageEnv.setStatutMessage(false);
		messageEnv.setSupprimer(false);
		offre=dao.getOffrebyCode(codeoffre);
		System.out.println("voici le code de l'offre"+codeoffre);
	
		postuler.setDatePostule(datePostule);
		postuler.getPostuleid().setOffreId(offre);
		postuler.getPostuleid().setUserId(u);
		if(cvjoint.equals("oui")){
			messageEnv.setUrlcvjoint(u.getUrlCV());
		}else{
			messageEnv.setMessagText(messageText);
		}
		dao.createOrUpdateMessageEnvoye(messageEnv);
		dao.createOrUpdatePostule(postuler);
//		_________________________________________
		
		envoiMsg.setDateEnvoi(dateEnvoie);
		envoiMsg.getMessageid().setClientId(cli);
		envoiMsg.getMessageid().setUserId(u);
		envoiMsg.getMessageid().setMsgId(messageEnv);
		
		/**
		 * Ajout du message en base
		 */
		System.out.println("debut d'enregistrement");
		
		System.out.println("----message ok----");
		dao.createOrUpdateMessage(envoiMsg);
		System.out.println("=====envoi ok====");
		
		
	}else if(clientDest!=null)
	{
		System.out.println("clientDest different de null");
		EnvoieMessage envoiMsg=new EnvoieMessage();
		MessageEnvoye messageEnv=new MessageEnvoye();
		
		User useDest=new User();
		
		Client cliDest=new Client();
		
		User userExp=new User();
		Client cliExp=new Client();
		
		useDest=dao.getUsertbyEmail(clientDest);		
		userExp=dao.getUsertbyEmail(expeditaire);
		
		cliExp=dao.getClientbyEmail(expeditaire);		
		cliDest=dao.getClientbyEmail(clientDest);
		
		if(cliDest!=null){
		
			
			messageEnv.setDestinataire(clientDest);
			messageEnv.setExpeditaire(expeditaire);
			messageEnv.setObjetMessage(objet);
			messageEnv.setMessagText(messageText);
			messageEnv.setStatutMessage(false);
			messageEnv.setSupprimer(false);
			offre=dao.getOffrebyCode(codeoffre);
			postuler.setDatePostule(datePostule);
			postuler.getPostuleid().setOffreId(offre);
			postuler.getPostuleid().setUserId(userExp);
			if(cvjoint!=null){
			if(cvjoint.equals("oui")){
				messageEnv.setUrlcvjoint(cvjoint);
				dao.createOrUpdatePostule(postuler);
			}
			}
			
			dao.createOrUpdateMessageEnvoye(messageEnv);
			
	//		_________________________________________
			
			envoiMsg.setDateEnvoi(dateEnvoie);
			envoiMsg.getMessageid().setClientId(cliDest);
			envoiMsg.getMessageid().setUserId(userExp);
			envoiMsg.getMessageid().setMsgId(messageEnv);
			
			/**
			 * Ajout du message en base
			 */
			System.out.println("debut d'enregistrement");
			
			System.out.println("----message ok----");
			dao.createOrUpdateMessage(envoiMsg);
			System.out.println("=====envoi ok====");
		}else 
			
			if(useDest!=null){
				
				EnvoieMessage envoiMg=new EnvoieMessage();
				MessageEnvoye messagEnv=new MessageEnvoye();
			
			
				messagEnv.setDestinataire(clientDest);
				messagEnv.setExpeditaire(expeditaire);
				messagEnv.setObjetMessage(objet);
				messagEnv.setMessagText(messageText);
				messagEnv.setStatutMessage(false);
				messagEnv.setSupprimer(false);
				dao.createOrUpdateMessageEnvoye(messagEnv);
//				_________________________________________
				
				envoiMg.setDateEnvoi(dateEnvoie);
				envoiMg.getMessageid().setClientId(cliExp);
				envoiMg.getMessageid().setUserId(useDest);
				envoiMg.getMessageid().setMsgId(messagEnv);
				
				/**
				 * Ajout du message en base
				 */
				System.out.println("debut d'enregistrement");				
				System.out.println("----message ok----");
				dao.createOrUpdateMessage(envoiMg);
				System.out.println("=====envoi ok====");
			}
			
		
	}else if(idmgsExterne!=null){
		
		try {
			dao.EnvoiMail(idmgsExterne, messageText);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("Le message lui a été envoyé avec succés");

	 }else if(expNewMsg!=null){
		 
				System.out.println("expNewMsg different de null");
				EnvoieMessage envoiMsg=new EnvoieMessage();
				MessageEnvoye messageEnv=new MessageEnvoye();
				User candidatDest=new User();
				User candidatExp=new User();
				Client employeurDest=new Client();
				Client employeurExp=new Client();
				
				employeurDest=dao.getClientbyEmail(expeditaire);
				employeurExp=dao.getClientbyEmail(expNewMsg);
				
				candidatDest=dao.getUsertbyEmail(expeditaire);
				candidatExp=dao.getUsertbyEmail(expNewMsg);
				
				messageEnv.setDestinataire(expeditaire);
				messageEnv.setExpeditaire(expNewMsg);
				messageEnv.setObjetMessage(objet);
				messageEnv.setMessagText(messageText);
				messageEnv.setStatutMessage(false);
				messageEnv.setSupprimer(false);
				
				dao.createOrUpdateMessageEnvoye(messageEnv);
				envoiMsg.setDateEnvoi(dateEnvoie);
				
				
			
				
				
				if(employeurDest!=null && candidatExp!=null)
				{
					System.out.println("candidat a employeur okkkk");				
					envoiMsg.getMessageid().setClientId(employeurDest);
					envoiMsg.getMessageid().setUserId(candidatExp);
					
					envoiMsg.getMessageid().setMsgId(messageEnv);				
					/**
					 * Ajout du message en base
					 */
					System.out.println("debut d'enregistrement");				
					System.out.println("----message ok----");
					dao.createOrUpdateMessage(envoiMsg);
					System.out.println("=====envoi ok====");
				}else if(candidatDest!=null && employeurExp!=null)
				{
					System.out.println("employeur a candidat okkkk");
					
					envoiMsg.getMessageid().setClientId(employeurExp);
					envoiMsg.getMessageid().setUserId(candidatDest);
					
					envoiMsg.getMessageid().setMsgId(messageEnv);				
					/**
					 * Ajout du message en base
					 */
					System.out.println("debut d'enregistrement");				
					System.out.println("----message ok----");
					dao.createOrUpdateMessage(envoiMsg);
					System.out.println("=====envoi ok====");
				}
				
				else{
					 System.out.println("l'email du destinataire n'existe pas");
			    	 // response.sendRedirect("Erreur?mailNotfound=mailerror");
				}
//				_________________________________________
				
				
				
				
				
				
				
				

				
				
				
				
//	 }else if(expNewMsgCli!=null){
//		 
//			System.out.println("expNewMsgCli different de null");
//			EnvoieMessage envoiMsg=new EnvoieMessage();
//			MessageEnvoye messageEnv=new MessageEnvoye();
//			User u=new User();
//			Client cli=new Client();
//			cli=dao.getClientbyEmail(expNewMsgCli);
//			u=dao.getUsertbyEmail(expeditaire);
//			messageEnv.setDestinataire(expeditaire);
//			messageEnv.setExpeditaire(expNewMsgCli);
//			messageEnv.setObjetMessage(objet);
//			messageEnv.setMessagText(messageText);
//			messageEnv.setStatutMessage(false);
//			messageEnv.setSupprimer(false);
//			dao.createOrUpdateMessageEnvoye(messageEnv);
////			_________________________________________
//			
//			envoiMsg.setDateEnvoi(dateEnvoie);
//			envoiMsg.getMessageid().setClientId(cli);
//			envoiMsg.getMessageid().setUserId(u);
//			envoiMsg.getMessageid().setMsgId(messageEnv);
//			
//			/**
//			 * Ajout du message en base
//			 */
//			System.out.println("debut d'enregistrement");
//			
//			System.out.println("----message ok----");
//			dao.createOrUpdateMessage(envoiMsg);
//			System.out.println("=====envoi ok====");
//			
}else if(destinataire==null  && expNewMsg==null && clientDest==null && idmgsExterne==null){
	System.out.println("==========je suis dans externUserMessage===============");
		ExterneUserMessage externUserMsg=new ExterneUserMessage();
		externUserMsg.setDateEnvoie(dateEnvoie);
		externUserMsg.setEmail(expeditaire);
		externUserMsg.setEmailDest("kasadouzl@hotmail.fr");
		externUserMsg.setMessageText(messageText);
		externUserMsg.setNom(nom);
		externUserMsg.setPrenom(prenom);
		externUserMsg.setObjet(objet);	
		externUserMsg.setStatutMessage(false);
		externUserMsg.setSupprimer(false);
		if(externUserMsg!=null)
		{
			dao.createOrUpdateExternUsermessage(externUserMsg);
			System.out.println("ajout ok");
		}else{
			
			System.out.println("erreur d'enregistrement");
		}

	 	
	 }
		 return new RedirectView("Home");
	     	
	}


//Rechercher un CV
@RequestMapping(value = {"/SearchCV"},method=RequestMethod.POST)
public ModelAndView SearchCV(HttpServletRequest request, HttpServletResponse response) {
	   String lieu=request.getParameter("lieu");
	   String titre=request.getParameter("titre");
		request.setAttribute("titre", titre);
		request.setAttribute("lieu", lieu);
    return new ModelAndView("ListeUser");
}

@RequestMapping(value = {"/connectFB"})
public RedirectView ConnectFB(HttpServletRequest request, HttpServletResponse response) throws IOException {

    MappingDao dao = MappingDao.getInstance();
    User user = new User();
    String mail = request.getParameter("email");
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");
    String id = request.getParameter("id");
    System.out.println("le nom de l'utilsateur Facebook  est :" + " " + nom);
    System.out.println("le prenom de l'utilsateur Facebook  est :" + " " + prenom);
    System.out.println("l'email de l'utilsateur Facebook  est :" + " " + mail);
    System.out.println("le mot de passe de l'utilsateur Facebook  est :" + " " + id);
    user = dao.getUsertbyEmail(mail);
    request.getSession().setAttribute("user", user);
    System.out.println(" l'utilsateur Facebook  est :" + " " + user);
    if (user != null) {
        
    	return new RedirectView("Home");

    } else if (mail != null) {
        user = new User();
        user.setEmail(mail);
        user.setPassword(id);
        user.setPrenom(prenom);
        user.setNom(nom);
        
        dao.createOrUpdateUser(user);
        
        return new RedirectView("Home");
    }

    return new RedirectView("Home");
}



/**
 * fonction pour recuperer le nom d'un fichier ou image telecharge dans le site
 * @param part
 * @return
 */
private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
	if (s.trim().startsWith("filename")) {
		return s.substring(s.indexOf("=") + 2, s.length()-1);
		}

    }
    	return " ";
}




}
