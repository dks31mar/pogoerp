
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

		<form:form class="well form-horizontal" name="forp" action=""
			method="POST" commandName="regionEdit" id="">

			<fieldset>

				<!-- Form Name -->
				<legend>Add Zones</legend>

				<!-- Text input-->
				<%--
<div class="form-group">
  <label class="col-md-2 control-label" >Region Id</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input value="${zones.zonesid}"  name="zonesid" placeholder="Region Name" id="region"  class="form-control"  type="text">
    </div>
  </div>
  --%>
				<span
					style="color: red; text-align: center; text-transform: uppercase;"
					id="messagespan">please fill blank or (*) fileds</span>
				<div class="form-group">
					<label class="col-md-2 control-label">Zone Name</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								value="${zones.zonesid}" name="zonesid" placeholder="Zone Name"
								id="zoneid" class="form-control" required="required"
								type="hidden"> <input value="${zones.zonesname}"
								name="zonesname" placeholder="Zone Name" pattern="[a-zA-Z]+"
								id="regionname" required="required"
								pattern="^[a-zA-Z](\s?[a-zA-Z]){2,20}$" class="form-control"
								type="text" oninput="funcal();">
						</div>
					</div>
					<label class="col-md-2 control-label" style="margin-left: -62px;">E-Mail
						Id<span style="color: red;">*</span>
					</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input
								value="${zones.zonesmail}" placeholder="E-Mail Address"
								class="form-control"
								pattern="^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$"
								id="emailid" required="required" type="email"
								pattern="^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$"
								oninput="funcal();">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Mobile No #<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input
								value="${zones.zonesphone}" class="form-control"
								placeholder="8285080678" type="text" pattern="^\d{1,10}$"
								required="required" id="mobileno" required="required"
								oninput="funcal();">
						</div>

					</div>
					<label class="col-md-2 control-label" style="margin-left: -62px;">Zone
						Address<span style="color: red;">*</span>
					</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <input
								value="${zones.zones}" placeholder="Zones Address"
								class="form-control" id="regadress" required="required"
								type="address" oninput="funcal();">
						</div>
					</div>
				</div>


				<!-- Text input-->

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-2 control-label">Fax No</label>
					<div class="col-md-3 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input
								value="${zones.zonesfax}" placeholder="Fax No"
								class="form-control" id="fax" required="required" type="fax"
								oninput="funcal();">

						</div>
					</div>
					<!--  
   <label class="col-md-2 control-label" style="margin-left: -62px;">Zone Address<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
   <input  value="${zones.zonesmail}"  placeholder="Zones Address" class="form-control"  id="address" required="required" type="address" oninput="funcal();">
    </div>
  </div>-->
				</div>
				<!-- Success message -->

				<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-2" align="center">
						<button type="button" class="btn btn-warning" id="senddata">
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

<script type="text/javascript">

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
			//alert("RePassword must be Same!!!");
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
		
		
		// by satyendra
		$('#messagespan').hide();
		$('#senddata').click(function(){
			
		var reginname =	$('#regionname').val();
		var selecthead =	$('#selecthead').text();
		var mobileno =	$('#mobileno').val();
		var emailid =	$('#emailid').val();
		   var fax    =	$('#fax').val();
		   var regadress    =	$('#regadress').val();
		   
		  //alert(regadress+reginname);
		   

		   if(reginname==''||mobileno==''||emailid==''||fax==''||regadress==''||selecthead=='---Select Region---'){

			   $('#messagespan').show('fast');

			   $('#messagespan').show('fast');

		   

		   }
		   else{
			   

		  

		   
		   
			   var jsonObj={
			                    'zonesname':reginname,
								'zonesaddress':regadress,
									'zonesfax':fax,
									'zonesphone':mobileno,
									'zonesemail':emailid
				} ;
			
			$.ajax({
					url: "addzonedetails",
					type: "POST",
					
					  data :JSON.stringify(jsonObj),
					  cache:false,
				        beforeSend: function(xhr) {  
				            xhr.setRequestHeader("Accept", "application/json");  
				            xhr.setRequestHeader("Content-Type", "application/json");  
				        },
					     success: function(resposeJsonObject){
					    	 window.location.reload();
					    	 alert(save);
								}
				        
			});	  

		    
		   }

		  
		   }

		  
		); 
		
	function funcal(){
		$('#messagespan').hide();
	}
		
		
</script>

