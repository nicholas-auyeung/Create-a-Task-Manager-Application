<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<h1>Registration</h1>
	
		<form:form modelAttribute="form" action="register">
			<form:errors path="" element="div" />
			<div>
				<form:label path="name"> Name: </form:label>
				<form:input path="name" />
				<form:errors path="name" />
				<form:label path="email"> Email: </form:label>
				<form:input path="email" />
				<form:errors path="email" />
				<form:label path="userName"> Username: </form:label>
				<form:input path="userName" />
				<form:errors path="userName" />
				<form:label path="password"> Password: </form:label>
				<form:input path="password" />
				<form:errors path="password" />
				<form:label path="city"> City: </form:label>
				<form:input path="city" />
				<form:errors path="city" />
	
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
</body>
</html>