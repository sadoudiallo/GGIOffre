 
<%!
private boolean userI;
private boolean clientI;

 %>
<%
    userI = (request.getSession().getAttribute("user") != null);
    clientI = (request.getSession().getAttribute("client") != null);
   %>
   
       <head>
        <title>Offre</title>
        <meta http-equiv="Access-Control-Allow-Origin" content="*">    
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link href="ressources/css/style.css" rel="stylesheet">
         <script src="ressources/js/flux.js"></script>
         <script  src="ressources/lib/jquery-1.9.1.min.js"></script>
   		 <script  src="ressources/lib/jssor.slider.mini.js"></script>
    </head>
 <%--  <%if(clientI){ %> --%>
 <body class="body"> 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"> <a href="/Offre/menuA">Accueil</a> </li>
      <li> <a href="/Offre/annuaire" class="glyphicon glyphicon-plus">Ajouter une entreprise</a> </li>    
		    
		
    </ul>
   
  </div>
</nav>
<form class="form-horizontal" action="rechercheEntreprise" method="post">
	<div class="form-group" align="center">
	 <span class="idlabel" id="idlabel"><h1>Trouver plus que des coordonnées des entreprises</h1></span>
	 </div>
	 <aside class="idsearch"> 
      <div class="form-group" align="center">
      <input type="search" placeholder="Quoi? Qui? Nom d'une entreprise ou domaine" size="30px" name="nom" id="nom">
        <input type="search"  placeholder="où? Lieu" size="30px" name="lieu" id="lieu">
        <button type="submit" class="btn btn-primary btn-sm" name="chercher" id="chercher" title="chercher"><span class="glyphicon glyphicon-eye-open"></span> Chercher</button>
      </div>
  </aside>
    </form>
 </body>
  <%-- <%}else{    
  	response.sendRedirect("Home");
  } %> --%>

