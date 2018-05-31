<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginPage</title>
</head>
<body onload="submitForm()">

<h1>Login</h1>

<div id="login-error" style="color: red;">${error}</div>

<form name="myForm" action="/spring/j_spring_security_check" method="post" >

<p>
	<label for="username">Username</label>
	<input id="username" name="username" value="${username}" type="text" />
</p>

<p>
	<label for="password">Password</label>
	<input id="password" name="password" value="${password}"  type="password" />
</p>
<p>
	<label for="remember-me">Remember Me</label>
	<input id="remember" name="remember-me" type="checkbox" />
</p>
<input type="hidden"
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
<input  type="submit" name="mySubmit" value="Login"/>								
<script>
function submitForm(){
	if(document.myForm.j_username.value!='')
		document.myForm.mySubmit.click();
}
</script>
</form>

</body>
</html>