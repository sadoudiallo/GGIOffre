<%!
private boolean userFiltre;
private boolean clientFiltre;

 %>
<%@page import="dao.MappingDao"%>
<% MappingDao daoFilter=MappingDao.getInstance();



userFiltre = (request.getSession().getAttribute("user") != null);
clientFiltre = (request.getSession().getAttribute("client") != null);

if(!userFiltre && !clientFiltre)
{
	int nb=daoFilter.getAllNbConnecte().size();
	if(nb>0)
	{
		daoFilter.deleteAllConnect();
	}
	
	response.sendRedirect("Home");

}
   %>
