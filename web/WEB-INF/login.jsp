<%-- 
    Document   : login
    Created on : 11-Oct-2020, 3:36:34 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <b>Username: </b> <input type="text" name="username" value = ${name}><br><br>
            <b>Password: </b> <input type="text" name="password"><br><br>
            <input type ="submit" value="Log in"><br><br>
        </form>
        <b>${error}</b>


    </body>
</html>
