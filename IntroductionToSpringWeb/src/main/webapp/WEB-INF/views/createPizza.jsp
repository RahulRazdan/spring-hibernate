<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
<title>Create Pizza</title>
</head>
<body>
<h2>Create Pizza</h2>
<f:form modelAttribute="pizza">
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<b>Size:</b>
	<f:radiobutton path="size" label="small" value="SMALL"/>
	<f:radiobutton path="size" label="medium" value="MEDIUM"/>
	<f:radiobutton path="size" label="large" value="LARGE"/>
	<br/>
	<br/>
	<b>Toppings:</b>
	<f:checkboxes path="topping" items="${toppingsList}" delimeter="&lt;br/&gt;"/>
	<br/>
	<br/>
	<input type="submit" name="_eventId_addPizza" value="Continue"/>
	<input type="submit" name="_eventId_cancel" value="Cancel"/>
</f:form>
</body>
</html>
