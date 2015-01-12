<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title><spring:message code="title.cancelation"/></title>
	</head>


<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<h3><spring:message code="cancelation.title"/></h3>
		<p><spring:message code="cancelation.introduce"/></p>
	
		<form:form commandName="cancelation" cssClass="form-horizontal">
			<form:errors path="" cssClass="text-danger" /><br>
			<div class="form-group">
				<label class="col-xs-3 col-sm-2 col-md-2 col-lg-1"><spring:message code="cancelation.code"/></label>
				<form:input path="code" cssClass="col-sm-2"/>
				<form:errors path="code" cssClass="text-danger"/>
			</div>
			<input name="submit" type="submit" value="<spring:message code="cancelation.submit"/>" class="btn btn-default" />
		</form:form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
