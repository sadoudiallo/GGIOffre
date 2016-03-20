<!DOCTYPE html>
<%@page import="modele.MessageEnvoye"%>
<%@page import="modele.EnvoieMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="modele.ExterneUserMessage"%>
<%@page import="modele.Offre"%>
<%@page import="dao.MappingDao"%>
<%@page import="modele.Client"%>
<%@page import="modele.User"%>


 <%
 MappingDao dao=MappingDao.getInstance();
 ExterneUserMessage mesg=new ExterneUserMessage();
 //definition d'un employeur
 Client employeurDest=new Client();
 //definition d'un candidat
 User candidatDest=new User();
 //definition d'un employeur
 Client employeurExp=new Client();
 //definition d'un candidat
 User candidatExp=new User();
 //id est l'identifiant d'un message venant d'un utilisateur non enregistré destiné a l'admin
 String idm=request.getParameter("id");
 //idmessage est l'identifiant d'un message envoyé depuis le site Offre
 String idmessage=request.getParameter("idmessage");
//recuperation de l'email de la personne connectée
String emailDestinataire= session.getAttribute("ident").toString().toString();
  //On recherche si le destinatire est un employeur
  employeurDest=dao.getClientbyEmail(emailDestinataire);
 //On recherche si le destinatire est un candidat
 	candidatDest=dao.getUsertbyEmail(emailDestinataire);
  
 System.out.println("hihihhi voici l'email destinataire"+emailDestinataire);
 %>


<html>
 <head >

 <link rel="shortcut icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/> 
<link rel="icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/>
	</head>
<body>

<%@include file="menu.jsp" %>
<div id="main-content" style="margin-left: 6%;">
       	<%@include file="pub.jsp" %>
<div id="form-index" >
  <form class="form-horizontal" action="Repondre" method="post">
	<aside class="divCompetence">
			<div class="col-md-offset-2 col-md-7">
			<div class="form-group">             
		            <a href="/Offre/MessageEnvoye">Messages envoyés</a>
		      </div>
		        <div class="form-group">
		          <a href="/Offre/ListeMessage">Messages Reçus</a>
		         </div>
		        <div class="form-group">             
		                <a href="/Offre/MessageSup">Messages Supprimés</a>
		     	 </div>	
			    <div>
			 	  <button type="submit" class="glyphicon glyphicon-send" style="color: green;" name="repondre">&nbspRepondre</button>	      
				</div>
				<hr>
				 <div>
			   	  <button type="submit" class="glyphicon glyphicon-pencil" style="color: green;" name="nouveau">&nbspNouveau</button>	      
				</div>	    
				<hr>
			  <div>
		   	  <button type="submit" class="glyphicon glyphicon-trash" style="color: green;" name="supprimer">&nbspSupprimer</button>	      
			  </div>		
		</div>
	</aside>
	<%if(idm!=null){
		 int id= Integer.parseInt(idm);
		 mesg=dao.getExterneUserMessageById(id);
		 mesg.setStatutMessage(true);
		 dao.createOrUpdateExternUsermessage(mesg);
		 System.out.println("message inserer dans ExternUsermessage");
		Client cli=new Client();
		cli=dao.getClientbyEmail(mesg.getEmailDest());
		%>
    	<div class="row " style="margin-left: 10%;">		
			<div class="col-sm-10">
            De:<b> <%=mesg.getPrenom() %> <%=mesg.getNom() %></b>
      	   </div>
      	    <br>
			<hr>
			<div class="col-sm-10">
            A: <%=cli.getPrenom() %> <%=cli.getNom()%>(<%=mesg.getEmailDest() %>)
      	   </div>
      	    <br>
      	   <hr>
      	   	<div class="col-sm-10">
            Envoyé: <%=mesg.getDateEnvoie() %>
      	   </div>
      	    <br>
      	  
      	  <hr>
		  	<div class="col-sm-20">
            <%=mesg.getMessageText()%>
      	   </div>
	
		<input type="hidden" name="idmgsExterne" value="<%=idm%>">
</div>

<%}
	
	
	else if(idmessage!=null) {
		
		
		//resuperation de l'expeditaire
		  int idmes= Integer.parseInt(idmessage);
		  MessageEnvoye envoimsg=new MessageEnvoye();
		  
		  envoimsg=dao.getMessageById(idmes);
		  envoimsg.setStatutMessage(true);
		  dao.createOrUpdateMessageEnvoye(envoimsg);
		  //recuperation de l'email de l'expeditaire
		  String emailExpediatire=envoimsg.getExpeditaire();
		//On recherche si le expeditaire est un employeur
		  employeurExp=dao.getClientbyEmail(emailExpediatire);
		//On recherche si l'expediataire est un candidat
			candidatExp=dao.getUsertbyEmail(emailExpediatire);
		 //resuperation de l'expeditaire
		 
		 //recuperation de l'url du CV
		 String urlCv=envoimsg.getUrlcvjoint();	
		//recuperation de la date d'envoie
		 String dateE=dao.getDateEnvoieMessage(envoimsg);
		
		
		   
	%>	<div class="row " style="margin-left: 10%;">		
			<div class="col-sm-10" >
			<%if(employeurExp!=null && employeurDest!=null){%>
			
            De:<b> <%=employeurExp.getPrenom() %> <%=employeurExp.getNom() %></b>
           
      	   </div>
			<br>
			<hr>
			<div class="col-sm-10">
				
            A: <%=employeurDest.getPrenom() %> <%=employeurDest.getNom()%>(<%=employeurDest.getEmail() %>)
      	   </div>
     	 	<br>
			<hr>
      	   
      	   
     	   <%} else if(employeurExp!=null && candidatDest!=null){%>
			<div class="col-sm-10">
           De:<b> <%=employeurExp.getPrenom() %> <%=employeurExp.getNom() %></b>
          
     	   </div>
     	   <br>
			<hr>
			<div class="col-sm-10">
				
           A: <%=candidatDest.getPrenom() %> <%=candidatDest.getNom()%>(<%=candidatDest.getEmail() %>)
     	   </div>
     	   <br>
			<hr>
			
     	  
     	   
    	   <%} else if(candidatExp!=null && candidatDest!=null){%>
			 <div class="col-sm-10">
           De:<b> <%=candidatExp.getPrenom() %> <%=candidatExp.getNom() %></b>
   
     	   </div>
     	   <br>
     	   <hr>
		
			<div class="col-sm-10">
				
           A: <%=candidatDest.getPrenom() %> <%=candidatDest.getNom()%>(<%=candidatDest.getEmail() %>)
     	   </div>
			<br>
     	   <hr>
     	   
     	   
    	   <%} else if(candidatExp!=null && employeurDest!=null){%>
			<div class="col-sm-10">      
           De:<b> <%=candidatExp.getPrenom() %> <%=candidatExp.getNom() %></b>
          
     	   </div>
			<br>
     	   <hr>
			<div class="col-sm-10">
				
           A: <%=employeurDest.getPrenom()%><%=employeurDest.getNom()%>(<%=employeurDest.getEmail() %>)
     	   </div>
     	   <br>
     	   <hr> 
    	   <%} %>
     	   
    
       <div class="col-sm-10">
           Envoyé: <%=dateE%>
     	   </div>
     	   <br>
     	   <%if(urlCv!=null){ %><a class="glyphicon glyphicon-paperclip" href="<%=urlCv%>">CV joint</a><%} %>
	  	<br>
     	  <hr>
	  	<div class="col-sm-20" style="background-color: white; min-height:100px; ">
           <%=envoimsg.getMessagText()%>          
     	 </div>

	
	<input type="hidden" name="idmsgInterne" value="<%=idmessage%>">
</div>
</div>
	<%}%>
	
</form>		
 </div>

 <%@include file="footer.jsp" %>
 </div>
</body>
</html> 