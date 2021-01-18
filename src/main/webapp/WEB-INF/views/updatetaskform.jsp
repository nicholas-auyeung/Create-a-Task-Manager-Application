<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>Update Task Form</title>
<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  $( function() {
	$( "#datepicker2" ).datepicker();
  } );
 </script>
</head>
<body>
	<h1>Edit Task</h1>
	<form:form modelAttribute="task" action="updateTask">
			<div>
				<form:label path="taskId"> ID: ${task.taskId}</form:label><br/>
				<form:hidden path="taskId" />
				<form:label path="taskName"> Name: </form:label><br/>
				<form:input path="taskName" />
				<p>Start Date:<br/><input type="text" value="${task.startDate}" id="datepicker" name="startDate"></p>
				<p>End Date:<br/><input type="text" value="${task.endDate}" id="datepicker2" name="endDate"></p>
				<form:label path="taskDescription"> Description: </form:label><br/>
				<form:textarea path="taskDescription" />
				<br/>
				<form:label path="taskEmail"> Email: </form:label><br/>
				<form:input path="taskEmail" /><br/>
				<form:label path="taskSevirity"> Severity: </form:label><br/>
				<form:select path="taskSevirity"> 
				<form:option value="None">None</form:option>
				<form:option value="High">High</form:option>
				<form:option value="Medium">Medium</form:option>
				<form:option value="Low">Low</form:option>
				</form:select>
			</div>
			<div><br/>
				<input type="submit" value="Submit" />
			</div>
	</form:form>
	<a href="/dashboard/${sessionId}">Back</a>
</body>
</html>