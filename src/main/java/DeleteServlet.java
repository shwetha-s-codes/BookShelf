

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.book.DeleteDao;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		HttpSession session=request.getSession();
		int id=(int)session.getAttribute("id");
		DeleteDao dd=new DeleteDao();
		dd.deleteInfo(id,bookId);
		response.sendRedirect("bookhome.jsp");
	}

}
