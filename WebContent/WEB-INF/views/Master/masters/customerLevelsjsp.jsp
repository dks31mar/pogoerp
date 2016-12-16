<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/displaytag.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/messagebox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet" type="text/css" href="resources/css/view.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px; height: 34px;">
		<span class="glyphicon glyphicon-user"></span> Customer Status <label
			style="margin-left: 250px; margin-top: 8px;"><button
				class="btn btn-primary" id="getcustomerpopup"
				style="margin-bottom: -25px; margin-top: -26px; HEIGHT: 28px; margin-left: 561px;">
				Add Customer Status</button> </label>

	</div>
	<div id="formid" class="col-md-11" style="left: 20px; height: 34px;">



		<div class="row">
			<input type="hidden" id="hiddenid" />
			<div class="col-md-10" align="right">
				<input path="loginname" type="text"
					class="validate[required] text-input" id="customerlevels"
					style="border-radius: 5px;" value="" name="loginname"
					placeholder="Enter Customer Levels " autofocus="autofocus"></input>
			</div>

		</div>



		<div class="row">
			<div class="col-md-11" align="right">
				<button style="margin-left: 300px; margin-top: -31px;" type="button"
					class="btn btn-primary" id="saveForm">Save</button>
			</div>

			<div class="col-md-11" align="right">
				<button style="margin-left: 300px; margin-top: -31px;" type="button"
					class="btn btn-primary" id="EditForm">Edit</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10" align="right">
				<span style="color: red" id="msg1">*This field is required.</span>
			</div>
		</div>

	</div>
</div>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable" style="margin-left: 22px;">

		<tbody>
			<tr>
				<th style="width: 60px;">S.N.</th>
				<th data-th="Driver details"><span>Status</span></th>
				<!--  <th data-th=""><span>Level</span></th> -->
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;">Delete</th>
			</tr>
			<c:if test="${!empty customerLevelsList}">
				<c:forEach items="${customerLevelsList}" var="customerlevel"
					varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						<td>${customerlevel.status}</td>
						<%-- <td>${customerlevel.level}</td>  --%>
						<td><a href="#" onclick="editCur(${customerlevel.id})"
							title="Edit" align="center"> <span
								class="glyphicon glyphicon-pencil"></span></a></td>

						<td style=""><a
							href="deletecustomerlevels?id=${customerlevel.id}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"
								onclick="return confirm('Are u sure u want to delete?')"></span></a></td>
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
	src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js"
	type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script>

$(document).ready(
	    function(){
$("#getcustomerpopup").click(function(){
	
	 $("#formid").toggle('show');
	 $('#EditForm').hide();
	 $("#saveForm").show();
	 $("#customerlevels").val('');
	 $("#customerval").hide();
	 $("#hiddenid").val('');
	 $("#msg1").hide();

	
});
	    });
$("#formid").hide();
$("#customerval").hide();
$("#msg1").hide();


$('#saveForm').click(function (){
	var customerlevels=$('#customerlevels').val();
	if(customerlevels == ''){
		$("#msg1").show('fast');
	}
	else{
		var jsonObj={'status':customerlevels
		} ;
	$.ajax({
			url: "addcustomerlevels",
			type: "POST",
			
			  data :JSON.stringify(jsonObj),
			  cache:false,
		        beforeSend: function(xhr) {  
		            xhr.setRequestHeader("Accept", "application/json");  
		            xhr.setRequestHeader("Content-Type", "application/json");  
		        },
			     success: function(resposeJsonObject){
			    	 $('#openModal').hide();
			    	 //window.location.currency;
			    	 window.location.reload();
		     
		    }});
	}
	
	
});



function editCur(id){
	$("#formid").show('show');
	$('#EditForm').show();
	$("#saveForm").hide(); 
	$("#msg1").hide();
	
$.ajax({
	url: "getcustomerlevel?id="+id,
	type: "GET",
	
	     success: function(respose){
	    	// alert(respose);
	    	 var data=JSON.parse(respose)
	    	 var name=data.status;
	    	 var id=data.id;
	    	// alert("************************"+id);
	    	 $("#customerlevels").val(name);
	    	 $("#hiddenid").val(id);
	    	 
    }});
} 





$('#EditForm').click(function (){
	 $("#customerval").hide();
	var id=$("#hiddenid").val();
	var customerlevels=$('#customerlevels').val();
	
	var d1w=$("#hiddenid").val();
	//alert(d1w);
	if(customerlevels == '' ){
		$("#msg1").show('fast');
	}
	else{
	
	var jsonObj={'status':customerlevels,'id':id} ;
$.ajax({
		url: "editcustomerlevel",
		type: "POST",
		
		  data :JSON.stringify(jsonObj),
		  cache:false,
	        beforeSend: function(xhr) {  
	            xhr.setRequestHeader("Accept", "application/json");  
	            xhr.setRequestHeader("Content-Type", "application/json");  
	        },
		     success: function(resposeJsonObject){
		    	 $('#openModal').hide();
		    	 //window.location.currency;
		    	 window.location.reload();
	    // alert("edit");
	    }});
	}
	
});

$('#customerlevels').click(function (){
	 $('#msg1').hide();
	 
	
	
});


</script>


