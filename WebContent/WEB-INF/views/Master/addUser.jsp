
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/newdatepickercontrol.css" rel="stylesheet" type="text/css" />





 <!-- <link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
    <script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script> -->
	
   

<style>

#success_message{ display: Edited;}
</style>



	 
<div id="message" style="display: none;"></div>
<div id="body">
<div class="container">

    <form:form class="well form-horizontal" name="forp" action="saveuserEmp" method="POST"  commandName="userbean"
    id="" >
   
<fieldset>

<!-- Form Name -->
<legend>Add Employee</legend>
  <div class="form-group">
  <label class="col-md-2 control-label">Employee Id</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name=""    readonly="readonly"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" style="margin-left: -62px;">Employee Code<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="empCode"  placeholder="Enter Employee Code" required="required"  class="form-control"  type="text">
    </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-2 control-label">Login Name<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="loginname" placeholder="User Name" required="required"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" style="margin-left: -62px;">Joining Date</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  type="text"  class="form-control" name="dateofjoining" id="datepickerjoin" >
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label">First Name<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="firstname" placeholder="First Name" id="firstUpper" required="required" onkeyup="javascript:capitalize(this.id, this.value);" class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" style="margin-left: -62px;">Designation</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="designation" placeholder="Manger"   class="form-control"  type="text">
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-2 control-label" >Middle Name</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="middlename"   placeholder="Middle Name" id="firstUppermiddle" onkeyup="javascript:capitalizemiddle(this.id, this.value);" class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" style="margin-left: -62px;">DOB</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="dob"  id="datepickerDob" placeholder="Select Date"  class="form-control"  type="text">
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label" >Last Name</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="lastname"   placeholder="Last Name" id="firstlastupper" onkeyup="javascript:capitalizelast(this.id, this.value);" class="form-control"  type="text">
    </div>
  </div>
  
  <label class="col-md-2 control-label" style="margin-left: -62px;">SubCompany<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompany" class="form-control selectpicker" required="required">
  <option>---Select SubCompany---</option> 
      <option value="Relience">Relience</option>
	  <option value="Vodafone">Vodafone</option>
  </select>
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Division</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="division" class="form-control selectpicker" required="required">
   <option>---Select Division---</option> 
      <option value="Delhi">Delhi</option>
	  <option value="Delhi">Noida</option>
     
    </select>
  </div>
</div>
 <label class="col-md-2 control-label" style="margin-left: -62px;">E-Mail<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input  name="eamil"  placeholder="E-Mail Address" class="form-control" required="required" type="email">
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Region</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="region" class="form-control selectpicker" required="required">
    <option>---Select Region---</option>
      <option value="Delhi NCR">Delhi NCR</option>
	 <option value="Noida">Noida</option>
     
    </select>
  </div>
</div>
 <label class="col-md-2 control-label" style="margin-left: -62px;">Password<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="password"   class="form-control" id="Password1" placeholder="Password" required="required" type="password">
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Branch</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="branch" class="form-control selectpicker" required="required">
      <option>---Select Branch---</option>
      <option value="Delhi NCR">Delhi NCR</option>
	 <option value="Noida">Noida</option>
     
    </select>
  </div>
</div>
 <label class="col-md-2 control-label" style="margin-left: -62px;">RePassword<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="repassword" class="form-control" id="ConfirmPassword" placeholder="Repassword"  onblur="pass_validation();" type="password">
    </div>
  </div>
</div> 
<!-- Text input-->
       
<div class="form-group">
  <label class="col-md-2 control-label">Mobile #<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="usermobile"  class="form-control" placeholder="8285080678" type="text" required="required">
    </div>
  </div>
   <label class="col-md-2 control-label" style="margin-left: -62px;">Phone #</label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
  <input name="phone"   class="form-control"  placeholder="(845)555-1212" type="text" required="required">
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Department<span style="color: red;">*</span></label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="department" class="form-control selectpicker" required="required" >
   <option>---Select Department---</option> 
      <option value="HR">HR</option>
	  <option value="Data Entry">Data Entry</option>
     
    </select>
  </div>
</div>
</div>
<!-- Text input-->
<div class="form-group"> 
  <label class="col-md-2 control-label">Gender</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="gender" class="form-control selectpicker" >
    <option>--- Select Gender---</option> 
      <option value="Male" >Male</option>
      <option value="female">female</option>
    </select>
  </div>
  </div>
   <label class="col-md-2 control-label" style="margin-left: -62px;">Address<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <textarea class="form-control" name="address"  placeholder="Address" required="required"></textarea>
    </div>
  </div>
</div>
<!-- Success message -->

<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" onclick="message();" >Send <span class="glyphicon glyphicon-send"></span></button>
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>
<input type="text" id="datepickerjoin12">
</fieldset>
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>
<script src="resources/js/jquery.dialogBox.js" type="text/javascript"></script>
 <script type="text/javascript">

	  $( function() {
		    $("#datepickerDob" ).datepicker();
		  } );

		$( function() {
		    $( "#datepickerjoin12").datepicker();
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
</div>
