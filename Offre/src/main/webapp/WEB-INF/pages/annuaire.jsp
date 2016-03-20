<!DOCTYPE html>
<html>
    
<body>

     <%@include file="menu.jsp" %>
<div id="main-content">
 	       	<%@include file="pub.jsp" %>
 	<div id="form-index">
<form class="form-horizontal" action="AnuaireEntreprise" method="post">
	<div class="row">
 	<div class="navbar-actu" >
	 	<h2 class="h3" align="center">Ajout d'entreprise dans l'annuairee</h2>
	</div> 
	</div>
	<div class="row">
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="nom">Nom de l'entreprise</label>
		<input type="text" class="form-control" id="nom" name="nom" placeholder="Nom de l'entreprise">
		</div>
		</div>
		<div class="col-md-offset-1 col-md-3">
		<div class="form-group">
		<label for="domaine">Domaine</label>
		<input type="text" class="form-control" id="domaine" name="domaine" placeholder="Domaine de l'entreprise">
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
	
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="chiffre">Chiffre d'affaire</label>
		<input type="text" class="form-control" id="chiffre" name="chiffre" placeholder="Chiffre d'affaire">
		</div>
		</div>
		
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="datecreate">Date de Création</label>
		<div class="input-group">		
		<span class="input-group-addon glyphicon glyphicon-time"></span>
		<input type="date"  id="datecreate" name="datecreate" >
		</div>
		</div>
		</div>
	</div>
	<div class="row"> 
		<div class="col-md-offset-2 col-md-3">
		<div class="form-group">
		<label for="adresse">Adresse</label>
		<div class="input-group">		
		<span class="input-group-addon glyphicon glyphicon-globe"></span>
		<input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse" aria-describedby="basic-addon1">
		</div>
		</div>
		</div>

		<div class="col-md-offset-2 col-md-2">
		<div class="form-group">
		<label for="tel">Telephone</label>
		<input type="text" class="form-control" id="tel" name="tel" placeholder="Numéro de telephone">
		</div>
		</div>
		 
		
	</div>
	
	<div class="row">
		<div class="form-group last">
              <div class="col-sm-offset-2 col-sm-3">
              <div class="form-group">
					<label for="tel">Logo</label>
                   <input type="file" name="file" size="60" class="btn" />
              </div>
              </div>
               <div class="col-sm-offset-5 col-sm-9">
                  <button type="submit" class="btn ">Valider</button>
                  <button type="reset" class="btn ">Reset</button>
              </div>
          </div>
	</div>
	<hr>
	<!-- <div class="row">
		<div class="form-group last">
              <div class="col-sm-offset-5 col-sm-9">
                  <button type="submit" class="btn ">Valider</button>
                  <button type="reset" class="btn ">Reset</button>
              </div>
          </div>
	</div> -->
</form>
</div>
<%@include file="footer.jsp" %>
</div>
   </body >
   
  

</html>
