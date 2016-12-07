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
		<span class="glyphicon glyphicon-user"></span> States Details</b>
		 <label
			 style="margin-left: 250px;margin-top: 8px;"><a href="addstates"
			class="btn btn-primary">Add States</a>
			
     </label>
  		
</div>

</div>
</div>      
       <table class="responstable">
  
  <tbody align='center'>
 <div="wrapper">
<input type="hidden" value="${zoneid}">
  <tr id="ftr">
    <th>S.N.</th>
    <th data-th="Driver details"><span>States</span></th>
     <th>Branches</th>
   <!--   <th>Phone No</th>
    <th>Fax No</th>
    <th>Head Name</th>*/
    -->
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:if test="${!empty satyendra}">
	<c:forEach items="${satyendra}" var="state" varStatus="loop">
	
  <tr>
    <td>${loop.index+1}</td>
    <td>${state.stateName}</td>
    <td><a href="getbranchbystate?id=${state.stateId}"  target="_blank">Branches</a></td>
    <td><a href="editstates?id=${state.stateId}&id2=${zoneid}" title="Edit" id=""><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="deleteState?id=${state.stateId}" title="Delete" Onclick="ConfirmDelete()"><span class="glyphicon glyphicon-trash"  id="delete" ></span></a></td>
  </tr>
  
  </c:forEach>
  </c:if>

</table>      
</FORM>


 
</body>
</html>
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
