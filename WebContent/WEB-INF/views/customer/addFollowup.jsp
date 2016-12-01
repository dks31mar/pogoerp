
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" /> 
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />


   <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<!-- <link rel="stylesheet" type="text/css" href="resources/time/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/time/dist/bootstrap-clockpicker.min.css">
<link rel="stylesheet" type="text/css" href="resources/time/assets/css/github.min.css"> -->

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
function getData(id)
{
	alert(id);
	var url='getCustomerRecord/' + id;
	$
	.ajax({
		url :url,
		type : 'POST',
		success : function(data,status)
		{
			var j=JSON.parse(data);
			alert(j);
			
		},
		error : function(error, status) {
alert("error");
		}
		
	});
	}
</script>




<script type="text/javascript">
  $( function() {
		    $("#followdate").datepicker();
		    
		  });
  
  $('.clockpicker').clockpicker({
	    placement: 'top',
	    align: 'left',
	    donetext: 'Done'
	});
</script>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
	
	</div>
</div>
<div class="row">
	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; color:white; left: 20px;  height: 44px;">
		<span class="glyphicon glyphicon-file"> </span> <span> Add Activity</span>
		
</div>
</div>
 <!-- <div class="form-group">
		<div class="input-group clockpicker" data-placement="top" data-align="left" data-donetext="Done">
			<input type="text" class="form-control" value="18:00">
			<span class="input-group-addon">
				<span class="glyphicon glyphicon-time"></span>
			</span>
		</div>
		</div>  -->
		
		<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Customer Status</h4>
        </div>
        <div class="modal-body">
        <form:form action="" method="" commandName="">
        <div class="form-group">
            <label  class="col-md-2 control-label"><strong> Customer Name</strong><span
					style="color: red;">*</span></label>
					<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input type="text" name="" class="form-control">
            </div><br>
            <label class="col-md-2 control-label"><strong>Status</strong><span
					style="color: red;">*</span></label>
			<div class="input-group">
             <span class="input-group-addon"><i class="glyphicon glyphicon-star"></i></span>
			<select name="" class="form-control selectpicker">
		
			</select>
			</div>		
            </div>
            <div>
            
            <button type="button" class="btn btn-warning" style="margin-left: 586px;">Update</button>
            </div>
           
            </form:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
    
  </div>

<div class="container" style= "margin-left: 1px; width: 1227px;">

    <form:form class="well form-horizontal"  action="savefollowup" method="POST"  commandName="addFollowUpBean">
<fieldset>

<!-- Form Name -->
<legend>Add Followup</legend>
 <div class="form-group">
  <label class="col-md-2 control-label">Customer<span
					style="color: red;">*</span> </label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
   <select    class="form-control" name="followupDate" onclick="getData(this.value)" >
   <option value="" selected="selected">--Select Customer--</option>
   <c:if test="${!empty salesList}">
   <c:forEach items="${salesList}" var="list">
   <option value="${list.customerId}">${list.organisation}</option>
   </c:forEach>
   </c:if>
   </select>
    </div>
  </div>
  </div> 
  <div class="form-group">
  <label class="col-md-2 control-label">Address<span
					style="color: red;">*</span> </label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
   <input  type="text" value="" class="form-control" name="followupDate" id="followdate"  placeholder="Address" >
    </div>
  </div>
  <label class="col-md-2 control-label" >Status<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select   name="actionType"  required="required"  class="form-control selectpicker">
  <option>---Select Status---</option> 
      <option value="sales">Phone</option>
  </select>
    </div>
  </div>
</div>

  <div class="form-group">
  <label class="col-md-2 control-label">Date<span
					style="color: red;">*</span> </label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
   <input  type="text"  class="form-control" name="followupDate" id="followdate"  readonly="readonly" placeholder="Select Date" >
    </div>
  </div>
  <label class="col-md-2 control-label" >Action Type<span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <select   name="actionType"  required="required"  class="form-control selectpicker">
  <option>---Select Task---</option> 
      <option value="sales">Phone</option>
	  <option value="services">Sms</option>
      <option value="services">E-mail</option>
  </select>
    </div>
  </div>
</div>
 <div class="form-group">
  <label class="col-md-2 control-label"> Time In<span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
  <select name="followupTimeIn" class="form-control" style="width: 65px;" required="required">
  <option value="0">00</option>
  <option value="1">01</option>
  <option value="2">02</option>
  <option value="3">03</option>
  <option value="4">04</option>
  <option value="5">05</option>
  <option value="6">06</option>
  <option value="7">07</option>
  <option value="8">08</option>
  <option value="9">09</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  </select>
  <select name="followupTimeInMin" class="form-control" style="width: 65px;" required="required">
   <option value="0">00</option>
  <option value="1">01</option>
  <option value="2">02</option>
  <option value="3">03</option>
  <option value="4">04</option>
  <option value="5">05</option>
  <option value="6">06</option>
  <option value="7">07</option>
  <option value="8">08</option>
  <option value="9">09</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  <option value="24">24</option>
  <option value="25">25</option>
  <option value="26">26</option>
  <option value="27">27</option>
  <option value="28">28</option>
  <option value="29">29</option>
  <option value="30">30</option>
   <option value="31">31</option>
  <option value="32">32</option>
  <option value="33">33</option>
  <option value="34">34</option>
  <option value="35">35</option>
  <option value="36">36</option>
  <option value="37">37</option>
  <option value="38">38</option>
  <option value="39">39</option>
  <option value="40">40</option>
  <option value="41">41</option>
  <option value="42">42</option>
  <option value="43">43</option>
  <option value="44">44</option>
  <option value="45">45</option>
  <option value="46">46</option>
  <option value="47">47</option>
  <option value="48">48</option>
  <option value="49">49</option>
  <option value="50">50</option>
  <option value="51">51</option>
   <option value="52">52</option>
  <option value="53">53</option>
  <option value="54">54</option>
  <option value="55">55</option>
  <option value="56">56</option>
  <option value="57">57</option>
  <option value="58">58</option>
  <option value="59">59</option>
  
  
  </select>
  <!-- <input   name="followupTimeIn" placeholder="Enter Time out" id="clockpicker" required="required"  class="form-control"  type="text"> -->
    </div>
  </div>
  <label class="col-md-2 control-label">Contact Person <span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
   <input name="contactPerson"  class="form-control" type="text">
    </div>
  </div>
</div>

<div class="form-group">
 <label class="col-md-2 control-label" >Time Out <span style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
   <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
   <select name="followupTimeOut" class="form-control selectpicker" style="width: 65px;" required="required">
    <option value="0">00</option>
  <option value="1">01</option>
  <option value="2">02</option>
  <option value="3">03</option>
  <option value="4">04</option>
  <option value="5">05</option>
  <option value="6">06</option>
  <option value="7">07</option>
  <option value="8">08</option>
  <option value="9">09</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
   </select>
    <select name="followupTimeOutMin" class="form-control" style="width: 65px;" required="required">
   <option value="0">00</option>
  <option value="1">01</option>
  <option value="2">02</option>
  <option value="3">03</option>
  <option value="4">04</option>
  <option value="5">05</option>
  <option value="6">06</option>
  <option value="7">07</option>
  <option value="8">08</option>
  <option value="9">09</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  <option value="24">24</option>
  <option value="25">25</option>
  <option value="26">26</option>
  <option value="27">27</option>
  <option value="28">28</option>
  <option value="29">29</option>
  <option value="30">30</option>
   <option value="31">31</option>
  <option value="32">32</option>
  <option value="33">33</option>
  <option value="34">34</option>
  <option value="35">35</option>
  <option value="36">36</option>
  <option value="37">37</option>
  <option value="38">38</option>
  <option value="39">39</option>
  <option value="40">40</option>
  <option value="41">41</option>
  <option value="42">42</option>
  <option value="43">43</option>
  <option value="44">44</option>
  <option value="45">45</option>
  <option value="46">46</option>
  <option value="47">47</option>
  <option value="48">48</option>
  <option value="49">49</option>
  <option value="50">50</option>
  <option value="51">51</option>
  <option value="52">52</option>
  <option value="53">53</option>
  <option value="54">54</option>
  <option value="55">55</option>
  <option value="56">56</option>
  <option value="57">57</option>
  <option value="58">58</option>
  <option value="59">59</option>
  </select>
  
 <!--  <input name="followupTimeOut" class="form-control selectpicker" placeholder="Select Time In" required="required" type="text" id="datetimepicker"> -->
    </div>
  </div>
  <label class="col-md-2 control-label">Action Taken <span
					style="color: red;">*</span></label>  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
   <textarea rows="2" cols="35" name="actionTaken">
</textarea>
    </div>
    </div>
  </div>
  <div style="margin-left:20px;" ><a href="attachFiles" class="btn btn-success">Followup Attachment</a>
  <!-- <button type="button"  title="Change Status" class="btn btn-success" data-toggle="modal" data-target="#myModal">Change Customer Status</button> -->

<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-2" align="center">
    <button type="submit" class="btn btn-warning" >Save<span class="glyphicon glyphicon-send"></span></button> 
    <button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
    </div>
  </div>
</div>
</fieldset>
</form:form>
</div>




