<!DOCTYPE html>
<%@page import="modele.Titre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MappingDao"%>
<%@page import="modele.Client"%>
<%@page import="modele.User"%>


 
<html>
 <head >

 <link rel="shortcut icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/> 
<link rel="icon" href="/Offre/ressources/images/logoggi.jpg" type="image/jpg"/>
	</head>
<body>

     <%@include file="menuInscrition.jsp" %>
	  <%
	 if(!userI){ 
	response.sendRedirect("SignIn?err=errcv");
	}else{
	
	 MappingDao dao=MappingDao.getInstance();
	 ArrayList<Client> clients=new ArrayList<Client>();
	 clients=dao.getAllClient();
	 String email=session.getAttribute("ident").toString();
	 ArrayList<Titre> titres=dao.getAllTitreByUser(email);
	 %>

		
 <script src="ressources/js/cv.js"></script>
<div id="main-content">
       	<%@include file="pub.jsp" %>
<div id="form-index">
<form class="form-horizontal" action="SaveCV" method="post">

 	<div class=" navbar-actu" >
	 	<h2 class="text" align="center">Edition de votre CV</h2>
	</div> 

	<!-- ---------------Partie Experience------------------------------------ -->
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="employeur">Nom de l'Employeur</label>
		<input type="text" class="form-control" id="employeur" name="employeur" placeholder="Nom de l'employeur">
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
		<div class="col-md-offset-2 col-md-3">
			<div class="form-group">
			<label for="datedebut">Date Début</label>
			<div class="input-group">		
			<span class="input-group-addon glyphicon glyphicon-time"></span>
			<input type="date" class="form-control" id="datedebut" name="datedebut" placeholder="Date Début">
			</div>
			</div>
		</div>
		 
		 
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="datefin">Date Fin</label>
		<div class="input-group">		
		<span class="input-group-addon glyphicon glyphicon-time"></span>
		<input type="date" class="form-control" id="datefin" name="datefin" placeholder="Date Fin" aria-describedby="basic-addon1">
		</div>
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
	<!-- ---------------Partie competence------------------------------------ -->
 	<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="competence">Nom de la competence</label>
		<input type="text" class="form-control" id="competence" name="competence" placeholder="Nom de la competence">
		</div>
		</div>
 	
	<div class="row">
	
		<div class="col-md-offset-2 col-md-7">
		<div class="form-group">
		<label for="descriptioncomp"> Description de la competence</label>
		<textarea rows="4" cols="50" class="form-control" id="descriptioncomp" name="descriptioncomp" placeholder="Déscription de la competence"></textarea>
		
		</div>
		</div>
	</div>
	<!-- ---------------Partie Formation------------------------------------ -->
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="titref">Nom de le Formation</label>
		<input type="text" class="form-control" id="titref" name="titref" placeholder="Nom de votre Formation">
		</div>
		</div>
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="descritionf">Titre</label>
		<textarea rows="4" cols="50" class="form-control" id="descriptionf" name="descriptionf" placeholder="Déscription de la Formation"></textarea>
		</div>
		</div>
	</div>
	
	
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="origineF">Origine</label>
		<input type="text" class="form-control" id="originef" name="originef" placeholder="Origine de votre Formation">
		</div>
		</div>
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="datef">Date Formation</label>
		<input type="date" class="form-control" id="datef" name="datef" placeholder="Date de votre Formation">
		</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="domainef">Domaine </label>
		<input type="text" class="form-control" id="domainef" name="domainef" placeholder="Nom du domaine votre Formation">
		</div>
		</div>
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="niveauF">Niveau</label>
		<select name="niveauf" id="niveauf">
				  <option value="Bac+1"  >Bac+1</option> 
				  <option value="BAC+2">Bac+2</option>
				  <option value="BAC+3">Bac+3</option>
			  	 <option value="BAC+4">Bac+4</option>
		  	  	  <option value="BAC+5">Bac+5</option>
	  	  	  	  <option value="BTS">BTS</option>
				</select>
		</div>
		<div class="form-group">
		<label for="diplomef">Diplome Obtenu</label>
			<select name="diplomef" id="diplomef">
				<option value="Oui">Oui</option>
				<option value="Non">Non</option>
				<option value="En Cours">En Cours</option>			
			</select>
		</div>
		</div>
	</div>
	<!-- ---------------Fin Partie Formation------------------------------------ -->
	<!-- ---------------Partie Langue------------------------------------ -->
	<div class="row">
		<div class="col-md-offset-3 col-md-3">
		<div class="form-group">
		<label for="nomlangue">Langue</label>
			<select name="langue" id="nomlangue">
				<option value=" ">Choisir</option>
				<option value="Francais">Français</option>
				<option value="Anglais">Anglais</option>
				<option value="Arabe">Arabe</option>	
				<option value="Japonais">Japonais</option>
				<option value="Allemand">Allemand</option>
				<option value="Chinois">Chinois</option>	
				<option value="Poular">Poular</option>
				<option value="Soussou">Soussou</option>
				<option value="Malinke">Malinke</option>
				<option value="Guerze">Guerze</option>
				<option value="Toma">Toma</option>
				<option value="Kissi">Kissi</option>
				<option value="African">African</option>
				<option value="Swahili">Swahili</option>	
			</select>
		</div>
		</div>
		<div class="col-md-offset-0 col-md-3">
		<div class="form-group">
		<label for="niveaulangue">Niveau</label>
			<select name="niveaulangue" id="niveaulangue">
				<option value="Moyen">Moyen</option>
				<option value="Courant">Courant</option>
				<option value="Maternel">Maternel</option>	
				<option value="professionel">professionel</option>			
			</select>
		</div>
		</div>
	</div>
		<!-- ---------------Fin Partie Langue------------------------------------ -->
		
		
		
		<!-- ---------------Partie Titre------------------------------------ -->
	<div class="row">
		<div class="col-md-offset-3 col-md-2">
		<div class="form-group">
		<label for="nomtitre">Titre</label>
			<select name="nomtitre" id="nomtitre">
			
				<option value=" ">Choisir parmi vos Titres</option>
				<%
				 for(Titre titr:titres){%>
					 <option value="<%=titr.getNomTitre() %>"><%=titr.getNomTitre() %></option>
				<% }%>
				
					
			</select>
		</div>
		</div>
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
			<label for="nomNewtitre">Ajouter Nouveau Titre</label>
			<input type="text" class="form-control" id="nomNewtitre" name="nomNewtitre" placeholder="ex:Developpeur site web">
		</div>
		</div>
	</div>
		<!-- ---------------Fin Partie Titre------------------------------------ -->
		
		
		
		
		<!-- ---------------Partie Loisir----------------------------------- -->	
		
	<div class="row">
		<div class="col-md-offset-4 col-md-3">
		<div class="form-group">
		<label for="loisir">Loisir</label>
		<input type="text" class="form-control" id="loisir" name="loisir" placeholder="Ajouter un Centre d'interet">
		</div>
		</div>
	</div>
	
	<!-- ---------------Informations----------------------------------- -->	
	
		
		<div class="form-group" align="center">
		<label for="info" id="info" style="color: green;"><h3>Veuillez choisir une option a gauche pour l'édition de votre CV</h3></label>
		
		</div>
	
	<!-- ---------------Partie Menu------------------------------------ -->
	<div class="row">
		<div class="form-group last">
              <div class="col-sm-offset-5 col-sm-9">
             
              	 <% 
              	 	User user=new User();
              	 	user=dao.getUsertbyEmail(email);
              	 %>
               	  <input hidden value="<%= email %>" name="email" >
         
               	 
                  <!-- <button title="Ajouter" type="submit" class="btn btn-primary">Ajouter</button> -->
                  <button title="Valider" type="submit" class="btn btn-primary" id="valider">Valider</button>
                  <button title="Reset" type="reset" class="btn btn-primary">Reset</button>
                 
              </div>
               <aside class="divCompetence" >
	         
					 	<h2 class="h3" align="center">Menu</h2>
					<hr>
               		<a href="#" title="TitreCv" class="btn btn-primarycv">Ajouter Titre</a>
                   <a href="#" title="Ajouter" class="btn btn-primarycv">Ajouter Experience</a>
                   <a href="#" title="Competence" class="btn btn-primarycv">Ajouter Competence</a>
                   <a href="#" title="Formation" class="btn btn-primarycv">Ajouter Formation</a>
                   <a href="#" title="Langue" class="btn btn-primarycv">Ajouter Langue</a>
                   <a href="#" title="Loisir" class="btn btn-primarycv">Ajouter Loisir</a>
                   <hr>
                    <a href="#" title="exporter" class="btn btn-primary">Exporter votre CV</a>
                   <hr>
                   <a href="/Offre/import?cv=ok" title="Télécharger un CV" class="btn btn-primary">Telecharger CV</a>
                  <hr>
            		
                  <a href="/Offre/FicheCV?Id=<%=user.getIdUser() %>" class="btn btn-primary">Visualiser mon CV</a>
                  <hr>
                   </aside>
          </div>
	</div>
	
</form>
</div>
 <%@include file="footer.jsp" %>
</div>
<%}%>
    </body>
</html>
