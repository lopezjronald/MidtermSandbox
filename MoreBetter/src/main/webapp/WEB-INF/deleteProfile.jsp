<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>

	<form action="destroyProfile.do" method="POST">
		<strong><em>${user.username}</em></strong> <input type="hidden" name="id"
			value="${user.id}" /> <input type="submit" button type="button"
			value="Delete" />
	</form>

</body>
</html>