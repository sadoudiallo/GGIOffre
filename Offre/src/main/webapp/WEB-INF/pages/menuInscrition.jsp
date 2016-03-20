 <<!DOCTYPE nav PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
private boolean userI;
private boolean clientI;

 %>
<%
    userI = (request.getSession().getAttribute("user") != null);
    clientI = (request.getSession().getAttribute("client") != null);

   
   %>
<html>
    <%@include file="header.jsp" %>
     
<body>
	<nav class="navb">
	<a class="navbar-brand" href="/Offre/Home"><h4 class="text"><span class="glyphicon glyphicon-home" aria-hidden="true"> Acceuil</span><h3></h4></a>
	 
	</nav>
   </body>
   </html>     

