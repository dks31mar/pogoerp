
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	
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

 <div id="pop" style="display: none;"></div>
<div><c:out value="${id}" /></div>
<div id="body">
<div>
<div>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		 <input type="hidden" name="profile" value="0" />
	</div>
</div>
<!--  
<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; color:white; left: 20px;  height: 64px;">
		<span class="glyphicon glyphicon-user"></span>Competitor Details</b>
		 <label
			 style="margin-left: 250px;margin-top: 8px;"><a href="addfeature"
			class="btn btn-primary">Add Competitor </a>
			<!--   <label
			 style="margin-left: 250px;margin-top: 8px;"><a href="getzonepage"
			class="btn btn-primary">Show Competitor List
			 </a>
          -->	
  
    </label> 		
</div>

</div>
</div> 

	 
<div id="message" style="display: none;"></div>
<div id="body">
<div class="container"></div>
    <form:form class="well form-horizontal" name="forp" action="" method="POST"  commandName="userbean"
    id="" >
<!-- Form Name -->
<legend>Competitor Profile</legend>
  

<div class="form-group">
  <label class="col-md-2 control-label"> Name<span style="color: red;">*</span></label>  
					
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="" placeholder=" Name" id="name" required="required"  class="form-control"  type="text">
  <span style="color: red" id="msg1">*This field is required.</span>
    </div>
  </div>
  <label class="col-md-2 control-label" style="margin-left: -62px;">Contact Person</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="designation" placeholder="Contact Person"   id="contactper" class="form-control"  type="text">
  <span style="color: red" id="msg2">*This field is required.</span>
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-2 control-label" >Address</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="middlename"   placeholder="Address" id="address"  class="form-control"  type="text">
  <span style="color: red" id="msg3">*This field is required.</span>
    </div>
  </div>
  
  <label class="col-md-2 control-label" style="margin-left: -62px;">Phone No</label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
  <input name="phone"   class="form-control" id="phone2" placeholder="(845)555-1212" type="text" required="required">
  <span style="color: red" id="msg4">*This field is required.</span>
    </div>
  </div> 
  
</div>
<div class="form-group">
  <label class="col-md-2 control-label" >Mobile No</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="lastname"   placeholder="Mobile No" id="phone1"  class="form-control"  type="text">
   <span style="color: red" id="msg5">*This field is required.</span>
    </div>
  </div>
  
  <label class="col-md-2 control-label" style="margin-left: -62px;">Product Brand<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input   name="Product" placeholder=" Product Brand" id="productbrand" required="required"  class="form-control"  type="text">
    <span style="color: red" id="msg6">*This field is required.</span>
    </div> 
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">E-Mail</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input  name="eamil"  placeholder="E-Mail Address" class="form-control"id ="email1" required="required" type="email">
     <span style="color: red" id="msg7">*This field is required.</span>
  
  </div>
</div>
<!--  
 <div class="form-group"> 
  <label class="col-md-2 control-label">Fax No</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
       <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span> 
   <input  name="fax"  placeholder="fax Address" class="form-control"  id="faxno" required="required" type="fax">
  </div>
</div>
 <!--  
</div>

<div class="form-group"> 
  <label class="col-md-2 control-label">Fax No</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
       <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span> 
   <input  name="fax"  placeholder="fax Address" class="form-control"  id="faxno" required="required" type="fax">
  </div>
</div>
-->
 <label class="col-md-2 control-label" style="margin-left: -62px;">Warranty Period</label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="department" class="form-control selectpicker" required="required" id="warrantyPeriod" >
   <option></option>
      <option value="availbility">Not available</option>
	  <option value="1 year">1 year</option>
     <option value="2 years">2 years</option>
     <option value="3 years">3 years</option>
    </select>
     <span style="color: red" id="msg8">*This field is required.</span>
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Product Name</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input   name="firstname" placeholder="Product Name" id="productname" required="required"  class="form-control"  type="text">
    <span style="color: red" id="msg9">*This field is required.</span>
  </div>
</div>
<label class="col-md-2 control-label" style="margin-left: -62px;">NO of Free AMC<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="department" class="form-control selectpicker" required="required" id="freeamc" placeholder="Select Free AMC">
     <option></option>
      <option value="1" >1</option>
      <option value="2">2</option>
       <option value="More Than 2">More Than 2</option>
    </select>
     <span style="color: red" id="msg10">*This field is required.</span>
    </div>
  </div>
</div> 

<!-- Text input-->
       
<!-- <div class="form-group"> -->
  <label class="col-md-2 control-label">Price(Rs.)<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-doller"></i></span>
  <input name="price"  class="form-control" placeholder="Rupees" type="text" required="required" id ="price">
    <span style="color: red" id="msg11">*This field is required.</span>
    </div>
  </div>
   <div class="form-group"> 
  <label class="col-md-2 control-label">AMC Rate</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="Product Name"   class="form-control" id="rateamc" placeholder="AMC Rate" required="required" type="text">
    <span style="color: red" id="msg12">*This field is required.</span>
  </div>
</div>
</div>


 
<!-- </div> 
 -->
<!-- Success message -->

<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="button" class="btn btn-warning" onclick="message();" id="senddata" >Send <span class="glyphicon glyphicon-send"></span></button>
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
    
  </div>
</div>


</form:form>
</div>
</div>

 <script type="text/javascript">
//for profile page save data

$('#msg1').hide();
$('#msg2').hide();
$('#msg3').hide();
$('#msg4').hide();
$('#msg5').hide();
$('#msg6').hide();
$('#msg7').hide();
$('#msg8').hide();
$('#msg9').hide();
$('#msg10').hide();
$('#msg11').hide();
$('#msg12').hide();

$('#senddata').click(function(){
	
	
	
	  	var name =	$('#name').val();
	 	var contactper =	$('#contactper').val();
		var address =	$('#address').val();
	 	
	 	
	 	var phoneno=  $('#phone2').val();
	  	var mobileno   = $('#phone1').val();
		var productbrand= $('#productbrand').val();
		
		
	  	var email1    =	$('#email1').val();  
	  	var warrantyPeriod=$('#warrantyPeriod').val();
	  	var productname= $('#productname').val();
	  	var nofofreeamc=$('#freeamc').val();
		var price=$('#price').val();
		var Rateamc=$('#rateamc').val();
		
		if(name == ''){
			$('#msg1').show('fast');
		} else if(contactper == ''){
			$('#msg2').show('fast');
		}else if(address == ''){
			$('#msg3').show('fast');
		}else if(phoneno ==''){
			$('#msg4').show('fast');
		}else if(mobileno ==''){
			$('#msg5').show('fast');
		}else if(productbrand ==''){
			$('#msg6').show('fast');
		}else if(email1 ==''){
			$('#msg7').show('fast');
		}else if(warrantyPeriod ==''){
			$('#msg8').show('fast');
		}else if(productname ==''){
			$('#msg9').show('fast');
		}else if(nofofreeamc ==''){
			$('#msg10').show('fast');
		}else if(price ==''){
			$('#msg11').show('fast');
		}else if(Rateamc ==''){
			$('#msg12').show('fast');
		}
		
		else {
			
		
		
		
	    var jsonObj={
				
	    		'name':name,
	    		'contactperson':contactper,
	    		'address':address,
	    		/* 'designation':designation, */
	    		'phoneno':phoneno,
	    		'mobileno':mobileno,
	    		'productbrand':productbrand,
	    		'emailid':email1,
	    		'warrentyperiod':warrantyPeriod,
	    		'productname':productname,
	    		'nooffreeamc':nofofreeamc,
	    		'price':price,
	    		'amcrate':Rateamc
				} ;
		 
	
		alert(jsonObj);
		$.ajax({
			url: "saveDataCompetitiors",
			type: "POST",
			
			  data :JSON.stringify(jsonObj),
			  cache:false,
		        beforeSend: function(xhr) {  
		            xhr.setRequestHeader("Accept", "application/json");  
		            xhr.setRequestHeader("Content-Type", "application/json");  
		        },
			     success: function(resposeJsonObject){
			    	 window.location.href = "competitiorsProfile";
		    }});
		
   }
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
		 
		
		
		
		
		
		

		
		
		

		
		
		
		
		
		 $('#EditForm').click(function (){
			 
			 $("#senddata").hide(); 
			 
			 
			 
		  	var id=$("#hiddenid").val();
		
		  	var name =	$('#name').val();
	 	var contactper =	$('#contactper').val();
		var address =	$('#address').val();
	 	
	 	
	 	var phoneno=  $('#phone2').val();
	  	var mobileno   = $('#phone1').val();
		var productbrand= $('#productbrand').val();
		
		
	  	var email1    =	$('#email1').val();  
	  	var warrantyPeriod=$('#warrantyPeriod').val();
	  	var productname= $('#productname').val();
	  	var nofofreeamc=$('#freeamc').val();
		var price=$('#price').val();
		var Rateamc=$('#rateamc').val();
			
		  	
		  	
		  	
		  	
		  		var jsonObj={'compid':id , 'name':name,
		    		'contactperson':contactper,
		    		'address':address,
		    		
		    		'phoneno':phoneno,
		    		'mobileno':mobileno,
		    		'productbrand':productbrand,
		    		'emailid':email1,
		    		'warrentyperiod':warrantyPeriod,
		    		'productname':productname,
		    		'nooffreeamc':nofofreeamc,
		    		'price':price,
		    		'amcrate':Rateamc
		  	} ;
		  		$.ajax({
		  				url: "",
		  				type: "POST",
		  				
		  				  data :JSON.stringify(jsonObj),
		  				  cache:false,
		  			        beforeSend: function(xhr) {  
		  			            xhr.setRequestHeader("Accept", "application/json");  
		  			            xhr.setRequestHeader("Content-Type", "application/json");  
		  			        },
		  				     success: function(resposeJsonObject){
		  				    	 $('#openModal').hide();
		  				    	 
		  				    	 window.location.reload();
		  			     
		  			    }});
		  			
		  	
		  	
		  	
		  	
		  }); 		
		
		 $('#name,#contactper,#address,#phone2,#phone1,#productbrand,#email1,#warrantyPeriod,#productname,#nofofreeamc,#price,#Rateamc').click(function (){
			 $('#msg1').hide();
			 $('#msg2').hide();
			 $('#msg3').hide();
			 $('#msg4').hide();
			 $('#msg5').hide();
			 $('#msg6').hide();
			 $('#msg7').hide();
			 $('#msg8').hide();
			 $('#msg9').hide();
			 $('#msg10').hide();
			 $('#msg11').hide();
			 $('#msg12').hide();
			
			
		 }); 
		
		 
		 
</script>

