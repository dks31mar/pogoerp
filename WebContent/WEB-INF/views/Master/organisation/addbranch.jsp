
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>




 <!-- <link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
    <script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script> -->
	
   

<style>

#success_message{ display: Edited;}
</style>



	 
<div id="message" style="display: none;"></div>
<div id="body">
<div class="container">

    <form:form class="well form-horizontal"  action="saveBranch" method="POST"  commandName="branchBean"
    id="" >
   
<fieldset>

<!-- Form Name -->
<legend>Add Branches</legend>
  

<div class="form-group">
  <label class="col-md-2 control-label" >Branch Name</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="branchname" placeholder="Branch Name"  class="form-control"  type="text">
  
    </div>
  </div>
  
  <label class="col-md-2 control-label" style="margin-left: -62px;">Branch Head<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="branchId" class="form-control selectpicker" required="required"  >
  <option value="" selected="selected">----Select State----</option>
  <c:forEach items="${liststates}" var="list">
  <option value="${list.stateId}">${list.stateName}</option>
  </c:forEach>
  </select>
    </div>
  </div>
</div>


<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" >Send <span class="glyphicon glyphicon-send"></span></button>
    
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>

</fieldset>
</form:form>
</div>
</div>