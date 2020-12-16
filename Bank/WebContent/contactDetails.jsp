<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="ContactDetails" method="POST">
			<table border=0>
				<tr>
					<td>Email Address : </td>
					<td> <input type="text" name="email" placeholder="Email Address"/> </td>
				</tr>
				<tr>
					<td>Mobile Number : </td>
					<td> <input type="text" name="mobile" placeholder="Mobile Number"/> </td>
				</tr>
				<tr>
					<td>Alternate Mobile Number : </td>
					<td> <input type="text" name="altMobile" placeholder="Alternate Mobile Number"/> </td>
				</tr>
				<tr>
					<td>Address Line 1 : </td>
					<td> <input type="text" name="addLine1" placeholder="House Number and Village"/> </td>
				</tr>
				<tr>
					<td>Address Line 2 : </td>
					<td> <input type="text" name="addLine2" placeholder="Near By Location"/> </td>
				</tr>
				<tr>
					<td>City : </td>
					<td> <input type="text" name="city" placeholder="City"/> </td>
				</tr>
				<tr>
					<td>State : </td>
					<td> <input type="text" name="state" placeholder="State"/> </td>
				</tr>
				<tr>
					<td>Pincode : </td>
					<td> <input type="text" name="pincode" placeholder="PinCode"/> </td>
				</tr>
			</table>
			
			<a href="personalDetails.jsp">Go Back</a>
			<input type="submit" value="Procced"/>
		</form>
	</body>
</html>