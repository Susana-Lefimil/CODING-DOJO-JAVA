<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointments</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1 class="p-3 mb-2 text-success">Hello, <c:out value="${user.name}"/></h1>
				<p> Here are your appointemts</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Tasks</th>
							<th>Date</th>
							<th>Status</th>
							<th>Action</th>
						<tr>
					</thead>
					<tbody>
						<c:forEach items="${citas}" var="cit">
							<tr>
							<c:choose>										    
								<c:when test="${cit.date<today}">
									<td><c:out value="${cit.task}"/></td>
									<td><c:out value="${cit.date}"/></td>
									<td><c:out value="${cit.status}"/></td>
									<td>
								<c:choose>										    
									<c:when test="${cit.status!='Pending'}">
									<a href="/appointments/${cit.id}/edit">Edit</a>
									<a href="/appointments/${cit.id}/delete">Delete</a>
								    </c:when>							
							    </c:choose>
								</td>
								</c:when>							
							</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<p> Post appointments</p>
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Tasks</th>
							<th>Date</th>
						<tr>
					</thead>
					<tbody>
					
						<c:forEach items="${citas}" var="cita">
							<tr>
							<c:choose>										    
								<c:when test="${cita.date<today}">
								<td><c:out value="${cita.task}"/></td>
								<td><c:out value="${cita.date}"/></td>
							  </c:when>							
						 </c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<a href="/logout">Logout</a>
			</div>
		</div>
	</div>
</body>
</html>