<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update user</title>
</head>
<body>
	<h2>Update User</h2>
	<form action="updateuserdetials" method="post">
		<br> User Id: <input type="number" name="id"
			placeholder="Require" /> <br> Name: <input type="text"
			name="userName" /> <br> Email: <input type="text"
			name="userEmail" /><br> Address: <input type="text"
			name="userAddress" /> <br> Phone: <input type="text"
			name="userPhone" /><br>
		<button type="submit">Update</button>
		<br>
	</form>

</body>
</html>