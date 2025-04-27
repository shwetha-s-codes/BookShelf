

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.book.UpdateInfoDao;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		UpdateInfoDao ud=new UpdateInfoDao();
  		
  		
  		if(request.getParameter("bookname")!=null)
  		{
  			String oldname=request.getParameter("Identifybookname");
  			String newname=request.getParameter("bookname");
  			
  			
  		}
		
	}

	

}
