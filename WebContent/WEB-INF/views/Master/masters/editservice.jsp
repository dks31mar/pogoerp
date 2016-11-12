<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>


<style>

#success_message{ display: Edited;}
</style>



	 
<div id="message" style="display: none;"></div>
<div id="body">
<div class="container">

    <form:form class="well form-horizontal" name="forp" action="" method="POST" id="" >
   
<fieldset>

<!-- Form Name -->
<legend>Edit Service</legend>
  
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
<div class="form-group">
  <label class="col-md-2 control-label" >Name<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input value="${service.transportationserviceid}"  name="zonesid" placeholder="Region Name" id="serid"  class="form-control"  type="hidden">
  <input value="${service.servicename}" name="zonesname"  placeholder="Name" id="transportname"  class="form-control"  type="text">
    </div>
  </div>
  
  <label class="col-md-2 control-label" >Contact Person<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  
  <input value="${service.contactperson}" name="zonesname"  placeholder="Contact person name" id="contactperson"  class="form-control"  type="text">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label">Mobile No #<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input value="${service.mobile}"  class="form-control" placeholder="8285080678" type="text"  id="mobileno" required="required">
    </div>
 
</div>
 <label class="col-md-2 control-label">Phone<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input  value="${service.phone}"  placeholder="Phone Number" class="form-control"  id="phoneno" required="required" type="email">
    </div>
  </div>
</div>


<!-- Text input-->

<!-- Text input-->
<div class="form-group"> 
  
   <label class="col-md-2 control-label">Address<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input  value="${service.serviceaddress}"  placeholder="Address" class="form-control"  id="address" required="required" type="Text">
    </div>
  </div>
  <label class="col-md-2 control-label">Transport Mode<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required" id="mode" >
   <option value="${service.transportationmodeid}" selected="selected">${service.transportationmodeid}</option>
	<option value="by air">By Air</option>
	  <option value="by road">By Road</option>
	  <option value="by train">By Train</option>
	  <option value="others">Others</option>
  </select>
    </div>
  </div>
</div>

<div class="form-group"> 
  
   <label class="col-md-2 control-label">Email<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input  value="${service.email}"  placeholder="E-Mail Address" class="form-control"  id="email" required="required" type="text">
    </div>
  </div>
 
</div>


<!-- Success message -->

<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="button" class="btn btn-warning" id="senddata">Send <span class="glyphicon glyphicon-send"></span></button>
    
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>

</fieldset>
</form:form>
</div>
</div>
<script src="resources/js/jquery.jrumble.1.3.min.js"></script>
<script src="resources/js/jquery.jrumble.1.3.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
 <script type="text/javascript">
 $('#senddata').click(function(){
	 var  serid=$('#serid').val();
	 var  tname=$('#transportname').val();
	 var  tcontactname=$('#contactperson').val();
	 var  mobile=$('#mobileno').val();
	 var  phone=$('#phoneno').val();
	 var  address=$('#address').val();
	 var  mode=$('#mode').val();
	 var  email=$('#email').val();
	 
	 if(tname==''){
		 
	 }else if(tcontactname==''){
		 
	 }else if(mobile==''){
		 
	 }else if(phone==''){
		 
	 }else if(address==''){
		 
	 }else if(mode==0){
		 
	 }else{
		 var jsonObj={
				 	 'transportationserviceid':serid ,
					 'servicename': tname,
					 'contactperson':tcontactname ,
					 'mobile': mobile,
					 'phone': phone,
					 'serviceaddress':address ,
					 'email': email,
					 'transportationmodeid':mode 
					 }; 


		 $.ajax({
				url: "updateservicedata",
				type: "POST",

				  data :JSON.stringify(jsonObj),
				  cache:false,
			        beforeSend: function(xhr) {  
			            xhr.setRequestHeader("Accept", "application/json");  
			            xhr.setRequestHeader("Content-Type", "application/json");  
			        },
				     success: function(resposeJsonObject){
				    	 window.location.href = "serviceprovider";
			     
			    		}
			        }); 
	 }
	 
	
	 
	 
 });
 
 
 </script>
     