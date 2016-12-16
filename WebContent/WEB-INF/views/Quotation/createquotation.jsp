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

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
				<span class="glyphicon glyphicon-copy"></span> Create Quotation

		

				
				
				
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
					<input type="text" class="form-control" name="Refno" placeholder="Customer Name"
						 id="autocompletecustomer"  ></input>
				</div>

				<div class="col-sm-1 form-level">
				 Ref No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
					<span> <input type="text" class="form-control" name="Refno" placeholder="Reference No."
						 id="Refno"  size="100" ></input>
						</span>

				</div>
			</div>
			<div>
	
			
			<div class="row form-group">
				<div class="col-sm-3 form-level">
					TO:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
					<textarea rows="4" cols="50" name="address" placeholder="address"
						style="border-radius: 5px; background-color: #f2f2f2;" readonly id="addresstextarea"> </textarea>
						
				</div>
			</div>
			
			

			  </div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
				E-mail id:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<input type="text" name="emailsid" id="emailid" size="50"
						placeholder="Email address" 
						class="form-control" >
				</div>
			</div>
			<div class="row form-group">
        	<div class="col-sm-3 form-level" >
				Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-2">
				<span> <input type="text" class="form-control" name="dateTodate"
						id="datepicker" value="${date}" ReadOnly title="DD/MM/YYYY"></input>
					</span>
					
				</div>

				<div class="col-sm-3 form-level">
				Validity Days:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
					<input type="text" name="Validitydays"
						placeholder="Validity days" value=""
						class="form-control" style="display: inline-block;" id="validityid">
						</div>
			</div>
			
			
			<hr style="color: black">
					<div class="row form-group">
						<div class="col-sm-7">
						</div>
					</div>
				
					<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable">
					<thead id=hidethisthird1>
						<tr bgcolor="#3C8DBC">
							<td style="display: none;"><label>id</label> </td>
									<td class="col-sm-1 form-level" style="width: 10px">&nbsp;
										<font size="2" color="white">
										<label>S.No.</label></font></td>
									<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white">
										<label >Part No</label></font></td>
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
					
					<thead id=hidethisthird>
						<tr bgcolor="#3C8DBC">
							<td style="display: none;"><label>id</label> </td>
									<td class="col-sm-1 form-level" style="width: 10px">&nbsp;
										<font size="2" color="white">
										<label>S.No.</label></font></td>
									<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white">
										<label >Part No</label></font></td>
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
									<!--  <td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label id="totalchangelable">Total JPY</label></font></td>-->
									<!--  <td align="center">&nbsp;<font size="2" style="width: 65px"color="white">
										<label >Customer PO Reference</label></font></td>-->
							<%-- <td align="center"> &nbsp;<font size="2" style="width: 80px" color="white"><label path="">Total INR</label></font> --%>
					
					</tr>
					</thead>
					
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
							<td style="width: 250px">&nbsp; <input name='description'
									id='description' class='form-control'
									style="text-align: center;width: 238px;" value="" ></input></td>
							
							<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='stockqty' 
								id='stockqty' value="" class='form-control' /></td>
								
								<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='unitprice' 
								id='unitperit' value="" class='form-control' /></td>
                             
                             <td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='disc' 
								id='disc' value="" class='form-control' /></td>
								
								<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='netprice' 
								id='netprc' value="" class='form-control' /></td>
                             
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
							<td>
							<input type="hidden" style="text-align:center;" name="unitcost" id="unitcostx" value="" class="form-control"  ></td>
							
							<td align="center">&nbsp; <input type="button" value='+' style="background-color: #3C8DBC;"
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
						
						
						
						<td style="width: 578px" align="right">
						<button type="button" value="Save" onClick=""
						class="btn btn-success pull-center" id="savedata445"
						style="background-color: #3C8DBC;">Save</button>
						</td>
					<td align="right" style="width: 578px">
						<a href="" 
						class="btn btn-link" onclick="changeheading();" data-toggle="modal" data-target="#myModal"  title="Add Terms & Conditions">Show Terms</a>
						</td> 
						
					</tr>


					</table>



					
					<!-- <button type="button" value="AddMore" onClick="productdetail();"
						class="btn btn-success pull-right"
						style="background-color: #3C8DBC;">Add More</button> -->


				</div>

			</div>
	
	</div>

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header" style="background-color: #3C8DBC;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" id="termstext">Write Terms</h4>
        </div>
        <div class="modal-body">
       	<input class="form-control input-lg" id="terma" type="text">
       	<input class="form-control input-lg" id="termb" type="text">
       	<input class="form-control input-lg" id="termc" type="text">
       	<input class="form-control input-lg" id="termd" type="text">
       	<input class="form-control input-lg" id="terme" type="text">
       	<input class="form-control input-lg" id="termf" type="text">
       	<input class="form-control input-lg" id="termg" type="text">
       	<input class="form-control input-lg" id="termh" type="text">
       	<input class="form-control input-lg" id="termi" type="text">
       	<input class="form-control input-lg" id="termj" type="text">
        </div>
        <div class="modal-footer" style="background-color: white;">
         <button type="button" class="btn btn-success" style="background-color: #3C8DBC;" data-dismiss="modal">Send</button>
        </div>
      </div>
    </div>
    
  </div>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>

<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>





<script>
function changeheading(){
	var term1=$('#terma').val();
	var term2=$('#termb').val();
	var term3=$('#termc').val();
	var term4=$('#termd').val();
	var term5=$('#terme').val();
	var term6=$('#termf').val();
	var term7=$('#termg').val();
	var term8=$('#termh').val();
	var term9=$('#termi').val();
	var term10=$('#termj').val();
	if(term1!=''||term2!=''||term3!=''||term4!=''||term5!=''||term6!=''||term7!=''||term8!=''||term9!=''||term10!=''){
		$('#termstext').text('Edit Terms');
	}else{
		$('#termstext').text('Write Terms');
	}
}

$(document).ready(function(){
	 var id=$('#addprolisttbody').children('tr').length;
// 	 $('#sr').val(id+1);
       $("#addmorepro12").click(function(){
		    	$('#hidethisthird1').show();
		       	$('#hidethisthird').hide();
		        
		       	
		       	var id=$('#addprolisttbody').children('tr').length+1;
		       	var dateh=$("#datepicker").val();
		       	var valdays=$("#validityid").val();
		       	var emailadd=$('#emailid').val();
		       	var adress=$('#addresstextarea').val();
		       	var refnum=$('#Refno').val();
		       	var custname=$('#autocompletecustomer').val();
		       	var perit=$('#unitperit').val();
		      	var word=$('#autocomplete').val();
		      	var disco=$('#disc').val();
		      	var netprice=$('#netprc').val();
		    	var qtye=$('#qty').val();
				var  dis	= $('#description').val();
				var	 totjpy	=$('#totaljpy').val();
		 		var	 custpo	=$('#customerporefe').val();

			
           var markup = '<tr>'+
           '<td style="display: none;"><input type="hidden" value="" id="getid1"></input> </td>'+
           '<td style="right: 5px; position: relative;">&nbsp; <input readonly type="text" style="width: 60px" name="" id="sr'+id+'" value="'+id+'" class="form-control"/></td>'+
           '<td style="left: 2px; position: relative; width: 150px">&nbsp;<input readonly type="text" value="'+word+'" name="particulee1" style="overflow: auto; border-radius: 3px; width: 223px; "id="autocomplete'+id+'" class="form-control"/></td>'+
           '<td style="width: 250px">&nbsp; <input readonly name="" id="description'+id+'" class="form-control" style="text-align: center;width: 238px;" value="'+dis+'" ></input></td>'+
           '<td style="right: 7px; position: relative;">&nbsp; <input readonly type="text" style="text-align: center;" name="" id="stockqty'+id+'" value="" class="form-control" /></td>'+
           '<td style="right: 7px; position: relative;">&nbsp; <input readonly type="text" style="text-align: center;" name="unitprice" id="unitperit'+id+'" value="'+perit+'" class="form-control" /></td>'+
           '<td style="right: 7px; position: relative;">&nbsp; <input readonly type="text" style="text-align: center;" name="disc" id="disc'+id+'" value="'+disco+'" class="form-control" /></td>'+
           '<td style="right: 7px; position: relative;">&nbsp; <input readonly type="text" style="text-align: center;" name="netprice" id="netprc'+id+'" value="'+netprice+'" class="form-control" /></td>'+
           '<td align="center" style="right: 4px; position: relative;">&nbsp;<input readonly type="text" style="text-align: center;" name="qty" onkeypress="return event.charCode >= 48 && event.charCode <= 57" id="qty'+id+'" class="form-control" value="'+qtye+'"/></td>'+
           '<td align="center">&nbsp;<input readonly type="text" style="text-align: center;" name="totaljpy" id="totaljpy'+id+'" value="'+totjpy+'" class="form-control"  /></td>'+
           '<td align="center">&nbsp; <input readonly type="text" style="text-align: center;width: 132px;" onkeyup="this.value=value.toUpperCase();" name="customerporefe" id="customerporefe'+id+'" value="'+custpo+'" class="form-control"/></td>'+
           '<td><input type="hidden" style="text-align:center;" name="customername" id="customername'+id+'" value="'+custname+'" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="refnumber" id="refnum'+id+'" value="'+refnum+'" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="address" id="adress'+id+'" value="'+adress+'" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="email" id="eamil'+id+'" value="'+emailadd+'" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="date" id="date'+id+'" value="'+dateh+'" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="validays" id="valdays'+id+'" value="'+valdays+'" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="grandtotal" id="grandtotal'+id+'" value="'+valdays+'" class="form-control"  ></td>'+
           
           
           '<td><input type="hidden" style="text-align:center;" name="terma" id="terma'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="termb" id="termb'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="termc" id="termc'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="termd" id="termd'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="terme" id="terme'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="termf" id="termf'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="termg" id="termg'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="termh" id="termh'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="termi" id="termi'+id+'" value="" class="form-control"  ></td>'+
           '<td><input type="hidden" style="text-align:center;" name="termj" id="termj'+id+'" value="" class="form-control"  ></td>'+
           "<td><a class='glyphicon glyphicon-pencil' href='#' onclick='editfields("+(id)+");return false'></a><a class='glyphicon glyphicon-remove' href='#' onclick='deletethisrow("+(id)+");return false;' id="+(id)+"></a></td>"+
           '</tr>';
           $("#addprolisttbody").append(markup);
           calculation();
           //id++;
           $('#sr').val(id+1);
           
           	var d;
			var d1;
			var d2=0;
			var id=$('#addprolisttbody').children('tr').length;
			
		var d=$('#tjpy1').val();
		$('#grandtotal1').val(d);
		$('#unitperit').val('');
      	$('#autocomplete').val('');
      	$('#disc').val('');
      	$('#netprc').val('');
    	$('#qty').val('');
		$('#description').val('');
		$('#totaljpy').val('');
 		$('#customerporefe').val('');
 		calculation();
       });
});


$('#autocomplete').on("click",function(){
	var word=$('#autocomplete').val();

//alert($(e.target).val() );	
$.ajax({
	url: "getpartno?word="+word, 
	success: function(result){
		calculation();
		console.log(result);
		search(result);
		
}});

});

function search(result){
	var currencies =jQuery.parseJSON(result);
	/* alert(currencies); */
	$('#autocomplete').autocomplete({
	    lookup: currencies,
	    onSelect: function (suggestion) {
	    var pro= suggestion.value;
	      $.ajax({
				url: "getpartdetail?pro="+pro, 
				success: function(result){
				console.log(result);
					for(i=0;i<result.length;i++){
						var data=result.replace('"','');
						data=data.replace('"','');
					}
				var	productdescription=data.split(',')[0]
				var cost=data.split(',')[1];
					
					var unitcostx=data.split(',')[2];	
					
					$('#unitperit').val(unitcostx);
					
					$('#description').val(productdescription);
					//$('#tpinjpy').val(cost);
					
			      	
			      	
					
		    }});
	      
	      
	    }
	  });
	}

$('#disc').keyup(function(){
	var perit=$('#unitperit').val();
	var disco=$('#disc').val();
	var discount=Number(perit)-((Number(perit)*Number(disco))/Number(100));
	$('#netprc').val(discount);
	var qtye=$('#qty').val();
	var netprice=$('#netprc').val();
	if(qtye!=''&&netprice!=''){
		$('#totaljpy').val(Number(netprice)*Number(qtye));
		calculation();
	}
	calculation();
});

$('#qty').keyup(function(){
	var netprice=$('#netprc').val();
	var qtye=$('#qty').val();
	$('#totaljpy').val(Number(netprice)*Number(qtye));
	calculation();
});



function editfields(id){
	 var d=$('#totaljpy'+id).val();
	
	$('#qty'+id).attr("readonly", false); 
	$('#customerporefe'+id).attr("readonly", false); 
	$('#unitperit'+id).attr("readonly", false);
  	$('#autocomplete'+id).attr("readonly", false);
  	$('#disc'+id).attr("readonly", false);
  	$('#netprc'+id).attr("readonly", false);
	$('#qty'+id).attr("readonly", false);
	$('#description'+id).attr("readonly", false);
	
	$('#customerporefe'+id).attr("readonly", false);
	
	
	
	/* $('#qty'+id).keyup(function(){
		
		var d1=$('#tjpy1').val();
		$('#tjpy1').val(parseInt((d1), 10)-parseInt((d), 10));
		var qty=$('#qty'+id).val();
		var unit=$('#unitcostx').val();
		var jpy=$('#tpinjpy'+id).val();
		var total=parseInt(qty) * parseInt(jpy);
		$('#totaljpy'+id).val(total);
		var d2=$('#totaljpy'+id).val();
		var d3=$('#tjpy1').val();
		$('#tjpy1').val(parseInt((d3), 10)+parseInt((d2), 10));
	var grandtotl=	$('#tjpy1').val();
		$('#grandtotal1').val(grandtotl);
		calculation();
	}); */
	
	
	$('#disc'+id).keyup(function(){
		var perit=$('#unitperit'+id).val();
		var disco=$('#disc'+id).val();
		var discount=Number(perit)-((Number(perit)*Number(disco))/Number(100));
		$('#netprc'+id).val(discount);
		var qtye=$('#qty'+id).val();
		var netprice=$('#netprc'+id).val();
		if(qtye!=''&&netprice!=''){
			$('#totaljpy'+id).val(Number(netprice)*Number(qtye));
			calculation();
			var d=$('#tjpy1').val();
			$('#grandtotal1').val(d);
		}
		calculation();
		var d=$('#tjpy1').val();
		$('#grandtotal1').val(d);
	});

	$('#qty'+id).keyup(function(){
		var netprice=$('#netprc'+id).val();
		var qtye=$('#qty'+id).val();
		$('#totaljpy'+id).val(Number(netprice)*Number(qtye));
		calculation();
		var d=$('#tjpy1').val();
		$('#grandtotal1').val(d);
	});
	
	
	
	$('#autocomplete'+id).click(function(){
		var word=$('#autocomplete'+id).val();
		$.ajax({
			url: "getpartno?word=", 
			success: function(result){
				console.log(result);
				search1(result);
				
	    }});
		
	});
	
	function search1(result){
		//alert(result);
		var currencies =jQuery.parseJSON(result);
		
	$('#autocomplete'+id).autocomplete({
	    lookup: currencies,
	    onSelect: function (suggestion) {
	    var pro= suggestion.value;
	      $.ajax({
				url: "getpartdetail?pro="+pro, 
				success: function(result){
					for(i=0;i<result.length;i++){
						var data=result.replace('"','');
						data=data.replace('"','');
					}
				var	productdescription=data.split(',')[0]
				var cost=data.split(',')[1];
				var unitcostx=data.split(',')[2];	
				$('#unitperit'+id).val(unitcostx);
				
				$('#description'+id).val(productdescription);
				$('#disc'+id).val('');
		      	$('#netprc'+id).val('');
		    	$('#qty'+id).val('');
				
				$('#totaljpy'+id).val('');
		 		$('#customerporefe'+id).val('');
					calculation();
					var d=$('#tjpy1').val();
					$('#grandtotal1').val(d);
		    }});
	      
	      
	    }
	  });
	}
	
}




$('#autocompletecustomer').on("click",function(){
	//var word=$('#autocomplete').val();
	
	//alert($(e.target).val() );	
		$.ajax({
			url: "getCustomerRecords", 
			success: function(result){
				console.log(result);
				search1(result);
				
					}
		});

});

function search1(result){
//alert(result);
var currencies =jQuery.parseJSON(result);
//alert(currencies);
$('#autocompletecustomer').autocomplete({
lookup: currencies,
onSelect: function (suggestion) {
var company= suggestion.value;
 $.ajax({
		url: "getcompanydatabyname?organization="+company, 
		success: function(result){
			
			var data=jQuery.parseJSON(result);
			var add=data.address;
			var email=data.emailId;
			var mobile=data.mobileNo;
			var sta=data.status;
			console.log(add+'>>>>>>>>>'+sta);
			$('#addresstextarea').val(add);
			$('#emailid').val(email);
			//$('#mob').val(mobile);
			
			
    }}); 
  
  
}
});
}
$( function() {
    $("#datepicker" ).datepicker({dateFormat:'dd/mm/yy'}).datepicker("setDate", new Date());
  });
  
  $('#validityid').val('30 Days');


$('#hidethisthird1').hide();

function calculation(){
	var id=$('#addprolisttbody').children('tr').length;
	var t1=0;
	for(var i=1;i<=id ; i=i+1){
		t1+= Number($('#totaljpy'+i).val());
		
	}
	console.log(t1);
	$('#tjpy1').val(t1);
	
}


function deletethisrow(id){
	
	 $("#"+id).parents("tr").remove();
id=$('#addprolisttbody').children('tr').length;
$('#sr').val(id+1);
for (i=0;i<id ; i++){
	calculation();
}
calculation();
var d=$('#tjpy1').val();
$('#grandtotal1').val(d);
}





$("#savedata445").bind("click", function() {
	var temp=$("#totalchangelable").text();
	calculation();
	 var d=$('#tjpy1').val();
	 $('#grandtotal1').val(d);
	 inputTrems();
		  var AddressesDataJSON = $("#quotprodtable").find('input').serializeArray();
		  console.log(AddressesDataJSON);

		  
		 
	  $.ajax({
				url: "savequotation",
				type: "POST",
				
				  data :JSON.stringify(AddressesDataJSON),
				  cache:false,
			        beforeSend: function(xhr) {  
			            xhr.setRequestHeader("Accept", "application/json");  
			            xhr.setRequestHeader("Content-Type", "application/json");  
			        },
				     success: function(resposeJsonObject){
				    	 
				    	 //location.reload();
				    	 alert('saved!!!');
				    	 window.location.href = "quotation";
			    }
			}); 
		});
		
		
function inputTrems(){
	var term1=$('#terma').val();
	var term2=$('#termb').val();
	var term3=$('#termc').val();
	var term4=$('#termd').val();
	var term5=$('#terme').val();
	var term6=$('#termf').val();
	var term7=$('#termg').val();
	var term8=$('#termh').val();
	var term9=$('#termi').val();
	var term10=$('#termj').val();
	
	
	 $('#terma1').val(term1);
	 $('#termb1').val(term2);
	 $('#termc1').val(term3);
	 $('#termd1').val(term4);
	 $('#terme1').val(term5);
	 $('#termf1').val(term6);
	 $('#termg1').val(term7);
	 $('#termh1').val(term8);
	 $('#termi1').val(term9);
	 $('#termj1').val(term10);
	
}

</script>





