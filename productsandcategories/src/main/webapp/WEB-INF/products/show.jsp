<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>
	<h1><c:out value="${ product.name }"/></h1>
	<h3>Categories</h3>
	<c:forEach items="${ product.categories }" var="cat">
		<p>- ${ cat.name }</p>
	</c:forEach>
	<div class="wrapper">
			<form action="/products/${ product.id }" method="post">
				<label for="categoryId">Add Category</label>
				<select name="categoryId">
					<c:forEach items="${ categories }" var="cat">
						<option value="${ cat.id }">${ cat.name }</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add" />
			</form>
		</div>
</body>
</html>