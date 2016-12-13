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


</head>


	<div>
		<div>
			<div class="row" style="margin-top: 15px">
				<br>
				<div align="center">
					<i> </i> <input type="hidden" name="profile" value="0" />
				</div>
</div>
			<div class="row">

				<div class="page-heading col-sm-11.5"
					style="background-color: #3C8DBD; color: white; left: 20px; height: 44px;">

					<span class="glyphicon glyphicon-user" style="margin-left: 24px;"></span> <strong>Reports</strong> 

					<span class="glyphicon glyphicon-user"></span> Reports</b> 
					<label><a href="#" class="">Pending Tasks</a> </label>


						<a href="pendingtasks" class="btn btn-info">Pending Tasks</a> </label>

						



				</div>

			</div>
		</div>
		<br>
		<div class="col-sm-12" align="center"><strong>   ${empname}'s Pending Things To Do </strong></div>
		<br>
		<table class="responstable" style="width: 100%;">

			<thead>
				<tr>
					<th>S.N.</th>
					<th>Date</th>
					<th>Time</th>
					<th>Contact Person</th>
					<th>Doctor Name</th>
					<th>Task</th>
					<th>Objective</th>
					<th>Action</th>

				</tr>
</thead>
<tbody>
				<c:if test="${!empty diaryList}">
					<c:forEach items="${diaryList}" var="diary" varStatus="loop">

						<tr>
							<td>${loop.index+1}</td>
							<td>${diary.date}</td>
							<td>${diary.time}</td>
							<td>${diary.contacperson}</td>
							<td>${diary.organization}</td>
							<td>${diary.planName}</td>
							<td>${diary.objective}</td>
							<td><a href="editdiary?id=${diary.diaryId}&empid=${empid}&planid=${planid}" title="Edit">
							<span class="glyphicon glyphicon-pencil" style="margin-left: 27px;"></span></a></td> 

						</tr>

					</c:forEach>
				</c:if>

			</tbody>
		</table>


		
		<div>
		
		
		</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>


	