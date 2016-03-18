<%@page import="java.util.Date"%>
<%@page import="modele.MessageEnvoye"%>
<%@page import="modele.User"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="modele.EnvoieMessage"%>
<%@page import="modele.ExterneUserMessage"%>
<%@page import="modele.Offre"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%MappingDao dao=MappingDao.getInstance();
    ArrayList<ExterneUserMessage> messages=dao.getAllExterneUserMessage();
    String mail=session.getAttribute("ident").toString().toString();
    MessageEnvoye messageEnvoyer=new MessageEnvoye();
    EnvoieMessage ev=new EnvoieMessage();
    Client clientMsg=new Client();
    User userMsg=new User();
    clientMsg=dao.getClientbyEmail(mail);
    ArrayList<MessageEnvoye> messageClientRecus=dao.getAllMessageRecuByClient(mail);
    ArrayList<MessageEnvoye> messageUserRecus=dao.getAllMessageRecuByUser(mail);
    
    
    System.out.println("===taille du message==="+messages); 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<body>

<%@include file="menu.jsp" %>
<div id="main-content">
<%@include file="pub.jsp" %>
<div id="form-index">
<form class="form-horizontal" action="Repondre" method="post">

<div class="divCompetence">
 <div class="blocM">
<div class="form-group">     
      
           <a href="/Offre/MessageEnvoye" style="color: white;">Messages envoyés</a>
    </div>
       <div class="form-group">
         <a href="/Offre/ListeMessage" style="color: white;">Messages Reçus</a>
        </div>
       <div class="form-group">             
               <a href="/Offre/MessageSup" style="color: white;" >Messages Supprimés</a>
    	 </div>	
    	  <button type="submit" class="glyphicon glyphicon-pencil" style="color: green;" name="nouveau">&nbspNouveau</button>	      
    	 </div>
    	
    	
</div>

 <div class="col-sm-offset-2 col-sm-9">

<%if(client){ %>
			 <%if(messages.size()!=0 && clientMsg.getStatut().equals("admin"))
			 {%>
				  <div class="row">
				    <div class="col-xs-12">
				      <div class="table-responsive">
				        <table summary="This table shows how to create responsive tables using Bootstrap's default functionality" class="table table-bordered table-hover">
				          <caption class="text-center">La liste des vos messages recus</caption>
				          <thead>
				            <tr>
				              <th>Expeditaire</th>
				              <th>Objet</th>
			              <th>Date d'envoie</th>
			             </tr>
			          </thead>
			          <tbody>		         
			          <%for(ExterneUserMessage msg:messages){ %>
			     		<%if(!msg.isStatutMessage()) {%>
			            <tr>
			              <td><b><a href="/Offre/FicheMessage?id=<%=msg.getId() %>"> <%=msg.getNom() %> <%=msg.getPrenom() %></a></b></td>
			              <td><b><a href="/Offre/FicheMessage?id=<%=msg.getId() %>"><%=msg.getObjet() %></a></b></td>
			              <td><b><a href="/Offre/FicheMessage?id=<%=msg.getId() %>"><%=msg.getDateEnvoie()%></a></b></td>   
			            </tr>
			            <%}else{%>
			            <tr>
			              <td><a href="/Offre/FicheMessage?id=<%=msg.getId() %>"> <%=msg.getNom() %> <%=msg.getPrenom() %></a></td>
			              <td><a href="/Offre/FicheMessage?id=<%=msg.getId() %>"><%=msg.getObjet() %></a></td>
			              <td><a href="/Offre/FicheMessage?id=<%=msg.getId() %>"><%=msg.getDateEnvoie()%></a></td>   
			            </tr>	
			            
			            <%}%>
			        <%} %>
	    		
	    		 </tbody>
				</table>
				</div>
				</div>
				</div>	    		
	    		
	        <%}
			 
			 if(messages.size()==0 && clientMsg.getStatut().equals("admin")){%>
	        
	        		 <div class="row">
			     	<div class="msgAlert"><h2>Aucun message envoye</h2></div> 
			   			 </div>
	        
	        	
	       <% }		 
			 if(!clientMsg.getStatut().equals("admin") && messageClientRecus!=null)
	         {%>
	        
			        	<div class="row">
				   		<div class="col-xs-12">
				       <div class="table-responsive">
				        <table summary="This table shows how to create responsive tables using Bootstrap's default functionality" class="table table-bordered table-hover">
				          <caption class="text-center">La liste des vos messages recus</caption>
				          <thead>
				           <tr>
			              <th>Expeditaire</th>
			              <th>Objet</th>
			              <th>Date d'envoie</th>
			             </tr>
			          </thead>
			          <tbody>
				         
			           <%for(MessageEnvoye msg:messageClientRecus)
			           { %>
			          	   <%String prenomexpe=dao.getUsertbyEmail(msg.getExpeditaire()).getPrenom();
			          		String nomexpe=dao.getUsertbyEmail(msg.getExpeditaire()).getNom();
			          		User u=dao.getUsertbyEmail(msg.getExpeditaire());
			          		String dateE=dao.getDateEnvoieMessage(msg);
			          		
				          	 %>
				     		<%if(!msg.isStatutMessage()) 
				     		{%>
					           	 <tr>
					              <td><b><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"> <%=nomexpe %> <%=prenomexpe %></a></b></td>
					              <td><b><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"><%=msg.getObjetMessage() %></a></b></td>
					              <td><b><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"><%=dateE%></a></b></td>   
					            </tr>
			            	<%}else
			            		{%>
						            <tr>
						              <td><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"> <%=nomexpe %> <%=prenomexpe %></a></td>
						              <td><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"><%=msg.getObjetMessage() %></a></td>
						              <td><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"><%=dateE%></a></td>   
						            </tr>
					            
					            	<%}%>
				        <%}%>
				        
				        
				       </tbody>
					</table>
					</div>
					</div>
					</div>
					           
			       <%}if(messageClientRecus==null && !clientMsg.getStatut().equals("admin"))
			       {%>
			    
			     	<div class="msgAlert"><h2>Aucun message recu</h2></div> 
			         <div align="center">
				   	  <button type="submit" class="glyphicon glyphicon-pencil" style="color: green;" name="nouveau">&nbspNouveau</button>	      
					</div>
	 				
			       <%}%>
			        
		 
	      
	 <%}

   if(user)
   { %> 
   		<%if(messageUserRecus!=null){%>     	
         <div class="row">
		    <div class="col-xs-12">
		      <div class="table-responsive">
		        <table summary="This table shows how to create responsive tables using Bootstrap's default functionality" class="table table-bordered table-hover">
		          <caption class="text-center">La liste des vos messages</caption>
		          <thead>
		            <tr>
	              <th>Expeditaire</th>
	              <th>Objet</th>
	              <th>Date d'envoie</th>
	             </tr>
	          </thead>
	          <tbody>
		         
	           <%for(MessageEnvoye msg:messageUserRecus)
	           { %>
	              <%System.out.println("voici le nombre des message"+messageUserRecus.size()); %>
	          	   <%String prenomexpe=dao.getClientbyEmail(msg.getExpeditaire()).getPrenom();
	          		String nomexpe=dao.getUsertbyEmail(msg.getDestinataire()).getPrenom();
	          		User u=dao.getUsertbyEmail(msg.getDestinataire());
	          		String dateE=dao.getDateEnvoieMessage(msg);
	          		
		          	 %>
		     		<%if(!msg.isStatutMessage()) 
		     		{%>
			           	 <tr>
			              <td><b><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>">  <%=prenomexpe %></a></b></td>
			              <td><b><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"><%=msg.getObjetMessage() %></a></b></td>
			              <td><b><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"><%=dateE%></a></b></td>   
			            </tr>
	            	<%}else
	            		{%>
				            <tr>
				              <td><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"> <%=prenomexpe %></a></td>
				              <td><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"><%=msg.getObjetMessage() %></a></td>
				              <td><a href="/Offre/FicheMessage?idmessage=<%=msg.getIdM() %>"><%=dateE%></a></td>   
				            </tr>
			            
		            	<%}%>
			 <%}%>
		      
		     </tbody>
			</table>
			</div>
			</div>
			</div>
		           
	       <% }if(messageUserRecus==null){%>
	         
			
			     	<div class="msgAlert"><h2>Aucun message recu</h2></div>
					
			         
	  		<%}%>
	  	
		 

     <%} %>
     
	</div>
	</form>
	</div>
	<%@include file="footer.jsp" %>
	</div>
	</body>
	</html> 