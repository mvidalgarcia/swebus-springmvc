<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.signin"/></title>
	</head>


<body>
	<jsp:include page="header.jsp"/>
	<h3><spring:message code="signin.title"/></h3>
	<p><spring:message code="signin.introduce"/></p>

	<form:form commandName="user">
		<form:errors path="" cssClass="text-danger" />
		<br />
		<spring:message code="signin.email"/>
		<form:input path="email" />
		<form:errors path="email" cssClass="text-danger"/>
		
		<br />
		<spring:message code="signin.password"/>
		<form:password path="password" />
		<form:errors path="password" cssClass="text-danger" />
		
		<br />
		<input name="submit" type="submit" value="<spring:message code="signin.submit"/>" />
		<input name="reset" type="reset" value="<spring:message code="signin.reset"/>"/>
	</form:form>
</body>
</html>
