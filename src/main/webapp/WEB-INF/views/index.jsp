<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.index"/></title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<br/> <a href="signIn"><spring:message code="signin"/></a>
	
	<br/>
	<a href="signUp"><spring:message code="signup"/></a>
	<br/>
	<h3><spring:message code="index.planyourtrip"/></h3>
	<form:form commandName="reservation">
		<spring:message code="index.from"/>
		<form:select itemValue="name" itemLabel="name"  path="cityFrom" items="${cities}"/>
		<spring:message code="index.to"/>
		<form:select itemValue="name" itemLabel="name"  path="cityTo" items="${cities}"/>
		<form:errors path="cityTo" cssClass="text-danger"/><br/>
		
		<spring:message code="index.departuredate"/>
		<spring:message code="index.dateformat" var="dateformat"/>
		<form:input path="departureDate" placeholder="${dateformat}"/>
		<form:errors path="departureDate" cssClass="text-danger" />
		<div id=returnDate>
			<spring:message code="index.returndate" />
			<form:input path="returnDate" placeholder="${dateformat}"/>
			<form:errors path="returnDate" cssClass="text-danger" />
		</div>
		<br/>
		<spring:message code="index.onewaytrip"/>
		<form:checkbox id="oneWayTrip" path="oneWayTrip"/>
		<br/>
		<h4><spring:message code="index.passengers"/></h4>
		<spring:message code="index.adult"/>
		<form:select path="numberAdults" items="${numbers}"/>
		<spring:message code="index.youth"/>
		<form:select path="numberYouths" items="${numbers}"/>
		<spring:message code="index.student"/>
		<form:select path="numberStudents" items="${numbers}"/>
		<br/>
		<spring:message code="index.senior"/>
		<form:select path="numberSeniors" items="${numbers}"/>
		<spring:message code="index.disable"/>
		<form:select path="numberDisables" items="${numbers}"/>
		<spring:message code="index.pet"/>
		<form:select path="numberPets" items="${numbers}"/>
		<form:errors path="numberPets" cssClass="text-danger" />
		<br/>
		<input name="submit" type="submit" value="<spring:message code="index.search"/>" />
	</form:form>
	<script src="<c:url value="/resources/swebus/js/index.js" />"></script>

</body>
</html>