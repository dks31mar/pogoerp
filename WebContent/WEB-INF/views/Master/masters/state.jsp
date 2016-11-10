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
		<span class="glyphicon glyphicon-home"></span> State
		 <label
			 style="margin-left: 250px;margin-top: 8px;"><button 
			class="btn btn-primary" id="getcountrypopup" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Add State </button>
     </label> 
			
</div>
<div id="formid" class="col-md-11" style=" left: 20px;  height: 34px;">



<div class="row">
<input type="hidden" id="hiddenid"/>
<input type="hidden" id="countryid" value="${state123}"/> 
  <div class="col-md-10" align="right"><input path="loginname" type="text" class="validate[required] text-input" id="addstate"
						style="border-radius: 5px;" value="" name="loginname" placeholder="Add State"
						maxlength="20" autofocus="autofocus"></input></div>
  
</div>



 <div class="row">
<div class="col-md-11" align="right"><button style="margin-left: 300px; margin-top: -31px;" type="button"
				class="btn btn-primary" id="saveForm">Save</button></div>
				
				<div class="col-md-11" align="right"><button style="margin-left: 300px; margin-top: -31px;" type="button"
				class="btn btn-primary" id="EditForm">Edit</button></div>
</div> 


</div>
</div>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th style="width: 60px;">S.N.</th>
				<th data-th="Driver details"><span>State</span></th>
				 <th>District</th> 
			    <th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
		 <c:if test="${!empty stateList}">
				<c:forEach items="${stateList}" var="state" varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						<td>${state.state}</td>
						 
		            <td><a href = "district">District</a></td> 
					 <td><a href="#" onclick="editCur(${state.stateId})" title="Edit">
								<span class="glyphicon glyphicon-pencil"></span></a></td>
								
						<td style="margin"><a href="deletestate?stateId=${state.stateId}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"></span></a></td> 
								
					</tr>

				</c:forEach>
			</c:if> 



		</tbody>
	</table>

</div>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>

$(document).ready(
	    function(){
$("#getcountrypopup").click(function(){
	
	 $("#formid").toggle('show');
	 $('#EditForm').hide();
	 $("#saveForm").show();
	 $("#addstate").val('');
	 
	 $("#hiddenid").val('');
	
});
	    });
$("#formid").hide();

$('#saveForm').click(function (){
	var addstate=$('#addstate').val();
<<<<<<< HEAD
	if(addstate == ''){
		
	}
	else{
		
	}
	var jsonObj={'state':addstate
=======
	var getcountryid=$('#countryid').val();
	
	var jsonObj={'state':addstate,'stateId':getcountryid
>>>>>>> branch 'master' of https://github.com/dks31mar/pogoerp.git
	} ;
$.ajax({
		url: "addstate",
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
});



function editCur(id){
	$("#formid").show('show');
	$('#EditForm').show();
	$("#saveForm").hide(); 
$.ajax({
	url: "getstate?stateId="+id,
	type: "GET",
	
	     success: function(respose){
	    	// alert(respose);
	    	 var data=JSON.parse(respose)
	    	 var name=data.state;
	    	 var id=data.stateId;
	    	// alert("************************"+id);
	    	 $("#addstate").val(name);
	    	 $("#hiddenid").val(id);
	    	 
    }});
} 





$('#EditForm').click(function (){
	var id=$("#hiddenid").val();
	var addstate=$('#addstate').val();
	
	var d1w=$("#hiddenid").val();
	//alert(d1w);
	
	
	var jsonObj={'state':addstate,'stateId':id} ;
$.ajax({
		url: "editstate",
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
	     //alert("edit");
	    }});
	
	
});
</script>
