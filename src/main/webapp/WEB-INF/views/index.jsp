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
  	<div class="container">
	  	<div class="col-md-12 col-sm-12"> 
	  		<h3><spring:message code="index.populardestinations"/></h3>
	  		<c:forEach items="${cities}" var="city">
				<c:if test="${not empty city.uri}">
					<div class="col-sm-4 col-md-4">
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
	<!-- /Destinos más populares e imágenes -->
	<!-- Organiza tu viaje  -->
	<div class="container">
	
	
	<div class="panel panel-default">
  		<div class="panel-heading"><h3><spring:message code="index.planyourtrip"/></h3></div>
  		<div class="panel-body">		
			<form:form commandName="reservation" cssClass="form-horizontal">
				<div class="form-group">
					<label class="col-sm-1"><spring:message code="index.from"/></label>
					<form:select itemValue="name" itemLabel="name"  path="cityFrom" items="${cities}" cssClass="col-sm-2"/>
				
					<label class="col-sm-1"><spring:message code="index.to"/></label>
					<form:select itemValue="name" itemLabel="name"  path="cityTo" items="${cities}" cssClass="col-sm-2"/>
					<form:errors path="cityTo" cssClass="text-danger"/><br/>
				</div>
				<div class="form-group">
					<label class="col-sm-1"><spring:message code="index.departuredate"/></label>
					<spring:message code="index.dateformat" var="dateformat"/>
					<form:input path="departureDate" placeholder="${dateformat}" cssClass="col-sm-2"/>
					<div id=returnDate>
						<label class="col-sm-1"><spring:message code="index.returndate" /></label>
						<form:input path="returnDate" placeholder="${dateformat}" cssClass="col-sm-2"/>
					</div>
					<p><form:errors path="departureDate" cssClass="text-danger" /></p>
					<p><form:errors path="returnDate" cssClass="text-danger" /></p>
				</div>
				
				<spring:message code="index.onewaytrip"/>
				<form:checkbox id="oneWayTrip" path="oneWayTrip"/>
				
				<h4><spring:message code="index.passengers"/></h4>
				<div class="form-group">
					<label class="col-sm-1"><spring:message code="index.adult"/></label>
					<form:select path="numberAdults" items="${numbers}" cssClass="col-sm-1"/>
					<label class="col-sm-1"><spring:message code="index.youth"/></label>
					<form:select path="numberYouths" items="${numbers}" cssClass="col-sm-1"/>
					<label class="col-sm-1"><spring:message code="index.student"/></label>
					<form:select path="numberStudents" items="${numbers}" cssClass="col-sm-1"/>
				</div>
				<div class="form-group">
					<label class="col-sm-1"><spring:message code="index.senior"/></label>
					<form:select path="numberSeniors" items="${numbers}" cssClass="col-sm-1"/>
					<label class="col-sm-1"><spring:message code="index.disable"/></label>
					<form:select path="numberDisables" items="${numbers}" cssClass="col-sm-1"/>
					<label class="col-sm-1"><spring:message code="index.pet"/></label>
					<form:select path="numberPets" items="${numbers}" cssClass="col-sm-1"/>
					<form:errors path="numberPets" cssClass="text-danger" />
				</div>
				<input name="submit" type="submit" value="<spring:message code="index.search"/>" class="btn btn-default" />
			</form:form>
		</div>
		</div> <!-- /panel -->
		
		<!-- Historial de viajes de usuario -->
		<c:if test="${not empty reservations}">
			<h4><spring:message code="index.record"/></h4>
			<c:forEach items="${reservations}" var="reservation">
				<div>${reservation.cityFrom} - ${reservation.cityTo} <small>${reservation.departureDate}</small></div>
				<a href="reservationDetails/${reservation.code}"><spring:message code="index.moredetails"/></a>
			</c:forEach>
			<br><br>
		</c:if> 
		<p><spring:message code="index.hitcounter"/>${counter}</p>
	</div>
	<jsp:include page="footer.jsp"/>
	<script src="<c:url value="/resources/swebus/js/index.js" />"></script>
</body>
</html>