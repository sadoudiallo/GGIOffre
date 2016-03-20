<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%String erreur=request.getParameter("err"); 

%>
<html>
  <head >

 <link rel="shortcut icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/> 
<link rel="icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/>
	</head>
<body>
     <%@include file="menuInscrition.jsp" %>
    
<div id="main-content">
       	<%@include file="pub.jsp" %>
	<div id="form-index"> 
<form class="form-horizontal" action="SignIn" method="post">

 	<div class=" navbar-actu" >
	 	<h4 class="h3" align="center">Inscription</h4> 
	</div>
	<%if(erreur!=null){ %>
	<%if(erreur=="sinscrire"){%>
	<div class="row"> 
	<span><h4 style="color: #A52A43;">Cet Email existe deja dans notre base veuillez choisir un autre</h4></span>
	</div>
	<%}%>

	<%if(erreur.equals("errof") && !clientI){%>
	<div class="row"> 
	<span><h2 style="color: #A52A43;">Vous devez vous inscrire en tant qu'employeur pour pouvoir creer des offres</h2></span>
	</div>
	<%}%>
	<%if(erreur.equals("errcv") && !userI){%>
	<div class="row"> 
	<span><h2 style="color: #A52A43;">Vous devez vous inscrire en tant que Candidat pour publier un CV</h2></span>
	</div>
	<%}%>
  <%} %>
	
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="nom">Nom</label>
		<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom">
		</div>
		</div>
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="prenom">Prénom</label>
		<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom">
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-2 col-md-7">
		<div class="form-group">
		<label for="email">Email address</label>
		<input type="text" class="form-control" id="email" name="email" placeholder="Entrer email">
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="Password">Mot de passe</label>
		<input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe">
		</div>
		</div>
		 <span class="error_passwrd"></span>
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="Vpassword">Vérification mot de passe</label>
		<input type="password" class="form-control" id="vpassword" name="vpassword" placeholder="Vérification mot de passe">
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="input-group">
		<span class="input-group-addon glyphicon glyphicon-earphone"></span>
		<input type="text" class="form-control" id="telephone" name="telephone" placeholder="Téléphone">
		</div>
		</div>
		<div class="col-md-offset-1 col-md-3">
		<div class="input-group">
		<span class="input-group-addon glyphicon glyphicon-globe"></span>
		<input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse">
		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="datenais">Date de naissance</label>
		<input type="date"  class="form-control" id="datenais" name="datenais" placeholder="Date Naissance">
		</div>
		</div>
		<!-- <input type="date" name="bday"  id="datenais" name="datenais" placeholder="Date Naissance">
		 -->
		<div class="col-md-offset-1 col-md-3">
		
		<div class="form-group">
		<label for="datenais">S'inscrire en tant que</label>
			<div class="btn-group" data-toggle="buttons">
				<label class="btn btn-primary">
					<input name="type" value="employeur" type="radio" required="required">Employeur
				</label>
				<label class="btn btn-primary">
					<input name="type" value="candidat" type="radio" required="required">Candidat
				</label>
		</div>
		</div>
	</div>
	</div>
	<div class="row">
		<div class="col-md-offset-5 col-md-1">
		<button type="submit" class="btn btn-primary">Valider</button>
		 <!-- <input type="submit" name="submit" class="btn btn-primary" value="S'inscrire" /> -->
		</div>
	</div>

</form>
</div>
 <%@include file="footer.jsp" %>
</div>

    </body>
</html>
