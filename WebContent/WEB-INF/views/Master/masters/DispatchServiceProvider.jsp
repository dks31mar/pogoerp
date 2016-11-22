<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />


<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i>
			<h3></h3>
		</i> <input type="hidden" name="profile" value="0" />
	</div>
</div>


<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px;  height: 41px;">
		<span class=""></span> Service Provider
		<label
			 style="margin-left:850px;" >
			 <a href="getserviceprovider"
			class="btn btn-primary" > Add New Service</a>
     </label> 
    <!--  <div class="input-group" style="margin-left: 865px; width: 230px; top: -28px;
			 width: 230px;"><input type="text"  
			placeholder="Search by product name or code"  class="form-control" oninput="searchPro(this.value)" id="inputvalueinsearch" style="width: 245px"><span class="input-group-addon">
        <i class="fa fa-search"></i>
    </span></div> -->
      
			
</div>

</div>

<br>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th>S.No.</th>
				<th data-th="Driver details"><span>Service Name</span></th>
				<th>Contact Person</th>
				<th>Phone</th>
				<th>Mode</th>
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			
			<c:if test="${!empty servicelist}">
				<c:forEach items="${servicelist}" var="cur" varStatus="loop">
			
			<tr>
						
								<td>${loop.index+1}</td>
								<td>${cur.servicename}</td>
								<td>${cur.contactperson}</td>
								<td>${cur.mobile}</td>
								<td>${cur.transportationmodeid}</td>
							
						
								<td><a href="editserviceprovider?id=${cur.transportationserviceid}" title="Edit" align="center" >
								<span class="glyphicon glyphicon-pencil"></span></a></td>
								
						<td style="margin"><a href="deleteserviceprovider?id=${cur.transportationserviceid}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"></span></a></td>
					</tr>
</c:forEach>
</c:if>
				


		</tbody>
	</table>
</div>
<div class="row form-group">
	<div class="col-sm-7"></div>
</div>



<!-- <script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

