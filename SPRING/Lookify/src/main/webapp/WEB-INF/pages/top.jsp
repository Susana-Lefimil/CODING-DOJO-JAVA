<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Top Ten Song</h2>
       <c:forEach items="${top}" var="song">
				
			<p><c:out value="${song.rating} //"/><a href="/search/${song.id}"><c:out value="${song.title}"/></a>  <c:out value="${song.artist}"/></p>
	
		</c:forEach>

</body>
</html>