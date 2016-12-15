<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/displaytag.css" />
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
				<i>
				
				</i> <input type="hidden" name="profile" value="0" />
			</div>
		</div>

		<div class="row">

			<div class="page-heading col-sm-11" id="createpo"
				style="background-color: #3C8DBC; left: 10px">
				<span class="glyphicon glyphicon-copy"></span> Create Order
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				
				
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
					Customer Name:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<input type="text" name="customername" placeholder="Customer Name"
						onkeyup="" id="customerid"  value=""
						class="form-control">
						
				</div>

				<div class="col-sm-1 form-level">
			Customer Location:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
					<span> <input type="text" class="form-control" name="Customerlocation" placeholder="Customer Location."
						 id="CusLocid"  size="100" ></input>
						</span>

				</div>
			</div>
			<div>
	
			
			<div class="row form-group">
				<div class="col-sm-3 form-level">
				Order No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<span> <input type="text" class="form-control" name="Orderno" placeholder="Order No."
						 id="Orderid"  size="120" ></input>
						  
						</span>
						
				</div>
			</div>
			
			  </div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
				Quotation No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<select type="text" name="Quotationno" id="Quotationid" size="1"
						placeholder="Quotation no" 
						class="form-control" >
						<option>select quotation no</option>
						</select>
						
				</div>
			</div>
			<div class="row form-group">
        	<div class="col-sm-3 form-level" >
				Order Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
				<span> <input type="text" class="form-control" name="dateTodate" 	placeholder="Order Date"
						id="datepicker1" value="${date}" ReadOnly title="DD/MM/YYYY"></input>
					</span>
					
				</div>

				<div class="col-sm-2 form-level">
				Receive Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
				<span> <input type="text" class="form-control" name="recivedate" 	placeholder="Order Receive Date"
						id="datepicker2" value="${date}" ReadOnly title="DD/MM/YYYY"></input>
					</span>
					
				</div>
			</div>
			
			
			<hr style="color: black">
					<div class="row form-group">
						<div class="col-sm-7">
						</div>
					</div>
				
					<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable">
					<thead>
						<tr bgcolor="#3C8DBC">
							<td style="display: none;"><label>id</label> </td>
									<td class="col-sm-1 form-level" style="width: 10px">&nbsp;
										<font size="2" color="white">
										<label>S.No.</label></font></td>
									<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white">
										<label >Part No</label></font></td>
										<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white">
										<label >Product Type</label></font></td>
										
									<td align="center" class="col-sm-1 form-level"style="width: 80px">&nbsp;&nbsp;&nbsp;<font size="2" color="white">
										<label >Description</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label id="tpinchangelable">Stock Qty</label></font></td>
								
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label id="unitprice">Unit price</label></font></td>	
										
								   <td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label id="dis">Disc%</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label id="netprice">Net price</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label >QTY</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label id="amount">Amount</label></font></td>	
										<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label id="amount">Delivery</label></font></td>	
										<td align="center">&nbsp;<div class="checkbox">
										<label>
                                      <input type="checkbox" value="" id="maincheackbox" onclick="toggle(this)">
                                       <span class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
            
          </label>
									<!--  <td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label id="totalchangelable">Total JPY</label></font></td>-->
									<!--  <td align="center">&nbsp;<font size="2" style="width: 65px"color="white">
										<label >Customer PO Reference</label></font></td>-->
							<%-- <td align="center"> &nbsp;<font size="2" style="width: 80px" color="white"><label path="">Total INR</label></font> --%>
					
					</tr>
					</thead>
					<tbody id="addprolisttbody">
					
					</tbody>
					</table>
					
					<table>
					<tr>
					<td style="display: none;"><input type="hidden" value="" id="getid1"></input> </td>
					<td style="right: 5px; position: relative;">&nbsp; 
					<input type='text' style='width: 60px' name='posrno' id='sr'
								value="" class='form-control'/></td>
							<td style="left: 2px; position: relative; width: 150px">&nbsp;
								<input type='text' value="" name='particulee1'
								style='overflow: auto; border-radius: 3px; width: 223px;'
								id='autocomplete' class='form-control'/>	
							</td>
							
							<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='producttype' 
								id='protypeid' value="" class='form-control' /></td>
								
							<td style="width: 250px">&nbsp; <input name='description'
									id='description' class='form-control'
									style="text-align: center;width: 238px;" value="" ></input></td>
							
							<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='stockqty' 
								id='stockqty' value="" class='form-control' /></td>
								
								<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='unitprice' 
								id='unitprice' value="" class='form-control' /></td>
                             
                             <td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='disc' 
								id='disc' value="" class='form-control' /></td>
								
								<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='netprice' 
								id='netprice' value="" class='form-control' /></td>
                             
							<td align="center" style="right: 4px; position: relative;">&nbsp;
								<input  type='text' style='text-align: center;' name='qty' onkeypress='return event.charCode >= 48 && event.charCode <= 57'
								id='qty' class='form-control' value=""/>
							</td>
							<td align="center">&nbsp; 
							<input  type='text'
								style='text-align: center;' name='totaljpy' id='totaljpy' value=""
								class='form-control'  /></td>

							<td align="center">&nbsp; 
							
							<input type='text'
								style='text-align: center;width: 132px;' onkeyup='this.value=value.toUpperCase();' 
								name='customerporefe' id='customerporefe' value=""
								class='form-control'/>
							</td>
							
							<td align="center">&nbsp;<div class="checkbox">
          		<label>
            <input type="checkbox" value="" name="savecheck" id="savecheck${loop.index+1}">
            <span class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
            
          		</label>
							
							<td>
							<input type="hidden" style="text-align:center;" name="unitcost" id="unitcostx" value="" class="form-control"  ></td>
							<td>
							<td align="center">&nbsp; <input type="button" value='+'
							 id='addmorepro12' class='btn btn-success pull-right' data-toggle='tooltip'
								title='Add More Product'/>
					</tr>
					
					</table>
</form>

			
				<div class="row form-group" style="top: 10px; position: relative;"
					onclick="">
					<div class="col-sm-10 form-level" align="right">
						Total:<font color="#FF0000"></font>
					</div>
					<div align="right">
						<input type="text" name="tjpy1" id="tjpy1" class="form-control"
							value="${total}" style="width: 15%;" readonly>
					</div>
				</div>

				<hr align="left" size="" width="100%"
					style="background-color: #3C8DBC;height: 1px; " />

				<div align="center">

					<table>
					<tr>
						
						
						<!-- <td>
							<button type="button" value="update" onclick="numberingRow();"
								class="btn btn-success pull-center"
								style="background-color: #3C8DBC;">Number row</button>
						</td> -->
						<td>&nbsp;&nbsp;</td>
						<td>
						<button type="button" value="Save" onClick=""
						class="btn btn-success pull-center" id=""
						style="background-color: #3C8DBC;">Save</button>
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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>

<script>
$( function() {
    $( "#datepicker1" ).datepicker({dateFormat: 'dd/mm/yy'});
    $( "#datepicker2" ).datepicker({dateFormat: 'dd/mm/yy'});
  } );
</script>

