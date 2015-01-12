<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.signup"/></title>
	</head>


<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<h3><spring:message code="signup.title"/></h3>
		<p><spring:message code="signup.introduce"/></p>
	
		<form:form commandName="user" cssClass="form-horizontal">
			<form:errors path="" cssClass="text-danger" />
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.firstname"/></label>
				<form:input path="firstName" cssClass="col-sm-2"  />
				<form:errors path="firstName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.lastname"/></label>
				<form:input path="lastName" cssClass="col-sm-2" />
				<form:errors path="lastName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.email"/></label>
				<form:input path="email" cssClass="col-sm-2" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
				
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.phone"/></label>
				<form:input path="phone" cssClass="col-sm-2" />
				<form:errors path="phone" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.gender"/></label>
				<form:select path="gender" cssClass="col-sm-2">
					<spring:message code="signup.gender.male" var="male"/>
					<spring:message code="signup.gender.female" var="female"/>
					<form:option value="male" label="${male}"/>
					<form:option value="female" label="${female}"/>
				</form:select>
				<form:errors path="gender" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.address"/></label>
				<form:input path="address" cssClass="col-sm-2"/>
				<form:errors path="address" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.zipcode"/></label>
				<form:input path="zipCode" cssClass="col-sm-2"/>
				<form:errors path="zipCode" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.city"/></label>
				<form:input path="city" cssClass="col-sm-2" />
				<form:errors path="city" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.county"/></label>
				<form:input path="county" cssClass="col-sm-2"/>
				<form:errors path="county" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.idcard"/></label>
				<form:input path="idCard" cssClass="col-sm-2"/>
				<form:errors path="idCard" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<label class="col-sm-1"><spring:message code="signup.password"/></label>
				<form:password path="password" cssClass="col-sm-2"/>
				<form:errors path="password" cssClass="text-danger" />
			</div>
			<input name="submit" type="submit" value="<spring:message code="signup.submit"/>" class="btn btn-default" />
		</form:form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
