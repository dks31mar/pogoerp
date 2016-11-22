<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

 <script type="text/javascript">
 function getstateList(id) {
		var url = 'getstate/' + id;
		$
				.ajax({
					url : url,

					type : 'POST',
					success : function(data, status) {
						$("#state").empty();
						var st = '<select name="stateId" onchange=getdistrictLists(this.value,'
								+ id
								+ ') class="form-control select style="width: 100%; height:31%;">'
								+ '<option value="">-- Select State --</option>';
						var j = JSON.parse(data);
						var length = j.length;
						for (var i = 0; i < length; i++) {
							st = st + '<option value=' + j[i].id + '>'
									+ j[i].state + '</option>';

						}
						st = st + '</select>';

						$("#state").append(st);

					},
					error : function(error, status) {

					}
				});

	}
 
 function getdistrictLists(id, countryId) 
 {
	 alert("hi");alert("State"+ id+""+"Country"+ countryId);
		var url = 'getdistrictList/' + id + '/' + countryId;
		$
				.ajax({
					url : url,

					type : 'POST',
					success : function(data, status) {
						$("#districts").empty();

						var st = '<select name="districtId" class="form-control select " style="width: 100%;" id="districtId">'
								+ '<option value="">-- Select District --</option>';
						var j = JSON.parse(data);
						var length = j.length;
						for (var i = 0; i < length; i++) {

							st = st + '<option value=' + j[i].id + '>'
									+ j[i].district + '</option>';

						}
						st = st + '</select>';

						$("#districts").append(st);

					},
					error : function(error, status) {
					}
				});
	}
 
 
 
 
 
 
 
 
 
 
	  $( function() {
		    $("#enquirydate" ).datepicker();
		    dateFormat : "yyyy-MM-dd"
		  } );

		$( function() {
		    $( "#orderdate").datepicker();
		    dateFormat : "yyyy-MM-dd"
		  } );
		</script>

<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
	
	</div>
</div>
<div class="row">
	<div class="page-heading col-sm-11"

		style="background-color: #3C8DBD; left: 20px; height: 54px; color: white; " >
		<span class="glyphicon glyphicon-user"></span><span> Customer</span>
		<label
			style="margin-left: 250px; margin-top: 8px;"><a
			href="getSalesList" class="btn btn-primary"> Sales List </a> </label> 

	
		<span class="glyphicon glyphicon-user"></span> <span> Customer</span>
		<label
			 style="margin-left: 250px;margin-top: 8px;"><a href="AddDiaryForEntrySales"
			class="btn btn-primary">Add Dairy</a>
			
     </label>
  		

	</div>
	
</div>
<form:form class="well form-horizontal"  action="saveCustomer" method="POST"  commandName="customerSalesBean" style="width: 1217px;">
<fieldset>

<!-- Form Name -->
<legend>Add Customer</legend>
  <div class="form-group">
  <label class="col-md-2 control-label">Enquiry Date</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="creationDate" readonly="readonly" id="enquirydate" placeholder="Select Date" class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Order Expected In<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="orderdate"  placeholder="Select Date" required="required" id="orderdate" readonly="readonly" class="form-control"  type="text">
    </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-2 control-label">Organisation<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="organisation" placeholder="User Name" required="required"  class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Organisation Short Name<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  type="text"  class="form-control" name="orgShortName"    placeholder="Name" >
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label">Initiated By<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select   name="empId"   required="required"  class="form-control" >
  <option value="" selected="selected">----Select Employee----</option>
  <c:if test="${!empty listemp}">
  <c:forEach items="${listemp}" var="list">
  <option value="${list.userempid}">${list.loginname}</option>
  
  </c:forEach>
 </c:if>
  
  </select>
    </div>
  </div>
  <label class="col-md-2 control-label" >A/c Manager</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="acmanager"   class="form-control"  >
   <option value="" selected="selected">----Select Role----</option>
  <c:if test="${!empty listemp}">
  <c:forEach items="${listemp}" var="List">
  <option value="${List.userempid}">${List.firstname}</option>
  </c:forEach>
  </c:if>
  </select>
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-2 control-label" >Address</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="address"   placeholder="Middle Name"  class="form-control"  type="text">
    </div>
  </div>
   <label class="col-md-2 control-label" >Country<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="countryId" class="form-control" onchange="getstateList(this.value)" >
  <option value="" selected="selected">----Select Country----</option>
  <c:if test="${!empty countrylist}">
  <c:forEach items="${countrylist}" var="list">
  <option value="${list.countryId}">${list.country}</option>
  </c:forEach>
  </c:if>
 
  </select>
    </div>
    </div>
    </div>
    <div class="form-group">
  <label class="col-md-2 control-label">State<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <div class="span9"  id="state">
  <select name="stateId"  id="state" onchange="getdistrictLists(this.value)"  class="form-control" >
  <option>----Select State----</option>
  </select>
    </div>
  </div>
</div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label" >District<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <div class="span9" id="districts">
  <select name="districtId"  id="districts"  class="form-control" >
  <option value="">---Select District---</option>
  
  </select>
    </div>
    </div>
  </div>
  
  <label class="col-md-2 control-label" >Sub Location<span style="color: red;">*</span></label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select name="sublocationId" class="form-control selectpicker" required="required">
  <option value="" selected="selected">---Select Sub Location---</option> 
  <c:if test="${!empty locList}">
   <c:forEach items="${locList}" var="list">
  <option value="${list.locationId}">${list.location}</option>
  </c:forEach>
  </c:if>
  </select>
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Contact Person</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <input name="contactPerson" class="form-control selectpicker" placeholder="Person Name" required="required" type="text">
  </div>
</div>
 <label class="col-md-2 control-label" >Telephone No.<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
  <input  name="telephoneNo"  class="form-control" placeholder="121-12457" required="required" type="text">
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Email Id</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
    <input name="emailId" class="form-control selectpicker"  placeholder="E-Mail Address" required="required" type="email">
    
  </div>
</div>
 <label class="col-md-2 control-label" >Status<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <select name="customerLevelId" class="form-control" required="required" >
  <option value="">--Select Status--</option>
  <c:if test="${!empty cusStatus}">
  <c:forEach items="${cusStatus}" var="statuslist">
  <option value="${statuslist.id}">${statuslist.status}</option>
  </c:forEach>
  </c:if>
  </select>
    </div>
  </div>
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Mobile</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
    <input name="mobileNo" class="form-control selectpicker" placeholder="Mobile No" required="required" type="text">
      
  </div>
</div>
 <label class="col-md-2 control-label" >Category<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
  <select name="category" class="form-control">
  <option value="" selected="selected">---Select Category---</option>
  <option value="retail">Retail</option>
   <option value="distributor">Distributor</option>
   <option value="stockist">Stockist</option>
   <option value="dealer">Dealer</option>
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

