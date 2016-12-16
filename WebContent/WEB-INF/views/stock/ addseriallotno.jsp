<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/displaytag.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/messagebox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<%
//HttpSession session=request.getSession();
//String hh=(String)session.getAttribute("jsonp");
String norml=(String)session.getAttribute("normal");

if(norml==null){
norml="";
}
String cb=(String)session.getAttribute("CBW");
if(cb==null){
	cb="";
}
/* Integer total=(Integer)session.getAttribute("total"); */
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
java.util.Date date = new java.util.Date();
System.out.println();
%>
<form method="POST" action="">
	<div class="row" style="margin-top: 15px">
		<br>
		<div align="center">
			<i> </i> <input type="hidden" name="profile" value="0" />
		</div>
	</div>

	<div class="row">

		<div class="page-heading col-sm-11" id="createpo"
			style="background-color: #3C8DBC; left: 10px">
			<span class="glyphicon glyphicon-copy"></span> Serial & Lot No. Entry


		</div>
	</div>

	<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">

		<hr style="color: black">
		<div class="row form-group">
			<div class="col-sm-7"></div>
		</div>

		<table style="width: 100%; bottom: 15px; position: relative;"
			border="0" id="quotprodtable">
			<thead>
				<tr bgcolor="#3C8DBC">
					<td style="display: none;"><label>id</label></td>
					<td class="col-sm-1 form-level" style="text-align: center"><font
						size="2" color="white"> <label>S.No.</label></font></td>
					<td align="center" class="col-sm-1 form-level"
						style="text-align: center"><font size="2" color="white">
							<label> Po.Ref.No.</label>
					</font></td>
					<td class="col-sm-4 form-level" style="text-align: center"
						align="center"><font size="2" color="white"> <label>
								Invoice No.</label></font></td>
					<td align="center"><font size="2" style="width: 80px"
						color="white" style="text-align: center"> <label>
								Part No.</label></font></td>
					<td align="center"><font size="2" style="width: 80px"
						color="white" style="text-align: center"> <label
							id="serialid"> Serial No.</label></font></td>
					<td align="center"><font size="2" style="width: 80px"
						color="white"> <label id="dis"> Lot No.</label></font></td>



					<td align="center"><div class="checkbox">
							<label> </label>
				</tr>
			</thead>
			<tbody id="addprolisttbody">

			</tbody>
		</table>

		<table>
			<thead>
				<tr>
					<td style="display: none;"><input type="hidden" value=""
						id="getid1"></input></td>
					<td style="right: 7px; position: relative;"><input type='text'
						style='width: 60px' name='posrno' id='sr' value=""
						class='form-control' /></td>

					<td style="width: 250px"><input name=' Po.Ref.No' id='porefid'
						class='form-control' style="text-align: center; width: 238px;"
						value=""></input></td>

					<td style="left: 2px; position: relative; width: 150px"><input
						type='text' value="" name='Invoice No'
						style='overflow: auto; border-radius: 3px; width: 223px;'
						id='invoiceid' class='form-control' /></td>

					<td align="center" style="right: 4px; position: relative;"><input
						type='text' style='text-align: center;' name='Part No'
						id='Partnoid' class='form-control' value="" /></td>

					<td style="right: 7px; position: relative;"><input type='text'
						style='text-align: center;' name='  Serial No' id=' Serialid'
						value="" class='form-control' /></td>

					<td style="right: 15px; position: relative;"><input
						type='text' style='text-align: center;' name='Lot No' id='Lotnoid'
						value="" class='form-control' /></td>

					<td><input type="hidden" style="text-align: center;"
						name="unitcost" id="unitcostx" value="" class="form-control"></td>

					<td align="center"><input type="button" value='+'
						id='removemorepro12' class='btn btn-success pull-right'
						data-toggle='tooltip' title='Add More' /></td>
				</tr>
			</thead>
		</table>
</form>

<hr align="left" size="" width="100%"
	style="background-color: #3C8DBC; height: 1px;" />

<div align="center">

	<table>
		<tr>


			<!-- <td>
							<button type="button" value="update" onclick="numberingRow();"
								class="btn btn-success pull-center"
								style="background-color: #3C8DBC;">Number row</button>
						</td> -->
			<td></td>
			<td>
				<button type="button" value="Save" onClick=""
					class="btn btn-success pull-center" id=""
					style="background-color: #3C8DBC;">Save</button>
			</td>
			<td>
				<button type="button" value="Save" onClick=""
					class="btn btn-success pull-center" id=""
					style="background-color: #3C8DBC;">Back</button>
			</td>
			<%-- <td class="col-sm-2 form-level">
						
						
						Total:<font color="#FF0000"></font>
					
						</td>
						<td>
						
						<div align="right">
						<input type="text" name="tjpy1" id="tjpy1" class="form-control"
							value="${total}" style="width: 65%;" readonly>
					</div>
						</td> --%>

		</tr>


	</table>




	<!-- <button type="button" value="AddMore" onClick="productdetail();"
						class="btn btn-success pull-right"
						style="background-color: #3C8DBC;">Add More</button> -->


</div>

</div>

</div>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.autocomplete.min.js"></script>

<script>
$( function() {
    $( "#datepicker1" ).datepicker({dateFormat: 'dd/mm/yy'});
    $( "#datepicker2" ).datepicker({dateFormat: 'dd/mm/yy'});
  } );
</script>