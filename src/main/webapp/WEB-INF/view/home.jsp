<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Home Page</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr />
	Welcome to the home page
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input value="Logout" type="submit"/>
	</form:form>
</body>
</html>