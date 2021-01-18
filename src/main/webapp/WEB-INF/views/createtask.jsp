<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Task</title>
</head>
<body>
	<div align="center">
		<h1>Create Task</h1>
	
		<form:form modelAttribute="form" action="addtask">
			<form:errors path="" element="div" />
			<div>
				<form:label path="taskName"> Task Name: </form:label>
				<form:input path="taskName" />
				<form:errors path="taskName" />
				<form:label path="startDate"> Start Date: </form:label>
				<form:input path="startDate" />
				<form:errors path="startDate" />
				<form:label path="endDate"> End Date: </form:label>
				<form:input path="endDate" />
				<form:errors path="endDate" />
				<form:label path="taskDescription">Task Description: </form:label>
				<form:input path="taskDescription" />
				<form:errors path="taskDescription" />
				<form:label path="taskSevirity"> Task Severity: </form:label>
				<form:input path="taskSevirity" />
				<form:errors path="taskSevirity" />
	
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
	<a href="/dashboard/${sessionId}">Back</a>
</body>
</html>