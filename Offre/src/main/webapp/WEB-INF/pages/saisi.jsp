<%@page import="modele.Loisir"%>
<%@page import="modele.Langue"%>
<%@page import="modele.Formation"%>
<%@page import="modele.ExterneUserMessage"%>
<%@page import="modele.MessageEnvoye"%>
<%@page import="modele.EnvoieMessage"%>
<%@page import="modele.Experience"%>
<%@page import="modele.Competence"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
MappingDao dao=MappingDao.getInstance();
//Email du destinaire d'un message a partir d'une offre
String mail=request.getParameter("dest");
//S'il s'agit d'un message de contact
String contacter=request.getParameter("contacter");
//Recuperation de l'identifiant du message envoye depuis l'exterieur
String idmessageExterne=request.getParameter("idMsgExterne");
//Recuperation de l'identifiant du message
String idmessageInterne=request.getParameter("idMsgInterne");
//si c'est un nouveau message
String nouveauMsg=request.getParameter("new");
//Recuperation du code de l'offre
String offre=request.getParameter("c");

String postule=request.getParameter("postule");
//Recuperation de l'email de celui qui est connecté pour eventuellement envoyer une reponse


System.out.println("Je suis bien dans saisie");
//definition d'un candidat
User candidatDest=new User();
//definition d'un employeur
Client employeurDest=new Client();

//definition d'un candidat
User candidatExp=new User();
//definition d'un employeur
Client employeurExp=new Client();
if(contacter==null){
String emailExpediataire=session.getAttribute("ident").toString().toString();
candidatExp=dao.getUsertbyEmail(emailExpediataire);

employeurExp=dao.getClientbyEmail(emailExpediataire);
}


%>

<html>
 <head >

<%@include file="menu.jsp" %>
<body>
<div id="main-content" style="margin-left: 10%;">
       	<%@include file="pub.jsp" %>
<div id="form-index">
<form class="form-horizontal" action="Message" method="post">



	
<%if(contacter==null){ %>
		<%if(mail!=null ){ 
		
		
			String emailExpediataire=session.getAttribute("ident").toString().toString();
			candidatExp=dao.getUsertbyEmail(emailExpediataire);
			
			employeurExp=dao.getClientbyEmail(emailExpediataire);
		
				 int id= Integer.parseInt(request.getParameter("id"));
				
				 System.out.println("voici enfin le mail"+mail);
				 Client cli=new Client();
				 User u=new User();
				 cli=dao.getClientbyEmail(mail);
			     u=dao.getUsertbyEmail(emailExpediataire);
			     
				 ArrayList<Competence> competences =dao.getAllCompetenceByIdUser(id);
				 ArrayList<Experience> experiences=dao.getAllExperienceByIdUser(id);
				 ArrayList<Formation> formations=dao.getAllFormationByIdUser(id);
				 ArrayList<Langue> langues=dao.getAllLangueByIdUser(id);
				 ArrayList<Loisir> loisirs=dao.getAllLoisirByIdUser(id);
				 System.out.println("voici enfin le nom"+u.getNom());
				 %>
				<input type="hidden" name="dest" value="<%=mail%>">
				<input type="hidden" name="code" value="<%=offre%>">
		<div class="divCompetenceSaisi">
		
					<div class="col-md-offset-2 col-md-7">
				<div class="form-group">             
			             Email <input type="email" class="form-control" name="email" value="<%=u.getEmail()%>" readonly="readonly">
			      </div>
			        <div class="form-group">
			          Nom <input type="text" name="nom" class="form-control" id="nom" value="<%=u.getNom()%>" readonly="readonly">
			         </div>
			        <div class="form-group">             
			                Prénom  <input type="text" class="form-control" name="prenom" id="prenom" value="<%=u.getPrenom()%>" readonly="readonly">
			     	 </div>	
			     	 <div class="form-group">  
			     	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
			               <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
			     	 </div>	       
					</div>
			
					</div>
					
				<div class="blocSaisi">
						<div class="row ">
					<div class="col-sm-4">
		            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required">
		            
		           
					<div class="btn-group" data-toggle="buttons">
					<label for="type" class="">Joindre votre CV enregistré</label>
					<label class=" ">
						<input name="cvjoint" value="oui" type="radio" required="required">oui
					</label>
					<label class=" ">
						<input name="cvjoint" value="non" type="radio" required="required">non
					</label>
					 		
					</div>
		            
		      	   </div>
		      	   <br>
					<hr>	  
				  	<div>
				 	 <textarea name="message" style="margin: 2%;" class="styletextarea" readonly="readonly" >
				 	Contacts:
					<%=u.getAdresse() %>
					<%=u.getTelephone() %>
					<%=u.getEmail() %>
				     Competences:
					<%for(Competence comp:competences){ %>
					 <%=comp.getNom() %>: <%=comp.getDescription() %>
					 <%} %>
				
					Langues:
					<%for(Langue langue:langues){ %>
					<%=langue.getNom()%>:<%=langue.getNiveau() %>
					<%} %>
					Loisirs:
					<%for(Loisir loisir:loisirs) {%>
					<%=loisir.getNom() %>
					<%} %>
					
					Experiences Professionnelles:
					<%for(Experience exp:experiences){ %>
					<%=exp.getDatedebut() %> - <%=exp.getDatefin() %>:<%=exp.getNomEntreprise() %>
					<%=exp.getNomExp() %>
					<%=exp.getDescriptionExp() %>
					<%} %>
					Formations:
					<%for(Formation formation:formations){ %>
					<%=formation.getDateFormation() %>
					<%=formation.getTitre() %>
					<%=formation.getDescription() %>
					<%=formation.getDomaine() %>
					Niveau:<%=formation.getNiveau() %>
					Lieu:<%=formation.getOrigine() %>
					<%} %>
				 </textarea>
				 </div>
				 </div>
				 </div>
				

		<%}else 
			if(idmessageInterne!=null )
			{	
				
				System.out.println("on est dans la reponse");
				
					MessageEnvoye envoiM=new MessageEnvoye();
					 int id= Integer.parseInt(idmessageInterne);
					envoiM= dao.getMessageById(id);
					 
					 
					 employeurDest=dao.getClientbyEmail(envoiM.getExpeditaire());
					
					  candidatDest=dao.getUsertbyEmail(envoiM.getExpeditaire());
					  
					  System.out.println("on est dans la reponse emaildest "+ envoiM.getExpeditaire());
						
					  
					 if(candidatDest!=null && candidatExp!=null){
					 
					
						 %>
						<input type="hidden" name="clientDest" value="<%=candidatDest.getEmail()%>">
					<div class="divCompetenceSaisi">
				
							<div class="col-md-offset-2 col-md-7">
						<div class="form-group">             
					             Email <input type="email" class="form-control" name="email" value="<%=candidatExp.getEmail()%>" readonly="readonly">
					      </div>
					        <div class="form-group">
					          Nom <input type="text" name="nom" class="form-control" id="nom" value="<%=candidatExp.getNom()%>" readonly="readonly">
					         </div>
					        <div class="form-group">             
					                Prénom  <input type="text" class="form-control" name="prenom" id="prenom" value="<%=candidatExp.getPrenom()%>" readonly="readonly">
					     	 </div>	
					     	 <div class="form-group">  
					     	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
					               <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
					     	 </div>	       
							</div>
							</div>
						
						<div class="blocSaisi">
						<div class="row ">
							<div class="col-sm-4">
				            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
				      	   
					      	<%if(postule=="ok"){ %>		
							<div class="btn-group" data-toggle="buttons">
							<label for="type" class="">Joindre votre CV enregistré</label>
							<label class="">
								<input name="cvjoint" value="oui" type="radio" required="required">oui
							</label>
							<label class="">
								<input name="cvjoint" value="non" type="radio" required="required">non
							</label>
							
							</div>
							<%} %>
				      	   
				      	   
				      	   </div>
				      	   <br>
							<hr>	  
						  	<div>
						 	<textarea name="message" style="margin: 2%;" class="styletextarea" >
						 	</textarea>
						 </div>
						 </div>
						 </div>
						 
					<%} else if(candidatDest!=null && employeurExp!=null){	%>					
						employeur exp
						<input type="hidden" name="clientDest" value="<%=candidatDest.getEmail()%>">
				<div class="divCompetenceSaisi">
				
							<div class="col-md-offset-2 col-md-7">
						<div class="form-group">             
					             Email <input type="email" class="form-control" name="email" value="<%=employeurExp.getEmail()%>" readonly="readonly">
					      </div>
					        <div class="form-group">
					          Nom <input type="text" name="nom" class="form-control" id="nom" value="<%=employeurExp.getNom()%>" readonly="readonly">
					         </div>
					        <div class="form-group">             
					                Prénom  <input type="text" class="form-control" name="prenom" id="prenom" value="<%=employeurExp.getPrenom()%>" readonly="readonly">
					     	 </div>	
					     	 <div class="form-group">  
					     	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
					               <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
					     	 </div>	       
							</div>
						</div>
				
						<div class="blocSaisi">
						<div class="row ">
							<div class="col-sm-4">
				            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
				      	   
					      	<%if(postule=="ok"){ %>		
							<div class="btn-group" data-toggle="buttons">
							<label for="type" class="">Joindre votre CV enregistré</label>
							<label class="">
								<input name="cvjoint" value="oui" type="radio" required="required">oui
							</label>
							<label class="">
								<input name="cvjoint" value="non" type="radio" required="required">non
							</label>
							
							</div>
							<%} %>
				      	   
				      	   
				      	   </div>
				      	   <br>
							<hr>	  
						  	<div>
						 	<textarea name="message" style="margin: 2%;" class="styletextarea" >
						 	</textarea>
						 </div>
						 </div>
						 </div>
						
					<%}
					 
					else if(employeurDest!=null && employeurExp!=null){	%>					
					
					<input type="hidden" name="clientDest" value="<%=employeurDest.getEmail()%>">
				<div class="divCompetenceSaisi">
					
						<div class="col-md-offset-2 col-md-7">
					<div class="form-group">             
				             Email <input type="email" class="form-control" name="email" value="<%=employeurExp.getEmail()%>" readonly="readonly">
				      </div>
				        <div class="form-group">
				          Nom <input type="text" name="nom" class="form-control" id="nom" value="<%=employeurExp.getNom()%>" readonly="readonly">
				         </div>
				        <div class="form-group">             
				                Prénom  <input type="text" class="form-control" name="prenom" id="prenom" value="<%=employeurExp.getPrenom()%>" readonly="readonly">
				     	 </div>	
				     	 <div class="form-group">  
				     	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
				               <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
				     	 </div>	       
						</div>
					</div>
					<div class="blocSaisi">
					<div class="row ">
						<div class="col-sm-4">
			            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
			      	   
				      	<%if(postule=="ok"){ %>		
						<div class="btn-group" data-toggle="buttons">
						<label for="type" class="">Joindre votre CV enregistré</label>
						<label class="">
							<input name="cvjoint" value="oui" type="radio" required="required">oui
						</label>
						<label class="">
							<input name="cvjoint" value="non" type="radio" required="required">non
						</label>
						
						</div>
						<%} %>
			      	   
			      	   
			      	   </div>
			      	   <br>
						<hr>	  
					  	<div>
					 	 <textarea name="message" style="margin: 2%;" class="styletextarea" >
					 	</textarea>
					 </div>
					 </div>
					 </div>
					 
				<%}
					else if(employeurDest!=null && candidatExp!=null){	%>					
					
					<input type="hidden" name="clientDest" value="<%=employeurDest.getEmail()%>">
			<div class="divCompetenceSaisi">
				
						<div class="col-md-offset-2 col-md-7">
					<div class="form-group">             
				             Email <input type="email" class="form-control" name="email" value="<%=candidatExp.getEmail()%>" readonly="readonly">
				      </div>
				        <div class="form-group">
				          Nom <input type="text" name="nom" class="form-control" id="nom" value="<%=candidatExp.getNom()%>" readonly="readonly">
				         </div>
				        <div class="form-group">             
				                Prénom  <input type="text" class="form-control" name="prenom" id="prenom" value="<%=candidatExp.getPrenom()%>" readonly="readonly">
				     	 </div>	
				     	 <div class="form-group">  
				     	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
				               <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
				     	 </div>	       
						</div>
					</div>
					<div class="blocSaisi">
				
					<div class="row ">
						<div class="col-sm-4">
			            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
			      	   
				      	<%if(postule=="ok"){ %>		
						<div class="btn-group" data-toggle="buttons">
						<label for="type" class="">Joindre votre CV enregistré</label>
						<label class="">
							<input name="cvjoint" value="oui" type="radio" required="required">oui
						</label>
						<label class="">
							<input name="cvjoint" value="non" type="radio" required="required">non
						</label>
						
						</div>
						<%} %>
			      	   
			      	   
			      	   </div>
			      	   <br>
						<hr>	  
					  	<div>
					 	 <textarea name="message" style="margin: 2%;" class="styletextarea" >
					 	</textarea>
					 </div>
					 </div>
					 </div>
					 
				<%}%>
				
		 <%}else if(nouveauMsg!=null){%>		
	
			<%
				EnvoieMessage nouvoMsg=new EnvoieMessage();
			    if(candidatExp!=null){
			 %>
				<input type="hidden" name="expNewMsg" value="<%=candidatExp.getEmail()%>">
			<div class="divCompetenceSaisi">
				
					<div class="col-md-offset-2 col-md-7">
					
				  <div class="form-group">             
			             Email <input type="email" class="form-control" name="email" placeholder="Email Destinataire" required="required">
			      </div>
			        <div class="form-group">
			          Nom <input type="text" name="nom" class="form-control" id="nom" value="<%=candidatExp.getNom()%>" readonly="readonly">
			         </div>
			        <div class="form-group">             
			                Prénom  <input type="text" class="form-control" name="prenom" id="prenom" value="<%=candidatExp.getPrenom()%>" readonly="readonly">
			     	 </div>	
			     	 <div class="form-group">  
			     	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
			               <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
			     	 </div>	       
					</div>
			</div>
			<div class="blocSaisi">
				<div class="row ">
					<div class="col-sm-4">
		            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
		      	   </div>
		      	   <br>
					<hr>	  
				  	<div>
				 	 <textarea name="message" style="margin: 2%;" class="styletextarea" >
				 	</textarea>
				 </div>
				 </div>
				 </div>
				 
			<%}else  if(employeurExp!=null){%>
		
					<input type="hidden" name="expNewMsg" value="<%=employeurExp.getEmail()%>">
				<div class="divCompetenceSaisi">
					
						<div class="col-md-offset-2 col-md-7">
						
					  <div class="form-group">             
				             Email <input type="email" class="form-control" name="email" placeholder="Email Destinataire" required="required">
				      </div>
				        <div class="form-group">
				          Nom <input type="text" name="nom" class="form-control" id="nom" value="<%=employeurExp.getNom()%>" readonly="readonly">
				         </div>
				        <div class="form-group">             
				                Prénom  <input type="text" class="form-control" name="prenom" id="prenom" value="<%=employeurExp.getPrenom()%>" readonly="readonly">
				     	 </div>	
				     	 <div class="form-group">  
				     	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
				               <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
				     	 </div>	       
						</div>
						</div>
						
				<div class="blocSaisi">
					<div class="row ">
						<div class="col-sm-4">
			            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
			      	   </div>
			      	   <br>
			      	   <br>
						<hr>	  
					  	<div>
					 	 <textarea name="message" style="margin: 2%;" class="styletextarea" >
					 	</textarea>
					 </div>
					 </div>
					 </div>
					 
				<%}%>
		
	
	
	
<%}else if(idmessageExterne!=null){
	
	 ExterneUserMessage exterM=new ExterneUserMessage();
	 int id= Integer.parseInt(idmessageExterne);
	exterM=dao.getExterneUserMessageById(id);
	 String expediatire=exterM.getEmail();
	 String destinataire=exterM.getEmailDest();
	 Client cli=new Client();
	 cli=dao.getClientbyEmail(destinataire);

	
	 %>
	<input type="hidden" name="emailDestExterne" value="<%=expediatire%>">
<div class="divCompetenceSaisi">

		<div class="col-md-offset-2 col-md-7">
	<div class="form-group">             
            Email <input type="email" class="form-control" name="email" value="<%=cli.getEmail()%>" readonly="readonly">
     </div>
       <div class="form-group">
         Nom <input type="text" name="nom" class="form-control" id="nom" value="<%=cli.getNom()%>" readonly="readonly">
        </div>
       <div class="form-group">             
               Prénom  <input type="text" class="form-control" name="prenom" id="prenom" value="<%=cli.getPrenom()%>" readonly="readonly">
    	 </div>	
    	 <div class="form-group">  
    	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
              <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
    	 </div>	       
		</div>
	</div>
	<div class="blocSaisi">
	
	<div class="row ">
		<div class="col-sm-4">
       <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
 	   </div>
 	   <br>
		<hr>	  
	  	<div>
	 	 <textarea  rows="25" cols="100" name="message" placeholder="Saisir ici votre message" style="margin: 2%;" >
	 	</textarea>
	 </div>
	 </div>
	 </div>
	 
	 <%}
		
}else
{%>
		<div class="divCompetenceSaisi">
		
				<div class="col-md-offset-2 col-md-7">
				
			  <div class="form-group">             
		             Email <input type="email" class="form-control" name="email" placeholder="Email Destinataire" required="required">
		      </div>
		        <div class="form-group">
		          Nom <input type="text" name="nom" class="form-control" id="nom" placeholder="Nom" required="required">
		         </div>
		        <div class="form-group">             
		                Prénom  <input type="text" class="form-control" name="prenom" id="prenom" placeholder="Prenom" required="required">
		     	 </div>	
		     	 <div class="form-group">  
		     	 <button type="reset" class="glyphicon glyphicon-remove-sign" style="color: green;">&nbspAnnuler</button>           
		               <button type="submit" class="glyphicon glyphicon-send" style="color: green;">&nbspEnvoyer</button>	
		     	 </div>	       
				</div>
		
				</div>
			<div class="blocSaisi">
			<div class="row ">
				<div class="col-sm-4">
	            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" required="required" >
	      	   </div>
	      	   <br>
	      	   <hr>
	    	  	<div>
			 	 <textarea  rows="25" cols="100" name="message" placeholder="Saisir ici votre message" " >
			 	</textarea>
			 </div>
			 </div>
			 </div>
			
			
			<%
			}%>
		
		</form>
	</div>
	<%@include file="footer.jsp" %>
	</div>
	</body>


</html>