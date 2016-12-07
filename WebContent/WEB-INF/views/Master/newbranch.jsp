<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 
 <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<!-- call region -->
<link rel="stylesheet" type="text/css"
	href="resources/css/table.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/branch.css">
<script src="resources/js/branch.js" type="text/javascript"></script>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<title>Branches details</title>

</head>



<tbody>
<body>

    <div id="pop" style="display: none;"></div>

<div id="body">
<div>
<div>
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
		<span class="glyphicon glyphicon-user"></span> Branches Details</b>
		 <label
			 style="margin-left: 250px;margin-top: 8px;"><a href="addbranchbystate"
			class="btn btn-primary">Add Branches</a>
			
     </label>
  		
</div>

</div>
</div> 
     
       <table class="responstable">
       
  
  <tbody align='center'>
 <tr>
    <th>S.N.</th>
     <th>Branches</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:if test="${!empty branchlist}">
  <c:forEach items="${branchlist}" var="branch" varStatus="loop">
  <tr>
  
  <td>${loop.index+1}</td>
  <td>${branch.branchname}</td>
 
    <td><a href="editbranch?id=${branch.branchId}&stateid=${stateid}" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="deletebranch?id=${branch.branchId}" title="Delete" Onclick="ConfirmDelete()"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  </c:forEach>
  </c:if>
  

</tbody>

</table>      


 <script>
 function ConfirmDelete()
 {
   var x = confirm("Are you sure you want to delete?");
   if (x)
       return true;
   else
     return false;
 }
	// by satyendra
	$('#messagespan').hide();
	$('#senddata').click(function(){
		
	var reginname =	$('#regionname').val();
	var selecthead =	$('#selecthead').text();
	var mobileno =	$('#mobileno').val();
	var emailid =	$('#emailid').val();
	   var fax    =	$('#fax').val();
	   var regadress    =	$('#regadress').val();
	   
	   alert(selecthead);
	   
	   if(reginname==''||mobileno==''||emailid==''||fax==''||regadress==''||selecthead=='---Select Region---'){
		   $('#messagespan').show('fast');
		   
	   }else{
		   var jsonObj={
					'zonesname':reginname,
							'zonesaddress':regadress,
								'zonesfax':fax,
								'zonesphone':mobileno,
								'zonesemail':emailid
			} ;
		
		$.ajax({
				url: "addzonedetails",
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
			
		   
	   }
	   
	   
		
	  
	}); 
	
function funcal(){
	$('#messagespan').hide();
}
</script>
