

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.book.BookInfoDao;
import com.book.UpdateInfoDao;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	 private static final String uploadDir = "D:/ImageUploads";

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String fileName;
	        
	    	// Accessing Bookname
	    	String bookname = request.getParameter("bookname"); 
	        
	        // Code to store the images in the Images folder
	    	if(request.getPart("coverimage")!=null)
	    	{
	    	
	        Part filePart = request.getPart("coverimage");
	        fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	        fileName = fileName.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");
	        System.out.println("Sanitized file name: " + fileName);
	        // Verify directory
	        Path folderPath = Paths.get(uploadDir);
	       
	        // Save File to the server
	        InputStream inputStream = null;
	        FileOutputStream outputStream = null;
	        String FilePath=null;
	        try {
	            inputStream = filePart.getInputStream();
	            File outputFile = new File(uploadDir + File.separator + fileName);
	            outputStream = new FileOutputStream(outputFile);

	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            response.getWriter().write("Error while uploading file: " + e.getMessage());
	        } finally {
	            if (inputStream != null) inputStream.close();
	            if (outputStream != null) outputStream.close();
	        }

	    	}
	    	else
	    	{
	    		fileName=request.getParameter("oldimagepath");
	    	}
	        
	        
	        
	       

	        String author = request.getParameter("author"); // Accessing Author name
	        String rating = request.getParameter("rating"); // Accessing Rating
	        int bookid=Integer.parseInt(request.getParameter("bookid"));
	        HttpSession session=request.getSession();
	        int id=(Integer)session.getAttribute("id");
	        UpdateInfoDao ud=new UpdateInfoDao();
	        ud.update(bookname, fileName, author,rating,id,bookid);
	       
	    }

}
