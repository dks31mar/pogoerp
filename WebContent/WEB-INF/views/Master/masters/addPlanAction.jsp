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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px;  height: 34px;">
		<span class="glyphicon glyphicon-user"></span> Add Plan 
 <label
			 style="margin-left: 250px;margin-top: 8px;"><button 
			class="btn btn-primary" id="getcountrypopup" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Add Plan of Action </button>
     </label>
			
</div>
<div id="formid" class="col-md-11" style=" left: 20px;  height: 34px;">



<div class="row">
<input type="hidden" id="hiddenid"/>
  
  
  <div class="col-md-10" align="right" id="dddd1234"><input path="loginname" type="text" class="validate[required] text-input" id="addsource"
						style="border-radius: 5px;" value="${planname.action}" name="" placeholder="Add Plan of Action  "
						maxlength="20" autofocus="autofocus" onclick="stopmoving();"></input></div>
  
  
  
  <div class="col-md-2" align="left">
  <button type="button"
				class="btn btn-primary" id="saveForm">Save</button>
				<button type="button"
				class="btn btn-primary" id="EditForm">Edit</button>
				
				</div>
</div>
<div class="row">


  <div class="col-md-10" align="right" id="messagediv"><span style="color: red;">*Mandatory filed</span></div>

</div>
</div>
<div id="pop" style="height: 12px"></div>
<div id="searchedRecord"></div>

</div>
 <div class="row" id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th style="width: 60px;">S.N.</th>
				<th data-th="Driver details"><span>Add Plan of Action</span></th>
				 <th style="width: 60px;">Edit</th>
			    <th style="width: 60px;"> Delete</th>
			</tr>
			 <c:if test="${!empty actionplanlist}">
				<c:forEach items="${actionplanlist}" var="action" varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						<td>${action.action}</td>
		              
						 
						<td><a href="#" onclick="editCur(${action.id})" title="Edit">
								<span class="glyphicon glyphicon-pencil"></span></a></td>		
					 <td style="margin"><a href="deletecustomerso?id=${action.id}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"></span></a></td>  
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
<script src="resources/js/jquery.jrumble.1.3.min.js"></script>
<script src="resources/js/jquery.jrumble.1.3.js"></script>
<script> 

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
	var action=$('#addsource').val();
	if(action == ''){
		$('#messagediv').show();
		
	}else{
		var jsonObj={'action':action
		} ;
	$.ajax({
			url: "addactionplan",
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
	//var id=$("#hiddenid").val();
	var action=$('#addsource').val();
	
	//var d1w=$("#hiddenid").val();
	//alert(d1w);
	
	
	var jsonObj={'action':action} ;
$.ajax({
		url: "editforactionplan",
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
	     alert("edit");
	    }});
	
	
});
function editCur(id){
	$("#formid").show('show');
	$('#EditForm').show();
	$("#saveForm").hide(); 
$.ajax({
	url: "getcustomersource?customersourceId="+id,
	type: "POST",
	
	     success: function(respose){
	    	 alert(respose);
	    	 var data=JSON.parse(respose)
	    	 var name=data.customersourceId;
	    	 var id=data.source;
	    	 alert("************************"+id);
	    	 $("#addsource").val(id);
	    	 $("#hiddenid").val(name);
	    	 
    }});
} 

</script>
