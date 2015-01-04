<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.payment"/></title>
	</head>


<body>
	<jsp:include page="header.jsp"/>
	<h3><spring:message code="payment.paymentmethod"/></h3>

	<form:form method="POST" commandName="payment">
		<p><spring:message code="payment.choose"/></p>
		
		<table>
  			<tr>
    			<td><form:radiobutton path="type" value="card" cssClass="radio-payment"/> <spring:message code="payment.method.card"/></td>
  				<td><form:radiobutton path="type" value="americanexpress" cssClass="radio-payment"/> <spring:message code="payment.method.americanexpress"/></td>
  			</tr>
  			<tr>
  				<td><form:radiobutton path="type" value="directbank" cssClass="radio-payment"/> <spring:message code="payment.method.directbank"/></td>
  				<td><form:radiobutton path="type" value="swebusaccount" cssClass="radio-payment" id="radio-swe-acc"/> <spring:message code="payment.method.swebusaccount"/></td>
  			</tr>
		</table>
		<br />
		<div class="well form-swe-account">
			<p><strong><spring:message code="payment.method.swebusaccount"/></strong></p>
			<spring:message code="payment.username"/>
			<form:input path="userName" />
			<form:errors path="userName" cssClass="text-danger" />
			<br>
			<spring:message code="payment.pincode"/>
			<form:input path="pinCode" />
			<form:errors path="pinCode" cssClass="text-danger" />
			<br>
		</div>
		<spring:message code="payment.cardnumber"/>
		<form:input path="cardNumber" />
		<form:errors path="cardNumber" cssClass="text-danger" />
		<br>
		<spring:message code="payment.email"/>
		<form:input path="email" />
		<form:errors path="email" cssClass="text-danger" />
		<br>
		<spring:message code="payment.mobile"/>
		<form:input path="mobile" />
		<br>
		<input name="submit" type="submit" value="<spring:message code="payment.submit"/>" />
	</form:form>
	<script src="<c:url value="/resources/swebus/js/payment.js" />"></script>
</body>
</html>
