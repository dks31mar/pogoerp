<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/displaytag.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/messagebox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet" type="text/css" href="resources/css/view.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link href="resources/css/prettify.css" rel="stylesheet" type="text/css" />


<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<%
String name=(String)session.getAttribute("username");
 %>
<%
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
java.util.Date date = new java.util.Date();
%>
<%--  <input type="hidden" id="userid" value="${userid}"/>   --%>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<input type="hidden" name="profile" value="0" />
	</div>
</div>
<form:form method="POST" action="saveexpensereport"
	commandName="command">
	<div class="row">
		<div class="page-heading col-sm-11" id=""
			style="background-color: #3C8DBC; left: 10px">
			<div  class="col-sm-2" >
			<span class="fa fa-money"></span> Expense Report
			</div>
			<div  class="col-sm-6" > <input id="ason"
				type="radio" name="potype" checked="checked"> As On
				
				
			<input	id="period" type="radio" name="potype" />Period <span id="hide1">From:<input
				type="text" style="color: black;" id="datepicker1" name="startdate"
				value="<%=dateFormat.format(date) %>" ReadOnly></span> <span
				id="hide2">To: <input type="text" style="color: black"
				id="datepicker2" name="enddate"
				value="<%=dateFormat.format(date) %>" ReadOnly></span>
</div>
<div  class="col-sm-3" >
			<select name="selectmanager" class="form-control selectpicker"><option
					value="" style="color: black;">-----Select A/c Manager
					-----</option>
				<c:if test="${!empty listofaccountmanager}">
					<c:forEach items="${listofaccountmanager}" var="cur"
						varStatus="loop">
						<option value="${cur.userempid}" style="color: black;">${cur.firstname}
							${cur.lastname}</option>
					</c:forEach>
				</c:if>
			</select>
			</div>
			<input type="submit" value="Search" name="command"
				style="color: black;" />
		
	</div>

	<div class="row" id="body">
		<table class="responstable" style="margin-left: 22px;">

			<tbody>
				<tr>
					<th style="width: 60px;">S.N.</th>
					<th data-th="Driver details"><span> A/c Manager </span></th>

					<th style="width: 60px;">Total</th>

				</tr>
				 <c:if test="${!empty listofexpensereport}">
					<c:forEach items="${listofexpensereport}" var="expense"
						varStatus="loop">

						<tr>
							<td>${loop.index+1}</td>

                          <td>${expense.userid}</td>  
                            
						<%-- <td><%=name %></td>  --%>

							<td><a href="expensereportdetails">${expense.grandtotal}</a></td>



						</tr>

					</c:forEach>
				</c:if> 



			</tbody>
		</table>

	</div>
</form:form>
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