<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Task Dashboard</h1>
	<ul>
	<c:forEach items="${taskList}" var="task">
		<tr>
			<td>${task.taskName}</td>
		</tr>
	</c:forEach>
	</ul>
	<a href="/addtask/${sessionId}">Create Task </a>
	<a href="/updatetask/${sessionId}">Update Task </a>
	<a href="/deletetask/${sessionId}">Delete Task </a>
</body>
</html>