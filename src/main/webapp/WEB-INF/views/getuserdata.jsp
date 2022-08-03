<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add user data</title>
</head>
<body>
	<h2>Add user Details</h2>
	<form action="adduserdata" method="post">
		<br> User Name<input type="text" name="userName" /><br>Email
		<input type="text" name="userEmail" /><br> Address <input
			type="text" name="userAddress" /> <br>Phone <input
			type="number" name="userPhone" />
		<button type="submit">Add</button>
		<br>
	</form>

</body>
</html>