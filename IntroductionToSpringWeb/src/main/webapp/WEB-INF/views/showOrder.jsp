<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:directive.page contentType="text/html;charset=UTF-8"/>
<head>
<title>Create Pizza</title>
</head>
<body>
<h2>Create Pizza</h2>
<f:form>
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<input type="submit" name="_eventId_createPizza" value="Create Pizza"/>
	<input type="submit" name="_eventId_checkout" value="Check Out"/>
	<input type="submit" name="_eventId_cancel" value="Cancel"/>
</f:form>
</body>
</html>
