<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculadora Web</title>
<style type="text/css">


.box button {
	width:35px;
}
.clear button{
     width:50px;
}
.box{

   float: left;
   diplay:inline-block;
	width:200px;
	height:400px;
    margin: 10px;
}



</style>
</head>
<body>
<div class="box">
	<h3>Calculadora Web</h3>
	
		<form action="<%=request.getContextPath()%>/cal" method="post" >
		    <div>
				<input type="number"  name="txt" step="0.01" value="<c:out value="${currentCalculator.currentNumber}"></c:out>" >
			</div>
			<div>
				<button name="btn" value="1">1</button>
				<button name="btn" value="2">2</button>
				<button name="btn" value="3">3</button>
				<button name="btn" value="/">/</button>
			</div>
			<div>
				<button name="btn" value="4">4</button>
				<button name="btn" value="5">5</button>
				<button name="btn" value="6">6</button>
				<button name="btn" value="x">x</button>
			</div>
			<div>
				<button name="btn" value="7">7</button>
				<button name="btn" value="8">8</button>
				<button name="btn" value="9">9</button>
				<button name="btn" value="-">-</button>
			</div>
			<div>
				<button name="btn" value="0">0</button>
				<button name="btn" value=".">.</button>
				<button name="btn" value="=">=</button>
				<button name="btn" value="+">+</button>
			</div>
			<div class="clear">
				<button class="clear" name="btn" value="cl">Clear</button>
				
			</div>
		
		
		</form>
	
	</div>
	<div class="box">
	
		<h3>Resultados</h3>
		
		<ul>
		   <c:forEach var="rest" items="${currentCalculator.rest}">
				<li><c:out value="${rest}"/></li>
				
		    </c:forEach>	
		</ul>
		
	</div>



</body>
</html>