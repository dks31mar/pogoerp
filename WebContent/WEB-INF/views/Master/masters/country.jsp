<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/displaytag.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="resources/css/messagebox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet" type="text/css" href="resources/css/view.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px;  height: 34px;">
		<span class="glyphicon glyphicon-home"></span> Country
		 <label
			 style="margin-left: 250px;margin-top: 8px;"><button 
			class="btn btn-primary" id="getcountrypopup" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Add Country </button>
     </label> 
			
</div>
<div id="formid" class="col-md-11" style=" left: 20px;  height: 34px;">



<div class="row">
<input type="hidden" id="hiddenid"/>
<input type="hidden" id="stateid" value="${state123}"/>
  <div class="col-md-6" align="right"><input  type="text" class="form-control" id="addcountry"
						style='overflow: auto; border-radius: 3px; width: 200px; ' value="" name="loginname" placeholder="Add Country"
						 autofocus="autofocus"  pattern="^[a-zA-Z]*$"></input></div>
 
 
 <div class="col-md-4" align="right"><input  type="text" class="form-control" id="others"
						style='overflow: auto; border-radius: 3px; width: 200px; ' value="" name="loginname" placeholder="Add Others"
						></input></div>
 
  <!-- <input type = "text" id = "others" style='display:none'/> -->
</div>



 <div class="row">
<div class="col-md-11" align="right"><button style="margin-left: 300px; margin-top: -31px;" type="button"
				class="btn btn-primary" id="saveForm">Save</button></div>
				
				<div class="col-md-11" align="right"><button style="margin-left: 300px; margin-top: -31px;" type="button"
				class="btn btn-primary" id="EditForm">Edit</button></div>
</div> 
<div class="row">
<div class="col-md-6" align="right"><span style="color: red"  id="msg1" >*This field is required.</span></div>
<div class="col-md-6" align="right"><span style="color: red" id="msg" >*Please enter characters .</span></div>
<div class="col-md-6" align="right"><span style="color: red" id="msg2" >*Please select country.</span></div>
</div>

</div>
</div>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th style="width: 60px;">S.N.</th>
				<th data-th="Driver details"><span>Country</span></th>
				 <th>State</th> 
			    <th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			<c:if test="${!empty countryList}">
				<c:forEach items="${countryList}" var="country" varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						<td>${country.country}</td>
		            <td><a href = "state?countryId=${country.countryId}">State</a></td> 
					 <td><a href="#" onclick="editCur(${country.countryId})" title="Edit">
								<span class="glyphicon glyphicon-pencil"></span></a></td>
								
						<td style="margin"><a href="deletecountry?countryId=${country.countryId}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;" onclick="return confirm('Are you sure you want to delete?')"></span></a></td> 
								
					</tr>

				</c:forEach>
			</c:if>



		</tbody>
	</table>

</div>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>
<script>

$(document).ready(
	    function(){
$("#getcountrypopup").click(function(){
	
	 $("#formid").toggle('show');
	 $('#EditForm').hide();
	 $("#saveForm").show();
	 $("#addcountry").val('');
	 $('#countryspan').hide();
	 $("#hiddenid").val('');
	 $("#msg1").hide();
	 $("#msg").hide();
	 $("#msg2").hide();
	 $("#others").hide()
});
	    });
$("#formid").hide();
$('#countryspan').hide();
$("#msg1").hide();
$("#msg").hide();
$("#msg2").hide();
$("#others").hide()

$('#saveForm').click(function (){
	
	var addcountry=$('#addcountry').val();
	var others = $('#others').val();
	//var regex = /^[a-zA-Z ]*$/;
	var countryname=('["Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Brazil","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cabo Verde","Cambodia","Cameroon","Canada","Central African Republic","Chad","Chile","China","Colombia","Comoros","Congo","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","North Korea","Democratic Republic of the Cong","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia (Federated States of)","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Republic of Korea (South Korea)","Republic of Moldova","Romania","Russian Federation","Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Tajikistan","Thailand","Timor-Leste","Togo","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United Republic of Tanzania","United States of America","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe","Others"]');
	//alert(countryname);
	if(addcountry == ''){
		$("#msg1").show();
		//$("#msg2").hide();
	}/* else if (addcountry != countryname){
		$("#msg2").show();
		$("#msg1").hide();
	} */ 
	else{
		
		var jsonObj;
		
		var getstateid=$('#stateid').val();
		
		if(addcountry!='Others')
			{
			jsonObj={'country':addcountry,'countryId':getstateid};
			}else{
				
				
				jsonObj={'country':others ,'countryId':getstateid};	
			}
		
	
	$.ajax({
			url: "addcountry",
			type: "POST",
			
			  data :JSON.stringify(jsonObj),
			  cache:false,
		        beforeSend: function(xhr) {  
		            xhr.setRequestHeader("Accept", "application/json");  
		            xhr.setRequestHeader("Content-Type", "application/json");  
		        },
			     success: function(resposeJsonObject){
			    	 $('#openModal').hide();
			    	 //window.location.currency;
			    	 //window.location.reload();
			    	 window.location.href = "country";
		    }});
		
	}
	
	
});



function editCur(id){
	$("#formid").show('show');
	$('#EditForm').show();
	$("#saveForm").hide(); 
	$("#msg1").hide();
$.ajax({
	url: "getcountry?countryId="+id,
	type: "GET",
	
	     success: function(respose){
	    	// alert(respose);
	    	 var data=JSON.parse(respose)
	    	 var name=data.country;
	    	 var id=data.countryId;
	    	// alert("************************"+id);
	    	 $("#addcountry").val(name);
	    	 $("#hiddenid").val(id);
	    	 
    }});
} 





$('#EditForm').click(function (){
	var id=$("#hiddenid").val();
	var addcountry=$('#addcountry').val();
	
	var d1w=$("#hiddenid").val();
	//alert(d1w);
	if(addcountry == '' ){
		$("#msg1").show();
	}
	else{
	
	var jsonObj={'country':addcountry,'countryId':id} ;
$.ajax({
		url: "editcountry",
		type: "POST",
		
		  data :JSON.stringify(jsonObj),
		  cache:false,
	        beforeSend: function(xhr) {  
	            xhr.setRequestHeader("Accept", "application/json");  
	            xhr.setRequestHeader("Content-Type", "application/json");  
	        },
		     success: function(resposeJsonObject){
		    	 $('#openModal').hide();
		    	 //window.location.currency;
		    	 window.location.reload();
	    // alert("edit");
	    }});
	}
	
});

$('#addcountry').keyup(function (){
	 $('#msg1').hide();
	 $('#msg').hide();
	 $('#msg2').hide();
	
	
});
$('#addcountry').click(function (){
	 $('#msg1').hide();
	 $('#msg').hide();
	 $('#msg2').hide();
	
	
});

$(document).ready(function(){
    $("#addcountry , #others").keypress(function(event){
        var inputValue = event.which;
        // allow letters and whitespaces only.
        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
            event.preventDefault(); 
            $('#msg').show();
       	 
        }
    });
});



$(document).ready(function(){
	var countryname=('["Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia and Herzegovina","Botswana","Brazil","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cabo Verde","Cambodia","Cameroon","Canada","Central African Republic","Chad","Chile","China","Colombia","Comoros","Congo","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","North Korea","Democratic Republic of the Cong","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia (Federated States of)","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Republic of Korea (South Korea)","Republic of Moldova","Romania","Russian Federation","Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Tajikistan","Thailand","Timor-Leste","Togo","Tonga","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United Republic of Tanzania","United States of America","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe","Others"]');
	//alert(countryname);
	var finalArray=jQuery.parseJSON(countryname);
$('#addcountry').autocomplete({
	
    lookup: finalArray,
    onSelect: function (suggestion) {
   alert(suggestion.value);
   if(suggestion.value=='Others'){
	   
	   $("#others").show("fast");
	   
	   $("#addcountry").show();
   }
   else{
	   $("#others").hide();
   }
    }
  });
});



</script>


