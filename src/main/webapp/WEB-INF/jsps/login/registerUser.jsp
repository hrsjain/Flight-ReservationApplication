<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
<h2> Registration Page </h2>
<form action ="registerUser" method="post">
<pre>
First Name : <input type= "text" name="firstname"/>
Last Name: <input type= "text" name="lastname"/>
Username: <input type= "text" name="email">
Password: <input type= "password" name="password"/>
Confirm Password: <input type= "password" name="confirmpassword"/>
<input type="submit" name="register"/>
</pre>
</form>
</body>
</html>