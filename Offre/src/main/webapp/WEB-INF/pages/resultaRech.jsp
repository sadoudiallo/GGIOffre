<%@page import="java.util.ArrayList"%>
<%@page import="dao.MappingDao"%>
<%@page import="modele.Annuaire"%>
<%@page import="modele.Postule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
MappingDao dao=MappingDao.getInstance();
String nom=request.getParameter("nom");
String lieu=request.getParameter("lieu");
ArrayList<Annuaire> annuaires=dao.getAnnuaireByDomaineNomAdresse(nom, lieu);
%>

<html>
<head>
  
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
   <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
   <link href="ressources/css/style.css" rel="stylesheet">
    <script  src="ressources/lib/jquery-1.9.1.min.js"></script>
   <script src="ressources/js/annuaire.js"></script>
   	
<title>Offre</title>
</head>
<body>
<%@include file="menu.jsp"%>
	<<div id="main-content">
       	<%@include file="pub.jsp" %>
	<div id="form-index"> 
	
		<div class="navbar navbar-actu" >
			 	<h2 class="h3" align="center">Le resultat de votre recherche pour:<%= nom%> et <%=lieu %></h2>
		</div> 
		<div class="divAlign">
		<%int i=0; %>
	      <%if(annuaires!=null){ %>
	      	<% for(Annuaire annuaire:annuaires) {%>	      	
      		<%String nomE= annuaire.getNomEntreprise();
      			String domaine=annuaire.getDomaine();	
      			String tel=annuaire.getTelephone();
      			String adresse=annuaire.getAdresse();
      			%>
	      	<div >
	      		<a href="/Offre/FicheEntreprise?Id=<%=annuaire.getId() %>"><b><span style="color:black; background-color: yellow;"><%=++i %></span> <%=nomE %></b></a>
	      	</div>
	      	<div >
	      		<a href="/Offre/FicheEntreprise?Id=<%=annuaire.getId() %>"> <%=adresse %></a>
	      	</div>
	      	<div >
	      		<a href="/Offre/FicheEntreprise?Id=<%=annuaire.getId() %>"><%=domaine %></a>
	      	</div>
	      	
	      	<hr>
	      	<%}%>
	     
	      <%}else{ %>
	      <h2 class="h3" align="center" style="color: red;">Il n'ya aucun resultat pour:<%= nom%> se trouvant a <%=lieu %></h2>
	      <%}
	       %>
	 
</div>
	</div>
	 <%@include file="footer.jsp" %>
	 </div>
</body>
</html>