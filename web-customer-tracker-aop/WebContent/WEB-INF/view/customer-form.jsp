<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<!DOCTYPE html>
<html>
	<head>
		<title>Save Customer</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
	</head>
	<body>
		
		<div id="wrapper">
			<div id="header">
				<h2> CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
		<h3>Save Customer</h3>
			<div id="content">
				
				<form:form action="saveCustomer"  modelAttribute="customer" method="POST">
				<form:hidden path="id"/>
				<table>
						<tr>
							<td>
								<form:label path="firstName">First Name</form:label>
							</td>
							<td>
								<form:input path="firstName"/>
							</td>
						</tr>
						<tr>
							<td>
								<form:label path="lastName">Last Name</form:label>
							</td>
							<td>
								<form:input path="lastName"/>
							</td>
						</tr>
						<tr>
							<td>
								<form:label path="email">Email</form:label>
							</td>
							<td>
								<form:input path="email"/>
							</td>
						</tr>
						<tr>
							<td>
							</td>
							<td>
								<input type="submit" class="save" value="save"/>
							</td>
						</tr>
				</table>
				</form:form>
				<div style="clear;both;"></div>
				<p>
					<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
				</p>
			</div>
		</div>
	</body>
</html>