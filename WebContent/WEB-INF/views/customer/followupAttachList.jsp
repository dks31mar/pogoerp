<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" /> 
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/table.css">


<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
	
	</div>
</div>
<div class="row">
	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; color:white; left: 20px;  height: 44px;">
		<span class="glyphicon glyphicon-file"> </span> <span>Attachment List</span>
		
</div>
</div>
<table class="responstable" >

			<thead>
				<tr>
					<th>S.N.</th>
					<th>File Name</th>
					<th>File Type</th>
					<th>Doctor Name</th>
					<th>Action</th>
				</tr>
</thead>
<tbody>
				 <c:if test="${!empty filesList}">
					<c:forEach items="${filesList}" var="filedata" varStatus="count">

						<tr>
							<td>${count.count}</td>
							<td>${filedata.fileName}</td>
							<td>${filedata.fileType}</td> 
							<td>${filedata.oganisationName}</td>
							
							<td><a href="download-files?id=${filedata.cusfileId}" title="Download">
							<span class="glyphicon glyphicon-cloud-download" style="margin-left: 27px;"></span></a>
							<a href="delete-file?id=${filedata.cusfileId}" title="Delete">
									<span
									class="glyphicon glyphicon-trash" style="margin-left:19px;"></span></a></td>
						</tr>

					</c:forEach>
				</c:if>

			</tbody>
		</table>

