<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value="/resources/swebus/js/jquery-1.11.2.min.js" />"></script>
<link href="<c:url value="/resources/swebus/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/swebus/js/bootstrap.min.js" />"></script>
<link href="<c:url value="/resources/swebus/css/mystyle.css" />" rel="stylesheet">
	<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#mynavbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/Swebus"><spring:message code="header.title"/></a>
          <p class="navbar-text welcome-text"><spring:message code="header.welcome"/></p>
        </div>
        
        <div class="collapse navbar-collapse" id="mynavbar">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/Swebus/signIn"><spring:message code="signin"/></a></li>
            <li><a href="/Swebus/signUp"><spring:message code="signup"/></a></li>
            <li><a href="/Swebus/cancelation"><spring:message code="cancel.reservation"/></a></li>
            <c:if test="${not empty sessionUser}">
           	 <li><p class="navbar-text"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
           	  <strong><c:out value="${sessionUser}"></c:out></strong></p></li>
           	  <li><a href="/Swebus/logOut"><strong><span class="glyphicon glyphicon-off" aria-hidden="true"></span></strong></a></li>
            </c:if>
          </ul>
          </div>
      </div>
    </nav>
    <br><br><br><br><br><br>