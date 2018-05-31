<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<title>Take Payment</title>
</head>
<body>
<h2>Take Payment</h2>
<f:form modelAttribute="paymentDetails">
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<b>Payment Mode:</b>
	<f:checkboxes path="paymentType" items="${paymentTypeList}" delimeter="&lt;br/&gt;"/>
	<br/>
	<br/>
	<input type="submit" name="_eventId_paymentSubmitted" value="Pay"/>
	<input type="submit" name="_eventId_cancel" value="Cancel"/>
</f:form>
</body>
</html>
