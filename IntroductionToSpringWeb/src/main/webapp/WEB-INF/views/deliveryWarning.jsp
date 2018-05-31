<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<title>Check Delivery</title>
</head>
<body>
<h2>Delivery Unavailable!</h2>
<![CDATA[
	<a href='${flowExecutionUrl}&_eventId=accept'>Continue</a>
	<a href='${flowExecutionUrl}&_eventId=cancel'>Leave</a>
	]]>
</body>
</html>
