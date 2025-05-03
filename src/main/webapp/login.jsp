<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="login.css">
   
 
</head>
<body>
    <header>
        <center><h1 >Login</h1></center>
    </header>
   <form action="LoginServlet" method="post">
    <div id="login">
        
            <br>
            <label for= "email">Email</label>
            <input type="email" placeholder="enter your email" name="email">
        <label for="Username">Username</label>
        <input type="text" placeholder="enter your name" name="uname" autocomplete="off"><br><br>
        <label for="Password">Password</label>
        <input type="password" placeholder="enter password" name="pass" autocomplete="off"><br><br>
        <span>
       <button>Login</button>
    </span>
        
    
    </div>
    
   </form> 
</body>
</html>