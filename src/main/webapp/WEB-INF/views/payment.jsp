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
	<div class="container">	
		<h3><spring:message code="payment.paymentmethod"/></h3>
	
		<form:form method="POST" commandName="payment" cssClass="form-horizontal">
			<p><spring:message code="payment.choose"/></p>
			<div class="container">
	    		<div class="form-group">
		    		<div class="col-sm-2"><form:radiobutton path="type" value="card" cssClass="radio-payment"/> <spring:message code="payment.method.card"/></div>
		  			<div class="col-sm-2"><form:radiobutton path="type" value="americanexpress" cssClass="radio-payment"/> <spring:message code="payment.method.americanexpress"/></div>
	  			</div>
	  			<div class="form-group">
		  			<div class="col-sm-2"><form:radiobutton path="type" value="directbank" cssClass="radio-payment"/> <spring:message code="payment.method.directbank"/></div>
		  			<div class="col-sm-2"><form:radiobutton path="type" value="swebusaccount" cssClass="radio-payment" id="radio-swe-acc"/> <spring:message code="payment.method.swebusaccount"/></div>
	  			</div>
			</div>
			<div class="container">
				<div class="col-md-5 well form-swe-account">
					<h4><spring:message code="payment.method.swebusaccount"/></h4>
					<div class="form-group">
						<label class="col-sm-3"><spring:message code="payment.username"/></label>
						<form:input path="userName" cssClass="col-sm-4"/>
						<form:errors path="userName" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label class="col-sm-3"><spring:message code="payment.pincode"/></label>
						<form:input path="pinCode" cssClass="col-sm-4"/>
						<form:errors path="pinCode" cssClass="text-danger" />
					</div>
				</div>
			</div>
			<div class="container col-md-5">
				<div class="form-group">
					<label class="col-sm-4"><spring:message code="payment.cardnumber"/></label>
					<form:input path="cardNumber" cssClass="col-sm-5"/>
					<form:errors path="cardNumber" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<label class="col-sm-4"><spring:message code="payment.email"/></label>
					<form:input path="email" cssClass="col-sm-5"/>
					<form:errors path="email" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<label class="col-sm-4"><spring:message code="payment.mobile"/></label>
					<form:input path="mobile" cssClass="col-sm-5"/>
				</div>
				<div class="form-group">	
					<div class="alert alert-success col-sm-6"><spring:message code="payment.totalprice"/><strong>${totalprice}&#8364;</strong></div>
				</div>
					<input name="submit" type="submit" value="<spring:message code="payment.submit"/>" class="btn btn-default"/>
			</div>
		</form:form>
	</div>
	<jsp:include page="footer.jsp"/>
	<script src="<c:url value="/resources/swebus/js/payment.js" />"></script>
</body>
</html>
