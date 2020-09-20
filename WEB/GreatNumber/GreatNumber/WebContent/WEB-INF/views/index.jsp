<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Juego Great Number</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>Welcome to the Great Number Game!</h1>
	<h2>I am thinking of a number between 1 and 100</h2>
	<h2>Take a guess!</h2>
	
						
	
	      <div class="<c:out value="${clase}"/>">
		     <p><c:out value="${mensaje}"/></p>
		     
		     <div class="<c:out value="${clases}"/>">
		     	<p><c:out value="${number}"/></p>
		     	<form action="/GreatNumber/CleanSession" method="GET">
		     		<input type="submit" value="Play again">
				</form>
		     </div>
		     
		  </div>
	
	<form action="/GreatNumber/Home" method="POST">
		<input type="text" name="numero">
		<input type="submit" value="Submit">
	
	</form>

</body>
</html>