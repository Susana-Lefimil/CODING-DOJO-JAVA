<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shows</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col">
				<h1 class="p-3 mb-2 .text-light" > Welcome, <c:out value="${user.name}"/></h1>
				<p> Tv Shows</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Show</th>
							<th>Network</th>
							<th>Avg Rating</th>
						<tr>
					</thead>
					<tbody>
						<c:forEach items="${shows}" var="s">
							<tr>
							
									<td><a href="/shows/${s.id}"><c:out value="${s.name}"/></a></td>
									<td><c:out value="${s.network}"/></td>
									<td><c:out value="${s.avgRating}"/></td>
							
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
				
			</div>
		</div>
		<a href="/shows/new" class="btn btn-secondary"><c:out value="Add a Show"/></a>
		<a href="/" class="btn btn-secondary"><c:out value="Logout"/></a>
	
	</div>
</body>
</html>