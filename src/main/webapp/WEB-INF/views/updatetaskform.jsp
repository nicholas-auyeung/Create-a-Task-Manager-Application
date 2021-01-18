<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Task Form</title>
</head>
<body>
	<div align="center">
		<h1>Edit Task</h1>
		 <form:form action="update" method="post" modelAttribute="task">
	            <table border="0" cellpadding="5">
	                <tr>
	                    <td>ID: </td>
	                    <td>${task.taskId}
	                        <form:hidden path="taskId"/>
	                    </td>
	                </tr>       
	                <tr>
	                    <td>Task Name: </td>
	                    <td><form:input path="taskName" /></td>
	                </tr>
	                <tr>
	                    <td>Start Date: </td>
	                    <td><form:input path="startDate" /></td>
	                </tr>
	                <tr>
	                    <td>End Date: </td>
	                    <td><form:input path="endDate" /></td>
	                </tr>
	                 <tr>
	                    <td>Task Description: </td>
	                    <td><form:input path="taskDescription" /></td>
	                </tr>
	                 <tr>
	                    <td>Task Severity: </td>
	                    <td><form:input path="taskSevirity" /></td>
	                </tr>
	                <tr>
	                    <td colspan="2"><input type="submit" value="Save"></td>
	                </tr>                   
	            </table>
	        </form:form>
	 </div>
</body>
</html>