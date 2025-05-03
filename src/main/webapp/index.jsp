<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
<%
    String error=request.getParameter("error");
    if(error!=null){
    
%>
<p id="errormessage" style="color:red"><%=error %></p> 
<%} %>
<h1>Read Log</h1>
<a href="login.jsp"><button class="button">LOGIN</button></a> <br>
<a href="signup.jsp"><button class="button">SIGNUP</button></a>
<script>

// Make the message disappear after 5 seconds
setTimeout(() => {
  const msg = document.getElementById("errormessage");
  if (msg) msg.style.display = "none";
}, 1000);


</script>


</body>
</html>