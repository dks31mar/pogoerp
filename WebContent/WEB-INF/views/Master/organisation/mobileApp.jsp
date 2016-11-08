<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />






<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px;  height: 64px;">
		<span class="glyphicon glyphicon-user"></span> Mobile Apps Registration
			 <div class="input-group" style="margin-left: 590px; width: 230px; top: -38px;
			 width: 230px;"><input type="text"  
			placeholder="Search Employee name"  class="form-control" oninput="searchEmp(this.value)" ><span class="input-group-addon">
        <i class="fa fa-search"></i>
    </span></div> 
			
</div>
</div>
<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th>S.N.</th>
				<th data-th="Driver details"><span>Employees Name</span></th>
				<th>Designation</th>
				<th>Device No</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			
	
					

				
		</tbody>
		
		
	</table>


