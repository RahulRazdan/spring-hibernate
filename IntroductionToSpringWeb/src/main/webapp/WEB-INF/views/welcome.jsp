<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:directive.page contentType="text/html;charset=UTF-8"/>
<head>
<title>Welcome</title>
</head>
<body>
<h2>Welcome to SPIZZA!</h2>
<form:form>
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<input type="text" name="phoneNumber"/>
	<br/>
	<input type="submit" name="_eventId_phoneEntered" value="LookUp Customer"/>
	</form:form>
</body>
</html>
