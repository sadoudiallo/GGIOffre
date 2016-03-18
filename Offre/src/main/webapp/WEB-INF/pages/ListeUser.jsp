<%@page import="modele.Titre"%>
<%@page import="modele.Postule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
MappingDao dao=MappingDao.getInstance();

Postule postule=new Postule();
String code=request.getParameter("code");
Titre titre=new Titre();
	
ArrayList<User> users=dao.getAllPostulantByOffre(code);

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
   	
<title>Offre</title>
</head>
<body>

<%@include file="menu.jsp"%>
	<div id="main-content">
       	<%@include file="pub.jsp" %>
 	<div id="form-index"> 
 	
 	<%if(code!=null) {
 	System.out.println("Je suis la");
 	%>
		<div class=" navbar-actu" >
			 	<h2 class="h3" align="center">La liste des postulants a l'offre de:<%= doa.getOffrebyCode(code).getTitre()%></h2>
		</div> 
		
	      <%if(users!=null){ %>
<div class="box">
<div class="row">
	      	<% for(User user:users) {%>

	<div class="col-xs-0 col-sm-6">
	    <div class="ih-item square colored effect9 bottom_to_top imgeGdesigne">
		  	<%
	 		titre=dao.getTitreByUser(user.getEmail());
	   		String nom= user.getNom();
			 String prenom=user.getPrenom();
			 %>
	   	<a href="/Offre/FicheCV?Id=<%=user.getIdUser() %>">	
	   	<div class="img "><img src="<%=user.getUrlPhoto() %>" alt="img"></div>
	        <div class="info">
	          <div class="info-back">
	            <h3><%=nom %>-<%=prenom %><span style="color:green ;"> <%=titre.getNomTitre() %> </span></h3>
	            <p>Vous pouvez cliquez pour voire son CV</p>
	          </div>
	        </div>
	   	</a>
	  	
	  	</div>
	  </div>
	  
	      	<%}%>
   </div>
	    </div>
	      <%}else if(users.isEmpty()){ %>
	      <span><h2 style="color: blue;" align="center">Il n'ya aucun Postulant pour cette Offre</h2></span>
	      <%}
	       %>
	 <%}else{ 
	 String lieu=request.getAttribute("lieu").toString().toString();
	String title=request.getAttribute("titre").toString().toString();
	
	ArrayList<User> userTitreLieu=dao.getAllUserByTitrenameEtLieu(title, lieu);
	ArrayList<User> usersS=dao.getAllUserByTitrename(title);
	if(userTitreLieu!=null)
	{%>
		
		<%System.out.println("lieu okkk"); %>
		<div class=" navbar-actu" >
	 	<h2 class="h3" align="center">Resultat de votre recherche pour le poste de:<%= title%></h2>
</div> 
  
  	<% for(User user:userTitreLieu) {%>
  	<div class="row">
<div class="col-xs-6 col-sm-6">
    <div class="ih-item square colored effect9 bottom_to_top imgeGdesigne">
	  	<%
 		titre=dao.getTitreByUser(user.getEmail());
   		String nom= user.getNom();
		 String prenom=user.getPrenom();
		 %>
   	<a href="/Offre/FicheCV?Id=<%=user.getIdUser() %>">	
   	<div class="img "><img src="<%=user.getUrlPhoto() %>" alt="img"></div>
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
  	<%}
	}else if(usersS!=null){ %>
	 <div class=" navbar-actu" >
			 	<h2 class="h3" align="center">Resultat de votre recherche pour le poste de:<%= title%></h2>
		</div> 
	      
	      	<% for(User user:usersS) {%>

<div class="row">
<div class="col-xs-6 col-sm-6">
    <div class="ih-item square colored effect9 bottom_to_top imgeGdesigne">
	  	<%
 		titre=dao.getTitreByUser(user.getEmail());
   		String nom= user.getNom();
		 String prenom=user.getPrenom();
		 %>
   	<a href="/Offre/FicheCV?Id=<%=user.getIdUser() %>">	
   	<div class="img "><img src="<%=user.getUrlPhoto() %>" alt="img"></div>
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

	      	<%}%>
	     
	      <%}else if(usersS==null && userTitreLieu==null){ %>
	      <span><h2 style="color: blue;" align="center">Aucun resulat pour le poste de <%=title %></h2></span>
	      <%}
	       %>
	 
	 
	 <%} %>
	</div>
	<%@include file="footer.jsp" %>
	</div>
</body>
</html>