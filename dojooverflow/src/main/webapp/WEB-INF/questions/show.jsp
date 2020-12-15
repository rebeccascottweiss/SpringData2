<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Profile</title>
</head>
<body>
	<h1><c:out value="${ question.text }"/></h1>
	<h2>Tags:
		<c:forEach items="${ question.tags }" var="tag">
			<span>${ tag.subject }</span>
		</c:forEach>
	</h2>
	<table>
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ question.answers }" var="answer">
			<tr>
				<td>${ answer.text }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add your answer:</h2>
	<form:form action="/createAnswer" method="post" modelAttribute="answer">
		<form:label path="text">Answer</form:label>
		<form:errors path="text"/>
		<form:input path="text"/>
		<form:hidden path="question" value="${ question.id }"/>
		<input type="submit" value="Answer it!"/>
	</form:form> 
</body>
</html>