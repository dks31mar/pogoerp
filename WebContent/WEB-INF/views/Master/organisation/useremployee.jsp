<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/tableview.css" />
<script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script src="resources/js/jquery.dialogBox.js" type="text/javascript"></script>

<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />

<script>
	function fordelete()
	{
		alert("Are You Sure For Delete");
		
	}
	
	
	function deletUser(id){
		var x=confirm("Are you sure you want to delete?")
		if (x)
      
		$.ajax({
					url: "deleteuser?userempid="+id,
					type: "POST",
					
					success: function(result){
						window.location.reload();		    
					}});
	else
		 return false;
	}
	
	function searchEmp(loginname) {
		//alert("hi");
		//alert(loginname);
		$("#searchedRecord").empty();
		$("#body").show();
		
		$
				.ajax({

					type : "POST",
					url : 'searchEmployee',
					data : {
						'loginname' : loginname,
					},
					success : function(data) {
						var obj = JSON.parse(data);
						var count=0;
						var content = '<table class="responstable" style="margin-top: 5px;margin-left: 22px; border-radius: 5px;" id="searchdatatable"><thead><tr>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">SN</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Employee Code</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Employee Name</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Designation</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Branch</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Joining Date</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Edit</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Delete</label></th>'
							
						if (obj.length == 0) 
						{
							content += '<tr><td colspan="8"><font color="red" size="3" id="norecordid">No record found.</font></td></tr>';
						} 
						else
						{
							$
							.each(
									obj,
									function(key, value) {
										content += '<tr height="30">';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ ++count
												+ '</td>';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
													+ value.empCode
													+ '</td>';		
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.loginname + '</td>';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.designationName
												+ '</td>';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.branchName
												+ '</td>';		
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.dateofjoining
												+ '</td>';			
									    content += '<td style="font-size: 13px; color:black;width: 60px;" class="corg_th"><a href="editUser?id='+value.userempid+'" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>'	   
													+'</td>';		
										content += '<td style="font-size: 13px; color:black;width: 60px;" class="corg_th"><a title="Delete" href="#" onclick="deletUser('+value.userempid+')"><span class="glyphicon glyphicon-trash"></span></a>'
											+ '</td></tr>';		
										

												
									});
					content += '</tbody></table>';
							}
						$("#body").hide();
					$("#searchedRecord").append(content);
					
					var table = document.getElementById("searchdatatable");
					var len=table.rows.length-1;
					
					if($('#norecordid').text()=='No record found.'){
						$('#totalrecords').text('Total Records:0');
					}else{
						$('#totalrecords').text('Total Records:'+len);
					}
				},
				error : function(e) {
					
				}
			});
		
	}	
$('#openModal').hide();
$('#addemp').hide();
$('#editemp').hide();

$( function() {
    $( "#datepickerDob" ).datepicker();
  } );

$( function() {
    $( "#datepickerjoin" ).datepicker();
  } );
  
/* function ConfirmDelete()
{
  var x = confirm("Are you sure you want to delete?");
  if (x)
      return true;
  else
    return false;
} */

	</script>
</head>
<div class="row" style="margin-top: 5px;">
	
	
</div><br>


<div class="row">

	<div class="page-heading col-md-11.5"
		style="background-color: #3C8DBD; left: 20px; height: 64px;">
		<span class="glyphicon glyphicon-user"></span> Employee Details <label
			style="margin-left: 250px; margin-top: 8px;"><a
			href="addUser" class="btn btn-primary"> Add New Employee </a> </label>

		<!-- <div class="input-group"
			style="margin-left: 590px; width: 230px; top: -38px; width: 230px;">
			<input type="text" placeholder="Search Employee name"
				class="form-control" oninput="searchEmp(this.value)"><span
				class="input-group-addon"> <i class="fa fa-search"></i>
			</span>
		</div> -->

	</div>

</div>
<%-- <div class="row" style="margin-top: 10px;">
	<div class="col-md-12">

		<div class="col-md-12 col-sm-12 clearfix" style="text-align: left;">
			<h5 style="font-weight: 100; color: red;" id="totalrecords">Total
				Records:${totalrecords}</h5>
		</div>
	</div>
</div> --%>

<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable"  id="mainidtable">

		<thead>
			<tr>
				<th>S.N.</th>
				<th>Employee Code</th>
				<th data-th="Driver details"><span>Employees Name</span></th>
				<th>Designation</th>
				<th>Branch</th>
				 <th>Joining Date</th>
				 <th>Profile</th>
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;">Delete</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${empty Recordlist}">
					<div style="color: red; text-align: center;">No Employee
						Record in the List</div>
				</c:when>
				<c:otherwise>
					<c:if test="${!empty Recordlist}">
						<c:forEach items="${Recordlist}" var="user" varStatus="loop">

							<tr>
								<td>${loop.index+1}</td>  
								 <td>${user.empCode}</td>
								<td>${user.firstname} ${user.middlename} ${user.lastname}</td>
								<td>${user.designationName}</td>
								 <td>${user.branchName}</td>
                                 <td>${user.dateofjoining}</td>
                                 <td><img alt="" src="image/empProfile/${user.profile}"style="width: 60px; height: 60px;"></td>
                                
								<td><a href="editUser?id=${user.userempid}" title="Edit">
										<span class="glyphicon glyphicon-pencil"></span>
								</a></td>
								<td style=""><a href="#"
									onclick="deletUser(${user.userempid})"> <span
									class="glyphicon glyphicon-trash" style="margin-left:19px;"></span></a></td>

							</tr>

						</c:forEach>
					</c:if>
				</c:otherwise>
			</c:choose>
		</tbody>


	</table>

</div>


<%-- <div class="row form-group">
	<div class="col-sm-7"></div>
</div>
<div class="row" align="center">
	<div class="col-xs-9 col-right">
		<div class="dataTables_paginate paging_bootstrap">
			<ul class="pagination pagination-sm">
				<c:if test="${noOfPage > 1}">
					<li><a href="getuseremp?=${noOfPage - 1}">Previous</a></li>
				</c:if>

				<c:forEach begin="1" end="${totalNoOfPages}" var="i">
					<c:choose>
						<c:when test="${i==noOfPage}">

							<li class="active"><a href="#">${i}</a></li>

						</c:when>
						<c:otherwise>
							<li><a href="getuseremp?=${i}"> ${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${noOfPage < totalNoOfPages}">
					<li><a href="getuseremp?=${noOfPage + 1}">Next</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</div> --%>

<script type="text/javascript">

$(document).ready(function() {
    $('#mainidtable').DataTable( {
        "order": [[0, "asc" ]]
    } );
} ); 
var d= $('#chg').text();
$('#edit12').click(function(){
	$('#addemp').show();
	$('#editemp').hide();
});

function getDataList(id){
	$('#openModal').show();
	$('#addemp').hide();
	$('#editemp').show();
	$.ajax({
		url: "editUserdetails?userempid="+id,
		type: "get",
		success: function(respose){
			alert(respose);
			
	     
			
	    }});
	
}


</script>


