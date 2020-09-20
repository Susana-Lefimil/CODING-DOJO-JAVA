<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shows</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<h2>"${show.name}"</h2>

				<p>
					<form:errors path="user.*" />
				</p>

					<form:form method="post" action="/shows/${show.id}/edit" modelAttribute="show">
						<div class="form-group row">
						<label for="name" class="col-sm-2 col-form-label">Title</label>
						<div class="col-sm-10">
							<form:input path="name" class="form-control" />
						</div>
						</div>
						
						<div class="form-group row">
						<label for="network" class="col-sm-2 col-form-label">Network</label>
						<div class="col-sm-10">
							<form:input path="network" class="form-control" />
						</div>
						</div>
				
						<input type="submit" value="Update"  class="btn btn-secondary"/>
					</form:form><br>
					
					<form  action="/shows/${show.id}/delete" method="post">
					    <input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete" class="btn btn-secondary">
					</form>	<br>
				<a href="/shows" class="btn btn-secondary"><c:out value="Back"/></a>
			</div>
		</div>
	</div>


<script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>