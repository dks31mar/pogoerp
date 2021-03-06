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
		style="background-color: #3C8DBD; left: 20px; height: 34px;">
		<span class="glyphicon glyphicon-envelope"></span> Register New Email
		<label style="margin-left: 250px; margin-top: 8px;"><button
				href="#" class="btn btn-primary" id="getpopup"
				style="margin-bottom: -25px; margin-top: -26px; HEIGHT: 28px; margin-left: 561px;">
				Add Email</button> </label>
	</div>





	<div id="formid" class="col-md-11" style="left: 20px; height: 34px;">
		<div class="row">
			<div class="col-md-6">
				<span style="color: black;"> <strong>Name<span
						style="color: red;">*</span>:
				</strong></span>
			</div>

			<div class="col-md-6">
				<span style="color: black;"><strong>Email<span
						style="color: red;">*</span>:
				</strong></span>
			</div>
		</div>




		<div class="row">
			<input type="hidden" id="hiddenid" />
			<div class="col-md-6">
				<input type="text" class="validate[required] text-input" id="name"
					style="border-radius: 5px;" value="" name="loginname"
					autofocus="autofocus"></input>

			</div>
			<div class="col-md-6">
				<input type="email" class="validate[required] text-input" id="email"
					style="border-radius: 5px;" value="" name="loginname"
					autofocus="autofocus"></input>
			</div>

		</div>

		<div class="row">
			<div class="col-md-11" align="right">
				<button style="margin-left: 300px; margin-top: -31px;" type="button"
					class="btn btn-primary" id="save">Save</button>
			</div>
			<div class="col-md-11" align="right">
				<button style="margin-left: 300px; margin-top: -31px;" type="button"
					class="btn btn-primary" id="edit">Edit</button>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<span style="color: red" id="msg1">*This field is required.</span>
			</div>
			<div class="col-md-6" id='emailmsg1'>
				<span style="color: red" id="msg2">*This field is required.</span>
			</div>
			<div class="col-md-6" id='emailmsg2'>
				<span style="color: red" id="invalid_email">*This email is
					not valid.</span>
			</div>
			<div class="col-md-6">
				<span style="color: red" id="msg">*Please Enter Alphabets
					Only.</span>
			</div>
		</div>

	</div>
</div>
<br>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">

	<table class="responstable" style="margin-left: 22px;">
		<tbody>
			<tr>
				<th>S.No.</th>
				<th>Name</th>
				<th data-th="Driver details"><span>Email</span></th>
				<th>Status</th>
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;">Delete</th>
			</tr>

			<c:if test="${!empty list}">
				<c:forEach items="${list}" var="cur" varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						<td>${cur.name}</td>
						<td>${cur.emaillist}</td>
						<td>${cur.status}</td>

						<td><a href="#" onclick="editCur(${cur.emaillistid})"
							title="Edit" align="center"><span
								class="glyphicon glyphicon-pencil"></span></a></td>
						<td style=""><a
							href="deleteemail?emaillistid=${cur.emaillistid}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"
								onclick="return confirm('Are u sure u want to delete?')"></span></a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

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
$("#getpopup").click(function(){
	
	 $("#formid").toggle('show');
	 $('#edit').hide();
	 $("#save").show();
	// $("#name").val('');
	// $("#email").val('');
	 $('#msg1').hide();
	 $('#msg2').hide();
	 $('#invalid_email').hide();
	 $('#msg').hide();
	// $("#hiddenid").val('');
	
});
	    });	   
$("#formid").hide();

$('#save').click(function (){
	
	var name=$('#name').val();
	var email=$('#email').val();
	var regex = /^[a-zA-Z]*$/;
	if(name == ''){
		/* $("#expenseheadspan").show(); */
		$('#msg1').show('fast');
	} 
	else if(name == regex){
		$('#msg').show('fast');	
	}
	else if(email == ''){
		/* $("#expensetypespan").show(); */
		$('#msg2').show('fast');
	}else if(IsEmail(email)==false){
		$('#emailmsg1').hide();
        $('#invalid_email').show();
       // return false;
    }
	
	else {
		var jsonObj={'name':name,
				'emaillist':email 
		} ;
	$.ajax({
			url: "saveemail",
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
	$('#edit').show();
$.ajax({
	url: "getemail?emaillistid="+id,
			
	type: "POST",

	     success: function(respose){
	    	 
	    	 var data=JSON.parse(respose)
	    	 var name=data.name;
	    	 var emaillist=data.emaillist;
	    	
	    	 var id=data.emaillistid;
	    	alert("DDDDDDDDDDDDDDDD "+id);
	    	 $("#name").val(name);
	    	 $("#email").val(emaillist);
	    	  
	    	
	    	 $("#hiddenid").val(id); 
	    	 $("#save").hide();
	    	 $('#msg1').hide();
	    	 $('#msg2').hide();
	    	 $('#invalid_email').hide();
    }});
} 

$('#edit').click(function (){
	 $('#msg1').hide();
	 $('#msg2').hide();
	 $('#invalid_email').hide();
	var id=$("#hiddenid").val();
	var name=$('#name').val();
	var emaillist=$('#email').val();
	
	
	var d1w=$("#hiddenid").val();
	//alert(d1w);
	
	if(name == ''){
		/* $("#expenseheadspan").show(); */
		$('#msg1').show('fast');
	} else if(emaillist == ''){
		/* $("#expensetypespan").show(); */
		$('#msg2').show('fast');
	}else if(IsEmail(emaillist)==false){
		$('#emailmsg1').hide();
        $('#invalid_email').show();
        return false;
    }
	else{
		
		var jsonObj={'name':name,'emaillistid':id,
				'emaillist':emaillist} ;
		
	$.ajax({
			url: "editmail",
			type: "POST",
			
			  data :JSON.stringify(jsonObj),
			  cache:false,
		        beforeSend: function(xhr) {  
		            xhr.setRequestHeader("Accept", "application/json");  
		            xhr.setRequestHeader("Content-Type", "application/json");  
		        },
			     success: function(resposeJsonObject){
			    	
			    	 window.location.reload();
		   
		    }});
	}
	
	
	
}); 

$('#name,#email').click(function (){
	 $('#msg1').hide();
	 $('#msg2').hide();
	 
	
	
});

function IsEmail(email) {
    var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!regex.test(email)) {
       return false;
    }else{
       return true;
    }
  }
	    </script>