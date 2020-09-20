<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="p-3 mb-2 text-success">Edit appointment</h2>
				
			

				<form:form method="POST" action="/appointments/${cita.id}/edit"
					modelAttribute="cita">
					<div class="form-group row">
						<label for="task" class="col-sm-2 col-form-label">Task</label>
						<div class="col-sm-10">
							<form:input path="task" class="form-control"  required="required"
							placeholder="Task" />
							<p class="text-danger">
							<form:errors path="task" />
						</p>
						</div>
                    </div>
					 
                    <div class="form-group row">
						<label for="date" class="col-sm-2 col-form-label">Date</label>
						<div class="col-sm-10">
							<form:input path="date" pattern="yyyy-MM-dd" class="form-control"  required="required"
							type="date" />
							<p class="text-danger">
							<form:errors path="date" />
						</p>
						</div>
                    </div>
				
					
					<div class="form-group row">
						<label for="status" class="col-sm-2 col-form-label">Status</label>
						<div class="col-sm-10">
							<form:select path="status" items="${cita.optionsStatus}" class="form-control" required="required"
							placeholder="status" />
							<p class="text-danger">
							<form:errors path="status" />
						</p>
						</div>
					</div>
					
					<div class="form-group">
					     <input type="submit" value="Update" class="btn btn-secondary"/>
						<a href="/appointments/" class="btn btn-secondary">Cancel </a>
						
					</div>
				</form:form>

			</div>
		</div>
	</div>
	<script src="/webjars/jquery/3.4.1/dist/jquery.min.js"></script>
	<script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
</body>
</html>