<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>More Better</title>
<link rel="stylesheet" href="style/styles.css">
</head>
<body>
	<div class="">

		<h1 id="heading">MoreBetter</h1>

		<h3>Your Life Is Bigger Than Your Problems</h3>

	</div>
	<div class="row" align="center">
		<form method="GET" action="https://trello.com/b/d65CsPp2/morebetter">
			<div class="finance">
				<input type="image" name="submit"
					src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/whatsapp/238/bank_1f3e6.png" />
				<c:url value="/mypage.jsp" var="completeURL">
					<c:param name="id" value="1" />
				</c:url>
				${completeURL}
			</div>
			<div class="mind">
				<input type="image" name="submit"
					src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/emojidex/112/brain_1f9e0.png" />
			</div>
			<div class="heart">
				<input type="image" name="submit"
					src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/237/heavy-black-heart_2764.png" />
			</div>
		</form>
	</div>

	<div class="event-button">
		<form method="GET" action="https://trello.com/b/d65CsPp2/morebetter">
			<input type="submit" name="articleid" value="List of Events" />
		</form>
	</div>
</body>
</html>