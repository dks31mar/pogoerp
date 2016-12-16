<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.scheTit {
	border-right: 1px solid #000000;
	padding-right: 10px;
	padding-left: 5px;
	line-height: 40px;
	color: #5cd3ff;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 18px;
	font-weight: bold;
}

.scheCon {
	padding-left: 10px;
	padding-right: 10px;
	border-left: 1px solid #646464;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #ffffff;
}

.announce {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: bold;
	color: #000;
}

.survery_monkey {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: bold, underline;
	color: #fff;
}

.survery_monkey a {
	color: #fff;
}

.whatsnew {
	padding-left: 30px;
	padding-bottom: 4px;
	padding-right: 30px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #fff;
	text-decoration: none;
	font-weight: bold;
}

.menu-link {
	text-decoration: none;
	color: #FFFFFF;
	cursor: pointer;
	font-weight: 100;
}

.menu-link:hover {
	color: #FFFFFF;
	text-decoration: none;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		style="border-bottom: 1px solid #016E3B !important;">
		<tr>

			<td rowspan="2" class="logoLayer" id="logoTD" style="width: 222px">

				<IMG SRC="resources/image/pogo_erp_logo.png" HSPACE="4">

			</td>
		</tr>
		<tr>
			<td class="logoLayer" id="logoTD" style="width: 222px">
				<div align="right" style="white-space: nowrap; margin: 30px 10px;">
					<a href="#" target="_blank"
						style="border: 2px solid #a1a1a1; padding: 8px 10px; background: red; width: 100px; border-radius: 25px; margin-right: 20px; color: black;"
						title="New Call Added"><i></i></a> <a href="homepage"
						style="font-size: 30px; margin-right: 10px;"><IMG
						SRC="resources/image/blue-home-icon.png" HSPACE="4"> </i></a> <a
						href="logout" onclick="setLogoutParam()" style="font-size: 30px"><IMG
						SRC="resources/image/logout.png" HSPACE="4"></i></a>
				</div>
			</td>
		</tr>

	</table>
</body>
</html>