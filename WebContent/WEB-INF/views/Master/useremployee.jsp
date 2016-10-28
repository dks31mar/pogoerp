<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
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
	width: 730px;
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
			class="btn btn-primary"> Add Employee </a> </label> <label
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
						<!--  <td>${loop.index+1}</td>-->
						<td>${user.userempid}</td>
						<td>${user.loginname}</td>
						<td>${user.designation}</td>

						<td><a href="#" title="Edit"><span
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
		<a href="#close" title="Close" class="close">X</a> <span
			style="text-align: center;"><h2>Add Employee</h2></span><br>

		<form:form id="formID" action="saveuserEmp" method="POST"
			commandName="userbean">
			<table>
				<tr>
					<td><span style="color: black;"> <strong>Login
								Name<span style="color: red;">*</span>:
						</strong></span></td>
					<td><input type="text" class="validate[required] text-input"
						style="border-radius: 5px;" name="loginname"
						placeholder="Username" maxlength="20" autofocus="autofocus"></td>
					<td><span style="color: black;">
							<strong>Joining Date<span
								style="color: red;">*</span>:
						</strong>
					</span></td>
					<td><input type="text" class="validate[required] text-input"
						style="border-radius: 2px;" name="dateofjoining"
						placeholder="Date" maxlength="20"></td>

				</tr>

				<tr>
					<td><span style="color: black;"> <strong>FirstName<span
								style="color: red;">*</span>:
						</strong></span></td>

					<td><input type="text" class="validate[required] text-input"
						style="border-radius: 5px;" name="firstname"
						placeholder="Firstname" maxlength="20"></td>

					<td><span style="color: black;"><strong>Designation<span
								style="color: red;">*</span>:
						</strong></span></td>
					<td><input type="text" class="validate[required] text-input"
						style="border-radius: 5px;" name="designation"
						placeholder="eg.Manager" maxlength="20"></td>

				</tr>
				<tr>
					<td><span style="color: black;"> <strong>LastName<span
								style="color: red;">*</span>:
						</strong></span></td>

					<td><input type="text" class="validate[required] text-input"
						style="border-radius: 5px;" name="lastname" placeholder="Lastname"
						maxlength="20"></td>

				<td><span style="color: black;"><strong>DOB<span
					style="color: red;">*</span>:
			</strong></span></td>
				
				<td><input
				type="text" id="datepicker123" class="validate[required] text-input"
				style="border-radius: 5px;" name="dob" placeholder="DD-MM-YY"
				maxlength="20"></td>
				</tr>
			
			<tr>
			<td><span style="color: black;"> <strong>Division<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><select><option>---Select Division---</option>
				<option value="Delhi">Delhi</option>
				<option value="Delhi">Noida</option>
			</select></td>
			
			<td><span style="color: black;"><strong>Email<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><input
				type="text" class="validate[required] text-input"
				style="border-radius: 5px;" name="eamil" placeholder="MailId"
				maxlength="30"></td>
			
			</tr>
			
			
			<tr>
			
			<td><span style="color: black;"> <strong>Region<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><select><option>----Select Region----</option>
				<option value="Delhi NCR">Delhi NCR</option>
				<option value="Noida">Noida</option>
			</select></td>
			
			<td><span style="color: black;"><strong>Password<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><input type="text"
				class="validate[required] text-input" style="border-radius: 5px;"
				name="password" placeholder="Password" maxlength="20"></td>
			
			
			</tr>
			
			
			<tr>
			
			<td><span style="color: black;"> <strong>Branch<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><select><option>----Select Branch----</option>
				<option value="Delhi NCR">Delhi NCR</option>
				<option value="Noida">Noida</option> 
			</select></td>
			
			<td><span style="color: black;"><strong>Re-Password<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><input type="text" class="validate[required] text-input"
				style="border-radius: 5px;" name="repassword"
				placeholder="Re-Password" maxlength="20"></td>
			
			
			</tr>
			
			
						<tr>
			
			<td><span style="color: black;"> <strong>Mobile<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><input type="text" class="validate[required] text-input"
				style="border-radius: 5px;" name="usermobile"
				placeholder="9934012451" maxlength="20"></td>
			
			<td><span style="color: black;"><strong>Phone<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><input
				type="text" class="validate[required] text-input"
				style="border-radius: 5px;" name="phone" placeholder="121-12456"
				maxlength="20"></td>
			
			
			</tr>
			
			
			<tr>
			
			<td><span style="color: black;"> <strong>Gender<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><select name="gender"><option>---Select
					Gender---</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option> 
			</select></td>
			
			<td><span style="color: black;">&nbsp<strong>Address<span
					style="color: red;">*</span>:
			</strong></span></td>
			
			<td><textarea
				name="address" cols="20" rows="2"
				border-radius:5px;" placeholder="Address"></textarea></td>
			
			
			</tr>
			

			</table>
			<button style="margin-left: 282px; margin-top: -5px;" type="submit"
				class="btn btn-primary">Save</button>
		</form:form>
	</div>


</div>



