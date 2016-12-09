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
<link href="resources/css/checkboxcss.css" rel="stylesheet" type="text/css" />
<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>

</style>

<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px;  height: 34px;">
		<span class="glyphicon glyphicon-envelope"></span> 	SMS Sending Rights
		 
			
</div>

</div>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th style="display: none;"> id </th>
				<th >S.N.</th>
				<th >Employee Name</th>
				<th>Role</th> 
			    <th> SMS Allowed</th>
			</tr>
		 <c:if test="${!empty empdetails}">
				<c:forEach items="${empdetails}" var="sms" varStatus="loop">

					<tr>
						<td style="display: none;">${sms.userempid}</td>
						<td>${loop.index+1}</td>
						<td>${sms.firstname} ${sms.lastname}</td>
						<td>${sms.designationName}</td>
						<td><div class="checkbox checkbox-primary">
                        <input id="checkbox_${sms.userempid}" type="checkbox">
                        <label for="checkbox_${sms.userempid}">
                            Allowed
                        </label>
                    </div></td>
		           </tr>
				</c:forEach>			
			</c:if> 					
		</tbody>
	</table>
</div>

<script src="resources/js/jquery.jrumble.1.3.min.js"></script>
<script src="resources/js/jquery.jrumble.1.3.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.js"></script>
 <script type="text/javascript">
 
 $(":checkbox").change(function() {
	    if(this.checked) {
	    
	 	var d= $(this).attr('id');
	    var getidfromid=d.split('_');
	    var empid=getidfromid[1];
	    var jsonObj={
				'empid':empid
				}; 

			 $.ajax({
					url: "permitforsmssend",
					type: "POST",
	
					  data :JSON.stringify(jsonObj),
					  cache:false,
				        beforeSend: function(xhr) {  
				            xhr.setRequestHeader("Accept", "application/json");  
				            xhr.setRequestHeader("Content-Type", "application/json");  
				        },
					     success: function(resposeJsonObject){
					    	
				    
				    		}
				        });
	    }else{
	    	var d= $(this).attr('id');
		    var getidfromid=d.split('_');
		    var empid=getidfromid[1];
		    var jsonObj={
					'empid':empid
					}; 

				 $.ajax({
						url: "denyforsmssend",
						type: "POST",
		
						  data :JSON.stringify(jsonObj),
						  cache:false,
					        beforeSend: function(xhr) {  
					            xhr.setRequestHeader("Accept", "application/json");  
					            xhr.setRequestHeader("Content-Type", "application/json");  
					        },
						     success: function(resposeJsonObject){
						    	
					     
					    		}
					        });
	    }
	});
 
 $( document ).ready(function() {
	 $.ajax({
			url: "getsmspermituser",
			type: "POST",
			success: function(resposeJsonObject){
			var data= resposeJsonObject;
			var d=data.replace('[','');
			var d1=d.replace(']','');
		    var data2=d1.split(',')
		    for(i=0;i<data2.length;i++){
		    	//alert('checkbox_'+data2[i]+'    #checkbox_2');
		    	j=data2[i].replace(' ','');
		    $('#checkbox_'+j).prop( "checked", true );
		    	
		    }
		    		}
		        });
	});
 </script>