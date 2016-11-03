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
<title>Insert title here</title>



</head>

<TABLE WIDTH="375" BORDER="0" CELLSPACING="1" CELLPADDING="0" ALIGN="center">
    <FORM NAME="RegionList" METHOD="post" ACTION="RegionMain.jsp?operation=ADDNEW">
         
 </CENTER>
        <div id="pop" style="display: none;"></div>

<div id="body">
        
       <table class="responstable">
  
  <tbody><tr>
    <th>S.N.</th>
    <th data-th="Driver details"><span>Zone Name</span></th>
    <th>States</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:if test="${!empty branchList}">
	<c:forEach items="${branchList}" var="branch" varStatus="loop">
	
  <tr>
    <td>${loop.index+1}</td>
    <td>${branch.zonesname}</td>
   <td><a href="NewBranch" target="_blank">Branches</a></td>
    <td><a href="editregion" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="confirmDelete()" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
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


