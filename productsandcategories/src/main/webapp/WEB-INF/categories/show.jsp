<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
	<h1><c:out value="${ category.name }"/></h1>
	<div class="container">
		<div class="wrapper"><h3>Products</h3>
			<c:forEach items="${ category.products }" var="prod">
				<p>- ${ prod.name }</p>
			</c:forEach>
		</div>
		<div class="wrapper">
			<form action="/categories/${ category.id }" method="post">
				<label for="productId">Add Product</label>
				<select name="productId">
					<c:forEach items="${ products }" var="prod">
						<option value="${ prod.id }">${ prod.name }</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add" />
			</form>
		</div>
	</div>
</body>
</html>