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
				<h1 class="p-3 mb-2 .text-light" ><c:out value="${show.name}"/></h1>
				<p> Network <c:out value="${show.network}"/></p>
				<h2 class="p-3 mb-2 .text-light" >Users who rated this show</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Rating</th>
						<tr>
					</thead>
					<tbody>
						<c:forEach items="${show.ratings}" var="s">
							<tr>
							
									<td><c:out value="${s.user.name}"/></td>
									<td><c:out value="${s.rating}"/></td>
									<td>									    
							
								</td>
							</tr>
							
						</c:forEach>
						
					</tbody>
					
				</table>
				<a href="/shows/${show.id}/edit" class="btn btn-secondary">Edit</a>
			</div>
		</div>
       <div>  
       	<form:form method="post" action="/shows/${show.id}/rating" modelAttribute="rating">	   
			<div class="form-group row">
			<label for="rating" class="col-sm-2 col-form-label">Leave a Rating</label>
			<div class="col-sm-10">
				<form:select path="rating" items="${ rating.optionsRating }" class="form-control"
				placeholder="" />
				<p class="text-danger">
					<form:errors path="rating" />
				</p>		
			</div>
		    </div>		  
		    	<input type="submit" value="Rate!"  class="btn btn-secondary"/>
		    	<a href="/shows" class="btn btn-secondary"><c:out value="Back"/></a>
		  
		</form:form>
       

	  </div>
	</div>
	<script src="/webjars/jquery/3.4.1/dist/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>