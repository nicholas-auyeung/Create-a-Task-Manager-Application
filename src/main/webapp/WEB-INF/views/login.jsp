<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
		<h1>Task Manager Login</h1>
			<form action="login" method="post">
				Username:<br/><input type = "text" name ="username"><br/>
				Password:<br/><input type = "text" name ="password"><br/>
				<input type="submit" value="Submit" />
			</form>
	<a href="/register">Don't have an account? Register Here</a>
</body>
</html>