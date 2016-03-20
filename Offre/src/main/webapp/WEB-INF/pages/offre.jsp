<!DOCTYPE html>
<%@page import="modele.Client"%>
<%@page import="modele.User"%>

<html>
   
<body>
     <%@include file="menuInscrition.jsp" %>
    <%if(!clientI){ 
 response.sendRedirect("SignIn?err=errof");
} else{%>
 <%
 String email=session.getAttribute("ident").toString();
 %>
<div id="main-content">
 <%@include file="pub.jsp" %>
	<div id="form-index"> 
<div class="navbar-actu" >
	 	<h2 class="h3" align="center">Ajout d'une Offre</h2>
	</div> 
<form class="form-horizontal" action="SaveOffre" method="post">

 	

	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="code">Code</label>
		<input type="text" class="form-control" id="code" name="code" placeholder="Code de l'offre">
		</div>
		</div>
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="titre">Titre</label>
		<input type="text" class="form-control" id="titre" name="titre" placeholder="Titre de l'offre">
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-2 col-md-7">
		<div class="form-group">
		<label for="description">Déscription</label>
		<textarea rows="4" cols="50" class="form-control" id="description" name="description" placeholder="Déscription de l'offre"></textarea>
		
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="qualification">Qualification réquise</label>
		<input type="text" class="form-control" id="qualification" name="qualification" placeholder="Qualification réquise">
		</div>
		</div>
		 
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="adresse">Adresse</label>
		<div class="input-group">		
		<span class="input-group-addon glyphicon glyphicon-globe"></span>
		<input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse" aria-describedby="basic-addon1">
		</div>
		</div>
		</div>
	</div>
	
	
	
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="duree">Durée Hebdomadaire</label>
		<input type="text" class="form-control" id="duree" name="duree" placeholder="Durée hebdomadaire">
		</div>
		</div>
		 
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="datepub">Date de publication</label>
		<div class="input-group">		
		<span class="input-group-addon glyphicon glyphicon-time"></span>
		<input type="date" min="2016-01-01" id="datepub" name="datepub" >
		</div>
		</div>
		</div>
	</div>
	
	
	<div class="row">
		<div class="form-group last">
              <div class="col-sm-offset-5 col-sm-9">
               	  <input hidden value="<%= email %>" name="email" >
                  <button type="submit" class="btn btn-primary">Valider</button>
                  <button type="reset" class="btn btn-primary">Reset</button>
              </div>
          </div>
	</div>
</form>
</div>
 <%@include file="footer.jsp" %>

</div>
   </body>
</html>
<%}%>