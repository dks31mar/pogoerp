
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<link rel="stylesheet" type="text/css"
	href="resources/css/table.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


</head>    

<script>
$( function() {
    $("#followdatestart").datepicker({dateFormat: 'dd-mm-yy'});
    
  });
$( function() {
    $("#followdateend").datepicker({dateFormat: 'dd-mm-yy'});
    
  });
</script>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i>
			
		</i> <input type="hidden" name="profile" value="0" />
	</div>
</div>
<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; color:white; left: 20px;  height: 24px;">
		<span class="glyphicon glyphicon-briefcase"></span> <span> Followup Reports</span>
		 
  		
</div>

</div><br>
<div class="container">
<div class="form-group">
    
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
   <input  class="form-control" name="" id="followdatestart" value="${today}" placeholder="Select Starting Date" readonly>
    </div>
  </div>
  
  <div class="col-md-3 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
   <input name=""  class="form-control" type="text" id="followdateend" placeholder="Select Ending Date" readonly>
    </div>
  </div>
</div>
</div>
       <table class="responstable">
  
  <tbody>
  <tr>
    <th>S.N.</th>
    <th data-th="Driver details"><span>A/c Manager</span></th>
    <th>Sun</th>
    <th>Mon</th>
    <th>Tue</th>
    <th>Wed</th>
    <th>Thu</th>
    <th>Fri</th>
    <th>Sat</th>
    <th>Sun</th>
   <th>Mon</th>
    <th>Tue</th>
    <th>Wed</th>
    <th>Thu</th>
    <th>Fri</th>
    <th>Sat</th>
     <th>Sun</th>
   
  </tr>
    <%-- <c:if test="${!empty branchList}">
	<c:forEach items="${branchList}" var="branch" varStatus="loop">
	
  <tr>
    <td>${loop.index+1}</td>
    <td>${branch.zonesname}</td>
   <td><a href="states?id=${branch.zonesid}" target="_blank">States</a></td>
    <td><a href="Editregion?id=${branch.zonesid}" title="Edit" id="validate"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="deleteRegion?id=${branch.zonesid}" title="Delete"  Onclick="ConfirmDelete()"><span class="glyphicon glyphicon-trash"  id="delete" ></span></a></td>
  </tr>
   
  </c:forEach>
  </c:if> --%>
  
</tbody>
</table>
        
</div>


<script>
function ConfirmDelete()
{
  var x = confirm("Are you sure you want to delete?");
  if (x)
      return true;
  else
    return false;
}


</script>