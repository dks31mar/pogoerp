<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isErrorPage="true"%>
<spring:url value="/style" var="styleurl" />
<html>
<head>
<title>Show Error Page</title>
<spring:url value="/style" var="styleurl" />
<script type="text/javascript" src="${styleurl}/js/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="${styleurl}/newhome/js/jquery.min.js"></script>
<script type="text/javascript">
	if ('${pageContext.errorData.statusCode}' == 405) {
		window.history.back();
	}
</script>
</head>
<body>
	<center>

		<%--  <img style="width: 456px; height: 315px; margin-top: 78px;"
			alt="errorimage" src="${styleurl}/error_page.jpg"/> --%>
			 <img style="width: 456px; height: 315px; margin-top: 78px;"
			alt="errorimage" src="resources/image/errorpage.jpg"/>  

	</center>
	<div
		style="height: 150px; width: 700px; overflow: hidden; margin-left: 350px; text-align: center;">
		 <a href="javascript:history.back();"> <img alt=""
			src="resources/image/click-go-back-button.png" style="margin-left: -70px; width: 258px; height: 89px;"></a>
	</div>
</body>
</html>