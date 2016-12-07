<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>
<div class="container-fluid">
<tiles:insertAttribute name="header" />
</div>
<div class="container-fluid" style="background-color: #E6E6E6;">
				<tiles:insertAttribute name="body" />
</div>

<br>
<div style="background-color: #E6E6E6;">
<tiles:insertAttribute name="footer" />
</div>

</body>
</html>
