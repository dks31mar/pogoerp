
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />


<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

  <div id="pop" style="display: none;"></div>
<div id="body">

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
		style="background-color: #3C8DBD; color:white; left: 20px;  height: 64px;">
		<span class="glyphicon glyphicon-user"></span>New Entry in Diary</b></span>
		<label
			 style="margin-left: 250px;margin-top: 8px;"><a href="AddDiaryForEntrySales"
			class="btn btn-primary"> View Diary Entries</a>
			
     </label>
     
  		
</div>

</div>
</div>   
<div id="message" style="display: none;"></div>
<div id="body">
<div class="container">

    <form:form class="well form-horizontal" name="forp" action="" method="POST"  commandName=""
    id="" >
   
<fieldset>

<!-- Form Name -->
<legend>New Entry in Diary</legend>
  <div class="form-group">
  <label class="col-md-2 control-label">Date</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
   <input  type="text"  class="form-control" name="dateofjoining" id="datepickerjoin"  readonly="readonly" placeholder="Select Date" >
    </div>
  </div>
  <label class="col-md-2 control-label" >Time<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="Time"  placeholder="Enter Time " required="required"  class="form-control"  type="text">
    </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-2 control-label"> Organization<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="Organization" placeholder="Organization Name" required="required"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Contact Person <span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  type="text"  class="form-control" name="Contact Person " placeholder="Contact Person Name" type="text" >
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label">Task Type <span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="task" class="form-control selectpicker" required="required">
   <option>---Select Task---</option> 
      <option value="sales">Phone</option>
	  <option value="services">Sms</option>
      <option value="services">E-mail</option>
    </select>
    </div>
  </div>
  <label class="col-md-2 control-label" >Entry For </label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="Entryuser" placeholder="Entry"   class="form-control"  >
  <option value="" selected="selected">----Select Entry user----</option>
  <option value="sales">satyendra</option>
	  <option value="services">deepak</option>
 <!--  > <c:forEach items="${listofDeg}" var="designationList">
  <option value="${designationList.designationid}">${designationList.designation}</option>
  </c:forEach>
  -->
  </select>
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-2 control-label" >Deciding Authority</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="Authority"   placeholder="Authority Name"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Address	<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
 <textarea rows="2" cols="33">
</textarea>
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label" >Mobile </label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="usermobile"  class="form-control" placeholder="8285080678" type="text" required="required">
    </div>
  </div>
  
  <label class="col-md-2 control-label" >Fax No<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
   <input name="faxno"   placeholder="Fax No"  class="form-control"  type="text">
  
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Email	</label>
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input  name="eamil"  placeholder="E-Mail Address" class="form-control" required="required" type="email">
  </div>
</div>
 <label class="col-md-2 control-label" >Objective<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
     <div class="input-group">
 <textarea rows="2" cols="33">
</textarea>
    </div>
  </div>
</div>

  </div>

<!--  
 <label class="col-md-2 control-label" >Password<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <input name="password"   class="form-control" id="Password1" placeholder="Password" required="required" type="password">
    </div>
  </div>
</div>
-->

<!-- Text input-->

<!-- Success message -->

<!-- <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for Register</div> -->
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" onclick="message();" >Save<span class="glyphicon glyphicon-send"></span></button> 
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
    
  </div>
</div>
</fieldset>
</form:form>
</div>
</div>



