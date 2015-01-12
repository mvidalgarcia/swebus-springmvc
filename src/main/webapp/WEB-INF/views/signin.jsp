<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.signin"/></title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="container">
			<h3><spring:message code="signin.title"/></h3>
			<p><spring:message code="signin.introduce"/></p>
			<form:form commandName="user" cssClass="form-horizontal">
				<form:errors path="" cssClass="text-danger" />
				<div class="form-group">
					<label class="col-sm-1"><spring:message code="signin.email"/></label>
					<form:input path="email" placeholder="email@domain.com" cssClass="col-sm-2" />
					<form:errors path="email" cssClass="text-danger"/>
				</div>
				<div class="form-group">
					<label class="col-sm-1"><spring:message code="signin.password"/></label>
					<form:password path="password" placeholder="*****" cssClass="col-sm-2"/>
					<form:errors path="password" cssClass="text-danger" />
				</div>
				<input name="submit" type="submit" value="<spring:message code="signin.submit"/>" class="btn btn-default" />
			</form:form>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>
