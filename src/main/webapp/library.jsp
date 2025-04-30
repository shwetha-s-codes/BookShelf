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
  
    for(Book b:bookList) //Iterating all the books by the user
    {
%>
<tr>
<td><%= b.getBookName() %></td>
<td><img src="ImageServlet?fileName=<%=b.getImgPath()%>" width="100" height="150" alt="bookimage"></td>
<td><%=b.getAuthor() %></td>
<td><%=b.getRating() %></td>

<%
    System.out.println(b.getAuthor());
%>

<td><a href="Edit.jsp?bookId=<%= b.getBookId()%>"><button value=<%=b.getBookId() %>>Edit</button> </a> </td>
<td><a href="DeleteServlet?bookId=b.getBookId()"><button>Delete</button></td>
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

