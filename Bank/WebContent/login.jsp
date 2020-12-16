<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="Authenticate" method="POST">
			<table border=0>
				<tr>
					<td>Username : </td>
					<td> <input type="text" name="email" placeholder="Username"/> </td>
				</tr>
				<tr>
					<td>Password : </td>
					<td> <input type="text" name="password" placeholder="Password"/> </td>
				</tr>
			</table>
			<a href="home.jsp">Back</a>
			<input type="submit" value="Login"/>
		</form>
</body>
</html>