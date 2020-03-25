<%@include file="bootstrap.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/registrationform.js"/>"></script>

<link rel="stylesheet"
	href="https://fonts.google.com/?selection.family=Karla|Merriweather|Noto+Serif" />
<link rel="stylesheet"
	href="<c:url value="/resources/styles/main-style.css"/>">


<c:set var='contextPath' value="${pageContext.request.contextPath}"></c:set>