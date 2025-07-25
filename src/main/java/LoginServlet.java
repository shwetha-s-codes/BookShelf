

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.book.FetchUserIdDao;
import com.book.LoginDao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		LoginDao ld=new LoginDao();
		if(ld.check(uname, pass, email))
		{
			HttpSession session=request.getSession();
			FetchUserIdDao fd=new FetchUserIdDao();
			int id= fd.userId(uname,pass,email);
			if(id!=-1)
			{
				session.setAttribute("id", id);
				response.sendRedirect("bookhome.jsp");
				
			}
			else
			{
				PrintWriter out=response.getWriter();
				
				response.sendRedirect("index.jsp?error=Something+Went+Wrong");
			}
			
		    
			
			
		}
		else
		{
			PrintWriter out=response.getWriter();
			
			response.sendRedirect("index.jsp?error=Something went wrong Either User name or Password is incorrect or Create Account");
			
		}
		
	}

	
	}


