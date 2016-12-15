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
<link href="resources/css/prettify.css" rel="stylesheet" type="text/css" />


<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script src="//code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<% String name = (String)session.getAttribute("username"); %>

<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<input type="hidden" name="profile" value="0" />
	</div>
</div>
<div class="row">
	<div class="page-heading col-sm-11" id=""
		style=" text-align:'center' background-color: #3C8DBC; left: 10px ">
		<span class="fa fa-money"></span><strong style=" text-align:'center' ;">Expense Report Details of <%=name %> </strong>
		
	</div>
</div>
<div class="row" id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th style="width: 60px;">S.N.</th>
				<th style="width: 60px;">Date</th>
				 <th style="width: 60px;">Customer</th>
				 <th style="width: 60px;">Description</th>
				  <th style="width: 60px;">Nature of Expense</th>
				   <th style="width: 60px;">Units/Expense</th>
				    <th style="width: 60px;">Total</th>
			    
			</tr>
		  <c:if test="${!empty listofexpensereport}">
				<c:forEach items="${listofexpensereport}" var="expense" varStatus="loop">

					<tr>
						<td>${loop.index+1}</td>
						
						<td>${expense.crdate}</td>
						
						<td>${expense.orgnisation}</td>
						
						<td>${expense.description}</td>
						
						<td>${expense.expname}</td>
						
						<td>${expense.unit_expense}</td>
						
						<td>${expense.total}</td>
		           
					 
								
					</tr>

				</c:forEach>
			</c:if>
 


		</tbody>
	</table>

</div>
<!-- <div class="row form-group" style="top: 10px; position: relative;"
					onclick="">
					<div class="col-sm-10 form-level" align="right">
						Total:<font color="#FF0000"></font>
					</div>
					<div align="right">
						<input type="text" name="gtotal" id="gtotal" class="form-control"
							value="" style="width: 15%;" readonly>
					</div>
				</div> -->
 