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
String mail=request.getParameter("dest");
String contacter=request.getParameter("contacter");
String idmessageExterne=request.getParameter("idMsgExterne");
String idmessageInterne=request.getParameter("idMsgInterne");
String nouveauMsg=request.getParameter("new");
String offre=request.getParameter("c");
String postule=request.getParameter("postule");


%>

<html>

<%@include file="menu.jsp" %>
<body>
<div class="containermessage">

	<form class="form-horizontal" action="Message" method="post">
<%if(contacter==null){ %>
	<%if(user){ %>
		
		<%if(mail!=null ){ %>
				<% int id= Integer.parseInt(request.getParameter("id"));
				
				 System.out.println("voici enfin le mail"+mail);
				 Client cli=new Client();
				 User u=new User();
				 cli=dao.getClientbyEmail(mail);
				 u=dao.getUserbyId(id);
				 int idUser=u.getIdUser();
				 ArrayList<Competence> competences =dao.getAllCompetenceByIdUser(idUser);
				 ArrayList<Experience> experiences=dao.getAllExperienceByIdUser(idUser);
				 ArrayList<Formation> formations=dao.getAllFormationByIdUser(idUser);
				 ArrayList<Langue> langues=dao.getAllLangueByIdUser(idUser);
				 ArrayList<Loisir> loisirs=dao.getAllLoisirByIdUser(idUser);
				 System.out.println("voici enfin le nom"+u.getNom());
				 %>
				<input type="hidden" name="dest" value="<%=mail%>">
				<input type="hidden" name="code" value="<%=offre%>">
				<aside class="idexpim">
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
					</aside>
				<aside class="idsaisie">
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
					<hr>	  
				  	<div>
				 	 <textarea  rows="7" cols="100" name="message" placeholder="Saisir ici votre message" style="margin: 2%;" readonly="readonly" >
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
				 </aside>

		<%}else 
			if(idmessageInterne!=null )
			{	
					MessageEnvoye envoiM=new MessageEnvoye();
					 int id= Integer.parseInt(idmessageInterne);
					envoiM= dao.getMessageById(id);
					 String expediatire=envoiM.getExpeditaire();
					 String destinataire=envoiM.getDestinataire();
					
					 Client cli=new Client();
					 User u=new User();
					 cli=dao.getClientbyEmail(expediatire);
					 u=dao.getUsertbyEmail(destinataire);
					 
					 int idUser=u.getIdUser();
					
					 %>
					<input type="hidden" name="clientDest" value="<%=expediatire%>">
					<aside class="idexpim">
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
						</aside>
					<aside class="idsaisie">
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
						<hr>	  
					  	<div>
					 	 <textarea  rows="7" cols="100" name="message" placeholder="Saisir ici votre message" style="margin: 2%;" >
					 	</textarea>
					 </div>
					 </div>
					 </aside>
		 <%}else if(nouveauMsg!=null){%>		
			
			<%
				EnvoieMessage nouvoMsg=new EnvoieMessage();
			 	String expNewMsgUser=session.getAttribute("ident").toString().toString();
			 	User u=new User();
			 	u=dao.getUsertbyEmail(expNewMsgUser);
			 %>
				<input type="hidden" name="expNewMsgUser" value="<%=expNewMsgUser%>">
				<aside class="idexpim">
					<div class="col-md-offset-2 col-md-7">
					
				  <div class="form-group">             
			             Email <input type="email" class="form-control" name="email" placeholder="Email Destinataire" required="required">
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
					</aside>
				<aside class="idsaisie">
				<div class="row ">
					<div class="col-sm-4">
		            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
		      	   </div>
					<hr>	  
				  	<div>
				 	 <textarea  rows="7" cols="100" name="message" placeholder="Saisir ici votre message" style="margin: 2%;" >
				 	</textarea>
				 </div>
				 </div>
				 </aside>
			<%}
		
	
	}else if(client ){
			
			if(idmessageInterne!=null && postule!="ok")
			{	
				MessageEnvoye envoiM=new MessageEnvoye();
				 int id= Integer.parseInt(idmessageInterne);
				envoiM= dao.getMessageById(id);
				 String expediatire=envoiM.getExpeditaire();
				 String destinataire=envoiM.getDestinataire();
				
				 Client cli=new Client();
				 User u=new User();
				 cli=dao.getClientbyEmail(destinataire);
				 u=dao.getUsertbyEmail(expediatire);
				 
				 int idClient=cli.getID();
				
				 %>
				<input type="hidden" name="userDest" value="<%=expediatire%>">
				<aside class="idexpim">
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
					</aside>
				<aside class="idsaisie">
				<div class="row ">
					<div class="col-sm-4">
		            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
		      	   </div>
					<hr>	  
				  	<div>
				 	 <textarea  rows="7" cols="100" name="message" placeholder="Saisir ici votre message" style="margin: 2%;" >
				 	</textarea>
				 </div>
				 </div>
				 </aside>
			<%}else if(idmessageExterne!=null){
			
				 ExterneUserMessage exterM=new ExterneUserMessage();
				 int id= Integer.parseInt(idmessageExterne);
				exterM=dao.getExterneUserMessageById(id);
				 String expediatire=exterM.getEmail();
				 String destinataire=exterM.getEmailDest();
				 Client cli=new Client();
				 cli=dao.getClientbyEmail(destinataire);
				 int idClient=cli.getID();
				
				 %>
				<input type="hidden" name="emailDestExterne" value="<%=expediatire%>">
				<aside class="idexpim">
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
					</aside>
				<aside class="idsaisie">
				<div class="row ">
					<div class="col-sm-4">
		            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
		      	   </div>
					<hr>	  
				  	<div>
				 	 <textarea  rows="7" cols="100" name="message" placeholder="Saisir ici votre message" style="margin: 2%;" >
				 	</textarea>
				 </div>
				 </div>
				 </aside>
			
			
			
		<%}else if(nouveauMsg!=null){%>		
			
			<%
			  	String expNewMsgCli=session.getAttribute("ident").toString().toString();			 	
			 	Client cli=new Client();
			 	cli=dao.getClientbyEmail(expNewMsgCli);
			 
			 %>
				<input type="hidden" name="expNewMsgCli" value="<%=expNewMsgCli%>">
				<aside class="idexpim">
					<div class="col-md-offset-2 col-md-7">
					
				  <div class="form-group">             
			             Email <input type="email" class="form-control" name="email" placeholder="Email Destinataire" required="required">
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
					</aside>
				<aside class="idsaisie">
				<div class="row ">
					<div class="col-sm-4">
		            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
		      	   </div>
					<hr>	  
				  	<div>
				 	 <textarea  rows="7" cols="100" name="message" placeholder="Saisir ici votre message" style="margin: 2%;" >
				 	</textarea>
				 </div>
				 </div>
				 </aside>
			<%}
		
	}}else{%>
				
				<aside class="idexpim">
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
				</aside>
			<aside class="idsaisie">
			<div class="row ">
				<div class="col-sm-4">
	            <input type="text" class="form-control" name="objet" id="objet" placeholder="Objet de votre message" style="margin: 2%;" required="required" >
	      	   </div>
				<hr>	  
			  	<div>
			 	 <textarea  rows="7" cols="100" name="message" placeholder="Saisir ici votre message" style="margin: 2%;" >
			 	</textarea>
			 </div>
			 </div>
			 </aside>
			
			
			<%
			}%>
		
		</form>
	</div>

	</body>


</html>