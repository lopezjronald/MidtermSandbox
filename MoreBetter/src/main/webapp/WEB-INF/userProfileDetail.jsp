<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Look at YOU!</title>

<a href="/" button type="button" class="btn btn-outline-primary">Home</a>
<br>
<br>
</head>
<body>
	<br>User ID : ${user.id}
	<br>
	<br>

	<form action="updateProfile.do" method="POST">

		User Name<br> <input type="text" name="username"
			value="${user.username}" /><br>
			
		Password<br> <input type="text" name="password"
			value="${user.password}" /><br>			
		
		First Name<br> <input type="text" name="firstName"
			value="${user.firstName}" /><br>
			
		Last Name<br> <input type="text" name="lastName"
			value="${user.lastName}" /><br>
			
		Email Address<br> <input type="text" name="email"
			value="${user.email}" /><br>
				
		Mentor Status<br> <input type="text" name="role"
			value="${user.role}" /><br>	
			
		Age><br> <input type="number" name="age"
			value="${user.age}" /><br>	
			
		Biography<br> <input type="text" name="biography"
			value="${user.biography}" /><br>	
				
		Photo<br> <input type="text" name="picture"
			value="${user.picture}" /><br>	
	
	</form>
	<br>
	<br>
	<form action="destroyProfile.do" method="POST">
		<strong><em>${user.name}</em></strong> <input type="hidden"
			 value="${user.id}" /> <input type="submit" button type="button" value="Delete Yourself"/>
	</form>
	<br>
	<br>

</body>
</html>