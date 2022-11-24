<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login Page</title>

    <style type="text/css">
        .failed {
            color: red;
        }
    </style>
</head>

<body>
<h2>Login Page</h2>
<form:form action="${pageContext.request.contextPath}/authenticate"
           method="POST">
    <c:if test="${param.error != null}">
        <p class="failed">Entered invalid username/password</p>
    </c:if>
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