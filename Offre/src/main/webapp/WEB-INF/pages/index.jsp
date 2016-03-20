<!DOCTYPE html>

<%@page import="modele.Alert"%>
<%@page import="modele.Titre"%>
<%@page import="javax.ws.rs.core.HttpHeaders"%>
<%@page import="modele.Experience"%>
<%@page import="modele.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MappingDao"%>
<%@page import="modele.Offre"%>
<%@page import="javax.xml.ws.spi.http.HttpContext"%>

<%

    user = (request.getSession().getAttribute("user") != null);
    client = (request.getSession().getAttribute("client") != null);
    

  
%>
<%
MappingDao dao = MappingDao.getInstance();
ArrayList<Offre> offres  =dao.getAllOffre(); 
ArrayList<User> users =dao.getAllUser();
ArrayList<Experience> experiences=dao.getAllExperience();
ArrayList<Titre> titres=dao.getAllTitre();


%>

<html>
<head>

 <script src="ressources/js/flux.js"></script> 
 
 
 
    
<script>
    $(document).ready(
            function() {
                setInterval(function() {
                   
                    $('#discussion');
                }, 1000);
            });
</script>
 
 
</head>
<body >

 <%@include file="menu.jsp" %>
 

 	<div id="main-content">
 	<!-- <div id="vdo-2"></div> -->
	

 	<%@include file="pub.jsp"  %>

 
 <div id="form-index"> 	
 	<div class="row">
    <div class="col-md-offset-0 col-md-8">
 	
 	<div class="row">
 	
		<div class="col-xs-0 col-sm-5 coltext">
				<%if(!client){ %>
					 <form class="form-horizontal" action="PageOffre" method="post">
					 <nav ><h4 class="coltext" align="center" >Rechercher une offre</h4> </nav>	
				     <div class="form-group" align="center">
				      <input type="text"  name="titre" id="titre" placeholder="Nom de l'offre" required="required"  size="30px" style="color: black;">
				         <input type="text" name="lieu" id="lieu" placeholder="Lieu"  size="30px" style="color: black;">
				        <br><br><button type="submit" class="btn btn-primary btn-sm" name="rechercheOffre" id="chercher" title="chercher"><span class="glyphicon glyphicon-eye-open"></span> Chercher</button>
				     </div>
							     
				</form>
				<%}else{ %>
					<form class="form-horizontal" action="SearchCV" method="post">
					 <nav ><h4 class="coltext" align="center">Rechercher un cv</h2> </nav>	
				     <div class="form-group" align="center">
				      
				      <label for="nomtitre">Titre</label>
					<select name="titre" id="nomtitre" style="color: black;">			
					<option value=" " >Choisir parmi vos Titres</option>
						<%
						 for(Titre titre:titres){%>
							 <option value="<%=titre.getNomTitre() %>"><%=titre.getNomTitre() %></option>
						<% }%>					
					</select>			      
				      
				         <input type="text" name="lieu" id="lieu" placeholder="Lieu"  size="30px" style="color: black;">
				        <br><br><button type="submit" class="btn btn-primary btn-sm" name="rechercheOffre" id="chercher" title="chercher"><span class="glyphicon glyphicon-eye-open"></span> Chercher</button>
				     </div>
							     
				</form>
				
				<%} %>
		     </div>
		     
				<div class="col-xs-6 col-sm-6 coltex">
					
					 <form class="form-horizontal" action="rechercheEntreprise" method="post">
				      <nav class=" titre" >
				      	<h4 class="coltex" align="center" >Annuaire d'entreprises</h4>
				      </nav>
				      <div class="form-group" align="center">
				      <input type="search" placeholder="Quoi? Qui? Nom d'une entreprise" size="30px" name="nom" id="nom" required="required" style="color: black;">
				        <input type="search"  placeholder="ou? Lieu" size="30px" name="lieu" id="lieu" required="required" style="color: black;">
				        <br><br><button type="submit" class="btn btn-primary btn-sm" name="rechercherAnnuaire" id="chercher" title="chercher" ><span class="glyphicon glyphicon-eye-open"></span> Chercher</button>
				      </div>
				    </form>					
		        </div>
		     <!--   <div class=" col-sm-3">
		        <aside class=blocpub>
		          <a href="http://medienfreunde.com/deutsch/referenzen/kreation/whizzkids.html"><img src="ressources/images/imf2.jpg" alt="Whizzkids" class="imge" /></a>
		        </aside>
		        
		      </div> -->
		  
		    
	
 	</div>
	
 	<%if((!user && !client)||user){ %>

 	<nav class="navbar-actu" style="margin-right: 6%; margin-left: -2%;"><h3 class="h4" align="center" style="color: white;">Liste de nos Offres</h3></nav>
 	<%if(offres!=null){ %>
  <% for(Offre offre:offres) {%>
  <div class="box">
 	<div class="row">
 
		<div class="col-xs-6 col-sm-6">
	  	
      		<%String titre= offre.getTitre();%>
      		<h4 style="color: "><%=titre%></h4>
     	</div>
		<div class="col-xs-6 col-sm-6">		
			<a href="/Offre/FicheOffre?code=<%=offre.getCode() %>" class="colorlien" >Consulter l'offre </a>
			
        </div>
        </div>
    </div>
  
	<%}%>
  
<!--   <div class=" col-sm-3">
  <aside class=blocpub>
    <a href="http://medienfreunde.com/deutsch/referenzen/kreation/whizzkids.html"><img src="ressources/images/imf2.jpg" alt="Whizzkids" class="imge" /></a>
   </aside>
	        
 </div> -->
		      	
  <% }%>
   
   

   
 <%}else if(client){ %>
	<nav class="navbar-actu" style="margin-right: 6%; margin-left: -2%;"><h3 class="h4" align="center" style="color: white; marg">Liste des demandeurs d'emploi</h3></nav>
	<%if(users!=null){ %>
<% for(User user:users) {%>
<div class="box">
<div class="row">
<div class="col-xs-6 col-sm-6 ">
    <div class="ih-item square colored effect9 bottom_to_top imgeGdesigne">
	  	<%Titre titre=new Titre();
 		titre=dao.getTitreByUser(user.getEmail());
   		String nom= user.getNom();
		 String prenom=user.getPrenom();
		 %>
   	<a href="/Offre/FicheCV?Id=<%=user.getIdUser() %>">	
   	<div class="img "><img src="<%=user.getUrlPhoto() %>" alt="img" style="height: 170px; width: 170px;"></div>
        <div class="info">
          <div class="info-back">
            <h3><%=nom %>-<%=prenom %><span style="color:green ;"> <%=titre.getNomTitre() %> </span></h3>
            <p>Vous pouvez cliquez pour voire son CV</p>
          </div>
        </div>
   	</a>
  	
  	</div>
  </div>
</div>
</div>
	<%}
		      	
}%>
<%}%>

<div class="colalert">

<%if((client) || (user)){
				String email= session.getAttribute("ident").toString().toString();
				Alert alert=new Alert();
				 alert=dao.getAlertByMail(email);
				 
				 if(alert==null){%>
					 <div class="row " > 
					 <form class="form-horizontal" action="Alert" method="post">
							<div class="col-md-offset-2 col-md-6 ">
							 <nav class="navbar-actu" align="center"><b class="col">Recevoir des alerts </b></nav>
							<input type="email" class="form-control" id="nom" name="emailalert" value="<%=email%>">
							</div>
							<div class="col-md-offset-0 col-md-0" >
							<button type="submit" class="btn btn-primary" style="margin-top: 20px;">Envoyer</button>
							</div>
						</form>
					</div>
				<% }
				}else{%>
				
				 <div class="row " > 
					 <form class="form-horizontal" action="Alert" method="post">
							<div class="col-md-offset-2 col-md-6 ">
							 <nav class="navbar-actu" align="center"><b class="col">Recevoir des alerts </b></nav>
							<input type="email" class="form-control" id="nom" name="emailalert" placeholder="Saisir votre Email pour recevoir des Alerts">
							</div>
							<div class="col-md-offset-0 col-md-0" >
							<button type="submit" class="btn btn-primary" style="margin-top: 20px; width: 100px; margin-left: -12px;">Envoyer</button>
							</div>
						</form>
					</div>
				
				<%}%>


</div>

<div class="row ">	
	 <div style="margin-top: 50px;">
		 <div class="col-md-offset-0 col-md-5">
		   <nav class="navbar-actu" align="center"><b class="col">TV En direct</b></nav>
			<div class="embed-responsive embed-responsive-16by9">
		   <iframe class="embed-responsive-item" src="http://www.youtube.com/embed/qKEk1YCOz8Q" width="300" height="150" allowfullscreen></iframe>
		</div>
		</div>
		
		
		<div class="col-md-offset-0 col-md-5">
		<div class="box1">
		 	<nav class="navbar-actu" align="center"><b class="col">Trouver un travail</b></nav>
		 		<div class="embed-responsive embed-responsive-16by9">
		   <iframe class="embed-responsive-item" src="http://www.youtube.com/embed/svYQI4AjuR8" width="300" height="150" allowfullscreen></iframe>
		</div>		 	 	
		</div> 
		</div>
</div>
</div>

</div>

<div class="col-md-offset-0 col-md-4" align="right">
<div id="form-indexPub" align="center">

	
	<ul id="news">					
					<li>
						<a href="#"><img src="ressources/images/carte.jpg" alt="Whizzkids" class="imgeG" /></a>
					</li>
					<li>
						<a href="#"><img src="ressources/images/drapeau.gif" alt="Whizzkids" class="imgeG" /></a>
					</li>	
					<li>
						<a href="http://www.gn.cellcomgsm.com/"><img src="ressources/images/cellcom.jpg" alt="Cellcom" class="imgeG" /></a>
					</li>	
					<li>
						<a href="http://www.orange-guinee.com/"><img src="ressources/images/orange.jpg" alt="Orange" class="imgeG" /></a>
					</li>		
					<li>
						<a href="#"><img src="ressources/images/mercedes.jpg" alt="Orange" class="imgeG" /></a>
					</li>
					<li>
						<a href="#"><img src="ressources/images/ford.jpg" alt="Orange" class="imgeG" /></a>
					</li>
					<li>
						<a href="#"><img src="ressources/images/timbo.jpg" alt="Orange" class="imgeG" /></a>
					</li>
					<li>
						<a href="#"><img src="ressources/images/vache.jpg" alt="Orange" class="imgeG" /></a>
					</li>			
					<!-- <li>
						<a href="#n3">3 Sdipiscing elit,</a>
					</li>					
					<li>
						<a href="#n4">4 sed diam nonummy nibh euismod tincidunt ut</a>
					</li>
					<li>
						<a href="#n5">5 Nec Lorem.</a>
					</li>
					<li>
						<a href="#n6">6 Et eget.</a>
					</li>					
					<li>
						<a href="#n7">7 Leo orci pede.</a>
					</li>					
					<li>
						<a href="#n8">8 Ratio randorus wil.</a>
					</li>				 -->
				</ul>


</div>
<br>
<div id="form-indexPub" align="center">
<nav class="navbar-actu" align="center"><b class="col">Tuto sur AngularJs</b></nav>
<div class="embed-responsive embed-responsive-16by9">
   <iframe class="embed-responsive-item" src="http://www.youtube.com/embed/wZ_5des_6_c" width="300" height="150" allowfullscreen></iframe>
</div>

				 	 <!-- 	<nav class="navbar-actu" align="center"><b class="col">International</b></nav>
				 	 	<div id="Divrfi"></div> -->
			
</div>
<br>
<div id="form-indexPub" align="center">
<nav class="navbar-actu" align="center"><b class="col">Tuto sur Symfony 2</b></nav>
<div class="embed-responsive embed-responsive-16by9">
   <iframe class="embed-responsive-item" src="http://www.youtube.com/embed/ABJ8KxQAEXA" width="300" height="150" allowfullscreen></iframe>
</div>

</div>
</div>


</div>

</div>

<div id="discussion">
 <%@include file="discussion.jsp" %>
</div>
 <%@include file="footer.jsp" %>
</div>
	
  </body>
    
</html>
