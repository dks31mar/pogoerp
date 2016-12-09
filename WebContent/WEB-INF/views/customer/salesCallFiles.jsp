<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
$(document).on('click', '.browse', function(){
  var file = $(this).parent().parent().parent().find('.file');
  file.trigger('click');
});
$(document).on('change', '.file', function(){
  $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
});
</script>

<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
	
	</div>
</div>
<div class="row">
	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px; height: 44px;  color: white; ">
		<span class="glyphicon glyphicon-file"></span> <span>Attach Files</span>
</div>
</div>

<style>
.file {
  visibility: hidden;
  position: absolute;
}
</style>

<!-- <input type="file" name="file">  
					<div class="form-group">
								<div class="col-sm-offset-3 col-sm-5">
									<input type="submit" class="btn btn-info"  value="Upload">
								</div>
							</div> -->
							
							<%-- <div class="panel-body">
				<form:form id="formID" action="filUplaod"
					commandName="customerFile" method="POST" enctype="multipart/form-data"
					class="form-horizontal form-groups-bordered validate"
					novalidate="novalidate">

					<div class="form-group" align="center">
						<fieldset>
							<div class="form-group">
								<div style="margin-left: 35px;">
									<font color="green" size="3">Upload File</font>
								</div>
							</div>


							<div class="form-group" align="center">
								<label for="field-2" class="col-sm-3 control-label">Select
									File<font color="red">*</font>:<br></label>
									<label><font color="red">
									File must be less than 450KB </font>
								</label>

								<div class="col-sm-5">
									<input name="file" id="image-file" type="file"
										 data-validate="required">
								</div>
							</div>
		
							  <!-- <script type="text/javascript">
								$('#image-file')
										.bind(
												'change',
												function() {
													if (this.files[0].size / 1024 / 1024 > 5) {
														alert('This file size is: '
																+ this.files[0].size
																/ 1024
																/ 1024
																+ "MB more than 5MB");
													}
												});
							</script>  -->
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-5">
									<input type="submit" class="btn btn-info" onsubmit="check();" value="Upload">
								</div>
							</div>
						</fieldset>
					</div>
					</form:form>
			</div>
 --%>
 <div class="container" style="margin-top: 25px;">
  <form:form  action="fileUplaod"
					commandName="customerFile" method="POST" enctype="multipart/form-data"
					class="form-horizontal form-groups-bordered validate"
					novalidate="novalidate">
					
   <div class="form-group">
    <input type="file" name="file" class="file">
    <div class="input-group col-xs-8">
      <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
      <input type="text" class="form-control input-sm" name="file" disabled placeholder="Upload Image">
      <span class="input-group-btn">
        <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>&nbsp;&nbsp;
     <span class="input-group-btn">
      <button class="browse btn btn-success input-sm" type="submit"><i class="glyphicon glyphicon-upload"></i> Upload</button>
      </span>
    </div>
  </div>
  <div class="form-group">
    <input type="file" name="file" class="file">
    <div class="input-group col-xs-8">
      <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
      <input type="text" class="form-control input-sm" name="file" disabled placeholder="Upload Image">
      <span class="input-group-btn">
        <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>&nbsp;&nbsp;
      <span class="input-group-btn">
      <button class="browse btn btn-success input-sm" type="submit"><i class="glyphicon glyphicon-upload"></i> Upload</button>
      </span>
    </div>
  </div>
  <div class="form-group">
    <input type="file" name="file" class="file">
    <div class="input-group col-xs-8">
      <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
      <input type="text" class="form-control input-sm" name="file" disabled placeholder="Upload Image">
      <span class="input-group-btn">
        <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>&nbsp;&nbsp;
      <span class="input-group-btn">
      <button class="browse btn btn-success input-sm" type="submit"><i class="glyphicon glyphicon-upload"></i> Upload</button>
      </span>
    </div>
  </div> 
  </form:form>
</div><br><br>
 


