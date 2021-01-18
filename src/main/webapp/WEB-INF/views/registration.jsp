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
<title>Registration</title>
</head>
<body>
		<h1>Register for Task Manager</h1>
	
		<form:form modelAttribute="form" action="register">
			<form:errors path="" element="div" />
			<div>
				<form:label path="name"> Name: </form:label>
				<form:input path="name" /><br/><br/>
				<form:label path="email"> Email: </form:label>
				<form:input path="email" /><br/><br/>
				<form:label path="city"> City: </form:label>
				<form:input path="city" /><br/><br/>
				<form:label path="userName"> Username: </form:label>
				<form:input path="userName" /><br/><br/>
				<form:label path="password"> Password: </form:label>
				<form:input path="password" /><br/><br/>
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</form:form>
		<a href="/login">Already have an account? Login Here</a>
</body>
</html>