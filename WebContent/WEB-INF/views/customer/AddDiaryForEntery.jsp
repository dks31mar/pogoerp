
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />



<script>
$( function() {
    $("#date" ).datepicker({dateFormat: 'dd/mm/yy'});
  });
$('#datetimepicker').datetimepicker({
	datepicker:false,
	format:'H:i',
	step:5
});
</script>


<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i> </i> <input type="hidden" name="profile" value="0" />
	</div>
</div>
<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; color: white; left: 20px; height: 64px;">
		<span class="glyphicon glyphicon-user"></span>New Entry in Diary</span> <label
			style="margin-left: 250px; margin-top: 8px;"><a href="#"
			class="btn btn-primary"> View Diary Entries</a> </label>


	</div>

</div>


<div class="container">

	<form:form class="well form-horizontal" name="forp"
		action="saveDiaryForEntrySales" method="POST"
		commandName="addDiaryBean" id="">

		<fieldset>

			<!-- Form Name -->
			<legend>New Entry in Diary</legend>
			<div class="form-group">
				<label class="col-md-2 control-label">Customer<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type='text' value=""
							name='Organization'
							style='overflow: auto; border-radius: 3px; width: 210px;'
							id='autocompletecustomer' class='form-control' />
						<!-- <input   name="Organization"  placeholder="Organization Name" required="required"  class="form-control"  type="text"> -->
					</div>
				</div>
				<label class="col-md-2 control-label">Contact Person <span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							class="form-control" name="contacperson"
							placeholder="Contact Person Name" type="text">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Address</label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span>
						<textarea rows="4" cols="27" name="address" id="address">
</textarea>
					</div>
				</div>
				<label class="col-md-2 control-label">Mobile<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-earphone"></i></span> <input name="mobileno"
							class="form-control" id="mob" placeholder="8285080678"
							type="text" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Email </label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-envelope"></i></span> <input name="email"
							placeholder="E-Mail Address" class="form-control" id="email"
							required="required" type="email">
					</div>
				</div>
				<label class="col-md-2 control-label">Designation<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <select name="degId"
							class="form-control">
							<option value="">--Select Designation--</option>
							<c:if test="${!empty designationlist}">
								<c:forEach items="${designationlist}" var="listdeg">
									<option value="${listdeg.designationid}">${listdeg.designation}</option>
								</c:forEach>
							</c:if>
						</select>

					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Date</label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span> <input type="text"
							class="form-control" name="date" id="date" readonly="readonly"
							value="${today}" placeholder="Select Date">
					</div>
				</div>

				<label class="col-md-2 control-label">Time<span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span> <select name="time"
							class="form-control" style="width: 65px;" required="required">
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
						</select> <select name="timemin" class="form-control" style="width: 65px;"
							required="required">
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
					</div>
				</div>
			</div>


			<div class="form-group">
				<label class="col-md-2 control-label">Planner <span
					style="color: red;">*</span></label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <select name="planId"
							class="form-control selectpicker" required="required">
							<option value="">--Select Planner--</option>
							<c:if test="${!empty planlist}">
								<c:forEach items="${planlist}" var="data">
									<option value="${data.id}">${data.plan}</option>
								</c:forEach>
							</c:if>


						</select>
					</div>
				</div>
				<label class="col-md-2 control-label">Plan For </label>
				<div class="col-md-3 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <select name="enteryuserId"
							class="form-control">
							<option value="">--Select Plan For--</option>
							<c:forEach items="${listemp}" var="listemp">
								<option value="${listemp.userempid}">${listemp.firstname}
									${listemp.middlename} ${listemp.lastname}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">

				<label class="col-md-2 control-label">Objective<span
					style="color: red;">*</span></label>
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
					<button type="submit" class="btn btn-warning" onclick="message();">
						Send<span class="glyphicon glyphicon-send"></span>
					</button>
					<button type="button" class="btn btn-warning"
						onclick="history.back();">
						Back <span class="glyphicon glyphicon-send"></span>
					</button>

				</div>
			</div>

		</fieldset>
	</form:form>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.autocomplete.min.js"></script>

<script>

 $('#autocompletecustomer').on("click",function(){
		//var word=$('#autocomplete').val();
		alert("ddd");
		//alert($(e.target).val() );	
			$.ajax({
				url: "getCustomerRecords", 
				success: function(result){
					console.log(result);
					search1(result);
					
    					}
			});
	
});

function search1(result){
	//alert(result);
	var currencies =jQuery.parseJSON(result);
	//alert(currencies);
$('#autocompletecustomer').autocomplete({
    lookup: currencies,
    onSelect: function (suggestion) {
    var company= suggestion.value;
     $.ajax({
			url: "getcompanydatabyname?organization="+company, 
			success: function(result){
				
				var data=jQuery.parseJSON(result);
				var add=data.address;
				var email=data.emailId;
				var mobile=data.mobileNo;
				var sta=data.status;
				console.log(add+'>>>>>>>>>'+sta);
				$('#address').val(add);
				$('#email').val(email);
				$('#mob').val(mobile);
				
				
	    }}); 
      
      
    }
  });
}
</script>




