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
			<span class="glyphicon glyphicon-copy"></span> Add Collection


		</div>
	</div>
	<!--  
		<div class="row" id="editpo">
			<div class="page-heading col-sm-11"
				style="background-color: #3C8DBC; left: 10px">
				<span class="glyphicon glyphicon-copy"></span> Edit PO
			</div>
		</div>
		
		-->
	<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">
		<div class="row form-group">

			<div class="col-sm-3 form-level">
				Invoice No:<font color="#FF0000">*</font>
			</div>
			<div class="col-sm-4">
				<input type="text" name="Invoiceno" placeholder="Invoice No"
					onkeyup="" id="customerid" value="" class="form-control">

			</div>

			<div class="col-sm-2 form-level">
				Invoice Date:<font color="#FF0000">*</font>
			</div>
			<div class="col-sm-3">
				<span> <input type="text" class="form-control"
					name="invoicedate" id="datepicker1"
					value="<%=dateFormat.format(date) %>" ReadOnly></input>

				</span>

			</div>
		</div>


		<div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
					Buyer's Order No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<span> <input type="text" class="form-control"
						name="buyerOrderno" placeholder="Buyer's Order No." id="buyerid"
						size="120"></input>

					</span>

				</div>

				<div class="col-sm-2 form-level">
					Order Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
					<span> <input type="text" class="form-control"
						name="orderdate" id="datepicker2"
						value="<%=dateFormat.format(date) %>" ReadOnly></input>

					</span>

				</div>
			</div>

		</div>


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
							<label> Receipt No</label>
					</font></td>
					<td class="col-sm-4 form-level" style="text-align: center"
						align="center"><font size="2" color="white"> <label>
								Receipt Date</label></font></td>
					<td align="center"><font size="2" style="width: 80px"
						color="white" style="text-align: center"> <label>
								Mode</label></font></td>
					<td align="center"><font size="2" style="width: 80px"
						color="white" style="text-align: center"> <label
							id="unitprice"> Cheque No/Ref No</label></font></td>

					<td align="center"><font size="2" style="width: 80px"
						color="white"> <label id="dis"> Amount</label></font></td>


					<td align="center"><div class="checkbox">
							<label> </label>
							<!--  <td align="center"><font size="2" style="width: 80px"color="white">
										<label id="totalchangelable">Total JPY</label></font></td>-->
							<!--  <td align="center"><font size="2" style="width: 65px"color="white">
										<label >Customer PO Reference</label></font></td>-->
							<%-- <td align="center"> <font size="2" style="width: 80px" color="white"><label path="">Total INR</label></font> --%>
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

					<td style="width: 250px"><input name='Receipt' id='Receiptid'
						class='form-control' style="text-align: center; width: 238px;"
						value=""></input></td>

					<td style="left: 2px; position: relative; width: 150px"><input
						type='text' value="" name='Receiptdate'
						onkeypress='return event.charCode >= 48 && event.charCode <= 57'
						style='overflow: auto; border-radius: 3px; width: 223px;'
						id='autocomplete' class='form-control' /></td>

					<td align="center" style="right: 4px; position: relative;"><input
						type='text' style='text-align: center;' name='Mode' id='modeid'
						class='form-control' value="" /></td>

					<td style="right: 7px; position: relative;"><input type='text'
						style='text-align: center;' name=' Cheque No/Ref No' id='Chequeid'
						value="" class='form-control' /></td>

					<td style="right: 7px; position: relative;"><input type='text'
						style='text-align: center;' name='amount' id='amountid' value=""
						class='form-control' /></td>

					<td><input type="hidden" style="text-align: center;"
						name="unitcost" id="unitcostx" value="" class="form-control"></td>

					<td align="center"><input type="button" value='-'
						id='removemorepro12' class='btn btn-success pull-right'
						data-toggle='tooltip' title='Remove Product' /></td>
				</tr>
			</thead>
		</table>
</form>


<div class="row form-group" style="top: 10px; position: relative;"
	onclick="">
	<div class="col-sm-10 form-level" align="right">
		Total Invoice Value:<font color="#FF0000"></font>
	</div>
	<div align="right">
		<input type="text" name="invoicevalue" id="orderid"
			class="form-control" value="${total}" style="width: 15%;" readonly>
	</div>
</div>

<div class="row form-group" style="top: 10px; position: relative;"
	onclick="">
	<div class="col-sm-10 form-level" align="right">
		Total Collection:<font color="#FF0000"></font>
	</div>
	<div align="right">
		<input type="text" name="collection" id="collectionid"
			class="form-control" value="${total}" style="width: 15%;" readonly>
	</div>
</div>
<div class="row form-group" style="top: 10px; position: relative;"
	onclick="">
	<div class="col-sm-10 form-level" align="right">
		Pending Amount:<font color="#FF0000"></font>
	</div>
	<div align="right">
		<input type="text" name="pendingamount" id="pendingid"
			class="form-control" value="${total}" style="width: 15%;" readonly>
	</div>
</div>
<td align="center"><input type="button" value='ADD More'
	id='addproduct' class='btn btn-success pull-right'
	data-toggle='tooltip' title='Add Product' /></td>

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
  /*
  
$('#addproduct').click(function (){
	 $('#mainForm').show();
});


	
	
	 $(document).ready(function(){
		 var id=$('#addprolisttbody').children('tr').length;
		 $('#sr').val(id+1);
	        $("#addproduct").click(function(){
	        	var id=$('#addprolisttbody').children('tr').length+1;
	        	var idd=$('#getid1').val();
	        	var address=$('#addresstextarea').val();
	        	var temp=$("#totalchangelable").text();
	        	var pname=$('#prinicipalautocom').val();
	        
				var  dis	= $('#description').val();
				var  partno	=$('#autocomplete').val();
				var	 tpn	=$('#tpinjpy').val();
				var	 qty	=$('#qty').val();
				var	 totjpy	=$('#totaljpy').val();
				var	 custpo	=$('#customerporefe').val();
				var poref=$('#porefno').val();
				var date=$('#datepicker').val();
				var cur=temp.split(' ')[1];
				if(address==''||pname==''){
					alert('Please Fill Prinicpal Name!!!')
				}else{
	            var markup = "<tr>"+
		            "<td style='display: none;'><input type='hidden' name='date"+id+"' value='"+date+"' id='getdate"+id+"'></input> </td>"+
		            "<td style='display: none;'><input type='hidden' name='porefno' value='"+poref+"' id='getporefno"+id+"'></input> </td>"+
					"<td style='display: none;'><input type='hidden' name='prinicipalName' value='"+pname+"' id='getprinicipalname'"+id+"'></input> </td>"+
					"<td style='display: none;'><input type='hidden' name='Paddress' value='"+address+"' id='getadress'"+id+"'></input> </td>"+
					"<td style='display: none;'><input type='hidden' name='currency' value='"+cur+"' id='getcurrencylable'"+id+"'></input> </td>"+
					"<td style='right: 5px; position: relative;'>&nbsp;"+ 
					"<input type='text' style='width: 60px' name='' id='sr"+id+"' value='"+id+"' class='form-control' readonly/></td>"+
					"<td style='left: 2px; position: relative; width: 150px'>&nbsp;"+
					"<input readonly type='text' value='"+partno+"' name='particulee1'style='overflow: auto; border-radius: 3px; width: 223px;'id='partno"+id+"' class='form-control'/></td>"+
					"<td style='width: 250px'>&nbsp; <input readonly name='description' id='description"+id+"' class='form-control' style='text-align: center;width: 238px;' value='"+dis+"' ></input></td>"+
					"<td style='right: 7px; position: relative;'>&nbsp; <input readonly type='text' style='text-align: center;' name='tpinjpy' id='tpinjpy"+id+"' value='"+tpn+"' class='form-control' /></td>"+
					"<td align='center' style='right: 4px; position: relative;'>&nbsp;<input readonly type='text' style='text-align: center;' name='qty' id='qty"+id+"' class='form-control' onkeypress='return event.charCode >= 48 && event.charCode <= 57' value='"+qty+"' /></td>"+
					"<td align='center'>&nbsp; <input readonly type='text' style='text-align: center;' name='totaljpy' id='totaljpy"+id+"' value='"+totjpy+"' class='form-control'   onchange='caltotalagain();' /></td>"+
					"<td align='center'>&nbsp;<input readonly type='text' style='text-align: center;width: 132px;' onkeyup='this.value=value.toUpperCase();' name='customerporefe' id='customerporefe"+id+"' value='"+custpo+"' class='form-control'/>"+
					"</td>"+
					"<td style='display: none;'><input type='hidden' name='grandtotal' value='' id='grandtotal"+id+"'></input> </td>"+"<td style='display: none;'><input type='hidden' name='date' value='"+date+"' id='getdate"+id+"'></input> </td>"+
					"<td><input type='hidden' style='text-align:center;' name='unitcost' id='' value='split' class='form-control'  ></td>"+
					"<td><a class='glyphicon glyphicon-pencil' title='Edit This Row' href='#' onclick='editfields("+(id)+")'></a> |<a class='glyphicon glyphicon-remove' title='Remove This Row' href='#' onclick='deletethisrow("+(id)+")' id="+(id)+"></a></td>"+
					"</tr>";
	            $("#addprolisttbody").append(markup);
				alert(markup);
	            //id++;
	            $('#sr').val(id+1);
	            
	            var d;
				var d1;
				var d2=0;
				 var id=$('#addprolisttbody').children('tr').length;
				for(var i=1;i<=id;i++){
				d=$('#totaljpy'+i).val();
				
				d1=parseInt((d), 10);
				d2=parseInt((d1), 10)+parseInt((d2), 10);
				}
				$('#tjpy1').val(d2);
			var d=$('#tjpy1').val();
			$('#grandtotal1').val(d);
			$('#autocomplete').val('');
			$('#description').val('');
			$('#tpinjpy').val('');
			$('#qty').val('');
			$('#totaljpy').val('');
			$('#customerporefe').val('');
				}
	        });
	 });
	
  
  */
  
</script>