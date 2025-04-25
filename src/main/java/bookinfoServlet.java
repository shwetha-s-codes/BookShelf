

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

@MultipartConfig //Annotation for Informing file uploads 
@WebServlet("/bookinfoServlet")
public class bookinfoServlet extends HttpServlet {
	private static final String uploadDir = "D://ImageUploads";
;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookname=request.getParameter("bookname"); //Accessing Bookname
		
		//Code to store the images in the Images folder
		Part filePart=request.getPart("coverimage");
		String fileName=Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		//Location to save Uploaded File
		
		
		
		//Save File to the server
		try
		{
		String filePath=uploadDir+"//"+fileName;
		filePart.write(filePath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
		
	
		
		String author=request.getParameter("author"); //Accessing Author name
		
		String rating=request.getParameter("rating"); //Acessing Rating
		
		
		
	}

	
	

}
