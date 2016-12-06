<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="resources/css/table.css">



<div class="row" style="margin-top: 15px">
				<br>
				<div align="center">
					<i> </i> <input type="hidden" name="profile" value="0" />
				</div>
			</div>
			<div class="row">

				<div class="page-heading col-sm-11"
					style="background-color: #3C8DBD; color: white; left: 20px; height: 34px;">
					<span class="glyphicon glyphicon-user"></span> <span><strong> Task Not Disposal</strong></span>
					

				</div>

			</div>
		<table class="responstable" >

			<tbody>
				<tr>
					<th>S.N.</th>
					<th>A/c Manager</th>
					<th>Appointment</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Others</th>
					


				</tr>
				 <c:if test="${!empty diarydata}">
					<c:forEach items="${diarydata}" var="diarylist" varStatus="loop">

						<tr>
							<td>${loop.index+1}</td>
							<td>${diarylist.enteryuser}</td>
							<td>${diarylist.planName }</td>
						
						</tr>

					</c:forEach>
				</c:if> 

			</tbody>
		</table>

	
		