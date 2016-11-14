<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/" var="baseurl"></spring:url>
<spring:url value="resources" var="js_url" />
<link href="/pogoerpdemo/Resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/pogoerpdemo/Resources/font-awesome-4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/table.css">
<link rel="stylesheet" type="text/css"
	href="${js_url}/css/jquery.dialogbox.css">
<script src="${js_url}/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${js_url}/js/jquery.dialogBox.js" type="text/javascript"
	charset="utf-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>    
 </CENTER>
        <div id="pop" style="display: none;"></div>
<div><c:out value="${id}" /></div>
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
		<span class="glyphicon glyphicon-user"></span>Competitor Details</b>
		 <label
			 style="margin-left: 250px;margin-top: 8px;"><a href="competitiorsProfile"
			class="btn btn-primary">Add Competitor</a>
			
     </label>
  		
</div>

</div>
</div> 
        
       <table class="responstable">
  
  <tbody><tr>
    <th>S.NO.</th>
    <th data-th="Driver details"><span>Feature</span></th>
    <th>Edit</th>
    <th>Delete</th>
   
  </tr>
  <!--  -->>
  <td>1</td>
  <td>GLOBE RECTIFIERS</td>
  <td><a href="editcompetitior?id=${comprofilr.competitor}" }" title="Edit" id=""><span class="glyphicon glyphicon-pencil"></span></a></td>
  <td><a href="" title="Edit" id=""><span class="glyphicon glyphicon-trash"></span></a></td>
  <!--  
  <c:if test="${!empty branchList}">
	<c:forEach items="${branchList}" var="branch" varStatus="loop">
  <tr>
    <td>${loop.index+1}</td>
    <td>${branch.zonesname}</td>
  
    <td><a href="Editregion?id=${branch.zonesid}" title="Edit" id=""><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="deleteRegion?id=${branch.zonesid}" title="Delete"><span class="glyphicon glyphicon-trash"  id="delete" ></span></a></td> 
  -->
  </tr>
 
  </c:forEach>
  </c:if>
  
</tbody></table>
        
</div>

</TD>
    </TD>
    <TD valign="top">
      
  </TR>
</TABLE>

                    
<div class="row form-group">
						<div class="col-sm-7">
	</div>
<script>

</script>