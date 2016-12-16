
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />


<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />




<!-- <link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
    <script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script> -->



<style>
#success_message {
	display: Edited;
}
</style>




<div id="message" style="display: none;"></div>
<div id="body">
	<div class="container">

		<form:form class="well form-horizontal" action="saveStates"
			method="POST" commandName="statebean" id="">

			<fieldset>

				<!-- Form Name -->
				<legend>Add States</legend>


				<div class="form-group">
					<label class="col-md-2 control-label">States Name</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="stateName"
								placeholder="State Name" id="statename" class="form-control"
								type="text">

						</div>
					</div>

					<label class="col-md-2 control-label" style="margin-left: -62px;">RegionHead<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <select name="stateId"
								class="form-control selectpicker" id="regionhead">
								<option value="" selected="selected">----Select
									Region----</option>
								<c:forEach items="${zonesList}" var="list">
									<option value="${list.zonesid}">${list.zonesname}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<%-- <div class="form-group">
  <label class="col-md-2 control-label">Mobile No #<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input value="${zones.zonesphone}"  class="form-control" placeholder="8285080678" type="text"  id="mobileno" required="required">
    </div>
 
</div>
 <label class="col-md-2 control-label" style="margin-left: -62px;">E-Mail Id<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input  value="${zones.zonesmail}"  placeholder="E-Mail Address" class="form-control"  id="emailid" required="required" type="email">
    </div>
  </div>
</div>


 <!-- Text input-->

<!-- Text input-->
<div class="form-group"> 
  <label class="col-md-2 control-label">Fax No</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
        <input  value="${zones.zonesfax}"  placeholder="Fax Address" class="form-control"   id="fax" required="required" type="fax">
   
  </div>
  </div>
   <label class="col-md-2 control-label" style="margin-left: -62px;">Region Address<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input type="" name="address" value="${zones.zonesaddress}" placeholder="Address" required="required" id="regadress">
    </div>
  </div>
</div> --%>
				<!-- Success message -->

				<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-2" align="center">
						<button type="submit" class="btn btn-warning">
							Send <span class="glyphicon glyphicon-send"></span>
						</button>

						<button type="button" class="btn btn-warning"
							onclick="history.back();">
							Back <span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</div>
</div>

<!-- <script type="text/javascript">

	  $( function() {
		    $("#datepickerDob" ).datepicker();
		  } );

		$( function() {
		    $( "#datepickerjoin").datepicker();
		  } );
		
		
		
		function message() {
			$('#message').dialogBox({
				type : 'correct', //three type:'normal'(default),'correct','error',
				width : 250,
				height : 150,
				hasMask : true,
				hasClose : true,
				autoHide : false,
				time : '6000',
				effect : 'fall',
				title : 'Record',
				content : 'Data Saved Successfully!!!'
			});

		}
		
		
		function pass_validation()
		{
			var firstpassword=document.forp.Password1.value;  
			var secondpassword=document.forp.ConfirmPassword.value;  

			if(firstpassword==secondpassword){  
			return true;  
			}  
			else{  
			alert("RePassword must be Same!!!");
			document.getElementById("ConfirmPassword").value="";
			document.getElementById("ConfirmPassword").focus();
			return false;  
			}  
			} 
		

		function capitalize(firstUpper, str) {
		      if (str && str.length >= 1)
		      {       
		          var firstChar = str.charAt(0);
		          var remainingStr = str.slice(1);
		          str = firstChar.toUpperCase() + remainingStr;
		      }
		      document.getElementById(firstUpper).value = str;
		  }
		function capitalizemiddle(firstUppermiddle, str) {
		      if (str && str.length >= 1)
		      {       
		          var firstChar = str.charAt(0);
		          var remainingStr = str.slice(1);
		          str = firstChar.toUpperCase() + remainingStr;
		      }
		      document.getElementById(firstUppermiddle).value = str;
		  }
		function capitalizelast(firstlastupper, str) {
		      if (str && str.length >= 1)
		      {       
		          var firstChar = str.charAt(0);
		          var remainingStr = str.slice(1);
		          str = firstChar.toUpperCase() + remainingStr;
		      }
		      document.getElementById(firstlastupper).value = str;
		  }
		-->
<!-- <script type="text/javascript">
	
		$('#senddata').click(function(){
			
		var statename =	$('#statename').val();
		var regionhead=$('#regionhead').val();
		alert(statename+regionhead);
		<!--
		//var selecthead =	$('#selecthead').text();
		var mobileno =	$('#mobileno').val();
		var emailid =	$('#emailid').val();
		   var fax    =	$('#fax').val();
		   var regadress    =	$('#regadress').val();

		   
		   var mobileval = new RegExp("/[0-9]{10}/");
		   
		   
		   
		   
		   if(mobileval.test(mobileno)){
			   alert("cannot be blank")
			   
		   }else{
		  
			var jsonObj={
					'stateName':statename,
						'zones':regionhead
			} ;
		
		
			
			$.ajax({
				url: "saveStates",
				type: "POST",
				
				  data :JSON.stringify(jsonObj),
				  cache:false,
			        beforeSend: function(xhr) {  
			            xhr.setRequestHeader("Accept", "application/json");  
			            xhr.setRequestHeader("Content-Type", "application/json");  
			        },
				     success: function(resposeJsonObject){
				    	alert("save")
			    }});
			
		   }
		});
		
</script>  -->

