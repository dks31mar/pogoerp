<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Technobridge Innovations</title>

	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/styles.css" />

</head>
<body>

<section class="container login-form">
		<section>
		<form method="post" action="login" role="login">
				<img src="resources/image/pogo_erp_logo.png" alt="" class="img-responsive" style="background-color: #3C8DBC" />
		<div class="form-group">
					<input type="text" name="username" required class="form-control" placeholder="Email address" id="username"/>
				</div>
		<div class="input-group">
					<input type="password" name="password" required class="form-control" placeholder="Password" id="password" />
					<span class="input-group-btn">
						<button class="btn btn-default" type="button" id="tooltip" data-toggle="tooltip" data-placement="top" title="Forgot password ?">?</button>
					</span>
				</div>
		
		<button type="submit" name="go" class="btn btn-primary btn-block"  style="background-color: #3C8DBC">Login Now</button>
		</form>
		
		
		</section>
		</section>

</body>
</html>