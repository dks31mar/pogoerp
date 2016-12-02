
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

  <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>



<script>
$( function() {
    $("#date" ).datepicker();
  });
$('#datetimepicker').datetimepicker({
	datepicker:false,
	format:'H:i',
	step:5
});
</script>

  <div id="pop" style="display: none;"></div>
   <div id="body">

<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i>
		
		</i> <input type="hidden" name="profile" value="0" />
	</div>
</div>
<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; color:white; left: 20px;  height: 64px;">
		<span class="glyphicon glyphicon-user"></span>New Entry in Diary</b></span>
		<label
			 style="margin-left: 250px;margin-top: 8px;"><a href="#"
			class="btn btn-primary"> View Diary Entries</a>
			
     </label>
     
  		
</div>

</div>
</div>   

<div class="container">

    <form:form class="well form-horizontal" name="forp" action="saveDiaryForEntrySales" method="POST"  commandName="addDiaryBean"
    id="" >
   
<fieldset>

<!-- Form Name -->
<legend>New Entry in Diary</legend>
  <div class="form-group">
  <label class="col-md-2 control-label">Date</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
   <input  type="text"  class="form-control" name="date" id="date" readonly="readonly" value="${salesList.creationDate}" placeholder="Select Date" >
    </div>
  </div>
  
  <label class="col-md-2 control-label" >Time<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input  id="datetimepicker"   placeholder="Enter Time"   name="time" class="form-control" readonly="readonly" type="text">
    </div>
  </div>
</div>

 <div class="form-group">
  <label class="col-md-2 control-label">Customer<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="Organization"  placeholder="Organization Name" required="required"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Contact Person <span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  type="text"  class="form-control" name="contacperson"  placeholder="Contact Person Name" type="text" >
    </div> 
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label">Planner <span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="tasktype" class="form-control selectpicker"  required="required"> 
      <option value="appointment">Appointment</option>
	  <option value="email">E-mail</option>
      <option value="fax">Fax</option>
      <option value="sms">SMS</option>
      <option value="Phone">Phone </option>
	 

    </select>
    </div>
  </div>
  <label class="col-md-2 control-label" >Plan For </label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="enteryuserId"  class="form-control">
  <c:forEach items="${listemp}" var="listemp">
  <option value="${listemp.userempid}">${listemp.loginname}</option>
  </c:forEach>
  </select>
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-2 control-label" >Mobile</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="mobileno"  class="form-control"   placeholder="8285080678" type="text" required="required">
    </div>
  </div>
  <label class="col-md-2 control-label" >Address<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
 <textarea rows="2" cols="33" name="address" >
</textarea>
    </div>
  </div>
</div>

<div class="form-group"> 
  <label class="col-md-2 control-label">Email	</label>
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input  name="email"  placeholder="E-Mail Address"  class="form-control"  required="required" type="email">
  </div>
</div>
 <label class="col-md-2 control-label" >Objective<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
     <div class="input-group">
 <textarea rows="2" cols="33" name="objective">
</textarea>
    </div>
    </div> 
  </div>
  
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" onclick="message();">Send<span class="glyphicon glyphicon-send"></span></button> 
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
    
  </div>
</div>
 
</fieldset>
</form:form>
</div>
</div>






