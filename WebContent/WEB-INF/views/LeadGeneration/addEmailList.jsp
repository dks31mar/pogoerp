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
<link href="resources/css/table.css" rel="stylesheet" type="text/css" />

<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i>
			<h3></h3>
		</i> <input type="hidden" name="profile" value="0" />
	</div>
</div>

<div class="row">

	<div class="page-heading col-sm-11" style="background-color: #3C8DBD; left: 20px;  height: 34px;"><span class="glyphicon glyphicon-envelope"></span> Register New Email
	<label  style="margin-left: 250px;margin-top: 8px;"><button href="#" class="btn btn-primary" id="getexpenseheadpopup" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Add Email </button> </label>
	</div>		
			 
			
    
      
		
<div id="formid" class="col-md-11" style=" left: 20px;  height: 34px;">
<div class="row">
  <div class="col-md-6"><span style="color: black;"> <strong>Name<span style="color: red;">*</span>:</strong></span></div>
						
  <div class="col-md-6"><span style="color: black;"><strong>Email<span style="color: red;">*</span>:</strong></span></div>
	</div>							
  
 					
							
					
<div class="row">  
<input type="hidden" id="hiddenid"/>								
<div class="col-md-6">
<input  type="text" class="validate[required] text-input" id="expensehead" style="border-radius: 5px;" value="" name="loginname" maxlength="20" autofocus="autofocus"></input>	
									
</div>
<div class="col-md-6">
<input  type="text" class="validate[required] text-input" id="expensetype" style="border-radius: 5px;" value="" name="loginname" maxlength="20" autofocus="autofocus"></input>  
</div>

</div>						
						
<div class="row">
<div class="col-md-11" align="right"><button style="margin-left: 300px; margin-top: -31px;" type="button" class="btn btn-primary" id="saveexpenseheaderForm">Save</button></div>
<!-- <div class="col-md-11" align="right"><button style="margin-left: 300px; margin-top: -31px;" type="button" class="btn btn-primary" id="EditcurrencyForm">Edit</button></div> --> 				
</div>

<div class="row">
<!-- <div class="col-md-6"><span style="color: red" id="msg1">*This field is required.</span></div>
<div class="col-md-6"><span style="color: red" id="msg2">*This field is required.</span></div> -->


</div>
	
</div>
</div>
<br>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>			
<div id="body">

	<table class="responstable" style="margin-left: 22px; " >
       <tbody>
			<tr>
				<th>S.No.</th>
				<th>Name</th>
				<th data-th="Driver details"><span>Email</span></th>
				<th>Status</th>
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			
<%-- <c:if test="${!empty expenseheadList}">
				<c:forEach items="${expenseheadList}" var="cur" varStatus="loop">
			
			<tr>
				<td>${loop.index+1}</td>
				<td>${cur.expensehead}</td>
				<td>${cur.expensetype}</td>
				<td>${cur.unit}</td>
				<td>${cur.exlimit}</td>
				<td><a href="#" onclick="editCur(${cur.expensemasterId})" title="Edit" align="center" ><span class="glyphicon glyphicon-pencil"></span></a></td>
				<td style="margin"><a href="deleteexpenseheader?expensemasterId=${cur.expensemasterId}"><span class="glyphicon glyphicon-trash" style="margin-left: 19px;" onclick = "return confirm('Are u sure u want to delete?')"></span></a></td>
			</tr>
</c:forEach>
</c:if> --%>
</tbody>
</table>

</div>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
<script>
$(document).ready( function(){
	  $("#getexpenseheadpopup").click(function(){
	  $("#formid").toggle('show');
	  $('#EditcurrencyForm').hide();
	  $("#savecurrencyForm").show();
	  $("#expensehead").val('');
	  $("#expensetype").val('');
	  $("#limit").val('');
	  $("#unit").val('');
	  $("#hiddenid").val('');
	  $("#expenseheadspan").hide();
	  $("#expensetypespan").hide();
	  $("#limitspan").hide();
	  $("#unitspan").hide();
	
});
});	   
$('#msg1').hide();
$('#msg2').hide();
$('#msg3').hide();
$('#msg4').hide();

$("#formid").hide();
$("#msg1").hide();
$("#msg2").hide();
$("#msg3").hide();
$("#msg4").hide();

$('#saveexpenseheaderForm').click(function (){
	
	var name=$('#expensehead').val();
	var expensetype=$('#expensetype').val();
	var limit=$('#limit').val();
	var unit=$('#unit').val();
	if(expensehead == ''){
		/* $("#expenseheadspan").show(); */
		$('#msg1').show('fast');
	} else if(expensetype == ''){
		/* $("#expensetypespan").show(); */
		$('#msg2').show('fast');
	}else if(unit == ''){
		/* $("#limitspan").show(); */
		$('#msg3').show('fast');
	}else if (limit == ''){
		/* $("#unitspan").show(); */
		$('#msg4').show('fast');
	}
	
	else {
		var jsonObj={'expensehead':expensehead,
				'expensetype':expensetype, 'unit':unit ,'exlimit':limit 
		} ;
	$.ajax({
			url: "addexpensehead",
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
	$('#EditcurrencyForm').show();
$.ajax({
	url: "getexpenseheader?expensemasterId="+id,
			
	type: "POST",

	     success: function(respose){
	    	 
	    	 var data=JSON.parse(respose)
	    	 var expensehead=data.expensehead;
	    	 var expensetype=data.expensetype;
	    	 var limit=data.exlimit;
	    	 var unit=data.unit;
	    	 var id=data.expensemasterId;
	    	// alert("DDDDDDDDDDDDDDDD "+id);
	    	 $("#expensehead").val(expensehead);
	    	 $("#expensetype").val(expensetype);
	    	  $("#unit").val(unit);
	    	 $("#limit").val(limit);
	    	 $("#hiddenid").val(id); 
	    	 $("#saveexpenseheaderForm").hide();
	    	 $('#msg1').hide();
	    	 $('#msg2').hide();
	    	 $('#msg3').hide();
	    	 $('#msg4').hide();
    }});
} 




 $('#EditcurrencyForm').click(function (){
	 $('#msg1').hide();
	 $('#msg2').hide();
	 $('#msg3').hide();
	 $('#msg4').hide();
	var id=$("#hiddenid").val();
	var expensehead=$('#expensehead').val();
	var expensetype=$('#expensetype').val();
	var limit=$('#limit').val();
	var unit=$('#unit').val();
	
	var d1w=$("#hiddenid").val();
	//alert(d1w);
	
	if(expensehead == ''){
		/* $("#expenseheadspan").show(); */
		$('#msg1').show('fast');
	} else if(expensetype == ''){
		/* $("#expensetypespan").show(); */
		$('#msg2').show('fast');
	}else if(unit == ''){
		/* $("#limitspan").show(); */
		$('#msg3').show('fast');
	}else if (limit == ''){
		/* $("#unitspan").show(); */
		$('#msg4').show('fast');
	}
	else{
		
		var jsonObj={'expensehead':expensehead,'expensemasterId':id,
				'expensetype':expensetype, 'exlimit':limit,'unit':unit } ;
		
	$.ajax({
			url: "editexpenseheader",
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
		   //  alert("edit");
		    }});
	}
	
	
	
}); 
 
 $('#expensehead,#expensetype,#unit,#limit').click(function (){
	 $('#msg1').hide();
	 $('#msg2').hide();
	 $('#msg3').hide();
	 $('#msg4').hide();
	
	
 });
 


</script>
