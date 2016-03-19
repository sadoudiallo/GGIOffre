<!DOCTYPE html>
<%@page import="modele.Offre"%>
<%@page import="dao.MappingDao"%>
<%@page import="modele.Client"%>
<%@page import="modele.User"%>


 <%
 MappingDao dao=MappingDao.getInstance();
 Offre offre=new Offre();
 String code=request.getParameter("code");
 System.out.println("voici le code de l'offre"+ code);
 offre=dao.getOffrebyCode(code);
 Client cli=new Client();
 cli=offre.getClient();
 System.out.println("alors voici le bool user"+ user);
 %>
<html>
    <head >

 <link rel="shortcut icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/> 
<link rel="icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/>
	</head> 
<body>

     <%@include file="menu.jsp" %>
	<div id="main-content">
       	<%@include file="pub.jsp" %>
 	<div id="form-index">
 	<div class=" navbar-actu" >
	 	<h2 class="text" align="center">Visualisation de l'offre</h2> 
	</div>
<div class="blocOf">
	<div align="right"><b class="colText">Date de publication:</b> <%=offre.getDatePublication() %></div>
	<div><b class="colText">Numéro de l'offre:</b> <%=offre.getCode() %></div>
	 <div class="hr"><b class="colText">Titre de L'offre</b></div>
	<div><%=offre.getTitre() %></div>
	
	 <div class="hr"><b class="colText">Déscritpion de l'offre</b></div>
	<div><%=offre.getDescription() %></div>
	<div class="hr"><b class="colText">Qualification Requise</b></div>
	<div><%=offre.getQualification() %></div>

 	<div class="hr"><b class="colText">Employeur ou Entreprise</b></div>
	<div><%=cli.getPrenom() %></div>
	
 </div>
	<%if(user) {

		  String email= session.getAttribute("ident").toString().toString();
		  User u=dao.getUsertbyEmail(email);
		 
	
		%>
	   <%if(u.isAbonner() || !u.isAbonner()){%>
	   <div class=" navbar-actu" >
		 	<h3 class="text" align="center">Pour postuler à cette Offre voici les informations de l'employeur</a></h3>
		</div> 
		
	<div class="row">
		<div class="col-md-offset-0 col-md-8">   
		
	    <aside class="idPostuler">
		<div><b>Veuillez adresser par mail, votre CV et une lettre de motivation en précisant le numéro de l'offre à :</b></div>
		<div style="color:white;"><%=cli.getNom() %> - <%=cli.getPrenom() %></div>
		<div> <span class="colText">Téléphone : </span><%=cli.getTelephone() %></div>
		<div> <span class="colText">Courriel : </span><%=cli.getEmail() %></div>
		<hr>
		<div class="fb-like" data-share="true" data-width="450" data-show-faces="true" align="center">	</div>
		</aside>
	</div>

	<div class=" col-md-offset-0 col-md-4">   
		<aside class="idEnvoiMsg"> <b>
		<div>
		Joindre votre CV enregistré					
		<input name="cvjoint" value="oui" type="radio" required="required">oui
		<input name="cvjoint" value="non" type="radio" required="required">non	
				 		
		<hr><a href="/Offre/saisi?id=<%=u.getIdUser() %>&dest=<%=cli.getEmail() %>&c=<%=code%>&postule=ok">Cliquez pour postuler en ligne avec votre CV </a></b>
		
	</div>
		</aside>
	</div>
	</div>
		<%} else{%> 
		<div class=" navbar-actu" >
		 	<h3 class="text" align="center">Vous devez vous abonner pour voire les contacts de l'employeur et postuler à cette Offre <a href="#<%-- Offre/Abonnement?id=<%=cli.getID() %> --%>">  veuillez vous abonner</a></h3>
		</div> 
		<aside>
		<div style="color:black;"><%=cli.getNom() %> - <%=cli.getPrenom() %></div>
		<div> <span class="colText">Téléphone : </span></div>
		<div> <span class="colText">Courriel : </span></div>
		</aside>
		<%} }else{%>
			<div class="navbar-actu" >
		 	<h3 class="text" align="center">Vous devez vous inscrire pour pouvoir postuler aux offres d'emploi<a href="/Offre/SignIn" style="color: blue;"> veuillez vous inscrire</a></h3>
			</div> 
			<aside>
			<div style="color:black; "><%=cli.getNom() %> - <%=cli.getPrenom() %></div>
			<div> <span class="colText">Téléphone : </span></div>
			<div> <span class="colText">Courriel : </span></div>
			</aside>
		<%} %>
		
	
	</div>
	 <%@include file="footer.jsp" %>
	</div>
 </body>
</html>
