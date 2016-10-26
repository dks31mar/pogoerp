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
	href="${js_url}/css/jquery.dialogbox.css">
<script src="${js_url}/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${js_url}/js/jquery.dialogBox.js" type="text/javascript"
	charset="utf-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	jQuery(document).ready(function() {
		// binds form submission and fields to the validation engine
		jQuery("#formID").validationEngine('attach');
	});
	function addLocation() {
		$('#pop')
				.dialogBox(
						{
							type : 'normal', //three type:'normal'(default),'correct','error',
							width : 500,
							height : 450,
							hasMask : true,
							hasClose : true,
							autoHide : false,
							time : '0',
							effect : 'flip-horizontal',
							title : 'Add/Edit Region ',
							content :'<form:form id="formID" action="saveuserEmp" method="POST" commandName="userbean"><span style="color: black;"> <strong>Region Name<span style="color:red;">*</span>:</strong></span>&nbsp;&nbsp;<input type="text" class="validate[required] text-input"  style="border-radius:5px;"   name="regionnname" placeholder="Regionname"  maxlength="20" autofocus="autofocus"><br><br>'
									+'<span style="color: black;"><strong>Phone No<span style="color:red;">*</span>:</strong></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="validate[required] text-input"  style="border-radius:5px;"   name="phone" placeholder="121-12456"  maxlength="20"><br><br>'
									+'<span style="color: black;"> <strong>Fax No<span style="color:red;">*</span>:</strong></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="validate[required] text-input"  style="border-radius:5px;"   name="refaxno" placeholder="faxno"  maxlength="20"><br><br>'
									+'<span style="color: black;">  <strong>Emailid<span style="color:red;">*</span>:</strong></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="validate[required] text-input"  style="border-radius:5px;"   name="emailid" placeholder="Emialid"  maxlength="20"><br><br>'
									+'<span style="color: black;"> <strong>Region Head Name<span style="color:red;">*</span>&nbsp;&nbsp;&nbsp;</strong></span><select><option>----Select Region----</option><option value="Delhi NCR">Delhi NCR</option><option value="Noida">Noida</option>  style="border-radius:5px;"   name="region"   maxlength="20" </select><span style="color: black;"><br><br>'
									+'<span style="color: black;"><strong> Reagion Address<span style="color:red;">*</span>:</strong></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="address" cols="20" rows="2"  border-radius:5px;" placeholder="Address"></textarea><br><br>'
									
									+'<button style="margin-left: 200px;margin-top:-15px;" type="submit" class="btn-btn primary">Save</button></form:form>'
						});
	}
	
	
</script>
<style>
      /*

RESPONSTABLE 2.0 by jordyvanraaij
  Designed mobile first!

If you like this solution, you might also want to check out the 1.0 version:
  https://gist.github.com/jordyvanraaij/9069194

*/
.responstable {
  margin: 1em 0;
  width: 100%;
  overflow: hidden;
  background: #FFF;
  color: #024457;
  border-radius: 10px;
  border: 1px solid #167F92;
}
.responstable tr {
  border: 1px solid #D9E4E6;
}
.responstable tr:nth-child(odd) {
  background-color: #EAF3F3;
}
.responstable th {
  display: none;
  border: 1px solid #FFF;
  background-color: #167F92;
  color: #FFF;
  padding: 1em;
}
.responstable th:first-child {
  display: table-cell;
  text-align: center;
}
.responstable th:nth-child(2) {
  display: table-cell;
}
.responstable th:nth-child(2) span {
  display: none;
}
.responstable th:nth-child(2):after {
  content: attr(data-th);
}
@media (min-width: 480px) {
  .responstable th:nth-child(2) span {
    display: block;
  }
  .responstable th:nth-child(2):after {
    display: none;
  }
}
.responstable td {
  display: block;
  word-wrap: break-word;
  max-width: 7em;
}
.responstable td:first-child {
  display: table-cell;
  text-align: center;
  border-right: 1px solid #D9E4E6;
}
@media (min-width: 480px) {
  .responstable td {
    border: 1px solid #D9E4E6;
  }
}
.responstable th, .responstable td {
  text-align: left;
  margin: .5em 1em;
}
@media (min-width: 480px) {
  .responstable th, .responstable td {
    display: table-cell;
    padding: 1em;
  }
}

body {
  padding: 0 2em;
  font-family: Arial, sans-serif;
  color: #024457;
  background: #f2f2f2;
}

h1 {
  font-family: Verdana;
  font-weight: normal;
  color: #024457;
}
h1 span {
  color: #167F92;
}

    </style>
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
    <th>Branches</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:if test="${!empty branchList}">
	<c:forEach items="${branchList}" var="branch" varStatus="loop">
	
  <tr>
    <td>${loop.index+1}</td>
    <td>${branch.zonesname}</td>
   <td><a href="NewBranch" target="_blank">Branches</a></td>
    <td><a href="#"onclick="addLocation()" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
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


