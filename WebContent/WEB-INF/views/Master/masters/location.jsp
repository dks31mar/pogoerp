<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/displaytag.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="resources/css/messagebox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet" type="text/css" href="resources/css/view.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/prettify.css" rel="stylesheet" type="text/css" />


<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script src="//code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <style>
  
  </style>
  
  <div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px;  height: 34px;">
		<span class="glyphicon glyphicon-home"></span> Location
		 <label
			 style="margin-left: 250px;margin-top: 8px;">
			 <button class="btn btn-primary" id="getcountrypopup" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Add Location </button>
     </label> 
			
</div>
<div id="formid" class="col-md-11" style=" left: 20px;  height: 34px;">



<div class="row">
<input type="hidden" id="hiddenid"/>
 <input type="hidden" id = "districtid" value = "${district123}"/> 
  
  <div class="col-md-10" align="right" id="dddd1234"><input path="loginname" type="text" class="validate[required] text-input" id="addlocation"
						style="border-radius: 5px;" value="" name="loginname" placeholder="Add location"
						 autofocus="autofocus" onclick="stopmoving();"></input></div>
  
  
  
  <div class="col-md-2" align="left">
  <button type="button"
				class="btn btn-primary" id="saveForm123">Save</button>
				<button type="button"
				class="btn btn-primary" id="EditForm">Edit</button>
				
				</div>
				

</div>
<div class="row">
<div class="col-md-10" align="right"><span style="color: red" id="msg1" >*This field is required.</span></div>
</div>
</div>
</div>


<div class="row" id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th style="width: 60px;">S.N.</th>
				<th data-th="Driver details"><span>Location</span></th>
				 
			    <th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			 <c:if test="${!empty locationList}">
				<c:forEach items="${locationList}" var="location" varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						<td>${location.location}</td>
		           
					 <td><a href="#" onclick="editCur(${location.locationId})" title="Edit">
								<span class="glyphicon glyphicon-pencil"></span></a></td>
								
						<td style="margin"><a href="deletelocation?locationId=${location.locationId}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;" onclick = "return confirm('Are u sure u want to delete?')"></span></a></td> 
								
					</tr>

				</c:forEach>
			</c:if>



		</tbody>
	</table>

</div>
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script>
$(document).ready(
	    function(){
$("#getcountrypopup").click(function(){
	
	 $("#formid").toggle('show');
	 $('#EditForm').hide();
	 $("#saveForm").show();
	 $("#addlocation").val('');
	 $('#locationspan').hide();
	 $("#hiddenid").val('');
	 $("#msg1").hide();
	
});
});




$("#formid").hide();
$('#messagediv').hide();
$("#msg1").hide();

function stopmoving(){
	$('#addlocation').css('border-color', 'white');
	$('#messagediv').hide('slow');
}

$('#saveForm123').click(function (){
	//alert("hello");
	var addlocation=$('#addlocation').val();
	
	if(addlocation==''){
		
		//$('#addlocation').css('border-color', '#DC143C');
		$("#msg1").show();
	}else{
		var getdistrictid = $('#districtid').val();
		var jsonObj={'location':addlocation , 'locationId':getdistrictid
		} ;
	$.ajax({
			url: "addlocation",
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
		     
		    }
		 });
		
	}
	
});



function editCur(id){
	$("#formid").show('show');
	$('#EditForm').show();
	$("#saveForm123").hide(); 
	$("#msg1").hide();
$.ajax({
	url: "getlocation?locationId="+id,
	type: "GET",
	
	     success: function(respose){
	    	// alert(respose);
	    	 var data=JSON.parse(respose)
	    	 var name=data.location;
	    	 var id=data.locationId;
	    	// alert("************************"+id);
	    	 $("#addlocation").val(name);
	    	 $("#hiddenid").val(id);
	    	 $('#messagediv').hide('slow');
	    	 $('#addlocation').css('border-color', 'white');
	    	 
    }});
} 





$('#EditForm').click(function (){
	// $("#saveForm").show();
	var id=$("#hiddenid").val();
	var addlocation=$('#addlocation').val();
	
	var d1w=$("#hiddenid").val();
	//alert(d1w);
	
	if(addlocation==''){
		//$('#addlocation').css('border-color', '#DC143C');
		$("#msg1").show();
	}else{
		var jsonObj={'location':addlocation,'locationId':id} ;
		$.ajax({
			url: "editlocation",
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
	
	


	var jsonObj={'location':addlocation,'locationId':id} ;
$.ajax({
		url: "editlocation",
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
/* $(document).ready(function () {

    $('#addlocation').validate({ // initialize the plugin
        // rules & options,
        errorPlacement: function(error, element) {
            element.val("placeholder",error.text());
        }
    });

}); */

$('#addlocation').click(function (){
	 $('#msg1').hide();
	 
	
	
});

</script>
