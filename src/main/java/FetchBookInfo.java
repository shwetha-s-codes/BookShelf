

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.book.Book;
import com.book.FetchBookInfoDao;


@WebServlet("/FetchBookInfo")
public class FetchBookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session=request.getSession();
	
	if(session==null||session.getAttribute("id")==null)
	{
		response.sendRedirect("index.html");
	}
	int id= (Integer)session.getAttribute("id");
	List<Book> bookList=new ArrayList<>();
	FetchBookInfoDao db=new FetchBookInfoDao();
	bookList=db.fetchBookInfo(id);
	RequestDispatcher rd= request.getRequestDispatcher("library.jsp");
	request.setAttribute("booklist",bookList );
	rd.forward(request, response);
	}
	
	

}
