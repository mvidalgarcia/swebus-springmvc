<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.signup"/></title>
	</head>


<body>
	<center>
		<a href="/Swebus"><h1><spring:message code="title"/></h1></a>
		<br>
		<h2><spring:message code="welcome"/></h2>
	</center>
	<br> 
	<h3><spring:message code="signup.title"/></h3>
	<p><spring:message code="signup.introduce"/></p>

	<form:form commandName="user">
		<form:errors path="" />
		<br />
		<spring:message code="signup.firstname"/>
		<form:input path="firstName" />
		<form:errors path="firstName" />
		
		<br />
		<spring:message code="signup.lastname"/>
		<form:input path="lastName" />
		<form:errors path="lastName" />
		
		<br />
		<spring:message code="signup.email"/>
		<form:input path="email" />
		<form:errors path="email" />
		
		<br />
		<spring:message code="signup.phone"/>
		<form:input path="phone" />
		<form:errors path="phone" />
		
		<br />
		<spring:message code="signup.gender"/>
		<form:select path="gender">
			<spring:message code="signup.gender.male" var="male"/>
			<spring:message code="signup.gender.female" var="female"/>
			<form:option value="male" label="${male}"/>
			<form:option value="female" label="${female}"/>
		</form:select>
		<form:errors path="gender" />
		
		<br />
		<spring:message code="signup.address"/>
		<form:input path="address" />
		<form:errors path="address" />
		
		<br />
		<spring:message code="signup.zipcode"/>
		<form:input path="zipCode" />
		<form:errors path="zipCode" />
		
		<br />
		<spring:message code="signup.city"/>
		<form:input path="city" />
		<form:errors path="city" />
		
		<br />
		<spring:message code="signup.county"/>
		<form:input path="county" />
		<form:errors path="county" />
		
		<br />
		<spring:message code="signup.idcard"/>
		<form:input path="idCard" />
		<form:errors path="idCard" />
		
		<br />
		<spring:message code="signup.password"/>
		<form:password path="password" />
		<form:errors path="password" />
		
		<br />
		<input name="submit" type="submit" value="<spring:message code="signup.submit"/>" />
		<input name="reset" type="reset" value="<spring:message code="signup.reset"/>"/>
	</form:form>

</body>
</html>
