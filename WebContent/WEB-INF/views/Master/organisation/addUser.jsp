
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<form:form class="well form-horizontal" name="forp"
			action="saveuserEmp" method="POST" commandName="userbean" id="myForm">

			<fieldset>

				<!-- Form Name -->
				<legend>Add Employee</legend>
				<div class="form-group">
					<label class="col-md-2 control-label">Employee Id</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name=""
								readonly="readonly" class="form-control" type="text">
						</div>
					</div>
					<label for="alpha" class="col-md-2 control-label">Employee
						Code<span style="color: red;">*</span>
					</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="empCode"
								placeholder="Enter Employee Code" required="required"
								pattern="[a-zA-Z0-9]+" id="alpha" class="form-control"
								type="text">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Login Name<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="loginname"
								placeholder="User Name" required="required" pattern="[a-zA-Z]+"
								class="form-control" type="text">
						</div>
					</div>
					<label class="col-md-2 control-label">Joining Date<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-calendar"></i></span> <input type="text"
								class="form-control" name="dateofjoining" id="datepickerjoin"
								readonly="readonly" placeholder="Select Date">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">First Name<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="firstname"
								placeholder="Letters Only" pattern="^[a-zA-Z](\s?[a-zA-Z]){2,20}$" id="firstname"
								required="required"
								onkeyup="javascript:capitalize(this.id, this.value);"
								class="form-control" type="text">
						</div>
					</div>
					<label class="col-md-2 control-label">Designation</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <select
								name="designationId" placeholder="Manger" class="form-control">
								<option value="" selected="selected">----Select
									Role----</option>
								<c:forEach items="${listofDeg}" var="designationList">
									<option value="${designationList.designationid}">${designationList.designation}</option>
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
								placeholder="Middle Name" id="firstUppermiddle" pattern="^[a-zA-Z](\s?[a-zA-Z]){2,20}$"
								onkeyup="javascript:capitalizemiddle(this.id, this.value);"
								class="form-control" type="text">
						</div>
					</div>
					<label class="col-md-2 control-label">DOB<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-calendar"></i></span> <input name="dob"
								id="datepickerDob" placeholder="Select Date" readonly="readonly"
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
								placeholder="Last Name" id="firstlastupper" pattern="^[a-zA-Z](\s?[a-zA-Z]){3,20}$"
								onkeyup="javascript:capitalizelast(this.id, this.value);"
								class="form-control" type="text">
						</div>
					</div>

					<label class="col-md-2 control-label">SubCompany<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <select
								name="subcompanyId" class="form-control selectpicker"
								required="required">
								<option value="" selected="selected">---Select
									SubCompany---</option>
								<c:forEach items="${listofComp}" var="companylist">
									<option value="${companylist.companyinfoid}">${companylist.companyinfoname}</option>
								</c:forEach>
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
								class="form-control selectpicker" required="required">
								<option>---Select Division---</option>
								<option value="sales">Sales</option>
								<option value="services">Services</option>

							</select>
						</div>
					</div>
					<label class="col-md-2 control-label">E-Mail<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="eamil"
								placeholder="E-Mail Address"
								pattern="^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$"
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
								class="form-control selectpicker" required="required">
								<option>---Select Region---</option>
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
								class="form-control" id="Password1" placeholder="Password" 
								required="required" type="password">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Branch</label>
					<div class="col-md-3 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="branchId"
								class="form-control selectpicker" required="required">
								<option value="" selected="selected">---Select
									Branch---</option>
								<c:forEach items="${listofBranch}" var="listofBranch">
									<option value="${listofBranch.branchId}">${listofBranch.branchname}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<label class="col-md-2 control-label">RePassword<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input name="repassword"
								class="form-control" id="ConfirmPassword"
								placeholder="Repassword" onblur="pass_validation();"
								type="password">
						</div>
					</div>
				</div>
				<!-- Text input-->

				<div class="form-group">
					<label class="col-md-2 control-label">Mobile #<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input
								name="usermobile" class="form-control" placeholder="8285080678"
								pattern="^\d{1,10}$" type="text" required="required">
						</div>
					</div>
					<label class="col-md-2 control-label">Phone #</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-phone-alt"></i></span> <input name="phone"
								class="form-control" placeholder="0845-555-1212" type="tel"
								pattern="^\d{4}-\d{3}-\d{4}$" required="required">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label">Department<span
						style="color: red;">*</span></label>
					<div class="col-md-3 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="department"
								class="form-control selectpicker" required="required">
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
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="gender"
								class="form-control selectpicker">
								<option>--- Select Gender---</option>
								<option value="Male">Male</option>
								<option value="female">female</option>
								<option value="other">Other</option>
							</select>
						</div>
					</div>
					<label class="col-md-2 control-label">Address<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span>
							<textarea class="form-control" name="address"
								placeholder="Address" required="required"></textarea>
						</div>
					</div>
				</div>
				<!-- Success message -->

				<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-2" align="center">
						<button type="submit" class="btn btn-warning" onclick="message();">
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
	$(function() {
		$("#datepickerDob").datepicker();

	});

	$(function() {
		$("#datepickerjoin").datepicker();

	});

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

	function pass_validation() {
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
		var pass1 = $('#Password1').val();
		var confirmpass = $('#ConfirmPassword').val();

		if (pass1 != '' || confirmpass != '') {

			var checkvar = checkpassword(pass1, confirmpass);
			if (checkvar == false) {

				alert("Password not match")
			}
		}

	}

	function checkpassword(pass1, confirmpass) {
		if (pass1 != confirmpass) {
			return false;
		}
	}

	function capitalize(firstUpper, str) {
		if (str && str.length >= 1) {
			var firstChar = str.charAt(0);
			var remainingStr = str.slice(1);
			str = firstChar.toUpperCase() + remainingStr;
		}
		document.getElementById(firstUpper).value = str;
	}
	function capitalizemiddle(firstUppermiddle, str) {
		if (str && str.length >= 1) {
			var firstChar = str.charAt(0);
			var remainingStr = str.slice(1);
			str = firstChar.toUpperCase() + remainingStr;
		}
		document.getElementById(firstUppermiddle).value = str;
	}
	function capitalizelast(firstlastupper, str) {
		if (str && str.length >= 1) {
			var firstChar = str.charAt(0);
			var remainingStr = str.slice(1);
			str = firstChar.toUpperCase() + remainingStr;
		}
		document.getElementById(firstlastupper).value = str;
	}
</script>

