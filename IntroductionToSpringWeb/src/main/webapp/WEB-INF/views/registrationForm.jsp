<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<jsp:directive.page contentType="text/html;charset=UTF-8"/>
<head>
<title>Sign Up</title>
</head>
<body>
<h2>Customer Registration</h2>
<f:form modelAttribute="customer">
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<b>Phone Number:</b><f:input path="phoneNumber"/><br/>
	<b>Name:</b><f:input path="name"/><br/>
	<b>Address:</b><f:input path="address"/><br/>
	<b>City:</b><f:input path="city"/><br/>
	<b>State:</b><f:input path="state"/><br/>
	<b>Zip Code:</b><f:input path="zipCode"/><br/>
	<input type="submit" name="_eventId_submit" value="Submit"/>
	<input type="submit" name="_eventId_cancel" value="Cancel"/>
</f:form>
</body>
</html>
