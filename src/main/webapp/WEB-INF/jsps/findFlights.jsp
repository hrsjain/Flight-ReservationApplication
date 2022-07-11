<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights Page</title>
</head>
<body>
<h2> list of Flights</h2>
<form action="findFlights" method="POST">
<pre>
From: <input type="text" name="from"/>
To: <input type="text" name="to"/>
Departure Date: <input type="text" name="departureDate"/>
<input type="submit" value="search"/>
</pre>
</form>
</body>
</html>