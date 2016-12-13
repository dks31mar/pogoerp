<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/table.css" rel="stylesheet" type="text/css" />

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />

<script type="text/javascript">
		function designData(designation) {
			$.ajax({
							url : 'authority',
							type : 'GET',
							data : {
								'designation' : designation,
							},
							success : function(response) {
								var data1=response.replace('"','');
								var data1=data1.replace('"','');
								var data2=data1.split(">>");
								
								var content = '<option value="">Select</option>';
								for ( var i = 0; i < data2.length; i++) {
									content += '<option value='+data2[i]+'>'+data2[i]+ '</option>';
									//alert(i);
								}
								$("#designation").append(content); 
							
								
							 }});
			
		}
		
		$(document).ready(function() {
		    $('#mainidtable').DataTable( {
		        "order": [[0, "asc" ]]
		    } );
		} );
	</script>
	<div class="row" style="margin-top: 10px;">
	
</div><br>							
<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 30px;  height: 64px;">
		<span class="glyphicon glyphicon-user" style="margin-left: 70px;"></span> Designation
<label
			 style="margin-left: 250px;margin-top: 2px;"><a href="#"
			class="btn btn-success"> Level </a>
     </label>
     <label
			 style="margin-left: 250px;margin-top: 2px;"><a href="#"
			class="btn btn-primary"> Authority </a>
     </label>
		
</div>

</div>
<div class="container" id="mainidtable">

    <form:form class="well form-horizontal"  action="saveDesignation" method="POST"  commandName="designationbean"
    id="" >
<fieldset>

<!-- Form Name -->
  <div class="form-group">
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input   name="designation" class="form-control" required="required" placeholder="Add New Designation"   type="text" id="newdesg">
    </div>
  </div>
  <div class="form-group">
                        <div class="col-md-3">
                            <div class="radio" id="radioDiv">
                                <label>
                                    <input type="radio" name="position" value="0" /> Above
                                </label>
                                <label>
                                    <input type="radio" name="position" value="1" /> Below
                                </label>
                                <label>
                                    <input type="radio" name="position" value="2" /> Same
          						</label>
          					</div>
          						</div>	
          			<div class="col-md-4 selectContainer">			
          	 <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select  class="form-control selectpicker" id="dedig">
      <option value="">----Select Role---- </option>
						<c:forEach var="list" items="${desig}">
							<option value="${list.level}"> ${list.designation}</option>
						</c:forEach>
      </select>

   </div><br><br>
  <div class="form-group">
  <label class="col-md-10 control-label"></label>
  <div class="col-md-2" >
    <button type="button" class="btn btn-warning"  id="sendLevel" >Send <span class="glyphicon glyphicon-send"></span></button>
    </div>
  </div>
</div>
</div>
</div>
</fieldset>
</form:form>
</div>

<table class="responstable" style="margin-left: 19px;margin-top:-5px; ">

		<tbody>
			<tr>
				<th><span>Level</span></th>
				<th align="center"><span> Assign Right-Description</span></th>
				<th style="width: 60px;"><span>Edit</span></th>
				<th style="width: 60px;"><span>Delete</span></th>
				
			</tr>
			<c:choose>
							<c:when test="${empty designationlist}">
								<div style="color: red; text-align: center;">No Designation
													Record in the List</div>
									</c:when>
				<c:otherwise>
			<c:if test="${!empty designationlist}">
			<c:forEach items="${designationlist}" var="data" varStatus="deg">
			
			 <tr>
			<td>${deg.index+1}</td>
			<td>${data.designation} </td>
			
			<td><a href="editDesignation?id=${data.designationid}" title="Edit" ><span
								class="glyphicon glyphicon-pencil"></span></a></td>
			<td><a href="deleteDesg?designationid=${data.designationid}" title="Delete"><span class="glyphicon glyphicon-trash" style="margin-left: 10px;"onclick="return confirm('Are you sure you want to delete?')">
			</span></a></td>
			</tr>	
												
			</c:forEach>
			</c:if>
			</c:otherwise>
			</c:choose>
		</tbody>
	</table>
<script>

	
	
	
$('#sendLevel').click(function (){
	var newds=	$('#newdesg').val();
	var selected = $("#radioDiv input[type='radio']:checked").val();
	var des=$('#dedig').val();	
	
	
	var jsonObj={
			'designation' : newds,
			'level':des,
			'position':selected
		};
$.ajax({
		url: "show-designation",
		type: "POST",
		
		  data :JSON.stringify(jsonObj),
		  cache:false,
	        beforeSend: function(xhr) {  
	            xhr.setRequestHeader("Accept", "application/json");  
	            xhr.setRequestHeader("Content-Type", "application/json");  
	        },
		     success: function(resposeJsonObject){
		    	 window.location.reload();
	     
	    }
	        
	});
});
</script>
