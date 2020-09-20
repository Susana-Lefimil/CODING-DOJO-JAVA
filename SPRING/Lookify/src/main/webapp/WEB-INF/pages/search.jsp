<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<h1> Canciones de: <c:out value="${artist}"></c:out> </h1>
<a href="/dashboard" >Dashboard</a>
<form action="/search">
	<input type="text" name="artist" placeholder="Artista" value=<c:out value="${artist}"></c:out>>
	<input type="submit" value="Search">
</form>
<table>
	<thead>
		<tr>
			<th><h3 scope="col">Título</h3></th>
			<th><h3 scope="col">Rating</h3></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${artista}" var="cancion">
		<tr>		
			<td><a href="/search/${cancion.id}"><c:out value="${cancion.title}"/></a></td>
			<td><p><c:out value="${cancion.rating}"/></p></td>
			<td><a href="/show/${cancion.id}" >Delete</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>		
</body>
</html>