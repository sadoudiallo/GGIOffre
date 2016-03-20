package controleur;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modele.Client;
import modele.CopyFiles;
import modele.User;
import dao.MappingDao;

/**
 * Servlet implementation class Upload
 */

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"}) 
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
						maxFileSize=1024*1024*10,// 10MB
						maxRequestSize=1024*1024*50) // 50MB
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static final String SAVE_DIR = "photos";
	
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Recuperer le chemin absolu de l'application
		String appPath = request.getServletContext().getRealPath("");
		 // Construit le chemin du répertoire d'enregistrement du fichier téléchargé	
		 String savePath = appPath + File.separator + SAVE_DIR;
		//File toto=new File(path+"/toto.jpg");		
		//System.out.println("Voici apppath"+appPath);		
		//String savePath = appPath +""+ SAVE_DIR;		
		// creates the save directory if it does not exists
		//recuperation de l'email
		MappingDao dao=MappingDao.getInstance();
		User user=new User();
		Client client= new Client();
		
		String email=request.getParameter("m");
		String type=request.getParameter("type");
		String cv=request.getParameter("cv");
		System.out.println("voici le CV==>"+cv);
		System.out.println("voici le type==>"+type);
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
		fileSaveDir.mkdir();
		}		
		for (Part part : request.getParts()) {
		String fileName = extractFileName(part);
		part.write(savePath +File.separator+fileName);		
		//copie		
		  	File srcFolder = new File(savePath +File.separator+fileName);
	        String destFolder = new String("/home/diallo/Offre/src/main/webapp/ressources/photo/");
	        String destFoldercv = new String("/home/diallo/Offre/src/main/webapp/ressources/cv/");
	        CopyFiles cf = new CopyFiles();
	        
		//fincopie	
	        System.out.println("les params dans upload:"+request.getParameterMap());
	       //enregistrement en base
	        if(email!=null)
			{
				if(type.equals("client"))
				{
					client=dao.getClientbyEmail(email);
					if(client!=null)
					{
						cf.copyDirectory(srcFolder, destFolder);
						client.setUrlPhoto("/Offre/ressources/photo/"+fileName);
						dao.createOrUpdateClient(client);
						
					}
				}else if(type.equals("user"))
				{
					user=dao.getUsertbyEmail(email);
					if(user!=null)
					{
						if(cv.equals("ok"))
						{
							
							cf.copyDirectory(srcFolder, destFoldercv);
							user.setUrlCV("/Offre/ressources/cv/"+fileName);
							dao.createOrUpdateUser(user);
							System.out.println("cv different de  null==>"+cv);
							
							
							
						}else
						{
							cf.copyDirectory(srcFolder, destFolder);
							user.setUrlPhoto("/Offre/ressources/photo/"+fileName);
							dao.createOrUpdateUser(user);
							System.out.println("cv est null");
						}
						
						
					}
				}
			}
	
		}
		
		response.sendRedirect("Home");
	}
	
	private String extractFileName(Part part) {
	    String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    for (String s : items) {
		if (s.trim().startsWith("filename")) {
			return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
	
	    }
	    	return " ";
	}

}
