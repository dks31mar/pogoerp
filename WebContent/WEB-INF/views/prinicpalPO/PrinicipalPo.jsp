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
String hh=(String)session.getAttribute("jsonp");
String norml=(String)session.getAttribute("normal");
String cb=(String)session.getAttribute("CBW");
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
java.util.Date date = new java.util.Date();
System.out.println();
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

			<div class="page-heading col-sm-11"
				style="background-color: #3C8DBC; left: 10px">
				<span class="glyphicon glyphicon-copy"></span> Create PO
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="normal" type="radio"
					name="potype" checked />Normal <input id="CBW" type="radio"
					name="potype" />CBW
				</tr>
			</div>
		</div>

		<div class="row" id="editpo">
			<div class="page-heading col-sm-11"
				style="background-color: #3C8DBC; left: 10px">
				<span class="glyphicon glyphicon-copy"></span> Edit PO
			</div>
		</div>
		
		
	<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">
		<div class="row form-group">

				<div class="col-sm-3 form-level">
					PO Reference No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<input type="text" name="porefno" placeholder="PO Reference No."
						onkeyup="myFunction()" id="porefno" size="150" value="<%=norml %>"
						class="form-control" />
				</div>

				<div class="col-sm-1 form-level">
					Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-2">
					<span> <input type="text" class="form-control" name="date"
						id="datepicker" value="<%=dateFormat.format(date) %>" ReadOnly>
						<img src='' style=""
						onmouseover="displayCalendar(document.getElementById('date'),'dd/mm/yyyy',this,0); return false;"
						border='0' id='imgdate'>
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
			<hr style="color: black">
			<div>
				<div>

					<div class="row form-group">
						<div class="col-sm-7">



	
						</div>



					</div>


					<!-- <input type="text" name="currency" class="biginput"
						id="autocomplete"><br> <br> -->
					
				<form:form method="POST" action="savepodetails" commandName="productadd">
					<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable">
					<tr bgcolor="#3C8DBC">
					<td style="display: none;"><form:label path="porefentryitemdetailid">id</form:label> </td>
							<td class="col-sm-1 form-level" style="width: 10px">&nbsp;<font
								size="2" color="white">
								<form:label path="">S.No.</form:label></font></td>
							
							<td class="col-sm-3 form-level" style="width: 80px"
								align="center">&nbsp;<font size="2" color="white">
								<form:label path="particular">Part No</form:label></font></td>
							<td align="center" class="col-sm-1 form-level"
								style="width: 80px">&nbsp;&nbsp;&nbsp;<font size="2" color="white">
								<form:label path="productdescription">Description</form:label></font></td>
							<td align="center">&nbsp;<font size="2" style="width: 80px"
								color="white">
								<form:label path="tpinjpy">TP In JPY</form:label></font></td>
							<td align="center">&nbsp;<font size="2" style="width: 80px"
								color="white">
								<form:label path="qty">QTY</form:label></font></td>
							<td align="center">&nbsp;<font size="2" style="width: 80px"
								color="white">
								<form:label path="totaljpy">Total JPY</form:label></font></td>
							<td align="center">&nbsp;<font size="2" style="width: 65px"
								color="white"><form:label path="customerporefe">Customer PO Reference</form:label></font></td>
							<%-- <td align="center"> &nbsp;<font size="2" style="width: 80px" color="white"><form:label path="">Total INR</form:label></font> --%>
					
					</tr>
					<c:if test="${!empty prolist}">
					<c:forEach items="${prolist}" var="product" varStatus="loop">
					
					<tr>
					
					<td><c:out value="${loop.index+1}"></c:out></td>
					<td><c:out value="${product.particular}"></c:out></td>
					<td><c:out value="${product.productdescription}"></c:out></td>
					<td><c:out value="${product.tpinjpy}"></c:out></td>
					<td><c:out value="${product.qty}"></c:out></td>
					<td><c:out value="${product.totaljpy}"></c:out></td>
					<td><c:out value="${product.customerporefe}"></c:out></td>
					<td align="left"><a class="glyphicon glyphicon-pencil" href="editproduct?porefentryitemdetailid=${product.porefentryitemdetailid}"></a> | <a class="glyphicon glyphicon-remove" href="deleteproduct?porefentryitemdetailid=${product.porefentryitemdetailid}"></a></td>
					</tr>
			
					</c:forEach>
					</c:if>
					
					
					<tr id="mainForm">
					<td style="display: none;"><form:input path="porefentryitemdetailid" type="hidden" value="${product.porefentryitemdetailid}"></form:input> </td>
					<td style="right: 5px; position: relative;">&nbsp; 
					<form:input path="" type='text' style='width: 60px' name='posrno' id='sr'
								value="${loop.index+1}" class='form-control'/></td>
							<td style="left: 2px; position: relative; width: 150px">&nbsp;
								<form:input path="particular" type='text' value="${product.particular}" name='particulee1'
								style='overflow: auto; border-radius: 3px; width: 143px;'
								id='autocomplete' class='form-control'
								/>
							</td>
							<td style="width: 250px">&nbsp; <form:input path="productdescription" name='description'
									id='description' readonly='true' class='form-control'
									style="text-align: center;width: 238px;" value="${product.productdescription}" onfocus='closeDiv();'></form:input></td>
							
							<td style="right: 7px; position: relative;">&nbsp; <form:input path="tpinjpy"
								type='text' style='text-align: center;' name='tpinjpy' 
								id='tpinjpy' value="${product.tpinjpy}" class='form-control' readonly='true'/></td>

							<td align="center" style="right: 4px; position: relative;">&nbsp;
								<form:input path="qty" type='text' style='text-align: center;' name='qty'
								id='qty' class='form-control' value="${product.qty}"
								onfocus='closeDiv();'/>
							</td>
							<td align="center">&nbsp; 
							<form:input path="totaljpy" type='text'
								style='text-align: center;' name='totaljpy' id='totaljpy' value="${product.totaljpy}"
								class='form-control' readonly='true' onfocus='closeDiv();'/></td>

							<td align="center">&nbsp; 
							
							<form:input path="customerporefe" type='text'
								style='text-align: center;width: 132px;' onkeyup='this.value=value.toUpperCase();' 
								name='customerporefe' id='customerporefe' value="${product.customerporefe}"
								class='form-control' readonly='false'/>
								
							</td>
							<td>
								<input type="hidden" style="text-align:center;" name="unitcost" id="unitcostx" value="" class="form-control"  readonly="true"></td>
							<td>
							<td align="center">&nbsp; <input type="submit" value='+'
							 id='saveproduct123' class='btn btn-success pull-right' data-toggle='tooltip'
								title='Add More Product'/>
					</tr>
					
					</table>
</form:form>
				</div>
				<div class="row form-group" style="top: 10px; position: relative;"
					onclick="closeDiv();">
					<div class="col-sm-10 form-level" align="right">
						Total:<font color="#FF0000"></font>
					</div>
					<div align="right">
						<input type="text" name="tjpy1" id="tjpy1" class="form-control"
							value="" style="width: 15%;" readonly="true">
					</div>
				</div>

				<hr align="left" size="1" width="100%"
					style="background-color: #000000" />

				<div align="center" onclick="closeDiv();">



					<tr>
						<td align="center">
							<button type="button" value="update" onclick="updatebutton();"
								class="btn btn-success pull-center" id="update"
								style="background-color: #3C8DBC;">Update</button>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>
							<button type="button" value="update" onclick="updatebutton();"
								class="btn btn-success pull-center" id="print"
								style="background-color: #3C8DBC;">Print</button>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>
							<button type="button" value="update" onclick="updatebutton();"
								class="btn btn-success pull-center" id="pdf"
								style="background-color: #3C8DBC;">PDF</button>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>
							<button type="button" value="update" onclick="updatebutton();"
								class="btn btn-success pull-center" id="back"
								style="background-color: #3C8DBC;">Back</button>
						</td>
						<td>
							<button type="button" value="update" onclick="updatebutton();"
								class="btn btn-success pull-center" id="addmore"
								style="background-color: #3C8DBC;">Add More</button>
						</td>

					</tr>


					</table>



					<button type="button" value="Save" onClick="savebutton()"
						class="btn btn-success pull-center" id="savedata445"
						style="background-color: #3C8DBC;">Save</button>
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


$(document).ready(function(){
	var table = document.getElementById("quotprodtable");
	var len=table.rows.length-1;
	$('#sr').val('');
	$('#sr').val(len);
	
});
/* $(document).ready(function(){

}); */

$('#qty').keyup(function(){
	var qty=$('#qty').val();
	var unit=$('#unitcostx').val();
	var jpy=$('#tpinjpy').val();
	var total=parseInt(qty) * parseInt(jpy);
	$('#totaljpy').val(total);
	
	//alert(qty);
});
$(document).ready(function(){
	$('#editpo').hide();
	$('#update').hide();
	$('#back').hide();
	$('#pdf').hide();
	$('#print').hide();
	$('#addmore').hide();
    $('[data-toggle="tooltip"]').tooltip();
});

$("#normal").click(function(){
	$("#porefno").val("<%=norml%>");
});
$("#CBW").click(function(){
	$("#porefno").val("<%=cb%>");
});
$( function() {
    $( "#datepicker" ).datepicker();
  } );
  
  
  
  
$('#autocomplete').click(function(){
	$('#autocomplete').val('');
	$('#description').val('');
	$('#tpinjpy').val('');
	$('#qty').val('');
	$('#totaljpy').val('');
	$('#customerporefe').val('');
	$.ajax({
		url: "getpartno?word=b", 
		success: function(result){
			//alert(""+result)
			search(result);
			/* var currencies =jQuery.parseJSON(result);
			alert(currencies);
			$('#autocomplete').autocomplete({
			    lookup: currencies,
			    onSelect: function (suggestion) {
			      alert(suggestion);
			    }
			  }); */
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
					
				//$('#autocomplete').val('');
				for(i=0;i<result.length;i++){
					var data=result.replace('"','');
					data=data.replace('"','');
				}
			var	productdescription=data.split(',')[0]
			var cost=data.split(',')[1];
					//alert(data);
				var unitcostx=data.split(',')[2];	
				
				//$('#particulee1').val(pro)
				$('#description').val(productdescription);
				$('#tpinjpy').val(cost);
				$('#unitcostx').val(unitcostx)
	    }});
      
      
    }
  });
}

 $(document).ready(function(){
	$('#savedata445').click(function(){
	$.ajax({
			url: "getviewproduct",
			type: "POST",
			
			success: function(result){
			alert("ddd");		    
			}});
		
	});
});

</script>


