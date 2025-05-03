<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to ReadLog</title>
    <link rel="stylesheet" href="bookhome.css"> <!-- Link to external CSS -->
</head>

<body>
<%
    if(session==null||session.getAttribute("id")==null)
   {
     response.sendRedirect("index.html");
     return;
   }
%>
    <header>
        <h1>Welcome to Read Log</h1>
    </header>

    <main>
        <section>
            <article>
                This is the place where you can store and cherish all your book memories.
            </article>
        </section>

        <div class="button-section">
           
            <a href="FetchBookInfo">
                <button>GO TO LIBRARY</button>
            </a>
        </div>

        <div class="button-section">
           
            <a href="form.jsp">
                <button>ADD NEW BOOK</button>
            </a>
        </div>
    </main>
</body>

</html>
