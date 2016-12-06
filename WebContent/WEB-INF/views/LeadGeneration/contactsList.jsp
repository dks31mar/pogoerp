<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/jquery.dialogbox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/tableview.css" />
<script src="resources/plugins/jQuery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="resources/js/jquery.dialogBox.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"  rel="stylesheet" type="text/css" />
   


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
		style="background-color: #3C8DBD; left: 20px;  height: 34px;">
		<span class=""></span> Contacts
		<label style="margin-left: 250px;margin-top: 8px;"> <a href="getcontact" class="btn btn-primary" style="margin-bottom: -25px;margin-top: -22px;HEIGHT: 28px;margin-left:361px;"> Add Contacts </a></label> 
	</div>

</div>

<br>
<div id="pop" style="display: none;"></div>

<div id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th>S.No.</th>
				<th data-th="Driver details"><span>Name</span></th>
				<th>Department</th>
				<th>Designation</th>
				<th>Date of birth</th>
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			
			<c:if test="${!empty contactlist}">
				<c:forEach items="${contactlist}" var="con" varStatus="loop">
			
			<tr>
						
								<td>${loop.index+1}</td>
								<td>${con.contactName}</td>
								 <td>${con.depId}</td>
								<td>${con.desName}</td> 
								<td>${con.dob}</td>
							
						
								 <td><a href="getcontactsdetails?contactId=${con.contactId}" title="Edit" align="center" >
								<span class="glyphicon glyphicon-pencil"></span></a></td>
								
						<td style="margin"><a href="deletecontact?contactId=${con.contactId}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;" onclick="return confirm('Are you sure you want to delete?')"></span></a></td> 
					</tr>
</c:forEach>
</c:if>
				


		</tbody>
	</table>
</div>
<div class="row form-group">
	<div class="col-sm-7"></div>
</div>



<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>

function editCur(id){
	//$("#formid").show('show');
	//$('#EditForm').show();
	//$("#saveForm123").hide(); 
	//$("#msg1").hide();
$.ajax({
	url: "getcontactsdetails?contactId="+id,
	type: "GET",
	
	     success: function(respose){
	    	// alert(respose);
	    	 var data=JSON.parse(respose)
	    	
	    	 var id=data.contactId;
	    	 var name=data.location;
	    	 var name=data.location;
	    	 var name=data.location;
	    	 var name=data.location;
	    	// alert("************************"+id);
	    	 $("#addlocation").val(name);
	    	 $("#hiddenid").val(id);
	    	 $('#messagediv').hide('slow');
	    	 $('#addlocation').css('border-color', 'white');
	    	 
    }});
} 


</script>	
