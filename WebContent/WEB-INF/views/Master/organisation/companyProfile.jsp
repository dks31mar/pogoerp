
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<!-- <link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
    <script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script> -->



<style>
#success_message {
	display: Edited;
}
</style>





<div class="container">

	<form:form class="well form-horizontal" name="forp"
		action="savecompanyinfo" method="POST" id="">

		<fieldset>

			<!-- Form Name -->
			<legend>Add Company Details</legend>

			<a style="float: right; color: #b30059;"
				href="AddSignature.jsp?terms=Y"></a>

			<div class="form-group">
				<label class="col-md-2 control-label">Name<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input
							name="companyinfoname" id="firstlastupper" placeholder="Name"
							pattern="[a-zA-Z]+" class="form-control" type="text">
					</div>
				</div>
				<label class="col-md-2 control-label" style="margin-left: -62px;">Contact
					Person<span style="color: red;">*</span>
				</label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input
							name="companyinfocontactperson" id="capitalizelast"
							pattern="[a-zA-Z]+" placeholder="Enter Contect Person"
							required="required" class="form-control" type="text">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Contact No<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span> <input
							name="companyinfocontactno" placeholder="Contact No"
							required="required" pattern="^\d{1,10}$" class="form-control"
							id="contactno" type="text">
					</div>
				</div>

				<label class="col-md-2 control-label" style="margin-left: -62px;">Telephone
					No<span style="color: red;">*</span>
				</label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-phone-alt"></i></span> <input
							name="companyinfophone" placeholder="Telephone No"
							class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-2 control-label">Fax No<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-fax"></i></span> <input
							name="companyinfofax" placeholder="Fax No" class="form-control"
							type="text">
					</div>
				</div>
				<label class="col-md-2 control-label" style="margin-left: -62px;">E-Mail<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-envelope"></i></span> <input
							name="companyinfoemail" placeholder="E-Mail Address"
							class="form-control" required="required"
							pattern="^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$"
							type="email">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">VAT TIN/JST<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-tags"></i></span>
						<input name="companyinfovattin" placeholder="VAT TIN"
							id="firstlastupper" class="form-control" type="text">
					</div>
				</div>

				<label class="col-md-2 control-label" style="margin-left: -62px;">CST
					NO<span style="color: red;">*</span>
				</label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span> <input
							name="companyinfocstno" placeholder="CST NO" class="form-control"
							required="required" type="text">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">PAN<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-tags"></i></span>
						<input name="companyinfopan" placeholder="PAN"
							class="form-control" type="text">
					</div>
				</div>


				<label class="col-md-2 control-label" style="margin-left: -62px;">Service
					Tax Registration No<span style="color: red;">*</span>
				</label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-registered"></i></span>
						<input name="companyinfoservicetaxno"
							placeholder="Service Tax Registration No" class="form-control"
							required="required" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-2 control-label">Web Address<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span> <input
							name="companyinfoweb" placeholder="Web Address"
							class="form-control" type="text" required="required">
					</div>
				</div>


				<!-- Text input-->

				<label class="col-md-2 control-label" style="margin-left: -62px;">HO
					Address<span style="color: red;">*</span>
				</label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span>
						<textarea class="form-control" name="companyinfoaddress"
							placeholder="HO Address" required="required"></textarea>
					</div>
				</div>
			</div>
			<!-- Success message -->

			<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-3" align="center">
					<button type="submit" class="btn btn-warning" onclick="message();">
						Send <span class="glyphicon glyphicon-send"></span>
					</button>
					<button type="button" class="btn btn-warning"
						onclick="javascript:self.close();">
						Close <span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>

		</fieldset>
	</form:form>
</div>


<script>
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
		/*
		//Validation: allow only alphabets
		$('#firstlastupper').keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
            return true;
        }
        else
        {
        e.preventDefault();
        alert('Please Enter Alphabate');
        return false;
        }
    });
		  //for mobile no
		 $('input[name="number"]').keyup(function(e)
                                {
  if (/\D/g.test(this.value))
  {
    // Filter non-digits from input value.
    this.value = this.value.replace(/\D/g, '');
  }
});*/
</script>

