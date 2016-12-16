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
<div>
	<c:out value="${id}" />
</div>
<div id="body">
	<div>
		<div>
			<div class="row" style="margin-top: 15px">
				<br>
				<div align="center">
					<i> </i> <input type="hidden" name="profile" value="0" />
				</div>
			</div>
			<div class="row">

				<div class="page-heading col-sm-11"
					style="background-color: #3C8DBD; color: white; left: 20px; height: 64px;">
					<span class="glyphicon glyphicon-user"></span> Zones Details</b> <label
						style="margin-left: 250px; margin-top: 8px;"><a
						href="getzonepage" class="btn btn-primary">Add Zones</a> </label>

				</div>

			</div>
		</div>

		<table class="responstable">

			<tbody>
				<tr>
					<th>S.N.</th>
					<th data-th="Driver details"><span>Zone Name</span></th>
					<th>States</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:if test="${!empty branchList}">
					<c:forEach items="${branchList}" var="branch" varStatus="loop">

						<tr>
							<td>${loop.index+1}</td>
							<td>${branch.zonesname}</td>
							<td><a href="states?id=${branch.zonesid}" target="_blank">States</a></td>
							<td><a href="Editregion?id=${branch.zonesid}" title="Edit"
								id="validate"><span class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a href="deleteRegion?id=${branch.zonesid}"
								title="Delete" Onclick="ConfirmDelete()"><span
									class="glyphicon glyphicon-trash" id="delete"></span></a></td>
						</tr>

					</c:forEach>
				</c:if>

			</tbody>
		</table>

	</div>

	</TD>
	</TD>
	<TD valign="top">
	</TR>
	</TABLE>


	<div class="row form-group">
		<div class="col-sm-7"></div>
		<script>
function ConfirmDelete()
{
  var x = confirm("Are you sure you want to delete?");
  if (x)
      return true;
  else
    return false;
}


</script>