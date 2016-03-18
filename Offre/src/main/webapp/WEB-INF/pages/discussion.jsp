<%@page import="java.util.Date"%>
<%@page import="dao.MappingDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Discussion"%>
<%@page import="modele.Client"%>
<%@page import="modele.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="ressources/css/discussion.css" rel="stylesheet">
 
<script>

$(function(){
	$("#addClass").click(function () {
	          $('#qnimate').addClass('popup-box-on');
	            });
	          
	            $("#removeClass").click(function () {
	          $('#qnimate').removeClass('popup-box-on');
	            });
	  })
				
</script>

</head>
<%!
	private boolean userdiscussion;
	private boolean clientdiscussion;
 %>
 
<%
userdiscussion = (request.getSession().getAttribute("user") != null);
clientdiscussion = (request.getSession().getAttribute("client") != null);
MappingDao daodiscussion=MappingDao.getInstance();
ArrayList<Discussion> discussions=daodiscussion.getAllDiscussion();

%>

<body>

<form class="form-horizontal" action="Discussion" method="post">
   <div class="round hollow text-center">
   <a href="#" id="addClass"><span class="glyphicon glyphicon-comment"></span> Posez vos questions </a>
   </div>




<div class="popup-box chat-popup" id="qnimate" >
 
	 <div class="popup-head">
	 <%if(userdiscussion){ 	 
	 String email= session.getAttribute("ident").toString().toString();
	 User usd=daodiscussion.getUsertbyEmail(email);
	 %>
	 <div class="popup-head-left pull-left"><img src="<%=usd.getUrlPhoto() %>" alt="iamgurdeeposahan"><%=usd.getPrenom() %> <%=usd.getNom() %></div>
	 <%}else if(clientdiscussion){ 
	
		 String email= session.getAttribute("ident").toString().toString();
		 Client cld=daodiscussion.getClientbyEmail(email);
	 %>
		 <div class="popup-head-left pull-left"><img src="<%=cld.getUrlPhoto() %>" alt="iamgurdeeposahan"><%=cld.getPrenom() %> <%=cld.getNom() %></div>
	 <%}else{ %>
	 <div class="popup-head-left pull-left"><img src="/Offre/ressources/photo/avatar.gif" class="direct-chat-img" alt="iamgurdeeposahan">Invite </div>
	 <%} %>
		
	
			  <div class="popup-head-right pull-right">
				<!-- <div class="btn-group">
	 						<button class="chat-header-button" data-toggle="dropdown" type="button" aria-expanded="false">
							   <i class="glyphicon glyphicon-cog"></i> </button>
							  <ul role="menu" class="dropdown-menu pull-right">
								<li><a href="#">Media</a></li>
								<li><a href="#">Block</a></li>
								<li><a href="#">Clear Chat</a></li>
								<li><a href="#">Email Chat</a></li>
							  </ul>
				</div> -->
				
				<button data-widget="remove" id="removeClass" class="chat-header-button pull-right" type="button"><i class="glyphicon glyphicon-off"></i></button>
                </div>
	 </div>
	 
	 
	 
	 
	<div class="popup-messages">
    	<div class="direct-chat-messages">
              	<div class="chat-box-single-line">
								<abbr class="timestamp">
								<%Date dat=new Date();%>
								<%=dat.getDate()%>-<%=dat.getMonth()+1%>-<%=dat.getYear()+1900 %>
								
								</abbr>
					</div>
					
			<%-- <%String email= session.getAttribute("ident").toString().toString();
	  		
	  		 String urlu=us.getUrlPhoto();
	  		
	  		 %> --%>
	  	 <%if(discussions!=null){ %>
	  		 <%for(Discussion discussion:discussions){ %>
	  		 
	  		    <%
	  		    	String mail=discussion.getEmail();
	  		    	 User u=daodiscussion.getUsertbyEmail(mail);
	  		    	 Client c=daodiscussion.getClientbyEmail(mail);
	  		    %>
	  		 	
					<!-- Message. Default to the left -->
					 <%if(mail!=null){ %>
					 
					   <%if(u!=null){ 
					  		String urlphoto=u.getUrlPhoto();
						   %>
				
	                    <div class="direct-chat-msg doted-border">
	                      <div class="direct-chat-info clearfix">
	                     <span class="direct-chat-name pull-left"><%=u.getNom() %> <%=u.getPrenom() %></span>
	                    </div>
                      
	                      <!-- /.direct-chat-info -->
	                      <img alt="message user image" src="<%=urlphoto %>" class="direct-chat-img"><!-- /.direct-chat-img -->
	                      <div class="direct-chat-text">
	                        <%=discussion.getMessage() %>
	                      </div>
						  <div class="direct-chat-info clearfix">
	                        <span class="direct-chat-timestamp pull-right"><%=discussion.getDateEnvoie().getHours() %>-<%=discussion.getDateEnvoie().getMinutes() %></span>
	                      </div>
							<div class="direct-chat-info clearfix">
							<span class="direct-chat-img-reply-small pull-left">
								
							</span>
							
							</div>
	                      <!-- /.direct-chat-text -->
	                    </div>
	                 
                    
                    <!-- /.direct-chat-msg -->
					<%}else if(c!=null){ 
					
					String urlphoto=c.getUrlPhoto();
						   %>
				
	                    <div class="direct-chat-msg doted-border">
	                      <div class="direct-chat-info clearfix">
	                     <span class="direct-chat-name pull-left"><%=c.getNom() %> <%=c.getPrenom() %></span>
	                    </div>
                      
	                      <!-- /.direct-chat-info -->
	                      <img alt="message user image" src="<%=urlphoto %>" class="direct-chat-img"><!-- /.direct-chat-img -->
	                      <div class="direct-chat-text">
	                        <%=discussion.getMessage() %>
	                      </div>
						  <div class="direct-chat-info clearfix">
	                        <span class="direct-chat-timestamp pull-right"><%=discussion.getDateEnvoie().getHours() %>-<%=discussion.getDateEnvoie().getMinutes() %></span>
	                      </div>
							<div class="direct-chat-info clearfix">
							<span class="direct-chat-img-reply-small pull-left">
								
							</span>
							
							</div>
							
							
	                      <!-- /.direct-chat-text -->
	                    </div>
	                  
					
					<%}
					   
					 }else if(mail==null) {%>
					 
				
	                    <div class="direct-chat-msg doted-border">
	                      <div class="direct-chat-info clearfix">
	                     <span class="direct-chat-name pull-left">Invité</span>
	                    </div>
                      
	                      <!-- /.direct-chat-info -->
	                      <img alt="message user image" src="/Offre/ressources/photo/avatar.gif" class="direct-chat-img"><!-- /.direct-chat-img -->
	                      <div class="direct-chat-text">
	                        <%=discussion.getMessage() %>
	                      </div>
						  <div class="direct-chat-info clearfix">
	                        <span class="direct-chat-timestamp pull-right"><%=discussion.getDateEnvoie().getHours() %>-<%=discussion.getDateEnvoie().getMinutes() %></span>
	                      </div>
							<div class="direct-chat-info clearfix">
							<span class="direct-chat-img-reply-small pull-left">
								
							</span>
							
							</div>
	                      <!-- /.direct-chat-text -->
	                    </div>
	               
					 <%} 
					
	  		  }
	  		
	  		
	  		 }else if(discussions==null){%>
	  		
	  		 <div class="direct-chat-text">
	                       Il n'ya aucune discussion engagée!
	                      </div>
	  		 <%} %>
				
		   </div>
	</div>
			
		  
			
			 
			 
			<div class="popup-messages-footer">	
			
			<%if(clientdiscussion || userdiscussion ) {

			String email= session.getAttribute("ident").toString().toString();
			%>
			<input type="hidden" name="email" value="<%=email%>">
			<%} %>
			
			<textarea id="status_message" placeholder="Saisir votre Message ici..." rows="10" cols="40" name="message"></textarea>
			<div class="btn-footer">
			<!-- <button class="bg_none" type="submit"><i class="glyphicon glyphicon-film"></i> </button>
			<button class="bg_none"><i class="glyphicon glyphicon-camera"></i> </button>
            <button class="bg_none"><i class="glyphicon glyphicon-paperclip"></i> </button> -->
			<button class="bg_none pull-right" type="submit"><i class="glyphicon glyphicon-send" ></i> </button>
			</div>
			</div>
			
	  </div>
</form>

</body>
</html>