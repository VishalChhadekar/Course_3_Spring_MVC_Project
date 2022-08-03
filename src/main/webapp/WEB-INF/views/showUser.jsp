<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<h2>User details</h2>
	Name: ${user.userName}
	<br>Email: ${user.userEmail}
	<br>Address: ${user.userAddress}
	<br>Phone: ${user.userPhone}
	<br>
	<a href="modifyuser">Update Details</a>
</body>
</html>