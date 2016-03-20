<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String cv=request.getParameter("cv"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link href="ressources/css/style.css" rel="stylesheet">
        <script src="ressources/js/signin.js"></script>
         <script src="ressources/js/image.js"></script>

<title>Offre</title>
<%String type=null; 
    String email= session.getAttribute("ident").toString().toString();
    
    System.out.println("CV"+cv);
    %>
</head>
<body>
     <%@include file="menuInscrition.jsp" %>
<div class="containerphoto">
<center>
    <%if(cv!=null){ %>
	<h2>Télécharger votre CV</h2>
	<%}else{ %>
	<h2>Télécharger votre Photo</h2>
	<%} %>
    <% if(clientI){
    	 type="client";
    }if(userI){
    	type="user";
    }%>
    <form method="post" action="UploadServlet" enctype="multipart/form-data">
		<div>
		 <input hidden value="<%= type %>" name="type" >
		  <input hidden value="<%= email %>" name="m" >
		   <input hidden value="<%= cv %>" name="cv" >
       <input type="file" name="file" size="60" class="btn btn-primary" required="required"/><br />
      <input type="submit" value="Charger" class="btn btn-primary" />
     </div>
    </form>
</center>
</div>
</body>
</html>