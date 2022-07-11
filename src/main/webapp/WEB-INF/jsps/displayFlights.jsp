<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display flights</title>
</head>
<body>
<Table>
<tr>
<th>AIRLINE</th>
<th>DEPARTURE CITY</th>
<th>ARRIVAL TIME</th>
<th>DEPARTURE TIME</th>
</tr>
<c:forEach items="${flights}" var="flight">
<tr>
<td>${flight.operatingAirlines}</td>
<td>${flight.departureCity}</td>
<td>${flight.departureDate}</td>
<td>${flight.estimatedDepartureTime}</td>
<td><a href ="showCompleteReservation?flightId=${flight.flightNumber}">SELECT</a></td>
</tr>
</c:forEach>
</Table>

</body>
</html>