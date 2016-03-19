<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String mail = request.getParameter("email"); %>
<!DOCTYPE html>
<html>
    
    <body>
    <%@include file="menuInscrition.jsp" %>
     
     <div id="main-content">
 	<!-- <div id="vdo-2"></div> -->
 	       	<%@include file="pub.jsp" %>
	<div id="form-index">
	<form class="form-horizontal" action="validateCompte">  
        <div class="row" align="center">		 	
			 <h1>Votre compte est bientôt validé.</h1>
            <h2>Cliquez sur le bouton pour finaliser votre inscription</h2>
            <input hidden value="<%= mail %>" name="email" >
             <input type="submit" name="submit" class="btn btn-primary" value="Valider" />
			</div> 
			   </form>
		</div>
		 <%@include file="footer.jsp" %>
            </div>
        
       
    </body>
</html>

