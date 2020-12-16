<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Personal Details</title>
	</head>
	<body>
		<form action="PersonalDetails" method="POST">
			<table border=0>
				<tr>
					<td>First Name : </td>
					<td> <input type="text" name="fName" placeholder="First Name"/> </td>
				</tr>
				<tr>
					<td>Middle Name : </td>
					<td> <input type="text" name="mName" placeholder="Middle Name"/> </td>
				</tr>
				<tr>
					<td>Last Name : </td>
					<td> <input type="text" name="lName" placeholder="Last Name"/> </td>
				</tr>
				<tr>
					<td>Mother's Name : </td>
					<td> <input type="text" name="motherName" placeholder="Mother's Name"/> </td>
				</tr>
				<tr>
					<td>BirthDate : </td>
					<td> <input type="date" name="bDate" placeholder="BirthDate"/> </td>
				</tr>
				<tr>
					<td>Gender : </td>
					<td>
						<input type="radio" id="gender" name="gender" value="male" checked>
						<label for="gender">Male</label><br>
						<input type="radio" id="gender" name="gender" value="female">
						<label for="female">Female</label><br>
						<input type="radio" id="gender" name="gender" value="other">
						<label for="other">Other</label><br>
					</td>
				</tr>
				<tr>
					<td>Choose Marital status : </td>
					<td>
						<select name="maritalStatus" id="maritalStatus">
						  <option value="single">Single</option>
						  <option value="married">Married</option>
						  <option value="other">Other</option>
						  </select>
					</td>
				</tr>
			</table>
			
			<a href="home.jsp">Go Back</a>
			<input type="submit" value="Procced"/>
		</form>
	</body>
</html>