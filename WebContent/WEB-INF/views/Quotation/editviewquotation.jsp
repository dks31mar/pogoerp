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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/messagebox.css" />
	
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet" type="text/css" href="resources/css/view.css" />
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
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
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
			<span class="glyphicon glyphicon-user"></span> Quotation Details 	
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="ason"  type="radio" name="potype"checked="checked"> As On
					 <input id="period" type="radio" name="potype" />Period
					 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "hide1">From:<input type="text" style="color: black;" id="datepicker1" value="<%=dateFormat.format(date) %>" ReadOnly></span> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id = "hide2">To: <input type="text" style = "color:black" id="datepicker2" value="<%=dateFormat.format(date) %>" ReadOnly></span> 
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Search" style="color: black;"/>
						</div>
			</div>
		   
		    <table class="responstable">
  <tbody><tr>
    <th>S.N.</th>
    <th data-th="Driver details"><span> Ref.No</span></th>
    <th>Date</th>
    <th>Order Ref</th>
    <th>Customer Name</th>
    <th>Address</th>
  </tr>
  <!--  
  <c:if test="${!empty branchList}">
	<c:forEach items="${branchList}" var="branch" varStatus="loop">
	-->
  <tr>
    <td>${loop.index+1}</td>
    <td></td>
   <td></td>
    <td></a></td>
    <td></td>
    <td></td>
  </tr>
  <!--  
  </c:forEach>
  </c:if>
  -->
</tbody></table>
		
 <script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		
		<script>
		$("#hide1").hide();
		$( function() {
		    $( "#datepicker1" ).datepicker({dateFormat: 'dd/mm/yy'});
		  } );
		$( function() {
		    $( "#datepicker2" ).datepicker({dateFormat: 'dd/mm/yy'});
		  } );
		
		$(document).ready(function(){
		    $("#ason").change(function(){
		        $("#hide1").hide();
		    });
		});
		$(document).ready(function(){
		    $("#period").change(function(){
		        $("#hide1,#hide2").show();
		    });
		});
		</script>		
		   
		  
		   