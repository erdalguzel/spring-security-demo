<%@ taglib prefix="form" uri="http://www.springframework.com/tags/form"%>

<html>
<head>
	<title>Login Page</title>
</head>

<body>
	<h2>Login Page</h2>
	<form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
	<p>
		User name: <input type="text" name="username"/>
	</p>
	
	<p>
		Password: <input type="password" name="password"/>
	</p>
	
	<p>
		<input type="submit" name="Login"/>
	</p>
	</form:form>
</body>
</html>