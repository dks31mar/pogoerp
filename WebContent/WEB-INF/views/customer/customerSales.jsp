<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
	
	</div>
</div>
<div class="row">
	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px; height: 44px; color: white; " >
		<span class="glyphicon glyphicon-user"></span> <span> Customer</span>
		<label style="margin-left: 250px;margin-top: 8px;"><a href="AddDiaryForEntrySales"class="btn btn-primary">Add Dairy</a></label>
		<label style="margin-left: 250px;margin-top: 8px;"><a href="CreateQuotationForm"class="btn btn-primary">Create Quotation</a></label>
		<label style="margin-left: 250px;margin-top: 8px;"><a href="AddFollowupForm"class="btn btn-primary">Add FallowUp</a></label>
		<label style="margin-left: 250px;margin-top: 8px;"><a href="editCustomerForm" class="btn btn-primary">Edit Customer</a></label>	
  
  		
	</div>
	
</div>
<form:form class="well form-horizontal"  action="saveuserEmp" method="POST"  commandName="userbean"
    id="" >
   
<fieldset>

<!-- Form Name -->
<legend>Add Customer</legend>
  <div class="form-group">
  <label class="col-md-2 control-label">Enquiry Date</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name=""    readonly="readonly" placeholder="Select Date" class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Order Expected In<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="empCode"  placeholder="Select Date" required="required" readonly="readonly" class="form-control"  type="text">
    </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-2 control-label">Organisation<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="loginname" placeholder="User Name" required="required"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Organisation Short Name<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  type="text"  class="form-control" name="dateofjoining" id="datepickerjoin"  readonly="readonly" placeholder="Select Date" >
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label">Initiated By<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select   name="firstname" placeholder="Employee Name"  required="required"  class="form-control" >
  <option value="" selected="selected">----Select Employee----</option>
  </select>
    </div>
  </div>
  <label class="col-md-2 control-label" >A/c Manager</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="designationId" placeholder="Manger"   class="form-control"  >
  <option value="" selected="selected">----Select Role----</option>
  <c:forEach items="${listofDeg}" var="designationList">
  <option value="${designationList.designationid}">${designationList.designation}</option>
  </c:forEach>
  </select>
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-2 control-label" >Address</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="middlename"   placeholder="Middle Name" id="firstUppermiddle" onkeyup="javascript:capitalizemiddle(this.id, this.value);" class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >State<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="dob"  id="datepickerDob" placeholder="Select Date" readonly="readonly" class="form-control" >
  </select>
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label" >District</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="lastname"      class="form-control" >
  </select>
    </div>
  </div>
  
  <label class="col-md-2 control-label" >Sub Location<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="subcompanyId" class="form-control selectpicker" required="required">
  <option value="" selected="selected">---Select SubCompany---</option> 
  <c:forEach items="${listofComp}" var="companylist">
  <option value="${companylist.companyinfoid}">${companylist.companyinfoname}</option>
  </c:forEach>
  </select>
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Contact Person</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="division" class="form-control selectpicker" required="required">
   <option>---Select Division---</option> 
      <option value="sales">Sales</option>
	  <option value="services">Services</option>
     
    </select>
  </div>
</div>
 <label class="col-md-2 control-label" >Telephone No.<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input  name="eamil"  placeholder="E-Mail Address" class="form-control" required="required" type="email">
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Email Id</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="region" class="form-control selectpicker" required="required">
    <option>---Select Region---</option>
      <option value="Delhi NCR">Delhi NCR</option>
	 <option value="Noida">Noida</option>
     
    </select>
  </div>
</div>
 <label class="col-md-2 control-label" >Status<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <select name="password"   class="form-control" required="required" >
  <option>---Select Status---</option>
  </select>
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Mobile</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="branchId" class="form-control selectpicker" required="required">
      <option value="" selected="selected">---Select Branch---</option>
      <c:forEach items="${listofBranch}" var="listofBranch">
       <option value="${listofBranch.branchId}">${listofBranch.branchname}</option>
      </c:forEach>
     
    </select>
  </div>
</div>
 <label class="col-md-2 control-label" >Category<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <select name="repassword" class="form-control">
  <option value="" selected="selected">---Select Branch---</option>
  </select>
    </div>
  </div>
</div> 

<!-- Success message -->

<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" onclick="message();" >Send <span class="glyphicon glyphicon-send"></span></button>
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>

</fieldset>
</form:form>

