<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    
    
     <link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
	<link rel="stylesheet" type="text/css"
	href="resources/css/tableview.css" />
<script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script src="resources/js/jquery.dialogBox.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />
<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px;  height: 34px;">
		<span class="fa fa-balance-scale"></span> Product Sub Head
		 
			
</div>

</div>

<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	


<form:form commandName="producthead">
<div>
<div class="row">
<div class="col-md-3 selectContainer">
    <div class="input-group">
  <label for="text" > Product type</label>
</div>
  </div>
</div>
<div class="row" >
<div class="col-md-3 selectContainer">
    <div class="input-group">
    <form:select path="" class="form-control selectpicker" id="prolst">
   		 	<option >-----Select-----</option>
   		 	<c:if test="${!empty productlist}">
				<c:forEach items="${productlist}" var="pro" varStatus="loop">
  			<form:option value="${pro.productheadid}">${pro.productheadname}</form:option>
  			</c:forEach>
  			</c:if>
	</form:select>
</div>
  </div>
  </div>
  
  <div class="row">
  <div class="col-md-3 selectContainer">
  
    <label for="pwd">Product sub type:</label>
    
     </div>
     </div>
     <div class="row">
  <div class="col-md-3 selectContainer">
  
    <form:input path="" type="text" class="form-control" id="productsubtype"/>
  </div>
  </div>
  
 <div class="row">
 <br>
 </div>
  
  <button type="button" class="btn btn-default" id="senddata">Submit</button>
</div>
</form:form>

</div>



<div class="row form-group">
	<div class="col-sm-7"></div>
</div>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script>
	$('#senddata').click(function (){
		var productId=$('#prolst').val();
		var productname=$('#productsubtype').val();
		// alert(productname);
		var jsonObj={
				'productsubheadname': productname,
				'productheadid':productId
			  };
		$.ajax({
			url: "addproductSub",
			type: "POST",
			
			  data :JSON.stringify(jsonObj),
			  cache:false,
		        beforeSend: function(xhr) {  
		            xhr.setRequestHeader("Accept", "application/json");  
		            xhr.setRequestHeader("Content-Type", "application/json");  
		        },
			     success: function(resposeJsonObject){
			    	 
			    	
			    	 window.location.reload();
		     
		    }});
	});
	
	
	</script>