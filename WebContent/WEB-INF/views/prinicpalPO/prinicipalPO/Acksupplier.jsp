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





<div class="row" style="margin-top: 15px">
			<br>
			<div align="center">
				<i>
				
				</i> <input type="hidden" name="profile" value="0" />
			</div>
		</div>

		<div class="row">

			
		</div>

		<div class="row" id="editpo">
			<div class="page-heading col-sm-11"
				style="background-color: #3C8DBC; left: 10px">
				<span class="glyphicon glyphicon-copy"></span> Acknowledge PO
			</div>
		</div>
		
		
	<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">
		<div class="row form-group">

				<div class="col-sm-3 form-level">
					PO Reference No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<input type="text" name="porefno" placeholder="PO Reference No."
						onkeyup="myFunction()" id="porefno" size="150" value="${porefnumber}"
						class="form-control" />
				</div>

				<div class="col-sm-1 form-level">
					Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-2">
					<span> <input type="text" class="form-control" name="dateTodate"
						id="datepicker" value="${date}" ReadOnly></input>
						
					</span>

				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
					Principal Name:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-9">
					<input type="text" name="principalname"
						placeholder="Principal Name" value="YMC Co. Ltd., Japan"
						class="form-control" style="display: inline-block;" ReadOnly>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
					Address:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-9">
					<textarea rows="4" cols="77" name="address"
						style="border-radius: 5px; background-color: #f2f2f2;" readonly>YMC CO.,LTD. YMC Karasuma-Gojo Building 284 Daigo-cho Karasuma Nishiliru Gojo-dori,Shimogyo -Ku Kyoto 600-8106 Japan"  </textarea>
						
				</div>
			</div>
			<div class="row form-group">

				<div class="col-sm-3 form-level">
					S.No.:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-2">
					<select name="" class="form-control selectpicker" required="required" id="">
  						<option>---Select---</option> 
  						<c:if test="${!empty listbyporef}">
						<c:forEach items="${listbyporef}" var="poref" varStatus="loop">
						      <option value="${loop.index+1}">${loop.index+1}</option>
							 
						</c:forEach>
						</c:if>
  					</select>
				</div>

				<div class="col-sm-1 form-level">
					Part NO.:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-3">
					<span> <select name="" class="form-control selectpicker" required="required" id="" onChange="searchPro(this.value)">
					 <option>---Select---</option> 
							<c:if test="${!empty listbyporef}">
								<c:forEach items="${listbyporef}" var="poref" varStatus="loop">
 
						      <option value="${poref.porefentryitemdetailid}">${poref.particular}</option>
							  
						  		</c:forEach>
							</c:if>
  						</select>
						
					</span>

				</div>
			</div>
			<hr style="color: black">
					<div class="row form-group">
						<div class="col-sm-7">
						</div>
					</div>
					<div id="searchedRecord">
					
					</div>
					
					<div id='body'>
					
					<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable">
					<thead>
						<tr bgcolor="#3C8DBC">
									<td style="display: none;"><label>id</label> </td>
									<td class="col-sm-1 form-level" style="width: 10px">&nbsp;<font size="2" color="white"><label>S.No.</label></font></td>
									<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white"><label >Part No</label></font></td>
									<td align="center" class="col-sm-1 form-level"style="width: 80px">&nbsp;&nbsp;&nbsp;<font size="2" color="white"><label >Description</label></font></td>
									
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >TP In JPY</label></font></td>
									
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >QTY</label></font></td>
									
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >Total JPY</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Pending Qty</label></font></td>
							<%-- <td align="center"> &nbsp;<font size="2" style="width: 80px" color="white"><label path="">Total INR</label></font> --%>
					
					</tr>
					</thead>
					<tbody id="addprolisttbody">
					<c:if test="${!empty listbyporef}">
						<c:forEach items="${listbyporef}" var="poref" varStatus="loop">
					
					<tr>
					<td style="display: none;"><input type="hidden" name="date" value="${date}" id="getdate${loop.index+1}"> </td>
					<td style="display: none;"><input type="hidden" name="porefno" value="${porefnumber}" id="getporefno${loop.index+1}"> </td>
					<td style="display: none;"><input type="hidden" name="entryitemid" value="${poref.porefentryitemdetailid}" id="getid${loop.index+1}"> </td>
					<td style="right: 5px; position: relative;">&nbsp;<input type="text" style="width: 60px" name="" id="sr${loop.index+1}" value="${loop.index+1}" class="form-control" readonly></td>
					<td style="left: 2px; position: relative; width: 150px">&nbsp;<input readonly type="text" value="${poref.particular}" name="particulee${loop.index+1}" style="overflow: auto; border-radius: 3px; width: 223px;" id="partno${loop.index+1}" class="form-control"></td>
					<td style="width: 250px">&nbsp; <input readonly name="description" id="description${loop.index+1}" class="form-control" style="text-align: center;width: 238px;" value="${poref.productdescription}"></td>
					<td style="right: 7px; position: relative;">&nbsp; <input readonly type="text" style="text-align: center;" name="tpinjpy" id="tpinjpy${loop.index+1}" value="${poref.tpinjpy}" class="form-control"></td>
					<td align="center" style="right: 4px; position: relative;">&nbsp;<input readonly type="text" style="text-align: center;" name="qty" id="qty${loop.index+1}" class="form-control" value="${poref.qty}"></td>
					<td align="center">&nbsp; <input readonly type="text" style="text-align: center;" name="totaljpy" id="totaljpy${loop.index+1}" value="${poref.totaljpy}" class="form-control"></td>
					<td align="center">&nbsp;<button  type="button" style="text-align: center;width: 99px;background-color: #3C8DBC;color: aliceblue" name="customerporefe" id="pendindqty${loop.index+1}" value="${poref.pendingqty}" class="form-control" onclick="saveacknowlegdement(${loop.index+1});">${poref.pendingqty}</button></td>
					<td style="display: none;"><input type="hidden" name="grandtotal" value="${gtotal}" id="grandtotal${loop.index+1}"> </td><td style="display: none;"><input type="hidden" name="date" value="11/21/2016" id="getdate"> </td>
					
					</tr>
					</c:forEach>
					</c:if>
					</tbody>
					</table>
					</div>
					
					
					<div class="row form-group"  position: relative;" onclick="" id="pendingformdiv">
					<table>
					<tr>
					<td class="col-sm-6 form-level" align="center">
					
						Exp.Delivery Date
					
					</td>
					<td class="col-sm-6 form-level">
					
						Receive Quantity	
					
					</td>
					</tr>
					<tr>
					<td class="col-sm-6 form-level">
					
						<input type="text" class="form-control" name="dateTodate" id="datepicker1" value="" ReadOnly></input>
					
					</td>
					<td class="col-sm-6 form-level">
					
						<input type="text" name="tjpy1" id="tjpy" class="form-control"
							value="" style="width: 35%;">
					
					</td>
					</tr>
					
					
					</table>
					<table style="width: 100%; position: relative;" > 
					<tr >
					<td class="col-sm-6 form-level" align="right">
					<button type="button" value="update"
								class="btn btn-success pull-center" id="saveackdetail"
								style="background-color: #3C8DBC;">Update</button>
					</td>
					<td class="col-sm-6 form-level" align="left">
					<button type="button" value="update" onclick="backbutton();"
								class="btn btn-success pull-center" id=""
								style="background-color: #3C8DBC;">Back</button>
					</td>
					</tr>
					
					</table>
				</div>
					
			</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>
   	
   	
   	<script>
$( function() {
    $("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
$( function() {
    $( "#datepicker1" ).datepicker({dateFormat: 'dd/mm/yy'});
  } );
  
function searchPro(wordinsrch) {
	//alert("hi");
	//alert(loginname);
	$("#searchedRecord").empty();
	$("#body").show();
	$
			.ajax({

				type : "GET",
				url : 'ackdatabysearch?poref='+wordinsrch,
				
				success : function(data) {
					
					var obj = JSON.parse(data);
				
					var ind=0;
					var content = '<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable"><thead><tr>'
						+ '<tr bgcolor="#3C8DBC">'
						+ '<td style="display: none;"><label>id</label> </td>'
						+ '<td class="col-sm-1 form-level" style="width: 10px">&nbsp;<font size="2" color="white"><label>S.No.</label></font></td>'
						+ '<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white"><label >Part No</label></font></td>'
						+ '<td align="center" class="col-sm-1 form-level"style="width: 80px">&nbsp;&nbsp;&nbsp;<font size="2" color="white"><label >Description</label></font></td>'
						+ '<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >TP In JPY</label></font></td>'
						+ '<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >QTY</label></font></td>'
						+ '<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >Total JPY</label></font></td>'
						+ '<td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Pending Qty</label></font></td>'
						+ '</tr></thead>'
					if (obj.length == 0) 
					{
						content += '<tr><td colspan="8"><font color="red" size="3">No record found.</font></td></tr>';
					} 
					else
					{
						$
						.each(
								obj,
								function(key, value) {
									content += '<tbody id="addprolisttbody"><tr>';
									content += '<td style="display: none;"><input type="hidden" name="date" value="${date}" id="getdate${loop.index+1}"> </td>';
											
									content += '<td style="display: none;"><input type="hidden" name="porefno" value="${porefnumber}" id="getporefno${loop.index+1}"> </td>';
											
									content += '<td style="display: none;"><input type="hidden" name="entryitemid" value="${poref.porefentryitemdetailid}" id="getid${loop.index+1}"> </td>';
									content += '<td style="right: 5px; position: relative;">&nbsp;<input type="text" style="width: 60px" name="" id="sr${loop.index+1}" value="${loop.index+1}" class="form-control" readonly></td>';
									content += '<td style="left: 2px; position: relative; width: 150px">&nbsp;<input readonly type="text" value="${poref.particular}" name="particulee${loop.index+1}" style="overflow: auto; border-radius: 3px; width: 223px;" id="partno${loop.index+1}" class="form-control"></td>';
									content += '<td style="width: 250px">&nbsp; <input readonly name="description" id="description${loop.index+1}" class="form-control" style="text-align: center;width: 238px;" value="${poref.productdescription}"></td>';		
									content += '<td style="right: 7px; position: relative;">&nbsp; <input readonly type="text" style="text-align: center;" name="tpinjpy" id="tpinjpy${loop.index+1}" value="${poref.tpinjpy}" class="form-control"></td>';		
									content += '<td align="center" style="right: 4px; position: relative;">&nbsp;<input readonly type="text" style="text-align: center;" name="qty" id="qty${loop.index+1}" class="form-control" value="${poref.qty}"></td>';
									content += '<td align="center">&nbsp; <input readonly type="text" style="text-align: center;" name="totaljpy" id="totaljpy${loop.index+1}" value="${poref.totaljpy}" class="form-control"></td>';		
									content += '<td align="center">&nbsp;<button  type="button" style="text-align: center;width: 99px;background-color: #3C8DBC;color: aliceblue" name="customerporefe" id="customerporefe${loop.index+1}" value="${poref.qty}" class="form-control">${poref.qty}</button></td>';
									content += '<td style="display: none;"><input type="hidden" name="grandtotal" value="${gtotal}" id="grandtotal${loop.index+1}"> </td><td style="display: none;"><input type="hidden" name="date" value="11/21/2016" id="getdate"> </td>';
								});
				content += '</tbody></table>';
						}
					$("#body").hide();
				$("#searchedRecord").append(content);
				
			},
			error : function(e) {
				
			}
		});

}	

function saveacknowlegdement(id){
	var ponum=$("#getporefno"+id).val();
	var particular=$("#partno"+id).val();
	var qty=$('#qty'+id).val();
	var pqty=$("#pendindqty"+id).val();
	var des=$('#description'+id).val();
	var tpjpy=$('#tpinjpy'+id).val();
	var ttoaljpy=$('#totaljpy'+id).val();
	var sr=$('#sr'+id).val();
	var content = '<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable"><thead><tr>'
		+ '<tr bgcolor="#3C8DBC">'
		+ '<td style="display: none;"><label>id</label> </td>'
		+ '<td class="col-sm-1 form-level" style="width: 10px">&nbsp;<font size="2" color="white"><label>S.No.</label></font></td>'
		+ '<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white"><label >Part No</label></font></td>'
		+ '<td align="center" class="col-sm-1 form-level"style="width: 80px">&nbsp;&nbsp;&nbsp;<font size="2" color="white"><label >Description</label></font></td>'
		+ '<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >TP In JPY</label></font></td>'
		+ '<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >QTY</label></font></td>'
		+ '<td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >Total JPY</label></font></td>'
		+ '<td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Pending Qty</label></font></td>'
		+ '</tr></thead>'
		
		
		
	content += '<tbody id="addprolisttbody"><tr>';
	content += '<td style="display: none;"><input type="hidden" name="date" value="" id="getdate"> </td>';
			
	content += '<td style="display: none;"><input type="hidden" name="porefno" value="" id="getporefno"> </td>';
			
	content += '<td style="display: none;"><input type="hidden" name="entryitemid" value="" id="getid"> </td>';
	content += '<td style="right: 5px; position: relative;">&nbsp;<input type="text" style="width: 60px" name="" id="sr" value="'+sr+'" class="form-control" readonly></td>';
	content += '<td style="left: 2px; position: relative; width: 150px">&nbsp;<input readonly type="text" value="'+particular+'" name="particulee" style="overflow: auto; border-radius: 3px; width: 223px;" id="partno" class="form-control"></td>';
	content += '<td style="width: 250px">&nbsp; <input readonly name="description" id="description" class="form-control" style="text-align: center;width: 238px;" value="'+des+'"></td>';		
	content += '<td style="right: 7px; position: relative;">&nbsp; <input readonly type="text" style="text-align: center;" name="tpinjpy" id="tpinjpy" value="'+tpjpy+'" class="form-control"></td>';		
	content += '<td align="center" style="right: 4px; position: relative;">&nbsp;<input readonly type="text" style="text-align: center;" name="qty" id="qty" class="form-control" value="'+qty+'"></td>';
	content += '<td align="center">&nbsp; <input readonly type="text" style="text-align: center;" name="totaljpy" id="totaljpy" value="'+ttoaljpy+'" class="form-control"></td>';		
	content += '<td align="center">&nbsp;<button  type="button" style="text-align: center;width: 99px;background-color: #3C8DBC;color: aliceblue" name="customerporefe" id="pendindqty" value="'+pqty+'" class="form-control">'+pqty+'</button></td>';
	content += '<td style="display: none;"><input type="hidden" name="grandtotal" value="" id="grandtotal"> </td><td style="display: none;"><input type="hidden" name="date" value="11/21/2016" id="getdate"> </td>';
	content += '</tbody></table>';
	
	//content += '<div class="col-sm-2"><input type="text" name="Receive" placeholder="Enter Receive Quantity" id="receiveid" size="150" value="" class="form-control" /></div>';
	//content += '<div class="col-sm-2"><span><input type="text" class="form-control" name="dateTodate" id="datepicker1" value="" ReadOnly></input></span></div>';
	
	$("#body").hide();
	$("#searchedRecord").append(content);
	$('#pendingformdiv').show('slow');
}
$('#pendingformdiv').hide();


function backbutton(){

	window.location.reload();
}


$('#saveackdetail').click(function(){
	
	
	var ponum=$("#porefno").val();
	var particular=$("#partno").val();
	var qty=$('#qty').val();
	var pqty=$("#pendindqty").val();
	var des=$('#description').val();
	var tpjpy=$('#tpinjpy').val();
	var rqty=$('#tjpy').val();
	var date=$('#datepicker1').val();
	var sr=$('#sr').val();
	
	
   var json={
		  		'porefno': ponum,
			    'posrno': '',
			    'particular': particular,
			    'receiveqty': rqty,
			    'pendingqty': pqty,
			    'expdate': date
	};
   
   
   alert(json.porefno+'  <>  ' +json.particular+'   <>  '+json.receiveqty+'   <>  '+json.pendingqty+'   <>   '+json.expdate);
	
});
</script>


	
   	
   	
   	