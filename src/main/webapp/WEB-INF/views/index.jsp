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
	<!-- Destinos más populares e imágenes -->
  	<div class="row">
	  	<div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2"> 
	  		<h3><spring:message code="index.populardestinations"/></h3>
	  		<c:forEach items="${cities}" var="city">
				<c:if test="${not empty city.uri}">
					<div class="col-sm-3 col-md-3">
						<div class="thumbnail">
							<img src="<c:url value="${city.uri}"/>" alt="${city.name} photo">
							<div class="caption">
								<h4>${city.name}</h4>
							</div>
						</div>
					</div>
				</c:if>
	  		</c:forEach>
	  	</div>
	</div>
	<!--/ Destinos más populares e imágenes -->
	<div class="row">
	  	<div class="col-md-8 col-md-offset-2">
			<br/> <a href="signIn"><spring:message code="signin"/></a>
			<br/>
			<a href="signUp"><spring:message code="signup"/></a>
			<br/>
			<a href="cancelation"><spring:message code="cancel.reservation"/></a>
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
			<!-- Historial de viajes de usuario -->
			<c:if test="${not empty reservations}">
				<hr>
				<h4><spring:message code="index.record"/></h4>
				<c:forEach items="${reservations}" var="reservation">
					<div>${reservation.cityFrom} - ${reservation.cityTo} <small>${reservation.departureDate}</small></div>
					<a href="reservationDetails/${reservation.code}"><spring:message code="index.moredetails"/></a>
				</c:forEach>
				<br><br>
			</c:if> 
			<spring:message code="index.hitcounter"/>${counter}
		</div>
	</div>
	<script src="<c:url value="/resources/swebus/js/index.js" />"></script>

</body>
</html>