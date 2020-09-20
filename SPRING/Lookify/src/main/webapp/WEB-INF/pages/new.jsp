<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 	<p>
					<form:errors path="newSong.*" />
				</p>
       <form:form action="/songs" method="post" modelAttribute="newSong">
			<p>
				<form:label path="title">Title</form:label>

				<form:input path="title" required="required"/>
				<form:errors path="title" />
			</p>
			<p>
				<form:label path="artist">Artist</form:label>

				<form:input path="artist" required="required"/>
				<form:errors path="artist" />
			</p>
			<p>
				<form:label path="rating">Rating</form:label>
				<form:select path="rating" >
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
					<form:option value="6">6</form:option>
					<form:option value="7">7</form:option>
					<form:option value="8">8</form:option>
					<form:option value="9">9</form:option>
					<form:option value="10">10</form:option>
				</form:select>
				<form:errors path="rating"></form:errors>
			</p>
			<input type="submit" value="Add Song" />
		</form:form>

	

</body>
</html>