<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<a href="/songs/new" >Add New</a>
<a href="/search/top" >Top Songs</a>
<form action="/search">
	<input type="text" name="artist" placeholder="Artista">
	<input type="submit" value="Search">	
</form>

<table>
	<thead>
		<tr>
			<th><h1 scope="col">Título</h1></th>
			<th><h1 scope="col">Artista</h1></th>
			<th><h1 scope="col">Rating</h1></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${canciones}" var="cancion">
		<tr>		
			<td><a href="/search/${cancion.id}"><c:out value="${cancion.title}"/></a></td>
			<td><p><c:out value="${cancion.artist}"/></p></td>
			<td><p><c:out value="${cancion.rating}"/></p></td>
		</tr>
		</c:forEach>
	</tbody>
</table>		
</body>
</html>