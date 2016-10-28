<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
	
	<link rel="stylesheet" type="text/css"
	href="resources/css/tableview.css" />
<script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script src="resources/js/jquery.dialogBox.js" type="text/javascript"></script>

<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/ui-darkness/jquery-ui.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>

<style>
.modalDialog {
	position: fixed;
	font-family: Arial, Helvetica, sans-serif;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background: rgba(0, 0, 0, 0.8);
	z-index: 99999;
	opacity: 0;
	-webkit-transition: opacity 400ms ease-in;
	-moz-transition: opacity 400ms ease-in;
	transition: opacity 400ms ease-in;
	pointer-events: none;
}

.modalDialog:target {
	opacity: 1;
	pointer-events: auto;
}

.modalDialog>div {
	width: 725px;
	position: relative;
	margin: 5% auto;
	padding: 5px 20px 13px 20px;
	border-radius: 10px;
	background: #fff;
	background: -moz-linear-gradient(#fff, #999);
	background: -webkit-linear-gradient(#fff, #999);
	background: -o-linear-gradient(#fff, #999);
}
</style>

<script>
	function date()
	{
		//alert("hello");
		$( "#datepicker123" ).datepicker();	
	}
	
	
	function deletUser(id){
			$.ajax({
					url: "deleteuser?userempid="+id,
					type: "POST",
					
					success: function(result){
						window.location.reload();		    
					}});
				
			
	}
	
	function searchEmp(loginname) {
		//alert("hi");
		alert(loginname);
		$("#searchedRecord").empty();
		$("#body").show();
		$
				.ajax({

					type : "POST",
					url : 'searchEmployee',
					data : {
						'loginname' : loginname,
					},
					success : function(data) {
						var obj = JSON.parse(data);
						
						var content = '<table class="responstable" style="margin-top: 5px; border-radius: 5px;"><thead><tr>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">SN</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Employee Name</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Designation</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Edit</label></th>'
							+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Delete</label></th>'
							
						if (obj.length == 0) 
						{
							content += '<tr><td colspan="8"><font color="red" size="3">No record found.</font></td></tr>';
						} 
						else
						{
							$
							.each(
									obj,
									function(key, value) {
										content += '<tr height="30">';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.userempid
												+ '</td>';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.loginname + '</td>';
										content += '<td style="font-size: 13px; color:black;" class="corg_th">'
												+ value.designation
												+ '</td>';
												content += '<td style="font-size: 13px; color:black;" class="corg_th"><a href="#"  title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>'
													
													+ '</td>';		
										content += '<td style="font-size: 13px; color:black;" class="corg_th"><a title="Delete" href="#" onclick="deletUser(${user.userempid})"><span class="glyphicon glyphicon-trash"></span></a>'
											+ '</td></tr>';		
										

												
									});
					content += '</tbody></table>';
							}
						$("#body").hide();
					$("#searchedRecord").append(content);
					
				},
				error : function(e) {
					
				}
			});

	}	
$('#openModal').hide();
$('#addemp').hide();
$('#editemp').hide();

$( function() {
    $( "#datepickerDob" ).datepicker();
  } );

$( function() {
    $( "#datepickerjoin" ).datepicker();
  } );
  
 

	</script>
</head>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i>
			<h3></h3>
		</i> <input type="hidden" name="profile" value="0" />
	</div>
</div>

<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px">
		<span class="glyphicon glyphicon-user"></span> Staff Details
		 <label
			style="margin-left: 250px;"><a href="#openModal"
			class="btn btn-primary" id="edit12"> Add Employee </a> </label> <label
			style="margin-left: 405px;"><i
			class="glyphicon glyphicon-search"></i><input type="text"
			placeholder="Search by Employee" oninput="searchEmp(this.value)"
			style="color: black;"></label>
	</div>

</div>

<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable">

		<tbody>
			<tr>
				<th>S.N.</th>
				<th data-th="Driver details"><span>Employees Name</span></th>
				<th>Designation</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:if test="${!empty userlist}">
				<c:forEach items="${userlist}" var="user" varStatus="loop">

					<tr>
						<td>${user.userempid}</td>
						<td>${user.loginname}</td>
						<td>${user.designation}</td>

						<td><a href="saveuserEmp?userempid=${user.userempid}" title="Edit" id="edit"><span
								class="glyphicon glyphicon-pencil"></span></a></td>
						<%-- <td><a href="delete-user?id=${user.userempid}" title="Delete" onclick="deletUsert()"><span class="glyphicon glyphicon-trash"></span></a></td> --%>
						<td><a href="#" onclick="deletUser(${user.userempid})"><span
								class="glyphicon glyphicon-trash"></span></a></td>
					</tr>

				</c:forEach>
			</c:if>



		</tbody>
	</table>







</div>



<div class="row form-group">
	<div class="col-sm-7"></div>
</div>

<div id="openModal" class="modalDialog">

	<div>
	<form:form id="formID" action="saveuserEmp" method="POST"
			commandName="userbean"  >
		<a href="#close" title="Close" class="close">X</a>
		<td style="display: none;"><form:input path="userempid" type="hidden" 
		value="${user.userempid}" id=""></form:input> </td> 
		<span style="text-align: center;" id="addemp"><h3>Add Employee</h3></span>
		<span style="text-align: center;" id="editemp"><h3>Edit Employee</h3></span>
		
			<table class="flat-table">
				<tr>
					<td><span style="color: black;"> <strong>Login
								Name<span style="color: red;">*</span>:
						</strong></span></td>
					<td><form:input path="loginname" type="text" class="validate[required] text-input"
						style="border-radius: 5px;" value="${user.loginname}" name="loginname"
						placeholder="Username" maxlength="20" autofocus="autofocus"></form:input></td>
					<td><span style="color: black;">
							<strong>Joining Date<span
								style="color: red;">*</span>:
						</strong>
					</span></td>
					<td><form:input path="dateofjoining" type="text" class="validate[required] text-input"
						style="border-radius: 2px;" name="dateofjoining" value="${user.dateofjoining}" readonly="readonly"
						placeholder="Date" maxlength="20" id="datepickerjoin"></form:input></td>
				</tr>
				<tr>
					<td><span style="color: black;"> <strong>FirstName<span
								style="color: red;">*</span>:
						</strong></span></td>

					<td><form:input path="firstname" type="text" class="validate[required] text-input"
						style="border-radius: 5px;" name="firstname" value="${user.firstname}"
						placeholder="Firstname" maxlength="20"></form:input></td>

					<td><span style="color: black;"><strong>Designation<span
								style="color: red;">*</span>:
						</strong></span></td>
					<td><form:input path="designation" type="text" class="validate[required] text-input"
						style="border-radius: 5px;" name="designation" value="${user.designation}"
						placeholder="eg.Manager" maxlength="20"></form:input></td>

				</tr>
				<tr>
					<td><span style="color: black;"> <strong>LastName<span
								style="color: red;">*</span>:
						</strong></span></td>

					<td><form:input path="lastname" type="text" class="validate[required] text-input"
						style="border-radius: 5px;" name="lastname" value="${user.lastname}" placeholder="Lastname"
						maxlength="20"></form:input></td>

				<td><span style="color: black;"><strong>DOB<span
					style="color: red;">*</span>:
			</strong></span></td>
				<td><form:input path="dob"  type="text" id="datepickerDob" class="validate[required] text-input"
				style="border-radius: 5px;" readonly="readonly" name="dob" value="${user.dob}" placeholder="DD-MM-YY"
				maxlength="20"></form:input></td>
				
				</tr>
			
			<tr>
			<td><span style="color: black;"> <strong>Division<span
					style="color: red;">*</span>:
			</strong></span></td>
			<td><form:select path="division"><option value="none">-----Select Division------</option>
				<form:option value="Delhi">Delhi</form:option>
				<form:option value="Delhi">Noida</form:option>
			</form:select></td>
			
			<td><span style="color: black;"><strong>Email<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><form:input path="eamil"
				type="text" class="validate[required] text-input"
				style="border-radius: 5px;" name="eamil" value="${user.eamil}" placeholder="MailId"
				maxlength="30"></form:input></td>
			
			</tr>
			<tr>
			
			<td><span style="color: black;"> <strong>Region<span
					style="color: red;">*</span>:
			</strong></span></td>
			<td><form:select path="region"><option>------Select Region------</option>
				<form:option value="Delhi NCR">Delhi NCR</form:option>
				<form:option value="Noida">Noida</form:option>
			</form:select></td>
			
			<td><span style="color: black;"><strong>Password<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><form:input path="password" type="password"
				class="validate[required] text-input" value="${user.password}" style="border-radius: 5px;"
				name="password" placeholder="Password" maxlength="20"></form:input></td>
			</tr>
			<tr>
			
			<td><span style="color: black;"> <strong>Branch<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><form:select path="branch" name="branch"><option>------Select Branch------</option>
				<form:option value="Delhi NCR">Delhi NCR</form:option>
				<form:option value="Noida">Noida</form:option> 
			</form:select></td>
			
			<td><span style="color: black;"><strong>Re-Password<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><form:input path="repassword" type="password" class="validate[required] text-input"
				style="border-radius: 5px;" name="repassword" value="${user.repassword}"
				placeholder="Re-Password" maxlength="20"></form:input></td>
			
			</tr>
			<tr>
			
			<td><span style="color: black;"> <strong>Mobile<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><form:input  path="usermobile" type="text" class="validate[required] text-input"
				style="border-radius: 5px;" name="usermobile" value="${user.usermobile}"
				placeholder="9934012451" maxlength="20"></form:input></td>
			
			<td><span style="color: black;"><strong>Phone<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><form:input path="phone"  value="${user.phone}"
				type="text" class="validate[required] text-input"
				style="border-radius: 5px;" name="phone" placeholder="121-12456"
				maxlength="20"></form:input></td>
			</tr>
			<tr>
			
			<td><span style="color: black;"> <strong>Gender<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><form:select path="gender" name="gender"><option>------Select
					Gender------</option>
				<form:option value="Male">Male</form:option>
				<form:option value="Female">Female</form:option> 
			</form:select></td>
			
			<td><span style="color: black;">&nbsp<strong>Address<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><textarea
				name="address" cols="18" rows="2" value="${user.address}"
				style="border-radius:5px;" placeholder="Address"></textarea></td>
			</tr>
			</table>
			<button style="margin-left: 300px; margin-top: 6px;" type="submit"
				class="btn btn-primary">Save</button>
		</form:form>
	</div>
</div>
<script type="text/javascript">


var d= $('#chg').text();
$('#edit12').click(function(){
	$('#addemp').show();
	$('#editemp').hide();
});
$('#edit').click(function(){
	$('#openModal').show();
	$('#addemp').hide();
	$('#editemp').show();
});

</script>


