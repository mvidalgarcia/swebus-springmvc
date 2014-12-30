<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value="/resources/swebus/js/jquery-1.11.2.min.js" />"></script>
<link href="<c:url value="/resources/swebus/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/swebus/js/bootstrap.min.js" />"></script>

<center>
	<h1><a href="/Swebus"><spring:message code="title"/></a></h1>
	<br>
	<h2><spring:message code="welcome"/></h2>
	<p><c:out value="${sessionUser}"></c:out></p>
</center>
	<br/>