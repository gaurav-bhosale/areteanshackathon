<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Terms and Conditions</title>
	</head>
	<script type="text/javascript">
		function changeStatus(checkme) {
	        var subButtonr = document.getElementById("sendNewSms");
	        
	        subButtonr.removeAttribute("disabled");
        }
		
	</script>
	<body>
		<form action="RegisterUser" method="POST">
			<h3>
				Set Password : <input type="text" name="password1" placeholder="Password"/><br>
				Confirm Password : <input type="text" name="password2" placeholder="Retype Password"/>
			</h3>
			<h3> <input type="checkbox" id="checkme" onchange="changeStatus(this)"/>
			 I have read all the 
				<a href="termsAndCondithins.jsp">terms and conditions</a>
			</h3>
			<button onclick="kycDetails.jsp">Go Back</button>
			<input type="submit" name="sendNewSms" class="inputButton" id="sendNewSms" value="Submit" disabled/>
		</form>
	</body>
</html>