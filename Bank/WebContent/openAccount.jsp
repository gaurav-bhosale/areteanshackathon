<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Open Account</title>
	</head>
	<script>
		function goBack() {
		  window.history.back();
		}
	</script>
	<body>
		<form action="SetAccountType" method="GET">
			<h2>Please Select Account Type : </h2>
			<input type="radio" id="saving" name="accountType" value="saving" checked>
			<label for="saving">Saving</label><br>
			<h2>Please Select Account Category: </h2>
			<input type="radio" id="single" name="accountCat" value="single" checked>
			<label for="single">Single</label><br>
			<input type="radio" id="joint" name="accountCat" value="joint">
			<label for="joint">Joint</label><br>
			<button onclick="goBack()">Go Back</button>
			<input type="submit" value="Procced"/>
		</form>
	</body>
</html>