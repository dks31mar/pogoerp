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
		<span class="glyphicon glyphicon-user"></span>Supplier Msaterl <label
			style="margin-left: 250px; margin-top: 8px;">
			<button class="btn btn-primary" id="getcountrypopup"
				style="margin-bottom: -25px; margin-top: -26px; HEIGHT: 28px; margin-left: 561px;">
				Add Supplier Detail</button>
		</label>

	</div>
	<div id="formid" class="col-md-11" style="left: 20px; height: 34px;">
		<div class="row">
			<div class="col-md-4">
				<span style="color: black;"> <strong>Name<span
						style="color: red;">*</span>:

				</strong></span>
			</div>
			<div class="col-md-4">
				<span style="color: black;"> <strong>Address<span
						style="color: red;">*</span>:
				</strong>
				</span>
			</div>
			<div class="col-md-4">
				<span style="color: black;"> <strong>Currency<span
						style="color: red;">*</span>:

				</strong></span>
			</div>
		</div>

		<div class="row">
			<input type="hidden" id="hiddenid" />
			<div class="col-md-4">
				<input path="loginname" type="text"
					class="validate[required] text-input" id="supname"
					style="border-radius: 5px;" value="" name="loginname"
					maxlength="20" autofocus="autofocus"
					onclick="hidemsg();return false;">

				<div id="msg1" align="left">
					<span style="color: red">*Mandtory Field</span> </input>
				</div>
			</div>

			<div class="col-md-4">
				<input path="loginname" type="text"
					class="validate[required] text-input" id="supadr"
					style="border-radius: 5px;" value="" name="loginname"
					onclick="hidemsg();return false;" maxlength="20"
					autofocus="autofocus">
				<div id="msg2" align="left">
					<span style="color: red">*Mandtory Field</span></input>
				</div>
			</div>
			<div class="col-md-4">
				<input path="firstname" type="text"
					class="validate[required] text-input" id="supcur"
					style="border-radius: 5px;" name="firstname" value=""
					onclick="hidemsg();return false;" maxlength="20">
				<div id="msg3" align="left">
					<span style="color: red">*Mandtory Field</span></input>
				</div>
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


	</div>

	<br>
	<div id="pop" style="height: 12px"></div>
	<div id="searchedRecord"></div>

</div>

<br>
<div class="row" id="body">
	<table class="responstable" style="margin-left: 22px;">

		<tbody>
			<tr>
				<th style="width: 60px;">S.N.</th>
				<th data-th="Driver details"><span>Name</span></th>
				<th data-th="Driver details"><span>Address</span></th>
				<th data-th="Driver details"><span>Currency</span></th>
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;">Delete</th>
			</tr>
			<c:if test="${!empty suppmstlst}">
				<c:forEach items="${suppmstlst}" var="list" varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						<td>${list.name}</td>
						<td>${list.address}</td>
						<td>${list.currency}</td>


						<td><a href="#" onclick="editCur(${list.suppliermasterid});"
							title="Edit"> <span class="glyphicon glyphicon-pencil"></span></a></td>
						<td style=""><a
							href="deletesuppliermstdata?id=${list.suppliermasterid}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"
								onclick="return confirm('Are you sure you want to delete?')"></span></a></td>
					</tr>

				</c:forEach>
			</c:if>



		</tbody>
	</table>

</div>

<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>


<script> 

function hidemsg(){
	$('#msg1').hide();
	$('#msg2').hide();
	$('#msg3').hide();
}

$('#msg1').hide();
$('#msg2').hide();
$('#msg3').hide();
$(document).ready(
	    function(){
$("#getcountrypopup").click(function(){
	
	 $("#formid").toggle('show');
	 $('#EditForm').hide();
	 $("#saveForm").show();
	 $("#addsource").val('');
	 $('#countryspan').hide();
	 $("#hiddenid").val('');
	
});
	    });
$("#formid").hide();
$('#countryspan').hide();
$('#messagediv').hide();



$('#saveForm').click(function (){
	var name=$('#supname').val();
	var address=$('#supadr').val();
	var currency=$('#supcur').val();
	if(name == ''){
		$('#msg1').show('slow');
		
	}else if(address==''){
		
		$('#msg2').show('slow');
	}
	else if(currency==''){
		$('#msg3').show('slow');
	}
	else 
	{
		var jsonObj=
		{
				
				'name':name,
				'address':address,
				'currency':currency
		} ;
	$.ajax({
			url: "savesuppliermaster",
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

$('#EditForm').click(function (){
	var id=$("#hiddenid").val();
	var name=$('#supname').val();
	var address=$('#supadr').val();
	var currency=$('#supcur').val();
	var d1w=$("#hiddenid").val();
	//alert(d1w);
	
	
	var jsonObj=
	{
			'suppliermasterid':id,
			'name':name,
			'address':address,
			'currency':currency
	} ;
$.ajax({
		url: "editsuppliermstdata",
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
		    	window.location.href = "suppliermaster?page=suppliermaster";
	    // alert("edit");
	    }});
	
	
});
function editCur(id){
	$("#formid").show('show');
	$('#EditForm').show();
	$("#saveForm").hide(); 
$.ajax({
	url: "getsupplierdatabyid?id="+id,
	type: "POST",
	
	     success: function(respose){
	    	// alert(respose);
	    	 var data=JSON.parse(respose)
	    	 var name=data.name;
	    	 var address=data.address;
	    	 var cur=data.currency;
	    	 var id=data.id;
	    	$('#hiddenid').val(id);
	    	$('#supname').val(name);
	    	$('#supadr').val(address);
	    	$('#supcur').val(cur);
	    	 
    }});
} 

</script>
