<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>Spring Security</title>
</head>

<body>
	<h3>Hello! <security:authentication property="principal.username"/> </h3> 
	<br/>
	Role : <security:authentication property="principal.authorities"/>
	
	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leader Page</a>
	</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/system">System Page</a>
	</p>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout" 
							   method="POST" class="form-horizontal">
							   <input type="submit" value="logout"/>
	</form:form>
</body>
</html>