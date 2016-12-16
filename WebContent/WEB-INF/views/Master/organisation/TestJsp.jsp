<script>
	function getDescription(designationid) {
		alert(designationid);
		$.ajax({
			type : "GET",
			url : 'getdesignationId',
			data : {
				"designationid" : designationid,
			},
			success : function(data) {
				var obj = JSON.parse(data);
				alert(obj);
				var content = '<option value="">Select </option>';
				$.each(obj, function(key, value) {
					content += '<option value="'+value.designationid+'">'
							+ value.designation + '</option>';
				});
				$("#designationid").append(content);
			},
			error : function(e) {
				$('#loading').hide();
			}
		});
	}
</script>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/table.css" rel="stylesheet" type="text/css" />


<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 30px; height: 64px;">
		<span class="glyphicon glyphicon-user" style="margin-left: 70px;"></span>
		Designation

	</div>

</div>

<div class="container">

	<form:form class="well form-horizontal" action="saveuserTest"
		method="POST" commandName="userbeanTest" id="formID">

		<fieldset>
			<legend>Testing Map Designation</legend>
			<div class="form-group">
				<label class="col-md-2 control-label">Employee Name</label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="branchname"
							class="form-control" type="text">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <select
							path="designationid" class="form-control" name="designation"
							required="required" placeholder="Add New Designation">
							<c:forEach items="${deg}" var="deglist">
								<option value="${deglist.designationid}">${deglist.designation }</option>

							</c:forEach>
						</select>
					</div>
				</div>

				<br>
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-2">
						<button type="submit" class="btn btn-warning" id="sendLevel">
							Send <span class="glyphicon glyphicon-send"></span>
						</button>
						<button type="button" class="btn btn-warning"
							onclick="history.back();">
							Back <span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
				</div>
			</div>

		</fieldset>
	</form:form>
</div>
