<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Custom Login Page</h2>
<c:if test="${param.error !=null }">
	<span style="color:red;">Sorry! incorrect credentials.</span>
</c:if>
	<form:form action="${pageContext.request.contextPath}/authenticateLogin" method="POST">
	
	<p>
		Username : <input type="text" name="username"/>
	</p>
	<p>
		Paasword : <input type="password" name="password"/>
	</p>
	<input type="submit" value="login"/>
	</form:form>
</body>
</html>