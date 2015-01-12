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

		<form:form method="POST" commandName="schedulesSelected">
			<div class="container">
				<h4>
					<spring:message code="showschedules.choose.departure" />
					<c:out value="${reservation.cityFrom} - ${reservation.cityTo}"></c:out>
					<c:out value="${reservation.departureDate}"></c:out>
				</h4>
				<table class="table table-hover">
					<tr>
						<td><b><spring:message code="showschedules.departure"/></b></td>
						<td><b><spring:message code="showschedules.arrival"/></b></td>
						<td><b><spring:message code="showschedules.traveltime"/></b></td>
						<td><b><spring:message code="showschedules.price"/></b></td>
						<td><b><spring:message code="showschedules.select"/></b></td>
					</tr>
					<c:forEach items="${schedulesDeparture}" var="schedule">
						<tr>
							<td><c:out value="${schedule.hourDeparture}"></c:out>:00</td>
							<td><c:out value="${schedule.hourArrival}"></c:out>:00</td>
							<td><c:out value="${schedule.hourArrival-schedule.hourDeparture}"></c:out> hr</td>
							<td><c:out value="${schedule.price}"></c:out>&#8364;</td>
							<td><form:radiobutton path="idDepartureSchedule" value="${schedule.id}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
	
			<c:if test="${not reservation.oneWayTrip}">
				<div class="container">
					<h4>
						<spring:message code="showschedules.choose.return" />
						<c:out value="${reservation.cityTo} - ${reservation.cityFrom}"></c:out>
						<c:out value="${reservation.returnDate}"></c:out>
					</h4>
					<table class="table table-hover">
						<tr>
							<td><b><spring:message code="showschedules.departure"/></b></td>
							<td><b><spring:message code="showschedules.arrival"/></b></td>
							<td><b><spring:message code="showschedules.traveltime"/></b></td>
							<td><b><spring:message code="showschedules.price"/></b></td>
							<td><b><spring:message code="showschedules.select"/></b></td>
						</tr>
						<c:forEach items="${schedulesReturn}" var="schedule">
							<tr>
								<td><c:out value="${schedule.hourDeparture}"></c:out>:00</td>
								<td><c:out value="${schedule.hourArrival}"></c:out>:00</td>
								<td><c:out value="${schedule.hourArrival-schedule.hourDeparture}"></c:out> hr</td>
								<td><c:out value="${schedule.price}"></c:out>&#8364;</td>
								<td><form:radiobutton path="idReturnSchedule" value="${schedule.id}"/></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>	
		<input name="submit" type="submit" value="<spring:message code="showschedules.goon"/>" class="btn btn-default"/>
		<button onclick="window.print()" class="btn btn-default"><spring:message code="showschedules.print"/></button>
		</form:form>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>