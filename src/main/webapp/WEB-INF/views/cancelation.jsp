<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.cancelation"/></title>
	</head>


<body>
	<jsp:include page="header.jsp"/>
	<h3><spring:message code="cancelation.title"/></h3>
	<p><spring:message code="cancelation.introduce"/></p>

	<form:form commandName="cancelation">
		<form:errors path="" cssClass="text-danger" /><br>
		<spring:message code="cancelation.code"/>
		<form:input path="code" />
		<form:errors path="code" cssClass="text-danger"/>
		<br />
		<input name="submit" type="submit" value="<spring:message code="cancelation.submit"/>" />
	</form:form>
</body>
</html>
