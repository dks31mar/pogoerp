<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />
<script type="text/javascript">

  function searchEmployee(empName) {
		//alert("hi");
		//alert(empName);
		$("#searchedRecord").empty();
		$("#body").show();
		$
				.ajax({

					type : "POST",
					url : 'searchEmp',
					data : {
						'empName' : empName,
					},
					success : function(data) {
						var obj = JSON.parse(data);
						//alert(obj.firstname)
						var count=0;
						var content = '<table class="responstable" style="margin-top: 5px;margin-left: 22px; border-radius: 5px;"><thead><tr>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">SN</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Employee Name</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Designation</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Device No</label></th>'
							+'<th class="corg_th" style="font-size: 13px;"><label for="laborg">Status</label></th>'
							+  '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Apps Approval</label></th>'
						if (obj.length == 0) 
						{
							content += '<tr><td colspan="8"><font color="red" size="3">No record found.</font></td></tr>';
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
												+ value.firstname + '</td>';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.designationName
												+ '</td>';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.deviceno 
												+'</td>';
												if(value.empStatus==true)
													{
													content +='<td class=""><img src="resources/image/greens.gif"></td>'
													}else
													content += '<td class=""><img src="resources/image/reds.gif"></td>'	
										content += '<td class="corg_th"><a href="updateEmp?id='+value.userempid+'"<span class="btn btn-success">Approved</a>'
												+ "</td></tr>";
													
									});
					content += '</tbody></table>';
							}
						$("#body").hide();
					$("#searchedRecord").append(content);
					
				},
				error : function(e) {
					
				}
			});

	}	 
  
 
 
 


		/* function searchEmployee(empName) {
			
			$("#all").show();
			$("#some").empty();
			
			 $('#searchtotalrecords').empty();
			if (name == '') {
				$('#totalrecords').show();
			} else {
				$
						.ajax({
							url : 'searchEmp',
							type : 'POST',
							data : {
								'empName' : empName
							},
							success : function(data, status) {
								var j = JSON.parse(data);
								if (j.length == 0) {
									$("#all").hide();
									$("#some")
											.append(
													'<font color="red" size="3" align="centre">No records found</font>');
								} else {
									var st = '<table class="responstable" id="table-2" aria-describedby="table-2_info"><col width="50px"><col width="100px"><col width="50px"><col width="150px"><thead><tr role="row">'
											+ '<th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="table-2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="#: activate to sort column descending">Sr No</th>'
											+ '<th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="table-2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="#: activate to sort column descending">State Name</th>'
											+ '<th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="table-2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="#: activate to sort column descending">State Status</th>'
											+ '<th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="table-2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="#: activate to sort column descending">Action</th>'
											+ '</tr></thead><tbody role="alert" aria-live="polite" aria-relevant="all">';
									for (var i = 1; i <= j.length; i++) {
										st += '<tr class="odd"><td class=" sorting_1">'
												+ i
												+ '</td><td class=" ">'
												+ j[i-1].firstname + '</td>';
												+'<td class=" ">'
												+ j[i-1].designation + '</td>';
												+'<td class="">'
												+ j[i-1].deviceno + '</td>';
										if (j[i-1].empStatus == "active") {
											st += '<td class=" "><img src="resources/image/greens.gif"></td>'
										} else {
											st += '<td class=" "><img src="resources/image/reds.gif"></td>'
										}
										st +='<td class=" "><a href="updateEmp?id='
											+j[i-1].userempid 
											+'"class="btn btn-success">Approval</a></td></tr>';
										
										
									}
									st += '</tbody></table>';
									$("#all").hide();
									$("#some").append(st);
									$('#totalrecords').hide();
									$('#searchtotalrecords').append("Total Records:"+j.length);
								}

							},
							error : function(data, status) {

							}
						});
			}
		}
		
 */
		</script>
<div class="row" style="margin-top: 10px;"></div>
<br>

<div class="row">

	<div class="page-heading col-sm-11.5"
		style="background-color: #3C8DBD; left: 20px;">
		<span class="glyphicon glyphicon-phone"></span><span> Mobile
			Apps Registration</span>
		<!-- <div class="input-group" style="margin-left: 590px; width: 130px; top: -14px;
			 width: 230px;"><input type="text"  
			placeholder="Search Employee name"  class="form-control" oninput="searchEmployee(this.value)"><span class="input-group-addon">
        <i class="fa fa-search"></i>
    </span></div>  -->

	</div>
</div>
<%-- <div class="row" style="margin-top: 10px;">
					<div class="col-md-12">

						<div class="col-md-12 col-sm-12 clearfix"
							style="text-align: left;">
							<h5 style="font-weight: 100; color: red;" id="totalrecords">Total
								Records:${totalrecords}</h5>
						</div>
						</div>
						</div> --%>
<div id="some"></div>
<div id="all">
	<div id="searchedRecord"></div>
	<div id="body">
		<table class="responstable" id="mainidtable">

			<tbody>
				<tr>
					<th>S.N.</th>
					<th data-th="Driver details"><span>Employees Name</span></th>
					<th>Designation</th>
					<th>Device No</th>
					<th>Status</th>
					<th>Apps Approval</th>
				</tr>
				<c:choose>
					<c:when test="${empty emplDetails}">

						<div style="color: red; text-align: center; clear: both;">No
							Employee Record in the List</div>

					</c:when>
					<c:otherwise>
						<c:if test="${!empty emplDetails}">
							<c:forEach items="${emplDetails}" var="emp" varStatus="loop">

								<tr>
									<td>${loop.index+1}</td>
									<td>${emp.firstname}</td>
									<td>${emp.designationName}</td>
									<td>${emp.deviceno}</td>
									<td class=""><c:if test="${ emp.empStatus}">
											<img alt="" src="resources/image/greens.gif">
										</c:if> <c:if test="${ !emp.empStatus}">
											<img alt="" src="resources/image/reds.gif">
										</c:if></td>

									<td><a href="updateEmp?id=${emp.userempid}"
										class="btn btn-success">Approved</a></td>

								</tr>
							</c:forEach>
						</c:if>
					</c:otherwise>
				</c:choose>


			</tbody>


		</table>
	</div>
</div>








<script>
	$(document).ready(function() {
	    $('#mainidtable').DataTable( {
	        "order": [[0, "asc" ]]
	    } );
	} ); 
	</script>


<!-- <diV>Export Option:

<td><a href="#">CSV</a></td>
<td><a href="#">Excel</a></td>
<td><a href="#">XML</a></td>
<td><a href="#">PDF</a></td>

</diV>
-->











