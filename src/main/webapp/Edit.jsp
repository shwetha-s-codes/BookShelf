<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.book.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    if(session==null||session.getAttribute("id")==null)
   {
     response.sendRedirect("index.html");
     return;
   }
%>
<%
     int bookId=Integer.parseInt(request.getParameter("bookId"));
     int id=(Integer)session.getAttribute("id");
     FetchToUpdate fd=new FetchToUpdate();
     //List<Book> book=new ArrayList<>();
     Book b1=new Book();
     b1= fd.fetch(id,bookId);
     
%>
<form  id= "myform"   action="EditServlet" method="POST" enctype="multipart/form-data"> 
<h2>Enter fields You want to Update</h2>
<label for ="name">Book Name </label>
<input type="text" id="name" name="bookname"  value=<%=b1.getBookName() %>> <br><br>
<label for ="coverimage">Upload CoverImage </label>
<input type="file" id="coverimage" name="coverimage" > <br><br>
<input type="hidden" name="oldimagepath" value=<%=b1.getImgPath() %> %>

<label for ="author">Author</label>
<input type="text"  id="author" name="author" value=<%=b1.getAuthor() %>> <br><br>
<label for ="rating">Rating</label>
<input type="text"  id="rating" name="rating" value=<%= b1.getRating()%>> <br><br>

<input type="hidden" name="bookId" value= "<%=bookId%>">
<button>Submit</button>
</form>

</body>
</html>
</body>
</html>
