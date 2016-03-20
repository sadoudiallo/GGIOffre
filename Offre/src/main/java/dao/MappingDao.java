package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modele.*;

public class MappingDao {
	
	   private static MappingDao instance;
	    private static EntityManager entityM;
	   
	    private MappingDao() {
	        this.entityM = Persistence.createEntityManagerFactory("offre").createEntityManager();
	    }
	    
	    public static MappingDao getInstance() {
	        if(instance == null) {
	            synchronized (MappingDao.class) {
	                if (instance == null) {
	                    instance = new MappingDao();
	                }
	            }
	        }
	        
	        return instance;
	    }
	    
	    /**
	     * creation d'un user
	     * @param u
	     */
	    public  void createOrUpdateUser(User u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(User.class, u.getIdUser()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	    /**
	     * creation d'alert
	     * @param u
	     */
	    public  void createOrUpdateAlert(Alert u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(Alert.class, u.getIdAlert()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	    /**
	     * 
	     * @param u
	     */
	   
	    
	    /**
	     * creation d'un client
	     * @param c
	     */
	    public  void createOrUpdateClient(Client c)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(Client.class, c.getID()) == null){
	            
	            entityM.persist(c);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(c);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	    /**
	     * creation d'une competence
	     * @param u
	     */
	    
	    public  void createOrUpdateCompetence(Competence u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(Competence.class, u.getIdcomp()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	    
	    /**
	     * creation d'une experience
	     * @param u
	     */
	    public  void createOrUpdateExperience(Experience u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(Experience.class, u.getIdExp()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	    public  void createOrUpdatePossedeExperience(PossedeExperience u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(PossedeExperience.class, u.getContientid()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    public  void createOrUpdatePossedeCompetence(PossedeCompetence u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(PossedeCompetence.class, u.getCompetenceid()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	    /**
	     * creation d'une offre
	     * @param u
	     */
	    public  void createOrUpdateOffre(Offre u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(Offre.class, u.getCode()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	    /**
	     * creation d'une paie
	     * @param u
	     */
	    public  void createOrUpdatePaie(Paie u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(User.class, u.getNumPaie()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	    /**
	     * 
	     * @param u
	     */
	    public  void createOrUpdateMessageEnvoye(MessageEnvoye u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(MessageEnvoye.class, u.getIdM()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    /**
	     * 
	     * @param u
	     */
	    public void createOrUpdateFormation(Formation u) {
	    	// TODO Auto-generated method stub
	    		entityM.getTransaction().begin();
	        
	        if(entityM.find(Formation.class, u.getIdF()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }         
	    	
	    }
	    
	    
	/**
	 * 
	 * @param u
	 */
	    public void createOrUpdateLangue(Langue u) {
	    	// TODO Auto-generated method stub
	    		entityM.getTransaction().begin();
	        
	        if(entityM.find(Langue.class, u.getIdL()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }         
	    	
	    }
	    /**
	     * 
	     * @param u
	     */
	    public void createOrUpdateParleLangue(ParleLangue u) {
	    	// TODO Auto-generated method stub
	    		entityM.getTransaction().begin();
	        
	        if(entityM.find(ParleLangue.class, u.getParleid()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }         
	    	
	    }
	    
	    public void createOrUpdateLoisir(Loisir u) {
	    	// TODO Auto-generated method stub
	    		entityM.getTransaction().begin();
	        
	        if(entityM.find(Loisir.class, u.getIdloisir()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }         
	    	
	    }  
	    
	    public void createOrUpdateAimeLoisir(AimeLoisir u) {
	    	// TODO Auto-generated method stub
	    		entityM.getTransaction().begin();
	        
	        if(entityM.find(AimeLoisir.class, u.getLoisirId()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }         
	    	
	    } 
	    
	    /**
	     * Creation de titre d'un cv
	     * @param u
	     */
	    public void createOrUpdateTitre(Titre u) {
	    	// TODO Auto-generated method stub
	    		entityM.getTransaction().begin();
	        
	        if(entityM.find(Titre.class, u.getIDT()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }         
	    	
	    } 
	    
	    
	    /**
	     * creation d'un intitule de titre
	     * @param u
	     */
	    public void createOrUpdateIntitule(Intitule u) {
	    	// TODO Auto-generated method stub
	    		entityM.getTransaction().begin();
	    		
		        if(entityM.find(Intitule.class, u.getIntituleId()) == null){		            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
		        } else {
		            entityM.merge(u);
		            entityM.getTransaction().commit();
		        }         
	    	
	    }
	    
	    
	    
	    public void createOrUpdateEstTitulaireFormation(EstTitulaireFormation u) {
	    	// TODO Auto-generated method stub
	    		entityM.getTransaction().begin();
	        
	        if(entityM.find(EstTitulaireFormation.class, u.getEstTitulaireId()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }         
	    	
	    }
	    
	    public  void createOrUpdateMessage(EnvoieMessage u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(EnvoieMessage.class, u.getMessageid()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    /**
	     * creer un message d'un utilisateur non inscrit dans le site
	     * @param u
	     */
	    public  void createOrUpdateExternUsermessage(ExterneUserMessage u)
	    {        
	        entityM.getTransaction().begin();
	        
	        if(entityM.find(ExterneUserMessage.class, u.getId()) == null){
	            
	            entityM.persist(u);
	            entityM.getTransaction().commit();
	        } else {
	            entityM.merge(u);
	            entityM.getTransaction().commit();
	        }                        
	    }
	    
	  /**
	   * getUser by Id
	   * @param id
	   * @return
	   */
	    
	    public  Client getClienttbyId(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Client> result =(ArrayList<Client>) entityM.createNamedQuery("Client.getId").setParameter("_id",id).getResultList();
	        if(result.isEmpty())
	        {
	            System.out.print("Client non trouve");
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    
	    
	    public  Client getClientbyEmail(String email)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Client> result =(ArrayList<Client>) entityM.createNamedQuery("Client.getClientByEmail").setParameter("_email",email).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    
	    public  ArrayList<Client> getClientbyStatut(String statut)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Client> result =(ArrayList<Client>) entityM.createNamedQuery("Client.getClientByStatut").setParameter("_statut",statut).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result;
	        }
	        
	    }
	    
	    /**
	     * 
	     * @param email
	     * @return
	     */
	
	    
	    public  long getCountMessagebyEmail(String email) {
	        
	        @SuppressWarnings("unchecked")
	      long result =(long) entityM.createNamedQuery("ExterneUserMessage.getCountMessagebyEmail").setParameter("_email",email).getSingleResult();
	        if(result==0)
	        {
	            return 0;
	        }else{
	            
	            return result;
	        }
	        
	    }
	    
	    
	   
	    /**
	     *
	     * @param email
	     * @param password
	     * @return
	     */
	    public   Client getClientByEmailPwd(String email,String password)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Client> result =(ArrayList<Client>) entityM.createNamedQuery("Client.getClientByEmailPwd").setParameter("email",email).setParameter("password",password).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	   
	  
	    
	    /**
	     *
	     * @return
	     */
	    public  ArrayList<Experience> getAllExperience()
	    {
	        @SuppressWarnings("unchecked")
	                ArrayList<Experience> result =(ArrayList<Experience>) entityM.createNamedQuery("Experience.getAllExperience").getResultList();
	        return result;
	    }
	    
	    public  ArrayList<Competence> getAllCompetence()
	    {
	        @SuppressWarnings("unchecked")
	                ArrayList<Competence> result =(ArrayList<Competence>) entityM.createNamedQuery("Competence.getAllCompetence").getResultList();
	        return result;
	    }
	    
	    public  ArrayList<Client> getAllClient()
	    {
	        @SuppressWarnings("unchecked")
	                ArrayList<Client> result =(ArrayList<Client>) entityM.createNamedQuery("Client.getAllClient").getResultList();
	        return result;
	    }
	    
	    
	    
	    public  User getUserbyId(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<User> result =(ArrayList<User>) entityM.createNamedQuery("User.getId").setParameter("_id",id).getResultList();
	        if(result.isEmpty())
	        {
	            System.out.print("User non trouve");
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	   
	    /**
	     * Retourner toutes les competences d'un utilisateur
	     * @param id
	     * @return
	     */
	    public  ArrayList<Competence> getAllCompetenceByIdUser(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Competence> result =(ArrayList<Competence>) entityM.createNamedQuery("Competence.getAllCompetenceByIdUser").setParameter("_id",id).getResultList();
	    	         return result;
	      
	        
	    }
	    /**
	     * 
	     * @param id
	     * @return
	     */
	    public  ArrayList<Experience> getAllExperienceByIdUser(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Experience> result =(ArrayList<Experience>) entityM.createNamedQuery("Experience.getAllExperienceByIdUser").setParameter("_id",id).getResultList();
	    	         return result;
	      
	        
	    }
	    /**
	     * 
	     * @param id
	     * @return
	     */
	    public  ArrayList<Formation> getAllFormationByIdUser(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Formation> result =(ArrayList<Formation>) entityM.createNamedQuery("Formation.getAllFormationByIdUser").setParameter("_id",id).getResultList();
	    	         return result;
	      
	        
	    }
	    /**
	     * 
	     * @param id
	     * @return
	     */
	    public  ArrayList<Langue> getAllLangueByIdUser(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Langue> result =(ArrayList<Langue>) entityM.createNamedQuery("Langue.getAllLangueByIdUser").setParameter("_id",id).getResultList();
	    	         return result;
	  
	    }
	    
	    
	    
	/**
	 * Renvoyer tous les titres    
	 * @param id
	 * @return
	 */
	    
	    public  ArrayList<Titre> getAllTitreByUser(String id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Titre> result =(ArrayList<Titre>) entityM.createNamedQuery("Titre.getAllTitreByUser").setParameter("_email",id).getResultList();
	    	         return result;
	  
	    }
	    
	    public  Titre getTitreByUser(String id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Titre> result =(ArrayList<Titre>) entityM.createNamedQuery("Titre.getTitreByUser").setParameter("_email",id).getResultList();
	        if(result.isEmpty())
	        {
	            System.out.print("User non trouve");
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	  
	    }
	    
	    /**
	     * 
	     * @param id
	     * @return
	     */ 
	    public  Titre getTitreByNameAndUser(String email,String nom)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Titre> result =(ArrayList<Titre>) entityM.createNamedQuery("Titre.getTitreByNameAndUser").setParameter("_email", email).setParameter("_nom",nom).getResultList();
	    	        
	        
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	  
	    }
	     
	     
	    
	     
	     public  ArrayList<User> getAllUserByTitrename(String nom)
		    {
		        
		        @SuppressWarnings("unchecked")
		                ArrayList<User> result =(ArrayList<User>) entityM.createNamedQuery("Titre.getAllUserByTitrename").setParameter("_nomtitre",nom).getResultList();
		        
			        if(result.isEmpty())
			        {
			            return null;
			        }else{
			            
			            return result;
			        }
		        }
	
	    
	    public  ArrayList<User> getAllUserByTitrenameEtLieu(String nom, String lieu)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<User> result =(ArrayList<User>) entityM.createNamedQuery("Titre.getAllUserByTitrenameEtLieu").setParameter("_nomtitre",nom).setParameter("_lieu", lieu).getResultList();
	        
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result;
	        }
	        }

	   /**
	    * Renvoyer tous les titres
	    * @return
	    */
	    
	    public  ArrayList<Titre> getAllTitre()
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Titre> result =(ArrayList<Titre>) entityM.createNamedQuery("Titre.getAllTitre").getResultList();
	    	         return result;
	  
	    }
	    /**
	     * 
	     * @param id
	     * @return
	     */
	    public  ArrayList<Loisir> getAllLoisirByIdUser(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Loisir> result =(ArrayList<Loisir>) entityM.createNamedQuery("Loisir.getAllLoisirByIdUser").setParameter("_id",id).getResultList();
	    	         return result;
	      
	        
	    }
	    
	    public  User getUsertbyEmail(String email)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<User> result =(ArrayList<User>) entityM.createNamedQuery("User.getUserByEmail").setParameter("_email",email).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    
	    
	    public  ArrayList<User> getUsertbyTitre(String titre)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<User> result =(ArrayList<User>) entityM.createNamedQuery("User.getUserByTitre").setParameter("_titre",titre).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result;
	        }
	        
	    }
	   
	    /**
	     *
	     * @param email
	     * @param password
	     * @return
	     */
	    public   User getUserByEmailPwd(String email,String password)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<User> result =(ArrayList<User>) entityM.createNamedQuery("User.getUserByEmailPwd").setParameter("email",email).setParameter("password",password).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    
	    /**
	     *
	     * @return
	     */
	    public  ArrayList<User> getAllUser()
	    {
	        @SuppressWarnings("unchecked")
	                ArrayList<User> result =(ArrayList<User>) entityM.createNamedQuery("User.getAllUser").getResultList();
	        return result;
	    }
	    
	    /**
	     * Offre
	     */
	    
	    
	    public  Offre getOffrebyCode(String id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Offre> result =(ArrayList<Offre>) entityM.createNamedQuery("Offre.getCode").setParameter("_id",id).getResultList();
	        if(result.isEmpty())
	        {
	            
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    
	    
	    public  ExterneUserMessage getExterneUserMessageById(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<ExterneUserMessage> result =(ArrayList<ExterneUserMessage>) entityM.createNamedQuery("ExterneUserMessage.getId").setParameter("_id",id).getResultList();
	        if(result.isEmpty())
	        {
	            System.out.print("Message non trouve");
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    
	    
	    
	    public  Offre getOffreByAdresse(String add)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Offre> result =(ArrayList<Offre>) entityM.createNamedQuery("Offre.getOffreByAdresse").setParameter("_adresse",add).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    /**
	     * 
	     * @param titre
	     * @param lieu
	     * @return
	     */
	    public   ArrayList<Offre> getOffreByTitreEtLieu(String titre, String lieu)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Offre> result =(ArrayList<Offre>) entityM.createNamedQuery("Offre.getOffreByTitreEtLieu").setParameter("title",titre).setParameter("_lieu", lieu).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result;
	        }
	        
	    }
	    
	  
	    /**
	     * 
	     * @param d
	     * @param n
	     * @return
	     */
	    public   ArrayList<Annuaire> getAnnuaireByDomaineNomAdresse(String d, String n)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Annuaire> result =(ArrayList<Annuaire>) entityM.createNamedQuery("Annuaire.getAnnuaireByDomaineNomAdresse").setParameter("domaine",d).setParameter("adresse", n).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result;
	        }
	        
	    }
	    /**
	     * Get annuaire by id
	     * @param id
	     * @return
	     */
	    public  Annuaire getAnnuaireById(int id)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Annuaire> result =(ArrayList<Annuaire>) entityM.createNamedQuery("Annuaire.getAnnuaireById").setParameter("_id",id).getResultList();
	        if(result.isEmpty())
	        {
	            System.out.print("Annuaire non trouve");
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    
	    /**
	     * renvoyer les offres d'un client
	     * @param c
	     * @return
	     */
	    public   ArrayList<Offre> getOffreByClient(String c)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Offre> result =(ArrayList<Offre>) entityM.createNamedQuery("Offre.getOffreByClient").setParameter("email",c).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result;
	        }
	        
	    }
	    
	    /**
	     * Renvoyer les offres auxquelles un utilisateur a postulées
	     * @param c
	     * @return
	     */
	    public   ArrayList<Offre> getAllOffreByUser(String c)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Offre> result =(ArrayList<Offre>) entityM.createNamedQuery("Postule.getAllOffreByUser").setParameter("email",c).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result;
	        }
	        
	    }
	    
	    
	   
	/**
	 * 
	 * @param titre
	 * @return
	 */
	    public   Offre getUserByTitre(String titre)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<Offre> result =(ArrayList<Offre>) entityM.createNamedQuery("Offre.getOffreByTitreEtLieu").setParameter("_titre",titre).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    /** 
	     * 
	     * @param email
	     * @return
	     */
	    
	    public   ExterneUserMessage  getAllExterneUserMessagebydUser(String email)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<ExterneUserMessage> result =(ArrayList<ExterneUserMessage>) entityM.createNamedQuery("ExterneUserMessage.getAllExterneUserMessagebydUser").setParameter("_email",email).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    /**
	     * 
	     * @param email
	     * @return
	     */
	    public   ExterneUserMessage  getAllExterneUserMessagebyDest(String email)
	    {
	        
	        @SuppressWarnings("unchecked")
	                ArrayList<ExterneUserMessage> result =(ArrayList<ExterneUserMessage>) entityM.createNamedQuery("ExterneUserMessage.getAllExterneUserMessagebyDest").setParameter("_email",email).getResultList();
	        if(result.isEmpty())
	        {
	            return null;
	        }else{
	            
	            return result.get(0);
	        }
	        
	    }
	    /**
	     * 
	     * @return
	     */
	    public  ArrayList<ExterneUserMessage> getAllExterneUserMessage()
	    {
	        @SuppressWarnings("unchecked")
	                ArrayList<ExterneUserMessage> result =(ArrayList<ExterneUserMessage>) entityM.createNamedQuery("ExterneUserMessage.getAllExterneUserMessage").getResultList();
	        return result;
	    }
	    
	    
	  

	    
	    /**
	     *
	     * @return
	     */
	    public  ArrayList<Offre> getAllOffre()
	    {
	        @SuppressWarnings("unchecked")
	                ArrayList<Offre> result =(ArrayList<Offre>) entityM.createNamedQuery("Offre.getAllOffre").getResultList();
	        return result;
	    }
	    
	   
	/**
	 * 
	 * @param destinataire
	 * @param message
	 * @throws AddressException
	 * @throws MessagingException
	 */
	 
		public static void EnvoiMail(String destinataire, String message) throws AddressException, MessagingException {
              
			 Properties mailServerProperties;
				 Session getMailSession;
				 MimeMessage generateMailMessage;
				
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.port", "587");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.starttls.enable", "true");
                        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));		
			generateMailMessage.setSubject("Creation De compte");
			generateMailMessage.setContent(message,"text/html");
			Transport transport = getMailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", "kasadouz5@gmail.com", "gnakagnaka64");
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();  
		}
		
	   
	    public  ArrayList<MessageEnvoye> getAllMessage()
	    {
	        @SuppressWarnings("unchecked")
	                ArrayList<MessageEnvoye> result =(ArrayList<MessageEnvoye>) entityM.createNamedQuery("MessageEnvoye.getAllMessage").getResultList();
	        return result;
	    }
		
		
		
		  public   MessageEnvoye getMessageById(int id)
		    {
		        
		        @SuppressWarnings("unchecked")
		                ArrayList<MessageEnvoye> result =(ArrayList<MessageEnvoye>) entityM.createNamedQuery("MessageEnvoye.getMessageById").setParameter("_id",id).getResultList();
		        if(result.isEmpty())
		        {
		            return null;
		        }else{
		            
		            return result.get(0);
		        }
		        
		    }
		
		  
		  public   ArrayList<MessageEnvoye> getAllMessageRecuByClient(String dest)
		    {
		        
		        @SuppressWarnings("unchecked")
		                ArrayList<MessageEnvoye> result =(ArrayList<MessageEnvoye>) entityM.createNamedQuery("MessageEnvoye.getAllMessageRecuByClient").setParameter("dest",dest).getResultList();
		        if(result.isEmpty())
		        {
		            return null;
		        }else{
		            
		            return result;
		        }
		        
		    }
		  
		  /**
		   * 
		   * @param dest
		   * @return
		   */
		  public   ArrayList<MessageEnvoye> getAllMessageSupByClient(String dest)
		    {
		        
		        @SuppressWarnings("unchecked")
		                ArrayList<MessageEnvoye> result =(ArrayList<MessageEnvoye>) entityM.createNamedQuery("MessageEnvoye.getAllMessageSupByClient").setParameter("dest",dest).getResultList();
		        if(result.isEmpty())
		        {
		            return null;
		        }else{
		            
		            return result;
		        }
		        
		    }
		
		  public   ArrayList<MessageEnvoye> getAllMessageEnvoyerByClient(String exp)
		    {
		        
		        @SuppressWarnings("unchecked")
		                ArrayList<MessageEnvoye> result =(ArrayList<MessageEnvoye>) entityM.createNamedQuery("MessageEnvoye.getAllMessageEnvoyerByClient").setParameter("exp",exp).getResultList();
		        if(result.isEmpty())
		        {
		            return null;
		        }else{
		            
		            return result;
		        }
		        
		    }
		
		
		  public   long  getCountMessageRecuByEmailByClient(String dest)
		    {
		        
		        @SuppressWarnings("unchecked")
		             long  result =entityM.createNamedQuery("MessageEnvoye.getCountMessageRecuByClient").setParameter("dest",dest).getSingleResult().hashCode();
		        if(result==0)
		        {
		            return 0;
		        }else{
		            
		            return result;
		        }
		        
		    }
		
		  

		  public   long  getCountMessageEnvoyeByEmailByClient(String exp)
		    {
		        
		        @SuppressWarnings("unchecked")
		             long  result =entityM.createNamedQuery("MessageEnvoye.getCountMessageEnvoyeByClient").setParameter("exp",exp).getSingleResult().hashCode();
		        if(result==0)
		        {
		            return 0;
		        }else{
		            
		            return result;
		        }
		        
		    }
		
		
		
		  
		  //____________________________by user_____________________
		  
		  public   ArrayList<MessageEnvoye> getAllMessageRecuByUser(String dest)
		    {
		        
		        @SuppressWarnings("unchecked")
		                ArrayList<MessageEnvoye> result =(ArrayList<MessageEnvoye>) entityM.createNamedQuery("MessageEnvoye.getAllMessageRecuByUser").setParameter("dest",dest).getResultList();
		        if(result.isEmpty())
		        {
		            return null;
		        }else{
		            
		            return result;
		        }
		        
		    }
		  
		  /**
		   * 
		   * @param dest
		   * @return
		   */
		  public   ArrayList<MessageEnvoye> getAllMessageSupByUser(String dest)
		    {
		        
		        @SuppressWarnings("unchecked")
		                ArrayList<MessageEnvoye> result =(ArrayList<MessageEnvoye>) entityM.createNamedQuery("MessageEnvoye.getAllMessageSupByUser").setParameter("dest",dest).getResultList();
		        if(result.isEmpty())
		        {
		            return null;
		        }else{
		            
		            return result;
		        }
		        
		    }
		
		  public   ArrayList<MessageEnvoye> getAllMessageEnvoyerByUser(String exp)
		    {
		        
		        @SuppressWarnings("unchecked")
		                ArrayList<MessageEnvoye> result =(ArrayList<MessageEnvoye>) entityM.createNamedQuery("MessageEnvoye.getAllMessageEnvoyerByUser").setParameter("exp",exp).getResultList();
		        if(result.isEmpty())
		        {
		            return null;
		        }else{
		            
		            return result;
		        }
		        
		    }
		
		
		  public   long  getCountMessageRecuByEmailByUser(String dest)
		    {
		        
		        @SuppressWarnings("unchecked")
		             long  result =entityM.createNamedQuery("MessageEnvoye.getCountMessageRecuByUser").setParameter("dest",dest).getSingleResult().hashCode();
		        if(result==0)
		        {
		            return 0;
		        }else{
		            
		            return result;
		        }
		        
		    }
		
		  

		  public   long  getCountMessageEnvoyeByEmailByUser(String exp)
		    {
		        
		        @SuppressWarnings("unchecked")
		             long  result =entityM.createNamedQuery("MessageEnvoye.getCountMessageEnvoyeByUser").setParameter("exp",exp).getSingleResult().hashCode();
		        if(result==0)
		        {
		            return 0;
		        }else{
		            
		            return result;
		        }
		        
		    }
		
		
		  
  public   String  getDateEnvoieMessage(MessageEnvoye e )
    {
	  	
        @SuppressWarnings("unchecked")
             String  result =entityM.createNamedQuery("EnvoieMessage.getDateEnvoieMessage").setParameter("e",e).getSingleResult().toString();
       
            return result;
        }
        
  /**
   * 
   * @param iddelete
   */
  
  public   void  deleteMessageById(int iddelete )
  {
	  	
      @SuppressWarnings("unchecked")
      int result= entityM.createNamedQuery("MessageEnvoye.deleteMessageById").setParameter("_iddelete",iddelete).executeUpdate();
   
   }
  
  
 
 /**
  * Renvoie un EnvoieMessage par son message
  * @param e
  * @return
  */
  
public   EnvoieMessage  getEnvoieByMessage(MessageEnvoye e )
{
	
	  @SuppressWarnings("unchecked")
     ArrayList<EnvoieMessage>  result =(ArrayList<EnvoieMessage>) entityM.createNamedQuery(" EnvoieMessage.getEnvoieByMessage").setParameter("e",e).getResultList();
	  if(result==null)
	  {
		  return null;
	  }else
	  {
		  return result.get(0);
	  }
    
}

/**
 * Renvoyer l'email d'un alert
 * @param e
 * @return
 */
public  Alert  getAlertByMail(String e )
{
	
	  @SuppressWarnings("unchecked")
     ArrayList<Alert>  result =(ArrayList<Alert>) entityM.createNamedQuery("Alert.getAlertByMail").setParameter("_email",e).getResultList();
	  if(result.isEmpty())
	  {
		  return null;
	  }else
	  {
		  return result.get(0);
	  }
    
}

/**
 * Renvoyer tous emails des alerts
 * @return
 */
public  ArrayList<Alert> getAlertAllAlert()
{
    @SuppressWarnings("unchecked")
            ArrayList<Alert> result =(ArrayList<Alert>) entityM.createNamedQuery("Alert.getAllAlert").getResultList();
    return result;
}

/**
 * Supprimer un message dans la table envoieMessage
 * @param msgE
 */
public   void  deleteEnvoieMessage(MessageEnvoye msgE )
{
	  	
    @SuppressWarnings("unchecked")
    int result= entityM.createNamedQuery("EnvoieMessage.deleteEnvoieMessage").setParameter("e",msgE).executeUpdate();
 
 }
/**
 * 
 * @param id
 */
public   void  deleteNbConnecte(String id )
{
	  	
    entityM.getTransaction().begin();
    int result= entityM.createNamedQuery("NbConnecte.deleteNbConnecte").setParameter("_mail",id).executeUpdate();
    entityM.getTransaction().commit();
 }


public   void  deleteAllConnect()
{
	  	
    entityM.getTransaction().begin();
    entityM.createNamedQuery("NbConnecte.deleteAll").executeUpdate();
    entityM.getTransaction().commit();
 }
/**
 * 
 * @return
 */
public  ArrayList<NbConnecte> getAllNbConnecte()
{
    @SuppressWarnings("unchecked")
            ArrayList<NbConnecte> result =(ArrayList<NbConnecte>) entityM.createNamedQuery("NbConnecte.getAllNbConnecte").getResultList();
    return result;
}

public  void createOrUpdateNbConnecte(NbConnecte u)
{        
    entityM.getTransaction().begin();
    
    if(entityM.find(NbConnecte.class, u.getNombreConnecte()) == null){
        
        entityM.persist(u);
        entityM.getTransaction().commit();
    } else {
        entityM.merge(u);
        entityM.getTransaction().commit();
    }                        
}	
/**
 * 
 * @param u
 */

public  void createOrUpdatePostule(Postule u)
{        
    entityM.getTransaction().begin();
    
    if(entityM.find(Postule.class,u.getPostuleid()) == null){
        
        entityM.persist(u);
        entityM.getTransaction().commit();
    } else {
        entityM.merge(u);
        entityM.getTransaction().commit();
    }                        
}



/**
 * renvoyer tous les postulants a une offre donnée
 * @param code
 * @return
 */

public   ArrayList<User> getAllPostulantByOffre(String code)
{
    
    @SuppressWarnings("unchecked")
            ArrayList<User> result =(ArrayList<User>) entityM.createNamedQuery("Postule.getAllPostulantByOffre").setParameter("code",code).getResultList();
    
        
        return result;
    }
    

/**
 * Ajouter une entreprise dans l'annuaire
 * @param u
 */
public  void createOrUpdateAnnuaire(Annuaire u)
{        
    entityM.getTransaction().begin();
    
    if(entityM.find(Annuaire.class, u.getId()) == null){
        
        entityM.persist(u);
        entityM.getTransaction().commit();
    } else {
        entityM.merge(u);
        entityM.getTransaction().commit();
    }                        
}
    

// Les fonctions concernant la discussion

public  void createOrUpdateDiscussion(Discussion u)
{        
    entityM.getTransaction().begin();
    
    if(entityM.find(Discussion.class, u.getIdDiscussion()) == null){
        
        entityM.persist(u);
        entityM.getTransaction().commit();
    } else {
        entityM.merge(u);
        entityM.getTransaction().commit();
    }                        
}

/**
 * Renvoie une discussion par email
 * @param e
 * @return
 */
public  Discussion  getDiscussionByMail(String e )
{
	
	  @SuppressWarnings("unchecked")
     ArrayList<Discussion>  result =(ArrayList<Discussion>) entityM.createNamedQuery("Discussion.getDiscussionByMail").setParameter("_email",e).getResultList();
	  if(result.isEmpty())
	  {
		  return null;
	  }else
	  {
		  return result.get(0);
	  }
    


}



public  ArrayList<Discussion> getAllDiscussion()
{
    @SuppressWarnings("unchecked")
            ArrayList<Discussion> result =(ArrayList<Discussion>) entityM.createNamedQuery("Discussion.getAllDiscussion").getResultList();
    if(result.isEmpty())
	  {
		  return null;
	  }else
	  {
		  return result;
	  }
}


}
