<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
   
    <style>
        input {
                border:3px solid

        }
        body {
            color:beige
        }
        label{
                color:black;
                font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        }
        body{
               background-color:antiquewhite;
        }
        #login {
                  border: none
                  

        }
        button:hover{
                        background-color: green;
        }
    </style>
</head>
<body>
    <header>
        <center><h1 style="color:black">SignUp</h1></center>
    </header>
   <form action="SignUpServlet">
    <div id="login">
        <center>
            <br>
            <label for= "email">Email</label>
            <input type="email" placeholder="enter your email" name="email"><br><br>
        <label for="Username">Username</label>
        <input type="text" placeholder="enter your name" name="uname"><br><br>
        <label for="Password">Password</label>
        <input type="password" placeholder="enter password" name="pass"><br><br>
        </center>
    
    </div>
    <span>
        <center ><button>SignUp</button></center>
    </span>
   </form> 
</body>
</html>