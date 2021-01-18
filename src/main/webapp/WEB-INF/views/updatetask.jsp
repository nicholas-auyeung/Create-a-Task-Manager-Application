<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Task</title>
</head>
<body>
	<h1>Update Task</h1>
	<ul>
	<c:forEach items="${taskList}" var="task">
		<tr>
			<td>${task.taskName}</td>
		</tr>
	</c:forEach>
	</ul>
	<form action="update" method="post">
				<input type ="number" name ="updateId">Enter task ID to Update: 
				<input type="submit" value="Submit" />
	</form>
	<a href="/dashboard/${sessionId}">Back</a>
</body>
</html>