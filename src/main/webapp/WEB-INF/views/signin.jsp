<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.signin"/></title>
	</head>


<body onload='document.loginForm.email.focus();'>
	<center>
		<h1><spring:message code="title"/></h1>
		<br>
		<h2><spring:message code="welcome"/></h2>
	</center>
	<br>
	<h3><spring:message code="signin.title"/></h3>
	<p><spring:message code="signin.introduce"/></p>

	<form name='loginForm' method='POST'>
		<table>
			<tr>
				<td><spring:message code="signin.email"/></td>
				<td><input type='text' name='email' value=''></td>
			</tr>
			<tr>
				<td><spring:message code="signin.password"/></td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="<spring:message code="signin.submit"/>" /></td>
				<td><input name="reset" type="reset" value="<spring:message code="signin.reset"/>"/></td>
			</tr>
		</table>

	</form>
</body>
</html>
