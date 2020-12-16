<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<script type="text/javascript">
	    function EnableDisableTextBox(btnPassport) {
	        var txtPassportNumber = document.getElementById("pancard");
	        if (btnPassport.value == "Yes") {
	            txtPassportNumber.removeAttribute("disabled");
	        } else {
	            txtPassportNumber.setAttribute("disabled", "disabled");
	        }
	    }
	</script>
	<body>
		<form action="KycDetails" method="POST">
			<table border=0>
				<tr>
					<td>Aadhar Number : </td>
					<td> <input type="text" name="aadhar" placeholder="Aadhar Number"/> </td>
				</tr>
				<tr>
					<td>Confirm Aadhar Number : </td>
					<td> <input type="text" name="reAadhar" placeholder="Retype Aadhar Number"/> </td>
				</tr>
				<tr>
					<td>Do You have Pancard? : </td>
					<td>
						<input type="button" value="Yes" onclick="EnableDisableTextBox(this)" />
						<input type="button" value="No" onclick="EnableDisableTextBox(this)" />
					</td>
				</tr>
				<tr>
					<td>Enter Pan Number : </td>
					<td>
						<input type="text" name="pancard" id="pancard" disabled = "disabled" />
					</td>
				</tr>
			</table>
			
			<a href="contactDetails.jsp">Go Back</a>
			<input type="submit" value="Procced"/>
		</form>
	</body>
</html>