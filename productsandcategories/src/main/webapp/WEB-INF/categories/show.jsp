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
	<h3>Products</h3>
	<c:forEach items="${ category.products }" var="prod">
		<p>- ${ prod.name }</p>
	</c:forEach>
</body>
</html>