<%@page import="modele.Offre"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%MappingDao dao=MappingDao.getInstance();
    String lieu=request.getAttribute("lieu").toString().toString();
    String titre=request.getAttribute("titre").toString().toString();
    ArrayList<Offre> offres=dao.getOffreByTitreEtLieu(titre, lieu);
    Client clientOf=new Client();
    System.out.println("lieu cherche"+titre);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		
        <title>Offre</title>
        
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
<body>
<%@include file="menu.jsp" %>
<div id="main-content">
       	<%@include file="pub.jsp" %>

	<div id="form-index"> 
 <%if(offres!=null) {%>
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive">
        <table summary="This table shows how to create responsive tables using Bootstrap's default functionality" class="table table-bordered table-hover">
          <caption class="text-center" style="color: white;">Resultats de la recherche pour le poste de <%=titre %> se trouvant a <%=lieu %></caption>
          <thead>
            <tr>
              <th>Offre</th>
              <th>Employeur</th>
              <th>Lieu</th>
              <th>Date de publication</th>
              </tr>
          </thead>
          <tbody>
         
          <%for(Offre of:offres){ %>
          	<%clientOf=of.getClient();%>
            <tr>
              <td><a href="/Offre/FicheOffre?code=<%=of.getCode() %>"> <%=of.getTitre() %></td>
              <td><a href="/Offre/FicheOffre?code=<%=of.getCode() %>"><%=clientOf.getPrenom() %></td>
              <td><a href="/Offre/FicheOffre?code=<%=of.getCode() %>"><%=of.getAdresse() %></td>
              <td><a href="/Offre/FicheOffre?code=<%=of.getCode() %>"><%=of.getDatePublication() %></td>
            </tr>
            <%} %>
          
          </tbody>
          </table>
          </div>
          </div>
          </div>
          
        <%}else{%>
          
          	<div class="msgAlert"><h2>Aucun resutat trouve pour le poste de <%=titre %> se trouvant a <%=lieu %></h2></div>
        
           <%}%>
     
</div>
 <%@include file="footer.jsp" %>
</div>
</body>
</html>