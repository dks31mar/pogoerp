
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />



<div class="container">

    <form:form class="well form-horizontal"  action="updatebranch" method="POST"  commandName="branchBean" >
   
   
<fieldset>

<!-- Form Name -->
<legend>Edit Branches</legend>
<div class="form-group">
  <label class="col-md-2 control-label" >Branch Name</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="branchId" value="${branch.branchId}" readonly="readonly"  class="form-control"  type="text">
  
    </div>
  </div>
  
</div>

<div class="form-group">
  <label class="col-md-2 control-label" >Branch Name</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="branchname" value="${branch.branchname}"  class="form-control"  type="text">
  
    </div>
  </div>
  
</div>

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
