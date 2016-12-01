
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>




 <!-- <link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
    <script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script> -->
	
   

<style>

#success_message{ display: Edited;}
</style>


<div>
<div>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		 <input type="hidden" name="profile" value="0" />
	</div>
</div>

  
   	
</div>

</div>
</div> 

	 

<div class="container"></div>
    <form:form class="well form-horizontal"  action="upcompetitior" method="POST"  commandName="competitiorsProfileBean"
    id="" >
    <fieldset>
<!-- Form Name -->
<legend>Edit Competitor Profile</legend>
  

<div class="form-group">
  <label class="col-md-2 control-label"> Name<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="name" placeholder=" Name" id="name"value="${listofcompetitior.name}" required="required"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" style="margin-left: -62px;">Contact Person</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="contactperson" placeholder="Contact Person"  value="${listofcompetitior.contactperson}" id="contactper" class="form-control"  type="text">
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-2 control-label" >Address</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="address" value="${listofcompetitior.address}"  placeholder="Address" id="address"  class="form-control"  type="text">
    </div>
  </div>
    
  <label class="col-md-2 control-label" style="margin-left: -62px;">Phone No</label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
  <input name="phoneno"   class="form-control" id="phone2" value="${listofcompetitior.phoneno}"  placeholder="(845)555-1212" type="text" required="required">
    </div>
  </div> 
  
</div>
<div class="form-group">
  <label class="col-md-2 control-label" >Mobile No</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="mobileno"   placeholder="Mobile No" id="phone1" value="${listofcompetitior.mobileno}" class="form-control"  type="text">
    </div>
  </div>
  
 <label class="col-md-2 control-label" style="margin-left: -62px;">Product Brand<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input   name="productbrand" placeholder=" Product Brand" id="product" required="required" value="${listofcompetitior.productbrand}"  class="form-control"  type="text">
    </div> 
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">E-Mail</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input  name="emailid"  placeholder="E-Mail Address" class="form-control"id ="email1"  value="${listofcompetitior.emailid}" required="required" type="email">
    
  
  </div>
</div>

 <label class="col-md-2 control-label" style="margin-left: -62px;">Warranty Period</label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-list" ></i></span>
    <select name="warrentyperiod" class="form-control selectpicker" required="required" value="${listofcompetitior.warrentyperiod}" >
   <option>---Select Warranty---</option> 
      <option value="availbility">Not available</option>
	  <option value="yera entry">1 year</option>
     <option value="yera entry">2 years</option>
     <option value="yera entry">3 years</option>
    </select>
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Product Name</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input   name="productname" placeholder="ProductName"value="${listofcompetitior.productname}"  id="firstUpper" required="required"  class="form-control"  type="text">
   
  </div>
</div>
<label class="col-md-2 control-label" style="margin-left: -62px;">NO of Free AMC<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="nooffreeamc" class="form-control selectpicker" required="required" value="${listofcompetitior.nooffreeamc}" >
    <option>--- Select Free AMC---</option> 
      <option value="" >1</option>
      <option value="">2</option>
       <option value="">More Than 2</option>
    </select>
    </div>
  </div>
</div> 

<!-- Text input-->
       
<div class="form-group">
  <label class="col-md-2 control-label">Price<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-doller"></i></span>
  <input name="price"  class="form-control"  type="text" required="required" value="${listofcompetitior.price}" >
    </div>
  </div>
   <label class="col-md-2 control-label">AMC Rate</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="amcrate"   class="form-control" placeholder="AMC Rate" required="required" type="text" value="${listofcompetitior.amcrate}">
   
  </div>
</div>
</div>

<!-- Success message -->

<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" onclick="message();"  >Save<span class="glyphicon glyphicon-send"></span></button>
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>
</fieldset>
</form:form>
</div>


<!--  <script type="text/javascript">
//for profile page save data
	$('#senddata').click(function(){
	
	  	var name =	$('#name').val();
	 	var contactper =	$('#contactper').val();
		var address =	$('#address').val();
	 	var designation=$('#designation').val();
	  	var phone1    =	$('#phone1').val();
	  	var phone2=  $('#phone2').val();
	  	var email1    =	$('#email1').val();  
     	var email2    =	$('#email2').val();
      	var faxno    =	$('#faxno').val();
	   
		var jsonObj={
				
				'compname':name ,
				'compaddress':address ,
				'compphone': phone1,
				'compfax':faxno ,
				'compemail1': email1,
				'compcontactperson': contactper,
				'compcontactdesig': designation,
				'compemail2':email2 ,
				'compphone2':phone2 
				} ;
		 
	
		//alert(jsonObj);
		$.ajax({
			url: "upcompetitior",
			type: "POST",
			
			  data :JSON.stringify(jsonObj),
			  cache:false,
		        beforeSend: function(xhr) {  
		            xhr.setRequestHeader("Accept", "application/json");  
		            xhr.setRequestHeader("Content-Type", "application/json");  
		        },
			     success: function(resposeJsonObject){
			    	 window.location.href ="competitiorsProfile";
		    }});
		
   }
	
	);

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
		
</script>

 -->