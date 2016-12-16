<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/" var="baseurl"></spring:url>
<spring:url value="resources" var="js_url" />
<link
	href="/pogoerpdemo/Resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="/pogoerpdemo/Resources/font-awesome-4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/table.css">
<link rel="stylesheet" type="text/css"
	href="${js_url}/css/jquery.dialogbox.css">
<script src="${js_url}/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${js_url}/js/jquery.dialogBox.js" type="text/javascript"
	charset="utf-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

</CENTER>
<div id="pop" style="display: none;"></div>
<div></div>
<div id="body">

	<div>
		<div>
			<div class="row" style="margin-top: 15px">
				<br>
				<div align="center">
					<i> </i> <input type="hidden" name="profile" value="0" />
				</div>
			</div>

			<div class="row" background-color="white">

				<div class="page-heading col-sm-11"
					style="background-color: #3C8DBD; color: white; left: 20px; height: 64px;">
					<span class="glyphicon glyphicon-user"></span> Salescalls Products</b>
					<label style="margin-left: 250px; margin-top: 8px;"><a
						href="" class="btn btn-primary">Create New</a> </label>

				</div>
				<table width="100%" style="margin-left: 25px" border="0"
					cellspacing="1" cellpadding="0">
					<tbody>
						<form style="color: white">
							<tr>
								<td width="100%" align="left" colspan="9"><img src=""
									hspace="100"></td>
							</tr>

							<tr>
								<td align="left" width="60%"><b>Organization:</b>
									Technobridge Innovations</td>
								<td align="left" width="40%"><b>Qtn No.: </b>0003/16-17</td>
							</tr>
							<tr>
								<td align="left" width="60%"><b>Address:</b> Noida, Sector
									– 62, UP</td>
								<td width="40%"><b>Date: </b>21/11/2016</td>
							</tr>
							<tr>
								<td align="left"><b>Phone:</b> +91 110 2318001&nbsp;&nbsp;
									<b>Fax:</b>+91 129 2254165</td>
							</tr>
							<tr>
								<td><b>Email:</b>&nbsp;&nbsp;admin@gmail.com&nbsp;&nbsp; <b>Web
										Site:</b></td>
							</tr>

							<tr>
								<td>&nbsp;</td>
							</tr>





							<tr>
								<td style="white-space: nowrap; width: 50px"><select
									name="combo" style="width: 50px;">
										<option value="Mr.">Mr.</option>
										<option value="Ms.">Ms.</option>
										<option value="Mrs.">Mrs.</option>
										<option value="Dr.">Dr.</option>
										<!--end Neera on 02-may-2011-->
								</select> <input type="hidden" name="designation" value=""> <input
									type="text" name="contactPerson" style="width: 400px;"
									value="satyendra"></td>
							</tr>


							<tr>
								<td><b>Customer:</b> M/s. mobile</td>
							<tr>
								<td><b>Address: </b>noida sector58 <b>Pin: </b>noi001</td>
							</tr>
							<tr>
								<td><b>Phone: </b>56599999666666 <br> <b>Mobile: </b>85888888888



									<b>Fax No.: </b> <input type="hidden" name="customerFax"
									value=""></td>
							</tr>

							<tr>
								<td><b>Email: </b>vipghggh@gmail.com</td>
							</tr>


							<tr>
								<td><b>Qtn No: </b></td>
							</tr>
					</tbody>
				</table>
			</div>


			<table class="responstable">
				<tr>
					<td colspan="7" align="left" class="heading">Products Details</td>
				</tr>

				<tbody>
					<tr>
						<th>Products</th>
						<th data-th="Driver details"><span> Products Name</span></th>
						<th>Unit Quote Price</th>
						<th>Qty</th>
						<th>Std Price</th>
						<th>Quote Price (in PC)</th>
						<th>Discount (In %)</th>
					</tr>

					<tr>
						<td>TCS</td>
						<td>server</td>
						<td>120000</td>
						<td>5</td>
						<td>100000</td>
						<td>$1123</td>
						<td>20</td>
					</tr>

					<tr>


						<input type="hidden" name="totQuote" value="0.0">
						<td height="1" class="alternateColor1" align="right"></td>
						<td height="1" class="alternateColor1" align="right"></td>
						<td height="1" class="alternateColor1" align="right"></td>
						<td height="1" class="alternateColor1" align="right"></td>
						<td height="1" class="alternateColor1" align="right"></td>
						<td height="1" class="alternateColor1" align="right"><b>TotalQuote
								Price:</b></td>
						<td class="alternateColor1" align="right"><input type="text"
							name="totQuotePrice" style="text-align: right;" value="0.0"
							size="10" readonly=""></td>
					</tr>

				</tbody>
			</table>
			</fieldset>
			<form>






				<script>

</script>