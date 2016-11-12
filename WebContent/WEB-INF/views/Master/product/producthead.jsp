<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<span class="fa fa-balance-scale"></span> Product Head
		 <label
			 style="margin-left: 250px;margin-top: 8px;"><button 
			class="btn btn-primary" id="getpopup" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Add New Product </button>
     </label> 
			
</div>
<div id="formid" class="col-md-11" style=" left: 20px;  height: 34px;">



<div class="row">
<input type="hidden" id="hiddenid"/>
  <div class="col-md-10" align="right"><input path="loginname" type="text" class="validate[required] text-input" id="unitname"
						style="border-radius: 5px;" value="" name="loginname" placeholder="Enter Product Name"
						maxlength="20" autofocus="autofocus"></input></div>
  
</div>



 <div class="row">
<div class="col-md-11" align="right"><button style="margin-left: 300px; margin-top: -31px;" type="button"
				class="btn btn-primary" id="saveForm">Save</button></div>
				
				<div class="col-md-11" align="right"><button style="margin-left: 300px; margin-top: -31px;" type="button"
				class="btn btn-primary" id="EditForm">Edit</button></div>
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
				<th data-th="Driver details"><span>Product</span></th>
			
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			<c:if test="${!empty productlist}">
				<c:forEach items="${productlist}" var="product" varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						<td>${product.productheadname}</td>
			

						<td><a href="#" onclick="editCur(${product.productheadid})" title="Edit" align="center" >
								<span class="glyphicon glyphicon-pencil"></span></a></td>
								
						<td style="margin"><a href="deleteproducthead?id=${product.productheadid}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"></span></a></td>
					</tr>

				</c:forEach>
			</c:if>



		</tbody>
	</table>







</div>



<div class="row form-group">
	<div class="col-sm-7"></div>
</div>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script>
	
	$("#formid").hide();
	
	
	$("#getpopup").click(function(){
		
		 $("#formid").toggle('show');
		 $('#EditForm').hide();
		 $("#saveForm").show();
		 $("#unitname").val('');
		 
		 $("#hiddenid").val('');
		
	});

	
	
	
	
	$('#saveForm').click(function (){
		var unitname=$('#unitname').val();
		
		
		var jsonObj={'productheadname':unitname
		} ;
	$.ajax({
			url: "addproduct",
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
		     
		    }});
	});

	
	
	
	$('#EditForm').click(function (){
		var id=$("#hiddenid").val();
		var currencyname=$('#unitname').val();
		
		var d1w=$("#hiddenid").val();
		alert(d1w);
		
		
		var jsonObj={'productheadname':currencyname,'productheadid':id} ;
	$.ajax({
			url: "editproducthead",
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
		 alert("edit"); 
		    }});
		
		
	});
	
	
	
	
	function editCur(id){
		$("#formid").show('show');
		$('#EditForm').show();
		$("#saveForm").hide(); 
	$.ajax({
		url: "getproducthead?id="+id,
		type: "POST",
		
		     success: function(respose){
		    	 //alert(respose);
		    	 var data=JSON.parse(respose)
		    	 var name=data.productheadname;
		    	 var id=data.productheadid;
		    	// alert("DDDDDDDDDDDDDDDD                   "+id); 
		    	 $("#unitname").val(name);
		    	 $("#hiddenid").val(id);
		    	
	    }});
	} 
	
	</script>