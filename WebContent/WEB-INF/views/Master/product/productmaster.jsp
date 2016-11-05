<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
    
    <link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
	<link rel="stylesheet" type="text/css"
	href="resources/css/tableview.css" />
<script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script src="resources/js/jquery.dialogBox.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />

<style>

.modalDialog {
	position: fixed;
	font-family: Arial, Helvetica, sans-serif;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background: rgba(0, 0, 0, 0.8);
	z-index: 99999;
	opacity: 0;
	-webkit-transition: opacity 400ms ease-in;
	-moz-transition: opacity 400ms ease-in;
	transition: opacity 400ms ease-in;
	pointer-events: none;
}

.modalDialog:target {
	opacity: 1;
	pointer-events: auto;
}

.modalDialog>div {
	width: 725px;
	position: relative;
	margin: 5% auto;
	padding: 5px 20px 13px 20px;
	border-radius: 10px;
	background: #fff;
	background: -moz-linear-gradient(#fff, #999);
	/* background: -webkit-linear-gradient(#fff, #999); */
	background: -o-linear-gradient(#fff, #999);
}

}

</style>


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
		style="background-color: #3C8DBD; left: 20px;  height: 34px;">
		<span class=""></span> Product
		<!--  <label
			 style="margin-left: 250px;margin-top: 8px;">
			 <button href="#"
			class="btn btn-primary" id="getpopup" style="margin-bottom: -25px;margin-top: -26px;HEIGHT: 28px;margin-left: 561px;"> Add New Currency </button>
     </label> -->
      
			
</div>

</div>

<br>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable" style="margin-left: 22px; ">

		<tbody>
			<tr>
				<th>S.No.</th>
				<th data-th="Driver details"><span>Product Code</span></th>
				<th>Product Name</th>
				<th>Cost price</th>
				<th>Selling price</th>
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			
			<c:if test="${!empty currencylist}">
				<c:forEach items="${currencylist}" var="cur" varStatus="loop">
			
			<tr>
						
								<td>${loop.index+1}</td>
								<td>${cur.currencyname}</td>
								<td>${cur.currencysymbol}</td>
								<td>${cur.currencysymbol}</td>
								<td>${cur.currencytype}</td>
							
						
								<td><a href="#" onclick="editCur(${cur.currencyid})" title="Edit" align="center" >
								<span class="glyphicon glyphicon-pencil"></span></a></td>
								
						<td style="margin"><a href="deletecurrency?id=${cur.currencyid}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"></span></a></td>
					</tr>
</c:forEach>
</c:if>
				


		</tbody>
	</table>
</div>
<div class="row form-group">
	<div class="col-sm-7"></div>
</div>



<!-- <script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
<script>

    
    
    


</script>