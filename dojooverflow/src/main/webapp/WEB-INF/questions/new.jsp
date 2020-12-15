<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
</head>
<body>
	<h1>What is your Question?</h1>
	<form:form action="/questions/new" method="post" modelAttribute="question">
		<p>
			<form:label path="text">Question: </form:label>
			<form:errors path="text" />
			<form:textarea path="text"/>
		</p>
		<p>
			<form:label path="tags">Tags: </form:label>
			<form:errors path="tags" />
			<form:input path="tags"/>
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>