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


<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<input type="hidden" name="profile" value="0" />
	</div>
</div>



<div id="body">
	<div class="container">

		<form:form class="well form-horizontal" name="forp" action=""
			method="POST" commandName="" id="">
			<fieldset>
				<legend> Contacts </legend>
				<div class="form-group">
					<label class="col-md-2 control-label">Name<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="" id="name"
								placeholder="Enter Name" class="form-control" type="text"
								required="required">
							<div id="msg0" align="center">
								<span style="color: red">*Input Needed</span>
							</div>
						</div>
					</div>

					<label class="col-md-2 control-label" style="">Email<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input
								name="designation" placeholder="Enter Email"
								class="form-control" type="email" id="email">
							<div id="msg1" align="center">
								<span style="color: red">*Input Needed</span>
							</div>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-2 control-label" style="">Phone<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-phone-alt"></i></span> <input
								name="designation" placeholder="Enter phone"
								class="form-control" type="text" id="phone">
							<div id="msg2" align="center">
								<span style="color: red">*Input Needed</span>
							</div>
						</div>
					</div>

					<label class="col-md-2 control-label">Designation<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <select
								class="form-control" id="designation" name="desId">
								<option value="">-----Select Designation-----</option>
								<c:if test="${!empty Dlist}">
									<c:forEach items="${Dlist}" var="cur">
										<option value="${cur.designationid}">${cur.designation}</option>
									</c:forEach>
								</c:if>
							</select>
							<div id="msg3" align="center"></div>
						</div>
					</div>

				</div>

				<div class="form-group">

					<label class="col-md-2 control-label" style="">Department<span
						style="color: red;">*</span></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <select
								class="form-control selectpicker" id="department">
								<option value="">-----Select Department-----</option>
								<c:if test="${!empty depList}">
									<c:forEach items="${depList}" var="depList">
										<option value="${depList.depId}">${depList.depName}</option>
									</c:forEach>
								</c:if>

							</select>
							<div id="msg4" align="center">
								<span style="color: red">*Input Needed</span>
							</div>
						</div>
					</div>
					<label class="col-md-2 control-label">Date of birth<span
						style="color: red;">*</span></label></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
							<input name="middlename" placeholder="Select DOB" id="dob"
								class="form-control" type="text">
							<div id="msg5" align="center">
								<span style="color: red">*Input Needed</span>
							</div>
						</div>
					</div>

				</div>
				<div class="form-group">


					<label class="col-md-2 control-label">Date of anniversary<span
						style="color: red;">*</span></label></label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
							<input name="lastname" placeholder="Select DOA" id="doa"
								class="form-control" type="text">
							<div id="msg6" align="center">
								<span style="color: red">*Input Needed</span>
							</div>
						</div>
					</div>


				</div>





				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-2" align="center">
						<button type="button" id="savecontactForm" class="btn btn-warning">
							Save<span class="glyphicon glyphicon-send"></span>
						</button>

					</div>
				</div>

			</fieldset>
		</form:form>
	</div>
</div>
<script>
	$('#msg0').hide();
	$('#msg1').hide();
	$('#msg2').hide();
	$('#msg3').hide();
	$('#msg4').hide();
	$('#msg5').hide();
	$('#msg6').hide();

	$('#savecontactForm').click(function() {

		var name = $('#name').val();
		var depId = $('#department').val();
		var desId = $('#designation').val();
		var phone = $('#phone').val();
		var email = $('#email').val();
		var dob = $('#dob').val();
		var doa = $('#doa').val();

		if (name == '') {
			/* $("#expenseheadspan").show(); */
			$('#msg0').show('fast');

		} else if (department == '') {
			/* $("#expensetypespan").show(); */
			$('#msg1').show('fast');
		} else if (designation == '') {
			/* $("#expensetypespan").show(); */
			$('#msg2').show('fast');
		} else if (phone == '') {
			/* $("#expensetypespan").show(); */
			$('#msg3').show('fast');
		} else if (email == '') {
			/* $("#expensetypespan").show(); */
			$('#msg4').show('fast');
		} else if (dob == '') {
			/* $("#expensetypespan").show(); */
			$('#msg5').show('fast');
		} else if (doa == '') {
			/* $("#expensetypespan").show(); */
			$('#msg6').show('fast');
		} else {
			var jsonObj = {
				'contactName' : name,
				'depId' : department,
				'desId' : designation,
				'phone' : phone,
				'contemail' : email,
				'dob' : dob,
				'doa' : doa
			};
			$.ajax({
				url : "savecontact123",
				type : "POST",

				data : JSON.stringify(jsonObj),
				cache : false,
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(resposeJsonObject) {
					$('#openModal').hide();
					//window.location.currency;
					window.location.reload();

				}
			});
		}
	});

	$('#name,#department,#designation,#phone,#email,#dob,#doa').click(
			function() {
				$('#msg0').hide();
				$('#msg1').hide();
				$('#msg2').hide();
				$('#msg3').hide();
				$('#msg4').hide();
				$('#msg5').hide();
				$('#msg6').hide();

			});

	$(function() {
		$("#doa").datepicker();
	});
	$(function() {
		$("#dob").datepicker();
	});
</script>