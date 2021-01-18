<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Task Dashboard</title>
</head>
<body>

	<h1>Task Dashboard</h1>
	
	<table class="table">
		<thead>
			<th scope = "col">ID</th>
			<th scope = "col">Name</th>
			<th scope = "col">Start Date</th>
			<th scope = "col">End Date</th>
			<th scope = "col">Description</th>
			<th scope = "col">Email</th>
			<th scope = "col">Severity</th>
			<c:forEach items="${taskList}" var="task">
				<tr>
					<th scope ="row">${task.taskId}</th>
					<td>${task.taskName}</td>
					<td>${task.startDate}</td>
					<td>${task.endDate}</td>
					<td>${task.taskDescription}</td>
					<td>${task.taskEmail}</td>
					<td>${task.taskSevirity}</td>
			</c:forEach>
		</thead>
	
	</table>
			<a class="btn btn-outline-primary" href="/addtask/${sessionId}" role="button">Create Task </a>
			<a class="btn btn-outline-success" href="/updatetask/${sessionId}" role="button">Update Task </a>
			<a class="btn btn-outline-danger" href="/deletetask/${sessionId}">Delete Task </a><br/>
			<a href="/logout">Logout </a>

</body>
</html>