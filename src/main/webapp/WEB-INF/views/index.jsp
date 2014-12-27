<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.index"/></title>
</head>
<body>
	<center>
		<a href="/Swebus"><h1><spring:message code="title"/></h1></a>
		<br>
		<h2><spring:message code="welcome"/></h2>
		<p><c:out value="${sessionUser}"></c:out></p>
	</center>
	<br/>
	<br/> <a href="signIn"><spring:message code="signin"/></a>
	
	<br/>
	<a href="signUp"><spring:message code="signup"/></a>

</body>
</html>