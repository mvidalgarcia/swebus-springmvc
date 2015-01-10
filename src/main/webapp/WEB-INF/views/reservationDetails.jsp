<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.reservation"/></title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h3><spring:message code="reservation.reservationdata"/> <small><spring:message code="reservation.code"/>${reservation.code}</small></h3>
		<spring:message code="reservation.departuretrip"/> ${reservation.departureDate}
		<div>${reservation.cityFrom} - ${reservation.cityTo}</div>
		<spring:message code="reservation.departuretime"/>${reservation.departureTime.hourDeparture}
		<spring:message code="reservation.returntime"/>${reservation.departureTime.hourArrival}
		<br>
		<c:if test="${not reservation.oneWayTrip}">
			<br>
			<spring:message code="reservation.returntrip"/> ${reservation.returnDate}
			<div>${reservation.cityTo} - ${reservation.cityFrom}</div>
			<spring:message code="reservation.departuretime"/>${reservation.returnTime.hourDeparture}
			<spring:message code="reservation.returntime"/>${reservation.returnTime.hourArrival}
			<br>
		</c:if>
		<!-- Passengers  -->
		<c:if test="${reservation.numberAdults > 0}">
			<br>
			${reservation.numberAdults} <spring:message code="reservation.adults"/>
		</c:if>
		<c:if test="${reservation.numberYouths > 0}">
			<br>
			${reservation.numberYouths} <spring:message code="reservation.youths"/>
		</c:if>
		<c:if test="${reservation.numberStudents > 0}">
			<br>
			${reservation.numberStudents} <spring:message code="reservation.students"/>
		</c:if>
		<c:if test="${reservation.numberSeniors > 0}">
			<br>
			${reservation.numberSeniors} <spring:message code="reservation.seniors"/>
		</c:if>
		<c:if test="${reservation.numberDisables > 0}">
			<br>
			${reservation.numberDisables} <spring:message code="reservation.disables"/>
		</c:if>
		<c:if test="${reservation.numberPets > 0}">
			<br>
			${reservation.numberPets} <spring:message code="reservation.pets"/>
		</c:if>
		<!-- Additionals  -->
		<c:if test="${reservation.extraBaggage}">
			<br>
			<spring:message code="reservation.extrabaggage"/>
		</c:if>
		<c:if test="${reservation.priorityBoarding}">
			<br>
			<spring:message code="reservation.priorityboarding"/>
		</c:if>
		<c:if test="${reservation.bike}">
			<br>
			<spring:message code="reservation.bike"/>
		</c:if>
		<c:if test="${reservation.insurance}">
			<br>
			<spring:message code="reservation.insurance"/>
		</c:if>
		
		
		<br><br>
		<spring:message code="reservation.total"/>${reservation.price}&#8364;
		<br>
		<button onclick="window.print()"><spring:message code="reservation.print"/></button>
	
		
	</body>
</html>
