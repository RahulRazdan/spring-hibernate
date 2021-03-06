<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
	<head>
		<title>List Customers</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
	<body>
		
		<div id="wrapper">
			<div id="header">
				<h2> CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				<input type="button" value="Add Customer" class="add-button" onclick="window.location.href='showFormForAdd';return false;"/>
				<table>
					<tr>
						<th>
							First Name
						</th>
						<th>
							Last Name
						</th>
						<th>
							Email Name
						</th>
						<th>
							Action
						</th>
					</tr>
					<c:forEach var="tempCustomer" items="${customers}">
						<tr>
							<td>
								${tempCustomer.firstName}
							</td>
							<td>
								${tempCustomer.lastName}
							</td>
							<td>
								${tempCustomer.email}
							</td>
							<td>
								<c:url var="updateLink" value="/customer/showFormForUpdate">
									<c:param name="customerId">${tempCustomer.id}</c:param>
								</c:url>
								<c:url var="deleteLink" value="/customer/deleteCustomer">
									<c:param name="customerId">${tempCustomer.id}</c:param>
								</c:url>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}" onclick="if(!(confirm('sure you want to delete?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>