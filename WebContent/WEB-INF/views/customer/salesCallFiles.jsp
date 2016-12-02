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



<div class="container" style="margin-top: 25px;">
  
  <div class="form-group">
    <input type="file" name="img[]" class="file">
    <div class="input-group col-xs-8">
      <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
      <input type="text" class="form-control input-sm" disabled placeholder="Upload Image">
      <span class="input-group-btn">
        <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>&nbsp;&nbsp;
     <span class="input-group-btn">
      <button class="browse btn btn-success input-sm" type="button"><i class="glyphicon glyphicon-upload"></i> Upload</button>
      </span>
    </div>
  </div>
  <div class="form-group">
    <input type="file" name="img[]" class="file">
    <div class="input-group col-xs-8">
      <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
      <input type="text" class="form-control input-sm" disabled placeholder="Upload Image">
      <span class="input-group-btn">
        <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>&nbsp;&nbsp;
      <span class="input-group-btn">
      <button class="browse btn btn-success input-sm" type="button"><i class="glyphicon glyphicon-upload"></i> Upload</button>
      </span>
    </div>
  </div>
  <div class="form-group">
    <input type="file" name="img[]" class="file">
    <div class="input-group col-xs-8">
      <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
      <input type="text" class="form-control input-sm" disabled placeholder="Upload Image">
      <span class="input-group-btn">
        <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>&nbsp;&nbsp;
      <span class="input-group-btn">
      <button class="browse btn btn-success input-sm" type="button"><i class="glyphicon glyphicon-upload"></i> Upload</button>
      </span>
    </div>
  </div>
</div><br><br>



