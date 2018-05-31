<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello <security:authentication property="principal.username" />! <a href="<c:url value="/logout" />">Logout</a>
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  Player Type is ${PlayerType}. </P>
<P>  Music Type is ${MusicType}. </P>
<P>  Music Type is ${testSPL}. </P>
</body>
</html>
