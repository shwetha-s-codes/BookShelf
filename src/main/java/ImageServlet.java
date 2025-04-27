

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName=request.getParameter("fileName");
		String folderPath="D:/ImageUploads/"+fileName;
		File file=new File(folderPath);
		if(file.exists())
		{
			FileInputStream fis=new FileInputStream(file);
			
			OutputStream os = response.getOutputStream();
			byte[] buffer =new  byte[1024];
			int bytesRead;
			while((bytesRead=fis.read(buffer))!=-1)
			{
				os.write(buffer,0,bytesRead);
			}
			fis.close();
			os.flush();
			os.close();
			
		}
		else
		{
			response.getWriter().println("Image Not Found");
		}
	}

	
}
