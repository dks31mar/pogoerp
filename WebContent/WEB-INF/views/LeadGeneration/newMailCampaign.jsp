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
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						<div class="col-md-6">
							<strong>Campaign Type<span style="color: red;">*</span>:
							</strong>
						</div>
						<label class="radio-inline">
							<div class="col-md-3">
								<strong><input type="radio" name="CampaignType"
									value="email">Email:</strong>
							</div>
						</label> <label class="radio-inline">
							<div class="col-md-3">
								<strong><input type="radio" name="CampaignType"
									value="fax">Fax:</strong>
							</div>
						</label>
						<!-- </div> -->
					</div>
				</div>


				<div class="form-group">
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						<div class="col-md-6">
							<strong>Campaign Name:<span style="color: red;">*</span></strong>
						</div>
						<div class="col-md-4">
							<input type="text">
						</div>
						<!-- </div> -->
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						<div class="col-md-6">
							<strong>From Address :<span style="color: red;">*</span></strong>
						</div>
						<div class="col-md-4">
							<select class="form-control" id="sel1">
								<option value="">-----Select Email-----</option>
								<c:if test="${!empty Elist}">
									<c:forEach items="${Elist}" var="cur" varStatus="loop">
										<option value="${cur.emaillistid}">${cur.emaillist}</option>
									</c:forEach>
								</c:if>

							</select><span>Example Your Name &lt yourid@yoursite.com &gt</span>
						</div>
						<div class="col-md-2">
							<a href="addemail">Add FromEmail</a>
						</div>
						<!-- </div> -->
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						<div class="col-md-6">
							<strong>To recipient :<span style="color: red;">*</span></strong>
						</div>
					</div>
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						<div class="col-md-4">
							<strong>No. of Email address selected = 0</strong>
						</div>
						<div class="col-md-2">
							<a href="addaddress">Add Address</a>
						</div>
						<div class="col-md-2">
							<a href="Vieweditdelete">View/Edit/Delete</a>
						</div>
						<div class="col-md-2">
							<a href="selectMailingList">Select Mailing List</a>
						</div>
						<div class="col-md-2">
							<a href="selectFromContacts">Select from Contacts </a>
						</div>
						<div class="col-md-2">
							<a href="selectFromSalesCalls">Select from SalesCall</a>
						</div>
					</div>
					<!-- </div> -->
					<!-- <div class="row"> -->
					<div class="col-md-12 inputGroupContainer">
						<div class="col-md-4">
							<strong>No. of Fax numbers selected = 0</strong>
						</div>
					</div>
					<!-- <div class="row"> -->
					<div class="col-md-12 inputGroupContainer">
						<div class="col-md-4">
							<strong>No. of Mailing List = 0</strong>
						</div>
					</div>

				</div>




				<div class="form-group">
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						<div class="col-md-6">
							<strong>Subject Line<span style="color: red;">*</span></strong>
						</div>
						<div class="col-md-4">
							<input type="text">
						</div>
						<!-- </div> -->
					</div>
				</div>



				<div class="form-group">
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						<div class="col-md-6">
							<strong>(Maximum three files)</strong>
						</div>
						<div class="col-md-4">
							<input type="text" value="--no attachment--">
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						<div class="col-md-6">
							<strong>Image Send as:</strong>
						</div>
						<!-- <label>	 -->
						<div class="col-md-3">
							<strong><input type="radio" name="imagesendas"
								value="includeinbody" />Include in Body</strong>
						</div>
						<!-- </label> -->
						<!--  <label> -->
						<div class="col-md-3">
							<strong><input type="radio" name="imagesendas"
								value="separateaslink" />Separate as Link</strong>
						</div>
						<!-- </label> -->
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-12 inputGroupContainer">
						<!-- <div class="row"> -->
						Write '##NAME##' in the header where you want to print the
						recipient name Example Dear ##NAME## in the header will print Dear
						Abc,if customer name is Abc <br>
						<span style="color: red; text-align: center;">Image Name
							should not have any space </span> Editor Tip :Use 'Shift+Enter' to
						insert one line space. 'Enter' will insert 2 lines spaces. Upload
						image [?]
						<textarea cols="50" rows="10" name="message" class="ckeditor"
							id="editor1"></textarea>
					</div>
				</div>

			</fieldset>
		</form:form>
	</div>
</div>
<link href="resources/css/prettify.css" rel="stylesheet" type="text/css" />
<script src="resources/js/jquery.jrumble.1.3.min.js"></script>
<script src="resources/js/jquery.jrumble.1.3.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>