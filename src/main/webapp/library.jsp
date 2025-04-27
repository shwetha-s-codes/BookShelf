<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
     <%@page import="com.book.*" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="library.css">
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
   List<Book> bookList=(List<Book>)request.getAttribute("booklist");
   if(bookList!=null)
   {
%>
<h1>Library</h1>
<table id="infoTable">
<tr>
<th>Book Name</th>
<th>Book Cover</th>
<th>Author</th>
<th>Rating</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<tbody>
<%
    
    int id=(Integer)session.getAttribute("id");
    int bookId=(Integer)session.getAttribute("bookId");
    for(Book b:bookList)
    {
%>
<tr>
<td><%= b.getBookName() %></td>
<td><img src="ImageServlet?fileName=<%=b.getImgPath()%>" width="100" height="150" alt="bookimage"></td>
<td><%=b.getAuthor() %></td>
<td><%=b.getRating() %></td>

<td><a href="Edit.jsp?bookId=<%=bookId%>"><button>Edit</button></td>
<td><a href="DeleteServlet"><button>Delete</button></td>
</tr>
<% } %>


</tbody>
</table>



<script src="library.js"></script>
<%}
   else
   {
	  %>
	  <p>No Books Found</p> 
  <% }
    %>

</body>
</html>

