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
<script src="ckeditor/ckeditor.js"></script>
<div class="row">
	<div class="page-heading col-sm-12"
		style="background-color: #3C8DBD; height: 34px; text-align: center;">
		<strong> Mail/Fax Campaign </strong>
	</div>
</div>
<div id="body">
	<div class="container">
		<form:form class="well form-horizontal" name="forp"
			action="saveuserEmp" method="POST" commandName="userbean"
			id="validate-form">
			<fieldset>
				<div class="form-group">
					<label class="col-md-2 control-label">Campaign Type</label>
					<div class="col-md-3 inputGroupContainer">
						<div class="input-group">
							<strong><input type="radio" name="CampaignType"
								value="email">Email:</strong>

						</div>
					</div>
			</fieldset>
		</form:form>
	</div>
</div>