 <!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">   
<%@page import="modele.Offre"%>
<%@page import="modele.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MappingDao"%>
<%@page import="modele.Client"%>
<html>

 
  <script src="ressources/js/scriptFB.js"></script>
  <%
	response.addHeader("Access-Control-Allow-Origin", "*");	
	if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
		// CORS "pre-flight" request
	response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
    response.addHeader("Access-Control-Allow-Headers", "Authorization");
    response.addHeader("Access-Control-Allow-Headers", "Content-Type");
	response.addHeader("Access-Control-Max-Age", "1");
	}
%> 

      <%@include file="header.jsp" %>


<%
MappingDao doa=MappingDao.getInstance();

%>
 
<%!
private boolean user;
private boolean client;

 %>
<%
String erreur=request.getParameter("err");

    user = (request.getSession().getAttribute("user") != null);
    client = (request.getSession().getAttribute("client") != null);
    Client clientu=new Client();
    User us=new User();
   int nblcient=doa.getAllClient().size();
   int nbuser=doa.getAllUser().size();
   int totalInscrit=nblcient+nbuser;
   int nb=doa.getAllNbConnecte().size();
    System.out.println("voici le nobmre de connectés"+nb);
    System.out.println("la racine du projet"+request.getContextPath());
    System.out.println("voici chemin absolue"+request.getContextPath()+"/ressources/images");
    String racine=getServletContext().getRealPath("")+"/photos";
%>

	<nav class="navb">
		 <a class="navbar-brand" href="/Offre/Home"><h4 class="text"><span class="glyphicon glyphicon-home" aria-hidden="true"> Acceuil</span></h4></a> 
	  <ul>
<%if(erreur!=null){%>
	  <%if(erreur.equals("connect")) {%>
	  
		 <%System.out.println("voici l'erreur dans le bloc"+erreur);%>
	
	<div class="alert alert-warning alert-dismissible fade in" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	   <strong >Ouff</strong> <a href="#" class="alert-link">Votre email ou mot de passe est incorrect</a> Verifiez et réessayez.
</div>
<%} if(erreur.equals("validate")) {%>	
	<div class="alerte" >
		<div class="alert alert-warning alert-dismissible fade in" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close" >
	    <span aria-hidden="true">&times;</span>
	  </button>
	   <strong >Oufff!!!!</strong> <a href="#" class="alert-link">Vous n'avez pas valider votre compte</a> Verifiez que vous avez bien une boite email valide.
	</div>
</div>
<%} %>	  
	  
  <%}else{%>
  
	  <%if(user) {%>
	    <%
	
	     	String email= session.getAttribute("ident").toString().toString();
	  		 us=doa.getUsertbyEmail(email);
	  		 String url=us.getUrlPhoto();
		    long nbMessage=doa.getCountMessageRecuByEmailByUser(email);
			 %>
			 
			 <!-- Affichage des offres par user dans une fenetre modale-->
			<% ArrayList<Offre> ofres=doa.getAllOffreByUser(email);
			%>
			<div class="listeOffre">
			<div id="oModal" class="oModal">
			  <div>
			    <header class="head">
			      <a href="#fermer" title="Fermer la fenêtre" class="droite">X</a>
			      <center> <h4 style="color:black; ">Les offres auxquelles vous avez postulées </h4></center>
			     </header>
			     
			<%if(ofres!=null){ %>		
			<%for(Offre of:ofres){ %>
        		<%String tit= of.getTitre();%>
			<div align="center"><a href="/Offre/FicheOffre?code=<%=of.getCode() %>" ><%=tit%></a></div>

            <%}
			}else{%> 
			<span style="color: red;">Vous n'avez postulé a aucune offre pour le moment</span>
		<%} %>
	     <footer class="cf">
			      <a href="#fermer" class="btn droite" title="Fermer la fenêtre">Fermer</a>
			 </footer>
			  </div>
			</div> 
		<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><a href="#oModal" style="color: white;">Mes Offres</a></span>
		</div>
		
			 <div class="messagerecu"><span class="glyphicon glyphicon-envelope" aria-hidden="true"><a href="/Offre/ListeMessage" class="text">Mail(<span style="color: red;"><%=nbMessage %></span>)</a></span></div> 
		  	<div class="creercompte"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"><a href="/Offre/Cv" class="text">Créer votre CV</a></span></div>
		  	 <div class="nbinscrit"><span style="color: red;"><%=totalInscrit %>inscrits</span> dont </div>
		  	  <div class="nbconnectet"><span style="color: red;"><%=nb %>Connectes</span></div>
		  	 <%if(url!=null){ %>
	  		<a data-toggle="dropdown" href="#"><img title="<%=us.getNom()%> <%=us.getPrenom() %>" src="<%=url %>" class="photo"></a>
             <ul class="dropdown-menu dropdown-menu-right">
              <li><a href="#">Modifier votre profil</a></li>
              <li><a href="/Offre/import">Changer votre photo</li>
             <%}else{ %>
             <a data-toggle="dropdown" href="#"><img title="<%=us.getNom()%> <%=us.getPrenom() %>&nbsp;Ajouter une photo de profil" src="/Offre/ressources/photo/avatar.gif" class="photo"></a>
             <ul class="dropdown-menu dropdown-menu-right">
              <li><a href="#">Modifier votre profil</a></li>
              <li><a href="/Offre/import">Ajouter une Photo de Profil</li>
             <%} %>
              <li class="divider" style="color: red"></li>
              <li><a  href="/Offre/Deconnect?mail=<%=email %>" class="text">Déconnexion</a></li>
            </ul>
         
	  	</div>
		  	<%}
		  	 
	  
	  %>
	  	<%if(client) {%> 
			<%
		
			String email= session.getAttribute("ident").toString().toString();
		 	 clientu=doa.getClientbyEmail(email);
		 	 String url=clientu.getUrlPhoto();
		 	 if(clientu.getStatut().equals("admin"))
		 	 {
		 		 long nbMessage=doa.getCountMessagebyEmail(email);
		 		 %>
		 		 <div class="messagerecu"><span class="glyphicon glyphicon-envelope" aria-hidden="true"><a href="/Offre/ListeMessage" class="text">Mail(<span style="color: red;"><%=nbMessage %></span>)</a></span></div>
		 	<% }else{
		 		long nbMessage=doa.getCountMessageRecuByEmailByClient(email);
		 		 %>
		 		 
		 		 <div class="messagerecu"><span class="glyphicon glyphicon-envelope" aria-hidden="true"><a href="/Offre/ListeMessage" class="text">Mail(<span style="color: red;"><%=nbMessage %></span>)</a></span></div>
		 		
		 	<%}
			%>
			<!-- Affichage des offres par client dans une fenetre modale-->
			<% ArrayList<Offre> ofres=doa.getOffreByClient(email);
			%>
			<div class="listeOffre">
			<div id="oModal" class="oModal">
			  <div>
			    <header class="head">
			      <a href="#fermer" title="Fermer la fenêtre" class="droite">X</a>
			       <h2 style="color: black;">Cliquez pour voire la liste des postulants </h2>
			     </header>
			     
			<%if(ofres!=null){ %>		
			<%for(Offre of:ofres){ %>
          	<div align="center">
             <a href="/Offre/ListeUser?code=<%=of.getCode() %>" style="color: blue;" > <%=of.getTitre() %></a>
            </div>
            <%}
			}else{%> 
			<span style="color: red;">Aucune Offre Publiée</span>
		<%} %>
		   <footer class="cf">
			      <a href="#fermer" class="btn droite" title="Fermer la fenêtre">Fermer</a>
			     </footer>
			  </div>
			</div> 
			<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><a href="#oModal" style="color: white;">Mes Offres</a></span>
		</div>
		<!-- Fin d'affichage -->
		
		
		<div class="creeranuuaire"><span class="glyphicon glyphicon-plus" aria-hidden="true"><a href="/Offre/annuaire" class="text">Ajout Entreprise</a></span></div>
	  	 <div class="creercompte"><span class="glyphicon glyphicon-briefcase" aria-hidden="true"><a href="/Offre/AddOffre" class="text">Créer une offre</a></span></div>
	  	 <%-- <div class="connect"><span class="glyphicon glyphicon-log-out" aria-hidden="true"><a  href="/Offre/Deconnect?mail=<%=email %>" class="text">Déconnexion</a></span></div> --%>
	  	 <div class="nbinscrit"><span  style="color: red;"><%=totalInscrit %>inscrits</span> dont</span></div>
	  	<div class="nbconnectet"><span style="color: red;"><%=nb %>Connectes</span></div>
	  	<div class="photo">
	  	<%if(url!=null){ %>	  		
            <a data-toggle="dropdown" href="#"><img title="<%=clientu.getNom()%> <%=clientu.getPrenom() %>" src="<%=url %>" class="photo"></a>
             <ul class="dropdown-menu dropdown-menu-right">
              <li><a href="#">Modifier votre profil</a></li>
              <li><a href="/Offre/import">Changer votre photo</li>
             <%}else{ %>
             <a data-toggle="dropdown" href="#"><img title="<%=clientu.getNom()%> <%=clientu.getPrenom() %>&nbsp;Ajouter une photo de profil" src="/Offre/ressources/photo/avatar.gif" class="photo"></a>
             <ul class="dropdown-menu dropdown-menu-right">
              <li><a href="#">Modifier votre profil</a></li>
              <li><a href="/Offre/import">Ajouter une Photo de Profil</li>
             <%} %>
              <li class="divider" style="color: red"></li>
              <li><a  href="/Offre/Deconnect?mail=<%=email %>" class="text">Déconnexion</a></li>
            </ul>
         
	  	</div>
	  	
	  	<%-- 	<%-- <a href="/Offre/import"><img title="<%=clientu.getNom()%> <%=clientu.getPrenom()%>&nbsp;Modifier votre photo de profil" src="<%=url %>" class="photo"></a> --%>
	  	<%-- <%}else{ %>
	  	<a href="/Offre/import"><img title="<%=clientu.getNom()%> <%=clientu.getPrenom() %>&nbsp;Ajouter une photo de profil" src="/Offre/ressources/photo/avatar.gif" class="photo"></a>
	  	<%}%> --%>
	  	<%}if(!user && !client){ %>
	  
	  <div class="connect">
	  	<form class="form-horizontal" action="LogIn" method="post">
          <div class="dropdown "> 
            <a data-toggle="dropdown" href="#"  style="color: white;">Connexion<b class="caret"></b></a>
            <ul class="dropdown-menu dropdown-menu-right" style="padding: 15px;min-width: 250px;">
              <li>
					<input type="email" class="form-control" name="email" id="email" placeholder="Email" required="required" >
					 <li class="divider"></li>
					<input type="password" name="password" class="form-control" id="password" placeholder="Password" required="required">
					 <li class="divider"></li>
					<div class="form-group" align="center">
					<button type="submit" class="btn btn-primary btn-block">Connexion</button>
	                 </div>
          			
          		</li>
	
              <li>
               <li class="divider"></li>
              	<div class="form-group last" align="center">
              <span class="btn btn-primarycFB btn-block">Facebook</span>
             <!--   <div id="BoutonFb" >
					        <fb:login-button  autologoutlink="true" scope="public_profile,email" onlogin="checkLoginState();">
					        </fb:login-button>
              </div> -->
              </div>
              </li>
           
               <li class="divider"></li>
              	<div class="form-group last" align="center">
                <span class="btn btn-primarycTw btn-block">Twitter</span>            
              	<div class="form-group last" align="center"></div>
              	</div>
              <li class="divider"></li>
              <li><a href="#"></a></li>
            </ul>
           </div>
           </form>
          </div>
  	  <div class="sinscrire"><span class="glyphicon glyphicon-user" aria-hidden="true"><a href="/Offre/SignIn" class="text">s'inscrire</a></span></div>
	   <!--  <div class="connect"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span></div> -->
	 	<!-- <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
		</fb:login-button>
		
		<div id="status">
		</div> -->
	 	
	   <%} 
	  	
	  	
	}%>
	   </ul>
	 </nav>

</html>       

