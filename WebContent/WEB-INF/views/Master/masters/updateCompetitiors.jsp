
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
    <form:form class="well form-horizontal"   action="upcompetitior" method="POST"  commandName="competitiorsProfileBean" 
    id="" >
    <input type="hidden" id="hiddenid"/>
    <fieldset>
<!-- Form Name -->
<legend>Edit Competitor Profile</legend>
  
  
  <div class="form-group">
  <label class="col-md-2 control-label"> id<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input readonly  name="compid" placeholder=" Name" id="name" value="${listofcompetitior.compid}" required="required"  class="form-control"  type="text">
    </div>
  </div>
  
</div>

<div class="form-group">
  <label class="col-md-2 control-label"> Name<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="name" placeholder=" Name" id="name" value="${listofcompetitior.name}" required="required"  class="form-control"  type="text">
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
    <select name="warrentyperiod" class="form-control selectpicker" required="required" value="${listofcompetitior.warrentyperiod}" id = "warranty">
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
    <select name="nooffreeamc" class="form-control selectpicker" required="required" value="${listofcompetitior.nooffreeamc}" id = "freeamc">
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
  <input name="price"  class="form-control"  type="text" required="required" value="${listofcompetitior.price}" id = "price" >
    </div>
  </div>
   <label class="col-md-2 control-label">AMC Rate</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="amcrate"   class="form-control" placeholder="AMC Rate" required="required" type="text" value="${listofcompetitior.amcrate}" id = "amcrate">
   
  </div>
</div>
</div>

<!-- Success message -->

<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" onclick="message();" id = "EditForm" >Edit<span class="glyphicon glyphicon-send"></span></button>
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>
</fieldset>
 </form:form> 
</div>


  <script type="text/javascript">


  $('#EditForm').click(function (){
  	var id=$("#hiddenid").val();
  //	var d1w=$("#hiddenid").val();
  	var name=$('#name').val();
  	var contactperson = $('#contactper').val();
  	var address = $('#address').val();
  	var phoneno = $('#phone2').val();
  	var mobile = $('#phone1').val();
  	var email = $('#email1').val();
  	var warranty = $('#warranty').val();
  	var productname = $('#firstUpper').val();
  	var freeamc = $('#freeamc').val();
  	var price = $('#price').val();
	var amcrate = $('#amcrate').val();
	
  	
  	
  	
  	//alert(d1w);
  	/* if(addmodeofdispatche == '' ){
  		$("#msg1").show();
  	}
  	else{ */
  		var jsonObj={'name':name, 'compid':id , 'contactperson':contactperson , 'address':address ,
  	      'phoneno' : phoneno ,'mobileno' :  mobile , 'emailid': email ,'warrentyperiod': warranty , 		
  	      'productname' :productname , 'nooffreeamc' :freeamc ,'price': price ,'amcrate':amcrate
  	} ;
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
  				    	 $('#openModal').hide();
  				    	 //window.location.currency;
  				    	 window.location.reload();
  			     //alert("edit");
  			    }});
  			
  	//}
  	
  	
  	
  });	
</script>

 