<!DOCTYPE html>
<html>
    <head>
        <title>Offre</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link href="ressources/css/style.css" rel="stylesheet">
        <script src="ressources/js/signin.js"></script>
    </head>
<body>
     <%@include file="menuInscrition.jsp" %>
	 

<div class="container">
<form class="form-horizontal" action="LogIn" method="post">
	<div class="row">
	 	<div class="navbar navbar-actu" >
		 	<h2 class="h3" align="center">Connexion</h2>
		</div> 
	</div>
	<div class="row">
		<div class="col-md-offset-4 col-md-4">
			<div class="form-group">             
	           <label for="email" class="col-sm-3 control-label">Email</label>
	           <div class="col-sm-9">
	               <input type="email" class="form-control" name="email" id="email" placeholder="Email" required="required">
	           </div>
	       </div>
	        <div class="form-group">
	            <label for="password" class="col-sm-3 control-label">Password</label>
	            <div class="col-sm-9">
	                <input type="password" name="password" class="form-control" id="password" placeholder="Password" required="required">
	            </div>
	        </div>
        
        
   	
       <label for="type" class="col-sm-3 control-label">Statut</label>		
			<div class="btn-group" data-toggle="buttons">
				<label class="btn btn-primary">
					<input name="statut" value="employeur" type="radio" required="required">Employeur
				</label>
				<label class="btn btn-primary">
					<input name="statut" value="candidat" type="radio" required="required">Candidat
				</label>
		</div>
		
		</div>
		</div>
        
        
          <div class="form-group">
              <div class="col-sm-offset-5 col-sm-9">
                  <div class="checkbox">
                      <label class="">
                       <input type="checkbox" class="">Se souvenir de moi</label>
                  </div>
              </div>
          </div>
          <div class="form-group last">
              <div class="col-sm-offset-5 col-sm-9">
                  <button type="submit" class="btn btn-primary">Sign in</button>
                  <button type="reset" class="btn btn-primary">Reset</button>
              </div>
          </div>
          <br>
          <div class="col-sm-offset-4 col-sm-9">
	 
	    <div class="" >
	    	Non enregistré? <a href="/Offre/SignIn" class="">Enregistre toi ici</a>
	    </div>	
	    </div>
    	</form>
    
	    
     </div>
     
 </body>
</html>
