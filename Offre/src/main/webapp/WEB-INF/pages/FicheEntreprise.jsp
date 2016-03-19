<!DOCTYPE html>
<%@page import="modele.Annuaire"%>
<%@page import="dao.MappingDao"%>
 <%
 MappingDao dao=MappingDao.getInstance();
 String idA=request.getParameter("Id");
 int id=Integer.parseInt(idA);
Annuaire annuaire=dao.getAnnuaireById(id);
 %>
 
<html>
    
<body>
  <%@include file="menu.jsp" %>
    <script src="ressources/js/annuaire.js"></script>
<div id="main-content">
       	<%@include file="pub.jsp" %>
 	<div id="form-index">
   
     
	<div class="row">
 	<div class=" navbar-actu" >
 	<span class="glyphicon glyphicon-triangle-left"><a href="/Offre/resultaRech?nom=<%=annuaire.getNomEntreprise() %>&lieu=<%=annuaire.getAdresse() %>" style="color: yellow;">Retour aux resultats</a></span>
	 	<h2 class="h3" align="center">Visualisation de l'entreprise :<%=annuaire.getNomEntreprise() %></h2>
	 	
	</div> 
	</div>
<div class="row">
	<div class="col-md-offset-1 col-md-3">
	<div class="form-group">
	<a href="#"><img title="Ajouter une photo de profil" src="/Offre/ressources/images/gg.jpg"></a>
	</div>
	</div>
	<div class="col-md-offset-1 col-md-5">
	<div class="form-group">
		<div><h1><%=annuaire.getNomEntreprise() %></h1></div>
		<hr>
		<div><b>Adresse:</b><%=annuaire.getAdresse() %></div>
		<hr>
		<div><b>Domaine:</b> <%=annuaire.getDomaine() %></div>
		<hr>
		<div><b>Description:</b> <%=annuaire.getDescription() %></div>
		<hr>
		<div><b>Chiffre d'affaires:</b> <%=annuaire.getChiffreAffaire() %></div>
		<hr>
		<div><b>Date de création:</b> <%=annuaire.getDatecreation() %></div>
		<hr>
		<div class="form-group" align="center">
		 <button type="submit" style="background-color: yellow;" name="telephone" id="telephone" title="telephone"><span class="glyphicon glyphicon-phone-alt"></span> Afficher le telephone</button>
		</div>
		<div class="form-group" align="center">
	 	<span class="tel" id="tel"><h1><b>Telephone:</b><%=annuaire.getTelephone() %></h1></span>
	 	</div>
	 	<hr>
	
</div>
</div>
</div>
</div>

 <%@include file="footer.jsp" %>
</div>
 </body>
</html>
