<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<title>Order Complete</title>
</head>
<body>
<h2>Thank you customer for your order!</h2>
	<![CDATA[
	<a href='${flowExecutionUrl}&_eventId=finished'>Finish</a>
	]]>
</body>
</html>
