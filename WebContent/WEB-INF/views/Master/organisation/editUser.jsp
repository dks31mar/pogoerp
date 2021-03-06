<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script> -->

<!-- calender jquery-->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">  




<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />



  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<script type="text/javascript">

	  $( function() {
		    $( "#datepickerDob" ).datepicker();
		  } );

		$( function() {
		    $( "#datepickerjoin" ).datepicker();
		  } );	  
	  </script>
<script type="text/javascript">
		function capitalize(firstname, str) {
		      if (str && str.length >= 1)
		      {       
		          var firstChar = str.charAt(0);
		          var remainingStr = str.slice(1);
		          str = firstChar.toUpperCase() + remainingStr;
		      }
		      document.getElementById(firstname).value = str;
		  }
		function capitalizemiddle(middlename, str) {
		      if (str && str.length >= 1)
		      {       
		          var firstChar = str.charAt(0);
		          var remainingStr = str.slice(1);
		          str = firstChar.toUpperCase() + remainingStr;
		      }
		      document.getElementById(middlename).value = str;
		  }
		function capitalizelast(firstlast, str) {
		      if (str && str.length >= 1)
		      {       
		          var firstChar = str.charAt(0);
		          var remainingStr = str.slice(1);
		          str = firstChar.toUpperCase() + remainingStr;
		      }
		      document.getElementById(firstlast).value = str;
		  }
		
		
			
			
			function pass_validation()
			{
				/* var firstpassword=document.forp.Password1.value;  
				var secondpassword=document.forp.ConfirmPassword.value;  

				if(firstpassword==secondpassword){  
				return true;  
				}  
				else{  
				alert("RePassword must be Same!!!");
				document.getElementById("ConfirmPassword").value="";
				document.getElementById("ConfirmPassword").focus();
				return false;  
				}   */
				var pass1=$('#Password1').val();
				var confirmpass=$('#ConfirmPassword').val();
				
				if(pass1!='' || confirmpass!=''){
					
					var checkvar=checkpassword(pass1,confirmpass);
					if(checkvar==false){
						
						alert("password not match")
					}
				}
				
				}
			
			function checkpassword(pass1,confirmpass){
				if(pass1!=confirmpass){
					return false;
				}
			}
			
	</script>

<style>
#success_message {
	display: Edited;
}
</style>
<html>
<body>


	
	<div class="container">


    <form:form class="well form-horizontal" action="update-employee" name="forp" method="POST" commandName="employeebean"
     enctype="multipart/form-data">
   
   <%--  <form:hidden path="userempid"/> --%>
   
<!-- Form Name -->
				<legend>Edit Employee</legend>

<!-- Text input-->


  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h6 class="modal-title">Upload Profile</h6>
        </div>
        <div class="modal-body">
           <div><input type="file" name="userProfile"></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
				
				 <div class="span6" style="margin-top: -5px; margin-left: 0px; width: 100px;">
		<div class="block">
			<div class="data-fluid">
				<div class="row-form" style="float: right:;">
					<div class="span3"></div>
					<div class="span9" style="float: right:;">
						<div class="span3" style="width: 100px; height: 50px;">
							<img src="image/empProfile/${employee.profile}" accept="image/*"
								style="width: 44px; height: 44px;" id="uploadimg123" title="Upload New Image">
								
						</div>
						
					</div>
				</div>

			</div>

		</div>

	</div> 



				

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-2 control-label">Employee Id</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								value="${employee.userempid}" name="userempid"
								readonly="readonly" class="form-control" type="text">
						</div>
					</div>
					<label class="col-md-2 control-label">Employee Code<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="empCode"
								value="${employee.empCode}" class="form-control"
								required="required" placeholder="A1243" type="text">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label">Login Name<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								value="${employee.loginname}" name="loginname"
								class="form-control" required="required" type="text">
						</div>
					</div>
					<label class="col-md-2 control-label">Joining Date</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-calendar"></i></span> <input
								value="${employee.dateofjoining}" name="dateofjoining"
								id="datepickerjoin" readonly="readonly"
								placeholder="Select Date" class="form-control" type="text">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">First Name<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input
								value="${employee.firstname}" name="firstname" id="firstname"
								onkeyup="javascipt:capitalize(this.id,this.value)"
								placeholder="First Name" class="form-control" type="text">
						</div>
					</div>
					<label class="col-md-2 control-label">Designation</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <select
								name="designationId" placeholder="Developer"
								class="form-control">
								<c:forEach items="${listofDeg}" var="deg">
									<option value="${deg.designationid}">${deg.designation}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-2 control-label">Middle Name</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="middlename"
								value="${employee.middlename}" id="firstmiddle"
								onkeyup="javascript:capitalizemiddle(this.id,this.value)"
								placeholder="MiddleName" class="form-control" type="text">
						</div>
					</div>
					<label class="col-md-2 control-label">DOB</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-calendar"></i></span> <input name="dob"
								value="${employee.dob}" id="datepickerDob"
								placeholder="Select Date of Birth" readonly="readonly"
								class="form-control" type="text">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Last Name</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="lastname"
								value="${employee.lastname}" id="firstlast"
								onkeyup="javascript:capitalizelast(this.id,this.value)"
								class="form-control" placeholder="Last Name" type="text">
						</div>
					</div>

					<label class="col-md-2 control-label">SubCompany</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <select
								name="subcompanyId" class="form-control selectpicker"
								required="required">
								<c:if test="${!empty listofComp}">
									<c:forEach items="${listofComp}" var="company">
										<option value="${company.companyinfoid}">${company.companyinfoname}</option>
									</c:forEach>
								</c:if>
								<%-- <option value="${employee.subcompany}">${employee.subcompany} 
      <option value="Relience">Relience</option>
	  <option value="Vodafone">Vodafone</option>--%>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Division</label>
					<div class="col-md-3 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="division"
								class="form-control selectpicker">
								<option value="${employee.division}">${employee.division}
								<option value="Delhi">Delhi</option>
								<option value="Delhi">Noida</option>

							</select>
						</div>
					</div>
					<label class="col-md-2 control-label">E-Mail<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="email"
								value="${employee.eamil}" placeholder="E-Mail Address"
								class="form-control" required="required" type="email">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Region</label>
					<div class="col-md-3 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="region"
								class="form-control selectpicker">
								<option value="${employee.region}">${employee.region}
								<option value="Delhi NCR">Delhi NCR</option>
								<option value="Noida">Noida</option>

							</select>
						</div>
					</div>
					<label class="col-md-2 control-label">Password<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input name="password"
								value="${employee.password}" id="password1" class="form-control"
								placeholder="Password" required="required" type="password">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Branch</label>
					<div class="col-md-3 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="branchId"
								class="form-control selectpicker">
								<c:if test="${!empty listofBranch}">
									<c:forEach items="${listofBranch}" var="branch">
										<option value="${branch.branchId}">${branch.branchname}</option>
									</c:forEach>
								</c:if>
								<%-- <option value="${employee.branch}">${employee.branch} 
      <option value="Delhi NCR">Delhi NCR</option>
	 <option value="Noida">Noida</option>--%>

							</select>
						</div>
					</div>
					<label class="col-md-2 control-label">RePassword<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input name="repassword"
								value="${employee.repassword}" placeholder="RePassword"
								onblur="pass_validation();" id="confirmPassword"
								class="form-control" required="required" type="password">
						</div>
					</div>
				</div>
				<!-- Text input-->


				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-2 control-label">Mobile #<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input
								name="usermobile" value="${employee.usermobile}"
								placeholder="8455551212" class="form-control"
								required="required" type="text">
						</div>
					</div>
					<label class="col-md-2 control-label">Phone #</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input name="phone"
								value="${employee.phone}" placeholder="(845)555-1212"
								class="form-control" type="text">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Department</label>
					<div class="col-md-3 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="depId"
								class="form-control selectpicker">
								<%-- <option value="${employee.depId}">${employee.depname}</option> --%>
								<c:if test="${!empty depList}">
									<c:forEach items="${depList}" var="list">
										<option value="${list.depId}">${list.depName}</option>
									</c:forEach>
								</c:if>
								<%-- <option value="${employee.department}">${employee.department}
      <option value="HR">HR</option>
	  <option value="DataEntry">Data Entry</option> --%>
     
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
    <select name="gender" class="form-control selectpicker" value="${employee.gender}">
      <option value="Male">Male</option>
      <option value="female">female</option>
    </select>
  </div>
  </div>
  
   <label class="col-md-2 control-label" >Address<span
					style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group" style="width: 215px;height: 70px;" >
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input  type="text" class="form-control" style="width: 215px;height: 70px;" name="address" value="${employee.address}" required="required" placeholder="Address">
    </div>
  </div>
</div>
<!-- Success message -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" >Send <span class="glyphicon glyphicon-send"></span></button>
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>


</fieldset>
		</form:form>
	</div>

			

</body>
</html>
<script>
$(document).ready(function(){
	$('#uploadimg123').on('click',function(){
		$('#myModal').modal('show'); 
	});
});

</script>