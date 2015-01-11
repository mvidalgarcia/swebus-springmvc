<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="<c:url value="/resources/swebus/js/jquery-1.11.2.min.js" />"></script>
<title><spring:message code="title.selectroute" /></title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<h3><spring:message code="showadditionals.title" /></h3>
		<form:form commandName="reservation">
			<p><spring:message code="showadditionals.extrabaggage" /> <form:checkbox path="extraBaggage"/>
			<p><spring:message code="showadditionals.priorityboarding" /> <form:checkbox path="priorityBoarding"/></p>
			<p><spring:message code="showadditionals.bike" /> <form:checkbox path="bike"/></p>
			<p><spring:message code="showadditionals.insurance" /> <form:checkbox path="insurance"/></p>
			<input name="submit" type="submit" value="<spring:message code="showadditionals.topayment"/>" />
		</form:form>
	</div>
</body>
</html>