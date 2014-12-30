<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value="/resources/swebus/js/jquery-1.11.2.min.js" />"></script>
<title><spring:message code="title.selectroute"/></title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h3><spring:message code="showroutes.departure"/></h3>
	<h3><spring:message code="showroutes.return"/></h3>
	
</body>
</html>