<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<!-- calender jquery-->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<!-- calender Bootstrap -->
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/> -->

  <!-- jquery -->
  <!-- <link rel="stylesheet" type="text/css" href="resources/css/jquery.dialogbox.css"/>
<script src="resources/plugins/jQuery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="resources/js/jquery.dialogBox.js" type="text/javascript"></script> -->

 <script type="text/javascript">
 function getstateList(id) {
		var url = 'getstate/' + id;
		$
				.ajax({
					url : url,

					type : 'POST',
					success : function(data, status) {
						$("#state").empty();
						var st = '<select name="stateId" onchange=getdistrictLists(this.value'
								
								+ ') class="form-control select style="width: 100%; height:31%;">'
								+ '<option value="">-- Select State --</option>';
						var j = JSON.parse(data);
						var length = j.length;
						for (var i = 0; i < length; i++) {
							st = st + '<option value=' + j[i].stateId + '>'
									+ j[i].state + '</option>';

						}
						st = st + '</select>';

						$("#state").append(st);

					},
					error : function(error, status) {

					}
				});

	}
 
  function getdistrictLists(id) 
 {
	 var url = 'getdistrictLists/' + id;
		$
				.ajax({
					url : url,
					type : 'POST',
					success : function(data, status) {
						 $("#districts").empty();
						var st = '<select name="districtId" class="form-control" style="width: 100%;" id="districtId">'
								+ '<option value="">-- Select District --</option>';
						var j = JSON.parse(data);
						var length = j.length;
						for (var i = 0; i < length; i++) {
							st = st + '<option value=' + j[i].districtId + '>'
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
		    $("#enquirydate" ).datepicker({dateFormat:'dd-MM-yyyy'});
		    
		  } );

		$( function() {
		    $( "#orderdate").datepicker({dateFormat: 'dd-MM-yyyy'});
		  } );
		
		var i=0;
		function contactP() 
		{
			i=parseInt(i)+parseInt(1);
			$.ajax({
				url:'contactPersons',
				type:'GET',
				success : function(data) {
					var f=JSON.parse(data);
					if(i==1){
					$.each(f, function(k, v) {
						$('#departOptions').append('<option value="'+k+'">'+v+'</option>');
						i=parseInt(i)+parseInt(2);
					});
					}
					
				},
				error:function(error,status)
				{
					alert("Not Reachable");
				}
				
			});
		}
		
		
		function contactDesignationdata() 
		{
			alert("hi");
			i=parseInt(i)+parseInt(1);
			$.ajax({
				url:'contactdesignation',
				type:'GET',
				success : function(data) {
					var f=JSON.parse(data);
					console.log(f.designation);
					if(i==1){
					$.each(f, function(k, v) {
						$('#designationOption').append('<option value="'+k+'">'+v+'</option>');
						i=parseInt(i)+parseInt(2);
					});
					}
					
				},
				error:function(error,status)
				{
					alert("Not Reachable");
				}
				
			});
		}
		</script>

<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
	
	</div>
</div>
<div class="row">
	<div class="page-heading col-sm-11"

		style="background-color: #3C8DBD; left: 20px; height: 44px; color: white; " >
		<span class="glyphicon glyphicon-user"></span> <span>Create Customer</span>
		<label
			style="margin-left: 540px;"><a 
			href="getSalesList" style="margin-top: -3px;" class="btn btn-primary"> Sales List </a> </label>
		
	</div>
	
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Contact Person</h4>
        </div>
        <div class="modal-body">
        <form:form action="savecontact" method="POST" commandName="contactBean">
        <div class="form-group">
            <label  class="col-md-2 control-label"><strong>  Name</strong><span
					style="color: red;">*</span></label>
					<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input type="text" name="contactName" class="form-control">
            </div><br>
            <label class="col-md-2 control-label"><strong>Designation</strong><span
					style="color: red;">*</span></label>
			<div class="input-group">
             <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
			<select name="" class="form-control" id="designationOption">
			<option value="" >--Select Designation--</option>
			</select>
			</div><br>
			<label class="col-md-2 control-label"><strong>Department</strong><span
					style="color: red;">*</span></label>
			<div class="input-group">
             <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
			<select name="depId" class="form-control" id="departOptions">
			<option>--Select Department--</option>
			
			</select>
			</div><br>
			<label class="col-md-2 control-label"><strong>Email</strong><span
					style="color: red;">*</span></label>
			<div class="input-group">
             <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
			<input name="contemail" class="form-control" type="text">
			</div><br>
			<label class="col-md-2 control-label"><strong>Phone</strong><span
					style="color: red;">*</span></label>
			<div class="input-group">
             <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
			<input name="phone" class="form-control" type="text">
			</div>					
            </div>
            <div>
            
            <button type="submit" class="btn btn-warning" style="margin-left: 406px;">Save</button>
             <button type="button" class="btn btn-warning" style="margin-left: 20px;" data-dismiss="modal">Close</button>
            </div>
           
            </form:form>
        </div>
        <div class="modal-footer">
         
        </div>
      </div>
    </div>
    
  </div>
<form:form class="well form-horizontal"  action="saveCustomer" method="POST"  commandName="customerSalesBean" style="width: 1217px;">
<fieldset>

<!-- Form Name -->
<legend>Add Customer</legend>
  <div class="form-group">
  <label class="col-md-2 control-label">Creation Date</label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input   name="creationDate" readonly="readonly" id="enquirydate" value="${today}" placeholder="Select Date" class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Expected Closer<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input   name="orderdate"  placeholder="Select Date" required="required" id="orderdate" readonly="readonly" class="form-control"  type="text">
    </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-2 control-label">Name<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="organisation" placeholder="Organisation Name"   class="form-control"  type="text">
    </div>
  </div>
  <label class="col-md-2 control-label" >Alias<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  type="text"  class="form-control" name="orgShortName"    placeholder="Name" >
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label">Created By<span
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

<div class="form-group">
  <label class="col-md-2 control-label" >Address</label> 
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <textarea name="address"   placeholder="Address"  class="form-control" rows="2" cols="35" ></textarea>
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
  <select name="stateId"  id="state" onchange="getdistrictLists(this.value);"  class="form-control" >
  <option>----Select State----</option>
  </select>
    </div>
  </div>
</div>
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
</div>
<div class="form-group"> 
  <label class="col-md-2 control-label">Telephone No.</label>
    <div class="col-md-3 selectContainer">
    <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
    <input name="telephoneNo"  class="form-control selectpicker" placeholder="121-12457" required="required" type="text">
  </div>
</div>
 <label class="col-md-2 control-label"> Contact Person<span style="color: red;">*</span></label>  
    <div class="col-md-3 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="contactPerson"  class="form-control" placeholder="Person Name" required="required" type="text">
    </div>
  </div><div><a href="#" onclick="contactP();" class="btn btn-success" data-toggle="modal" data-target="#myModal"  title="Add More">+</a></div>
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

<!-- bootstarp poup -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 