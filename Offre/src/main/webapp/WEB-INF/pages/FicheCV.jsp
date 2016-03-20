<!DOCTYPE html>
<%@page import="modele.Titre"%>
<%@page import="modele.Loisir"%>
<%@page import="modele.Langue"%>
<%@page import="modele.Formation"%>
<%@page import="modele.Experience"%>
<%@page import="modele.Competence"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Offre"%>
<%@page import="dao.MappingDao"%>
<%@page import="modele.Client"%>
<%@page import="modele.User"%>


 <%
 MappingDao dao=MappingDao.getInstance();
 String id=request.getParameter("Id");
int iduser=Integer.parseInt(id);
User user=dao.getUserbyId(iduser);
ArrayList<Competence> competences =dao.getAllCompetenceByIdUser(iduser);
ArrayList<Experience> experiences=dao.getAllExperienceByIdUser(iduser);
ArrayList<Formation> formations=dao.getAllFormationByIdUser(iduser);
ArrayList<Langue> langues=dao.getAllLangueByIdUser(iduser);
ArrayList<Loisir> loisirs=dao.getAllLoisirByIdUser(iduser);
String url=user.getUrlPhoto();
 Titre titre=new Titre();
 titre=dao.getTitreByUser(user.getEmail());

  
 %>
<html>
 <head >

 <link rel="shortcut icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/> 
<link rel="icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/>
	</head>
<body>

     <%@include file="menuInscrition.jsp" %>
     <%String urlCv=user.getUrlCV(); %>
<div id="main-content">
        	<%@include file="pub.jsp" %>
 	<div id="form-index">

 	<div class="navbar-actu" > 		
	 	<h2 class="h3" align="right"><%=titre.getNomTitre()%><%if(urlCv!=null){ %><a class="btn btn-primary view-pdf" href="<%=urlCv%>">Telecharger son CV joint</a><%} %></h2>
	 	
	</div> 	
 <div class="row">
	 <div class="col-sm-offset-0 col-sm-3">
 
	  <div class="competences">
	  
	    <div class="box">
 
 		<%if(url!=null){ %>
	  		<a href="#"><img alt="" src="<%=url %>" class="imagePetit"></a>
		  	<%}else{ %>
		  	<a href="/Offre/import"><img alt="" src="/Offre/ressources/photo/avatar.gif" class="imagePetit"></a>
		  	<%}%> 
 
        </div>
	  
	  
	<h2 class="h3" align="center"><%=user.getNom()%> <%= user.getPrenom() %></h2>
	  <div class="hr"><class="colText"></b></div>
		<h4 class="textcv" align="center">Contacts</h4>
		<div align="center"><%=user.getAdresse() %></div>
		<div align="center"><%=user.getTelephone() %></div>
		<div align="center"><%=user.getEmail() %></div>
		 <div class="hr"><class="colText"></b></div>
		<h4 class="textcv" align="center">Competences</h4>
		<%for(Competence comp:competences){ %>
		 <div align="center"><%=comp.getNom() %>: <%=comp.getDescription() %></div>
		 <%} %>
		 <div class="hr"><class="colText"></b></div>
		 <h4 class="textcv" align="center">Langues</h4>
		 <%for(Langue langue:langues){ %>
		 <div align="center"><%=langue.getNom()%>: <%=langue.getNiveau()%></div>
		 <%} %>
		 <div class="hr"><class="colText"></b></div>
		 <h4 class="textcv" align="center">Loisirs</h4>
		 <%for(Loisir loisir:loisirs){ %>
		 <div align="center"><%=loisir.getNom()%></div>
		 <%} %>
</div>	 
</div>
	
	<div class=" col-sm-7">
			<h4 class="textcva">Experiences Professionnelles</h4>
			<%for(Experience exp:experiences){ %>
			<div class="textc" style="color: maroon;"><%=exp.getDatedebut() %> - <%=exp.getDatefin() %>:<%=exp.getNomEntreprise() %></div>
			<div class="textc"><b><%=exp.getNomExp() %></b></div> 
			<div class="textc"><%=exp.getDescriptionExp() %></div>
			<%} %>
			<h4 class="textcva">Formations</h4>
			<%for(Formation formation:formations){ %>
			<div class="textc" style="color: maroon;"><%=formation.getDateFormation() %> </div>
			<div class="textc"><b><%=formation.getTitre()%></b></div> 
			<div class="textc"><b><%=formation.getDomaine()%></b></div>
			<div class="textc">Niveau:<%=formation.getNiveau() %></div>
			<div class="textc"><%=formation.getDescription() %></div>	 
			<div class="textc">Diplome:<%=formation.getDiplomeObtenu() %></div>
			<div class="textc">Lieu de Formation:<%=formation.getOrigine() %></div>
			
			<%} %>
			</div>	
		</div>
	
</div>
<%@include file="footer.jsp" %>
</div>
 </body>
</html>
