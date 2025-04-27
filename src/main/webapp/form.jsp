<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
     response.sendRedirect("login.jsp");
     return;
   }
%>
<form  id= "myform"   action="bookinfoServlet" method="POST" enctype="multipart/form-data"> <!--  Since we are dealing with files enctype should be mentioned--> 
<h2>Enter All the details</h2>
<label for ="name"> Book Name </label>
<input type="text" id="name" name="bookname" required> <br><br>
<label for ="coverimage">Upload CoverImage </label>
<input type="file" id="coverimage" name="coverimage"> <br><br>
<label for ="author">Author</label>
<input type="text"  id="author" name="author"> <br><br>
<label for ="rating">Rating</label>
<input type="text"  id="rating" name="rating"> <br><br>
<button>Submit</button>
</form>

</body>
</html>
</body>
</html>