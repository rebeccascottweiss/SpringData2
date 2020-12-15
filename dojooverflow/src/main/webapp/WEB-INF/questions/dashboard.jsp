<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Dashboard</title>
</head>
<body>
	<h1>Questions DashBoard</h1>
	
	<table>
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ questions }" var="question">
			<tr>
				<td><a href="/questions/${ question.id }">${ question.text }</a></td>
				<td>
					<c:forEach items="${ question.tags }" var="tag">
						<span>
							${ tag.subject },
						</span>
					</c:forEach>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/questions/new">New Question</a>
</body>
</html>