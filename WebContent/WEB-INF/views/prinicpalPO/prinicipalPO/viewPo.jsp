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
	
	
	
<%
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
java.util.Date date = new java.util.Date();
%>
	
	<div class="row" style="margin-top: 15px">
			<br>
			<div align="center">
				<i>
					<h3></h3>
				</i> <input type="hidden" name="profile" value="0" />
			</div>
		</div>
		
		<div class="row">
		<div class="page-heading col-sm-11" style="background-color: #3C8DBC; left: 10px">
			<span class="glyphicon glyphicon-user"></span> Supplier Details	
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="ason"  type="radio" name="potype"checked="checked"> As On
					 <input id="period" type="radio" name="potype" />Period
					 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "hide1">From:<input type="text" style="color: black;" id="datepicker1" value="<%=dateFormat.format(date) %>" ReadOnly></span> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "hide2">To: <input type="text" style = "color:black" id="datepicker2" value="<%=dateFormat.format(date) %>" ReadOnly></span> 
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Search" style="color: black;"/>
						</div>
			</div>
			
			<div class="row" style="margin-top: 15px">
			<br>
			<div align="center">
				<i>
					<h3></h3>
				</i> <input type="hidden" name="profile" value="0" />
			</div>
		   </div>
		
					
		 <form:form method="POST" action="savepodetails" commandName="command"> 
					<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="responstable">
					<tr>
					
							<td  style="width: 10px" align="center">&nbsp;<font size="2" >
							<form:label path="">S.No.</form:label></font></td>
							
							<td style="width: 150px" align="center">&nbsp;<font size="2" >
							<form:label path="porefno">Po.Ref.No</form:label></font></td>	
								
							<td align="center" style="width: 150px">&nbsp;<font size="2" >
							<form:label path="porefdate">Date</form:label></font></td>	
								
							<td align="center" style="width: 80px">&nbsp;<font size="2" >
							<form:label path="principalname">Principal Name</form:label></font></td>	
								
							<td align="center" style="width: 50px">&nbsp;<font size="2" >
							<form:label path="address">Address</form:label></font></td>	
								
						</tr>	
					
					
					<c:if test="${!empty viewlist}">
					<c:forEach items="${viewlist}" var="view" varStatus="loop">
					
					<tr>
					
					<td><c:out value="${loop.index+1}"></c:out></td>
					<td><a href = "editpo"><c:out value="${view.porefno}"></c:out></a></td>
					<td><c:out value="${view.porefdate}"></c:out></td>
					<td><c:out value="${view.principalname}"></c:out></td>
					<td><c:out value="${view.address}"></c:out></td>
					</tr>
					
			
					</c:forEach>
					</c:if>
					</table>
        </form:form> 
			
   <script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		
		<script>
		$("#hide1,#hide2").hide();
		$( function() {
		    $( "#datepicker1" ).datepicker();
		  } );
		$( function() {
		    $( "#datepicker2" ).datepicker();
		  } );
		
		$(document).ready(function(){
		    $("#ason").change(function(){
		        $("#hide1,#hide2").hide();
		    });
		});
		$(document).ready(function(){
		    $("#period").change(function(){
		        $("#hide1,#hide2").show();
		    });
		});
		</script>