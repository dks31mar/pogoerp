<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

.responstable {
	margin: 1em 0;
	width: 100%;
	overflow: hidden;
	background: #FFF;
	color: #024457;
	border-radius: 10px;
	border: 1px solid #167F92;
}

.responstable tr {
	border: 1px solid #D9E4E6;
}

.responstable tr:nth-child(odd) {
	background-color: #EAF3F3;
}

.responstable th {
	display: none;
	border: 1px solid #FFF;
	background-color: #167F92;
	color: #FFF;
	padding: 1em;
}

.responstable th:first-child {
	display: table-cell;
	text-align: center;
}

.responstable th:nth-child(2) {
	display: table-cell;
}

.responstable th:nth-child(2) span {
	display: none;
}

.responstable th:nth-child(2):after {
	content: attr(data-th);
}

@media ( min-width : 480px) {
	.responstable th:nth-child(2) span {
		display: block;
	}
	.responstable th:nth-child(2):after {
		display: none;
	}
}

.responstable td {
	display: block;
	word-wrap: break-word;
	max-width: 7em;
}

.responstable td:first-child {
	display: table-cell;
	text-align: center;
	border-right: 1px solid #D9E4E6;
}

@media ( min-width : 480px) {
	.responstable td {
		border: 1px solid #D9E4E6;
	}
}

.responstable th, .responstable td {
	text-align: left;
	margin: .5em 1em;
}

@media ( min-width : 480px) {
	.responstable th, .responstable td {
		display: table-cell;
		padding: 1em;
	}
}

body {
	padding: 0 2em;
	font-family: Arial, sans-serif;
	color: #024457;
	background: #f2f2f2;
}

#aboutorg {
	max-width: 900px;
	margin: 5px 0px;
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-box-flex: 1;
}

#aboutorgn {
	background: #66CCCC;
	bolder: 0px solid block;
	padding: 0px;
}

h4 {
	color: #ff6666;
	margin-right: 5px;
}

h2 {
	color: #00e6e6;
	margin-right: 5px;
}

h1 {
	font-family: Verdana;
	font-weight: normal;
	color: #024457;
}

h1 span {
	color: #167F92;
}
</style>
</head>
<body>



	<link
		href="/pogoerpdemo/Resources/bootstrap-3.3.6/css/bootstrap.min.css"
		rel="stylesheet" type="text/css" />
	<script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/jquery.min.js"></script>
	<script
		src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
		href="/pogoerpdemo/Resources/font-awesome-4.6.3/css/font-awesome.min.css">

		
	</script>
</HEAD>

<BODY LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0"
	BGCOLOR="#FFFFFF" onClick="calcHeight2()";>

	<div id="aboutorg">
		<div style="background-color: #167F92; text-align: center;">

			<header id="">
			<h2>
				<span class="glyphicon glyphicon-oil"></span>About Organization
			</h2>

			<!--glyphicon glyphicon-subtitles  --> <a href="#"><span><h4>
						<div style="text-align: right;">Terms and Conditions
					</h4></span></a> </header>
		</div>
		<form:form action="" >
		<table class="responstable">
			<tr>
				<td><div class="row form-group">
						<div class="col-sm-3 form-level">
							Name<font color="#FF0000">*</font>
						</div>
						<div class="col-sm-8">
							<form:input path="companyinfoname" type="text" class="form-control" style="margin-left: 8px; width: 268px;" />
						</div></td>
				<td></div>
					<div class="col-sm-4 form-level">
						Contact Person<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-8	">
						<form:input path="companyinfocontactperson" type="text" class="form-control" />
					</div></td>
			</tr>
			<tr>
				<td>
					</div>
					<div class="col-sm-4 form-level"
						style="text-align: left; margin-left: 0px;">
						Contact No<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-8">
						<form:input path="companyinfocontactno" type="text" class="form-control"
							style="margin-left: -32px; width: 268px;"/>

					</div>
				</td>
				<td></div>

					<div class="col-sm-4 form-level" style="text-align: left;">
						Telephone No<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-8">
						<form:input path="companyinfophone" type="text" class="form-control"/>

					</div></td>

			</tr>
			</tr>

			<tr>

				<td><div class="row form-group">

						<div class="col-sm-3 form-level">
							Fax No <font color="#FF0000">*</font>
						</div>
						<div class="col-sm-8">
							<form:input path="companyinfofax" type="text" class="form-control"  style="margin-left: 8px; width: 272px;" />
						</div></td>
				<td><div class="col-sm-4 form-level">
						Email<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-8">
						<form:input path="companyinfoemail" type="text" class="form-control" /></td>
			</tr>
			
			
			<tr>

				<td><div class="row form-group">

						<div class="col-sm-3 form-level">
							VAT TIN <font color="#FF0000">*</font>
						</div>
						<div class="col-sm-8">
							<form:input path="companyinfovattin" type="text" class="form-control"  style="margin-left: 8px; width: 272px;" />
						</div></td>
				<td><div class="col-sm-4 form-level">
						CST NO<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-8">
						<form:input path="companyinfocstno" type="text" class="form-control" /></td>
			</tr>
			
			
			<tr>

				<td><div class="row form-group">

						<div class="col-sm-2 form-level">
							PAN<font color="#FF0000">*</font>
						</div>
						<div class="col-sm-8">
							<form:input path="companyinfopan" type="text" class="form-control" style="margin-left: 45px; width: 270px;" />
						</div></td>
				<td><div class="col-sm-4 form-level">
						Service Tax Registration No<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-8">
						<form:input path="companyinfoservicetaxno" type="text" class="form-control" /></td>
			</tr>
			
			
			</tr>

			<td><div class="row form-group" style="margin-left: -28px;">
					<div class="col-sm-4 form-level">
						Web Address<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-8">
						<form:input path="companyinfoweb" type="text" class="form-control" style="margin-left: -20px; width: 268px;" />

					</div></td>
			<td><div class="col-sm-4 form-level">
					HO Address <font color="#FF0000">*</font>
				</div>
				<div class="col-sm-8">
					<textarea class="form-control"></textarea>
					<div class="row form-group"></div>
					<div class="row form-group">
					</div>
					</div>
					</td>
					
		</TABLE>
		</form:form>
		<div class="row form-group">
			<div class="col-sm-2 form-level"></div>
			<div class="col-sm-4"></div>
			<div class="col-sm-2 form-level"></div>
			<div class="col-sm-4">
				<input type="button" value="Update"
					class="btn btn-success pull-right" />
			</div>
		</div>
</body>
</html>