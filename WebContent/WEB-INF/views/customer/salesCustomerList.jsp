<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/table.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />

<div class="row" style="margin-top: 5px;"></div>
<br>
<div class="row">
	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px; height: 44px; color: white;">
		<span class="glyphicon glyphicon-user"></span> <span> Sales
			Enquiry </span> <label style="margin-left: 540px;"><a href="#"
			onclick="history.back();" style="margin-top: -3px;"
			class="btn btn-primary"> Return to Customer Add </a> </label>

	</div>

</div>
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Customer Operation</h4>
			</div>
			<div class="modal-body">
				<div>
					<a id="plannerbuttonid"><strong>Planner</strong></a>
				</div>
				<div>
					<a href="getSales"><strong> Add Customer</strong></a>
				</div>
				<div>
					<a href="addFollowup"><strong> Add Activities</strong></a>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<table class="responstable" id="mainidtable">


	<tbody align='center'>
		<tr>
			<th>S.N.</th>
			<th>Creation Date</th>
			<th>Customer</th>
			<th>Address</th>
			<th>Contact Person</th>
			<th>Status</th>
			<th>A/c Manager</th>
			<th>Operation</th>
		</tr>

		<c:choose>
			<c:when test="${empty salesList}">
				<div style="color: red; text-align: center;">No Sales Record
					in the List</div>
			</c:when>
			<c:otherwise>
				<c:if test="${!empty salesList}">
					<c:forEach items="${salesList}" var="salesdetails"
						varStatus="count">
						<tr>
							<td>${count.count}</td>
							<td>${salesdetails.creationDate}</td>
							<td>${salesdetails.organisation}</td>
							<td>${salesdetails.address}</td>
							<td>${salesdetails.contactPerson}</td>
							<td>${salesdetails.status}</td>
							<td>${salesdetails.initiatedBy}</td>
							<td><a href="editcustomer?id=${salesdetails.customerId}"
								title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
								<span>&nbsp;</span>
								<button type="button"
									onclick="putIdAtPlanner(${salesdetails.customerId})"
									title="More Action" data-toggle="modal" data-target="#myModal">
									<i class="fa fa-th" aria-hidden="true"></i>
								</button></td>
						</tr>
					</c:forEach>
				</c:if>
			</c:otherwise>
		</c:choose>

	</tbody>
</table>

<script type="text/javascript">
function putIdAtPlanner(id){
	$("#plannerbuttonid").attr("href","addDiaryForEntrySales?id="+id);
}

$(document).ready(function() {
    $('#mainidtable').DataTable( {
        "order": [[0, "asc" ]]
    } );
} );
</script>
