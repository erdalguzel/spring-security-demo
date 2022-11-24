<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Home Page</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr />
	Welcome to the home page

	<hr>

	<p>
		User:
		<security:authentication property="principal.username" />
		<br>
		<br> Roles:
		<security:authentication property="principal.authorities" />
	</p>

	<hr>

	<hr>
		<p>
			<a href="${pageContext.request.contextPath}/managers">Management meeting</a>
			(Only for managers. Karens cannot join this meeting)
		</p>
	<hr>
	
	
	<hr>
		<p>
			<a href="${pageContext.request.contextPath}/admin">IT Admin meeting</a>
			(Only for IT folks. Karens cannot join this meeting)
		</p>
	<hr>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input value="Logout" type="submit" />
	</form:form>
</body>
</html>