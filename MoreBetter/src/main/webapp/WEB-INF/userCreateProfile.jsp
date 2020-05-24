<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All about YOU!</title>
</head>
<body>
<a href="/" button type="button" class="btn btn-outline-primary">Home</a>
<br>
<h2> Tell us about yourself!</h2>
<br>
Fields with * are mandatory
<br>
	<form action="userCreateProfile.do" method="POST">
	
	Create a User Name:
	<input type="text" name="username" placeholder="type in a username, and we'll let you know if its already taken">*
	
	Enter a Password:
	<input type="text" name="password" placeholder="Create a password">*
	
	Your First Name:
	<input type="text" name="firstName" placeholder="enter your first name">*
	
	Your Last Name:
	<input type="text" name="lastName" placeholder="enter your last name">*
	
	Your Email Address:
	<input type="text" name="email" placeholder="enter your email">*
	
	i think this is fucked the fuck up...
	<br> Are you applying to be a mentor?:
	<select type="text" name="free"  placeholder="unspecified">
						<option value="Yes">Yes</option>
						<option value="No">No</option>
					</select><br>
	<br> Age:
	<input type="number" name="age" placeholder="Enter your age">*
	
	Tell us About yourself:
	<input type="text" name="biography" placeholder="Tell us your story!">
	
	<br><br> Insert a Photo:
	<input type="text" name="picture" placeholder="enter URL for image">
<br>
	<input type="submit" value="reCreate Yourself" />
</form>

</body>
</html>